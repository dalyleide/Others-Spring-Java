package com.sousa.finance.consumers.v3;

import com.sousa.finance.vo.v3.MerchantLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
@Slf4j
class MerchantClientTest {

    @Autowired
    UserClient merchantClient ;

    @Autowired
    private Environment env;

    @Test
    void whenValidUserRequest_thenCorrectResponse() {
        ResponseEntity<MerchantLoginVO> response = merchantClient.login(env.getProperty("app.api.default.user.client"),
                env.getProperty("app.api.default.user.password"));
        assertEquals(OK, response.getStatusCode());
        assertNotNull(Objects.requireNonNull(response.getBody()).getToken());
    }

    @Test
    void whenInvalidUserRequest_thenDeniedResponse() {
        try {
            RestClientException exception = assertThrows(RestClientException.class, () ->merchantClient.login("invaliduser", "invalidpassword"));
            assertTrue(Objects.requireNonNull(exception.getMessage()).contains("Merchant User credentials is not valid"));
        } catch (Exception e){
            log.error(e.getMessage(), e);
            fail();
        }
    }
}
package com.sousa.finance.consumers.v3;

import com.sousa.finance.util.CacheUtils;
import com.sousa.finance.vo.v3.MerchantLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
@Slf4j
class ClientClientTest {

    @MockBean
    CacheUtils cacheUtils;

    @InjectMocks
    @Autowired
    private ClientClient clientClient;

    @Autowired
    private UserClient merchantClient;

    @Autowired
    private Environment env;

    private String token;

    @BeforeEach
    public void setUp() {

        if (Objects.isNull(token)) {
            ResponseEntity<MerchantLoginVO> response = merchantClient.login(env.getProperty("app.api.default.user.client"),
                    env.getProperty("app.api.default.user.password"));
            token = Objects.requireNonNull(response.getBody()).getToken();
            log.info(">>>>>>>>>>>>>TOKEN: ".concat(token));
        }
    }

    @Test
    void whenValidListRequest_thenCorrectResponse() {
        when(cacheUtils.getValueByCacheAndKey(any(String.class), any(String.class))).thenReturn(token);
        try {
            ResponseEntity<String> response = clientClient.getByTransactionId(Optional.of("1-1444392550-1"));
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            fail();
        }
    }
}
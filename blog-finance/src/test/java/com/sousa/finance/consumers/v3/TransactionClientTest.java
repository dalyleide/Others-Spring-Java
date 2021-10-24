package com.sousa.finance.consumers.v3;

import com.sousa.finance.util.CacheUtils;
import com.sousa.finance.util.JsonParserUtil;
import com.sousa.finance.vo.v3.MerchantLoginVO;
import com.sousa.finance.vo.v3.list.transaction.TransactionListVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.*;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
@Slf4j
class TransactionClientTest {

    @MockBean
    CacheUtils cacheUtils;

    @InjectMocks
    @Autowired
    TransactionClient transactionClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private Environment env;

    private String token;

    @BeforeEach
    public void setUp() {
        if (Objects.isNull(token)) {
            ResponseEntity<MerchantLoginVO> response = userClient.login(env.getProperty("app.api.default.user.client"),
                    env.getProperty("app.api.default.user.password"));
            token = Objects.requireNonNull(response.getBody()).getToken();
        }
    }

    @Test
    void whenValidGetTransactionRequest_thenCorrectResponse() {
        when(cacheUtils.getValueByCacheAndKey(any(String.class), any(String.class))).thenReturn(token);
        try {
            ResponseEntity<String> response = transactionClient.getTransaction(Optional.of("1-1444392550-1"));
            assertEquals(OK, response.getStatusCode());
            assertNotNull(response.getBody());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            fail();
        }
    }

    @Test
    void whenValidListRequest_thenCorrectResponse() {
        when(cacheUtils.getValueByCacheAndKey(any(String.class), any(String.class))).thenReturn(token);
        try {
            ResponseEntity<String> response = transactionClient.list(Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
            TransactionListVO transactionListVO = (TransactionListVO) JsonParserUtil.parser(TransactionListVO.class, response.getBody());
            assertEquals(OK, response.getStatusCode());
            assertNotNull(response.getBody());
            assertNotNull(transactionListVO.getCurrentPage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            fail();
        }
    }

    @Ignore
    //TODO Client doesn't work
    void whenValidReportRequest_thenCorrectResponse() {
        when(cacheUtils.getValueByCacheAndKey(any(String.class), any(String.class))).thenReturn(token);
        try {
            ResponseEntity<String> response = transactionClient.report(
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
            assertEquals(OK, response.getStatusCode());
            assertNotNull(response.getBody());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            fail();
        }
    }

    @Test
    void whenExpiredListRequest_thenExpiredResponse() {
        when(cacheUtils.getValueByCacheAndKey(any(String.class), any(String.class))).thenReturn("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6NTMsInJvbGUiOiJ1c2VyIiwibWVyY2hhbnRJZCI6Mywic3ViTWVyY2hhbnRJZHMiOlszLDc0LDkzLDExOTEsMTI5NSwxMTEsMTM3LDEzOCwxNDIsMTQ1LDE0NiwxNTMsMzM0LDE3NSwxODQsMjIwLDIyMSwyMjIsMjIzLDI5NCwzMjIsMzIzLDMyNywzMjksMzMwLDM0OSwzOTAsMzkxLDQ1NSw0NTYsNDc5LDQ4OCw1NjMsMTE0OSw1NzAsMTEzOCwxMTU2LDExNTcsMTE1OCwxMTc5LDEyOTMsMTI5NCwxMzA2LDEzMDcsMTMyNF0sInRpbWVzdGFtcCI6MTYzMDgwMTAxMH0.C8asHIISpDts9d_ODmzqV04P1pKz4P829Q-3eg2wCvQ");
        try {
            HttpClientErrorException exception = assertThrows(HttpClientErrorException.class,
                    () -> transactionClient.list(Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty()));
            assertTrue(Objects.requireNonNull(exception.getMessage()).contains("401 Unauthorized"));

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            fail();
        }
    }

}
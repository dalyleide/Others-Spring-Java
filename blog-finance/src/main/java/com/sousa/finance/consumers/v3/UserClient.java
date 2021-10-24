package com.sousa.finance.consumers.v3;

import com.sousa.finance.vo.v3.MerchantLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.env.Environment;

import static com.sousa.finance.util.Constants.URL_API;
import static com.sousa.finance.util.Constants.URL_LOGIN;

@Component
@Slf4j
public class UserClient {

    private final Environment env;

    public UserClient(Environment env){
        this.env = env;
    }

    public ResponseEntity<MerchantLoginVO> login(String email, String password) {

        String url = env.getProperty(URL_API).concat(env.getProperty(URL_LOGIN));

        // Query parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                // Add query parameter
                .queryParam("email", email)
                .queryParam("password", password);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(builder.toUriString(), HttpMethod.POST,null, MerchantLoginVO.class);
    }
}

package com.sousa.finance.consumers.v3;

import com.sousa.finance.util.CacheUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

import static com.sousa.finance.util.Constants.URL_API;
import static com.sousa.finance.util.Constants.URL_CLIENT;

@Component
@Slf4j
public class ClientClient extends AbstractClient {

    public ClientClient(Environment env, CacheUtils cacheUtils) {
        super(env, cacheUtils);
    }

    public ResponseEntity<String> getByTransactionId(Optional<String> transactionId) {

        String url = env.getProperty(URL_API).concat(env.getProperty(URL_CLIENT));
        // Query parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                // Add query parameter
                .queryParam("transactionId", transactionId);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(builder.toUriString(), HttpMethod.POST,getEntity(), String.class);
    }
}

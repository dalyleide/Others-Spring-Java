package com.sousa.finance.consumers.v3;

import com.sousa.finance.util.CacheUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

import static com.sousa.finance.util.Constants.*;

@Component
@Slf4j
public class TransactionClient extends AbstractClient {

    public TransactionClient(Environment env, CacheUtils cacheUtils) {
        super(env, cacheUtils);
    }

    public ResponseEntity<String> report(Optional<String> fromDate, Optional<String> toDate, Optional<String> merchant,
                                         Optional<String> acquirer) {

        String url = env.getProperty(URL_API).concat(env.getProperty(URL_TRANSACTION_REPORT));
        // Query parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                // Add query parameter
                .queryParamIfPresent("fromDate", fromDate)
                .queryParamIfPresent("toDate", toDate)
                .queryParamIfPresent("merchant", merchant)
                .queryParamIfPresent("acquirer", acquirer);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(builder.toUriString(), HttpMethod.POST,getEntity(), String.class);
    }

    public ResponseEntity<String> list(Optional<String> fromDate,
                                                  Optional<String> toDate,
                                                  Optional<String> status,
                                                  Optional<String> operation,
                                                  Optional<String> merchant,
                                                  Optional<String> acquirerId,
                                                  Optional<String> paymentMethod,
                                                  Optional<String> errorCode,
                                                  Optional<String> filterField,
                                                  Optional<String> filterValue,
                                                  Optional<String> page) {

        String url = env.getProperty(URL_API).concat(env.getProperty(URL_TRANSACTION_LIST));
        // Query parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                // Add query parameter
                .queryParamIfPresent("fromDate", fromDate)
                .queryParamIfPresent("toDate", toDate)
                .queryParamIfPresent("status", status)
                .queryParamIfPresent("operation", operation)
                .queryParamIfPresent("merchant", merchant)
                .queryParamIfPresent("acquirerId", acquirerId)
                .queryParamIfPresent("paymentMethod", paymentMethod)
                .queryParamIfPresent("errorCode", errorCode)
                .queryParamIfPresent("filterField", filterField)
                .queryParamIfPresent("filterValue", filterValue)
                .queryParamIfPresent("status", status)
                .queryParamIfPresent("errorCode", errorCode)
                .queryParamIfPresent("page", page);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(builder.toUriString(), HttpMethod.POST,getEntity(), String.class);
    }

    public ResponseEntity<String> getTransaction(Optional<String> transactionId) {

        String url = env.getProperty(URL_API).concat(env.getProperty(URL_TRANSACTION));
        // Query parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                // Add query parameter
                .queryParamIfPresent("transactionId", transactionId);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(builder.toUriString(), HttpMethod.POST,getEntity(), String.class);
    }
}

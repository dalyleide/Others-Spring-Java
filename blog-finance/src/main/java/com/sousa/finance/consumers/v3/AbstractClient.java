package com.sousa.finance.consumers.v3;

import com.sousa.finance.util.CacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import static com.sousa.finance.util.Constants.HEADER_CACHE;
import static com.sousa.finance.util.Constants.HEADER_KEY_CACHE;

@Component
public abstract class AbstractClient {

    protected final Environment env;

    private final CacheUtils cacheUtils;

    public AbstractClient(Environment env, CacheUtils cacheUtils) {
        this.env = env;
        this.cacheUtils = cacheUtils;
    }

    protected HttpEntity getEntity() {

        String token = cacheUtils.getValueByCacheAndKey(HEADER_CACHE, HEADER_KEY_CACHE);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token);
        return new HttpEntity(headers);
    }

}

package com.sousa.finance.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
@Slf4j
public class CacheUtils {

    @Autowired
    CacheManager cacheManager;

    public String getValueByCacheAndKey(String cacheName, String key){
        return (String) cacheManager.getCache(cacheName).get(key).get();
    }
}


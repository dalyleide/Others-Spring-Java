package com.sousa.finance.service.serviceImpl;

import com.sousa.finance.consumers.v3.UserClient;
import com.sousa.finance.vo.v3.MerchantLoginVO;
import com.sousa.finance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.sousa.finance.util.Constants.HEADER_CACHE;
import static com.sousa.finance.util.Constants.HEADER_KEY_CACHE;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserClient userClient;
    @Autowired
    CacheManager cacheManager;

    @Override
    public ResponseEntity<MerchantLoginVO> login(String email, String password) {
        ResponseEntity<MerchantLoginVO> respose = userClient.login(email, password);

        if (respose.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Email " + email + " not found!");
        } else{
            cacheManager.getCache(HEADER_CACHE).put(HEADER_KEY_CACHE, respose.getBody().getToken());
        }
        return respose;
    }
}

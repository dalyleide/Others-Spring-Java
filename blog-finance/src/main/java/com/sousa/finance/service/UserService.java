package com.sousa.finance.service;

import com.sousa.finance.vo.v3.MerchantLoginVO;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public ResponseEntity<MerchantLoginVO> login(String email, String password);
}

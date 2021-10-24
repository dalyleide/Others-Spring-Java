package com.sousa.finance.service;

import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

public interface ClientService {

    ModelAndView consumeAPIGetClient(Optional<String> transactionId);
}

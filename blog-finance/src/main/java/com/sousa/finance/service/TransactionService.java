package com.sousa.finance.service;

import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

public interface TransactionService {

    ModelAndView consumeAPITransactionList(Optional<String> fromDate, Optional<String> toDate, Optional<String> status, Optional<String> operation, Optional<String> merchant, Optional<String> acquirerId, Optional<String> paymentMethod, Optional<String> errorCode, Optional<String> filterField, Optional<String> filterValue, Optional<String> page);
    ModelAndView consumeAPITransactionReport(Optional<String> fromDate, Optional<String> toDate, Optional<String> merchant, Optional<String> acquirerId);
    ModelAndView consumeAPITransactionGet(Optional<String> transactionId);
}

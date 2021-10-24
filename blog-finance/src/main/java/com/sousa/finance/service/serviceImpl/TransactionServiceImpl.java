package com.sousa.finance.service.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sousa.finance.consumers.v3.TransactionClient;
import com.sousa.finance.service.TransactionService;
import com.sousa.finance.vo.v3.get.transaction.TransactionVO;
import com.sousa.finance.vo.v3.list.transaction.TransactionListVO;
import com.sousa.finance.vo.v3.report.transaction.TransactionReportVO;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import static com.sousa.finance.util.JsonParserUtil.parser;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionClient client;

    @Override
    public ModelAndView consumeAPITransactionList(Optional<String> fromDate, Optional<String> toDate, Optional<String> status, Optional<String> operation, Optional<String> merchant, Optional<String> acquirerId, Optional<String> paymentMethod, Optional<String> errorCode, Optional<String> filterField, Optional<String> filterValue, Optional<String> page) {
        ModelAndView mv = new ModelAndView("fragments/result::result");
        ResponseEntity<String> respose = client.list(fromDate,
                toDate,
                status,
                operation,
                merchant,
                acquirerId,
                paymentMethod,
                errorCode,
                filterField,
                filterValue,
                page);
        mv.addObject("response", respose.getBody());
        try {
            mv.addObject("object", ((TransactionListVO)parser(TransactionListVO.class, respose.getBody())).toString());
//            mv.addObject("object", mockObjectTransactionListVO().toString());
        } catch (Exception e) {
            mv.addObject("message", String.format("Error parsing service TransactionList Erro: %s", e.getMessage()));
        }
        return mv;
    }

    @Override
    public ModelAndView consumeAPITransactionReport(Optional<String> fromDate, Optional<String> toDate, Optional<String> merchant, Optional<String> acquirerId) {
        ModelAndView mv = new ModelAndView("fragments/result::result");
        ResponseEntity<String> respose = client.report(fromDate,
                toDate,
                merchant,
                acquirerId);
        mv.addObject("response", respose.getBody());
        try {
            mv.addObject("object", ((TransactionReportVO)parser(TransactionReportVO.class, respose.getBody())).toString());
//            mv.addObject("object", mockObjectTransactionReportVO().toString());
        } catch (Exception e) {
            mv.addObject("message", String.format("Error parsing service TransactionReport Erro: %s", e.getMessage()));
        }
        return mv;
    }

    @Override
    public ModelAndView consumeAPITransactionGet(Optional<String> transactionId) {
        ModelAndView mv = new ModelAndView("fragments/result::result");
        final ResponseEntity<String> respose = client.getTransaction(transactionId);
        mv.addObject("response", respose.getBody());
        try {
            mv.addObject("object", parser(TransactionVO.class, respose.getBody()));
//            mv.addObject("object", mockObjectTransactionVO());
        } catch (Exception e) {
            mv.addObject("message", String.format("Error parsing service TransactionGet Erro: %s", e.getMessage()));
        }
        return mv;
    }

    //TODO Method to assist in screen development, erase after application stability.
    private TransactionListVO mockObjectTransactionListVO(){
        Path resourceDirectory = Paths.get("src","test","resources","transaction-list.json");
        try {
            TransactionListVO transactionListVO = (new ObjectMapper()).readValue(
                    new File(resourceDirectory.toFile().getAbsolutePath()),
                    TransactionListVO.class);
            return transactionListVO;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    //TODO Method to assist in screen development, erase after application stability.
    private TransactionVO mockObjectTransactionVO(){
        Path resourceDirectory = Paths.get("src","test","resources","transaction-get.json");
        try {
            return (new ObjectMapper()).readValue(
                    new File(resourceDirectory.toFile().getAbsolutePath()),
                    TransactionVO.class);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    //TODO Method to assist in screen development, erase after application stability.
    private TransactionReportVO mockObjectTransactionReportVO(){
        Path resourceDirectory = Paths.get("src","test","resources","transaction-report.json");
        try {
            return (new ObjectMapper()).readValue(
                    new File(resourceDirectory.toFile().getAbsolutePath()),
                    TransactionReportVO.class);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}

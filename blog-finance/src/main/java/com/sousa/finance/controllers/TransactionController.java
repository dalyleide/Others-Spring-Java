package com.sousa.finance.controllers;

import com.sousa.finance.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/finance")
public class TransactionController {

    TransactionService service;
    public TransactionController(TransactionService service){
        this.service = service;
    }

    @GetMapping(value = "/list")
    public ModelAndView getListTransaction() {
        return new ModelAndView("transactionList");
    }

    @GetMapping("/report")
    public ModelAndView getTransactionReport() {
        return new ModelAndView("transactionReport");
    }

    @GetMapping("/transaction")
    public ModelAndView getTransactionGet() {
        return new ModelAndView("transactionForm");
    }

    @PostMapping("/list")
    public ModelAndView getTransactionList(@ModelAttribute("fromDate") Optional<String> fromDate,
                                       @ModelAttribute("toDate") Optional<String> toDate,
                                       @ModelAttribute("status") Optional<String> status,
                                       @ModelAttribute("operation") Optional<String> operation,
                                       @ModelAttribute("merchantId") Optional<String> merchant,
                                       @ModelAttribute("acquirerId") Optional<String> acquirerId,
                                       @ModelAttribute("paymentMethod") Optional<String> paymentMethod,
                                       @ModelAttribute("errorCode") Optional<String> errorCode,
                                       @ModelAttribute("filterField") Optional<String>  filterField,
                                       @ModelAttribute("filterValue") Optional<String>  filterValue,
                                       @ModelAttribute("page") Optional<String> page){
        return service.consumeAPITransactionList(fromDate,
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
    }

    @PostMapping("/report")
    public ModelAndView getTransactionReport(@ModelAttribute("fromDate") Optional<String> fromDate,
                                       @ModelAttribute("toDate") Optional<String> toDate,
                                       @ModelAttribute("merchantId") Optional<String> merchant,
                                       @ModelAttribute("acquirerId") Optional<String> acquirerId){
        return service.consumeAPITransactionReport(fromDate,
                toDate,
                merchant,
                acquirerId);
    }

    @PostMapping("transaction")
    public ModelAndView getTransaction(@ModelAttribute("transactionId") Optional<String> transactionId){
        return service.consumeAPITransactionGet(transactionId);
    }

    @PostMapping("search")
    public ModelAndView searchTransaction(@ModelAttribute("transactionId") Optional<String> transactionId){
        ModelAndView mv =  service.consumeAPITransactionGet(transactionId);
        mv.setViewName("transactionForm");
        mv.addObject("showResult", Boolean.TRUE);
        return mv;
    }
}

package com.sousa.finance.controllers;

import com.sousa.finance.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/domain")
public class ClientController {

    ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping("/client")
    public ModelAndView getTransactionGet() {
        return new ModelAndView("clientForm");
    }

    @PostMapping("/client")
    public ModelAndView getTransaction(@ModelAttribute("transactionId") Optional<String> transactionId){
        return service.consumeAPIGetClient(transactionId);
    }
}

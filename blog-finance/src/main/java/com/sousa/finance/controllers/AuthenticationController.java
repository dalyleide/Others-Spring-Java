package com.sousa.finance.controllers;

import com.sousa.finance.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class AuthenticationController {

    public final UserService service;

    public AuthenticationController(UserService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView siging(@RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            service.login(email, password);

            return new ModelAndView("finance");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            ModelAndView mv = new ModelAndView("login");
            mv.addObject("message", "Invalid username/password supplied!");
            return mv;
        }
    }
}

package com.sporthub.controllers;

import com.sporthub.controllers.auth.Login;
import com.sporthub.controllers.auth.Register;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @RequestMapping(path = "/login")
    public String login(){
        return new Login().login();
    }

    @RequestMapping(path = "/register")
    public String register(){
        return new Register().register();
    }
}

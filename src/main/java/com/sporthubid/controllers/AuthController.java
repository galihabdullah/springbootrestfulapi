package com.sporthubid.controllers;

import com.sporthubid.controllers.auth.Login;
import com.sporthubid.controllers.auth.Register;
import com.sporthubid.models.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class AuthController {

    /*@RequestMapping(path = "/login")
    public String login(){
        return new Login().login();
    }

    @RequestMapping(path = "/register")
    public String register(){
        return new Register().register(User user);
    }*/
}

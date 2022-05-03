package com.travel.proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    public String register(){
        return "user/registerForm";
    }

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}

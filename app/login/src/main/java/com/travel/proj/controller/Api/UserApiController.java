package com.travel.proj.controller.Api;

import com.travel.proj.dto.ResponseDto;
import com.travel.proj.model.User;
import com.travel.proj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserApiController {

    private final UserService service;

    public UserApiController(UserService service){
        this.service = service;
    }

    @PostMapping("")
    public ResponseDto<Integer> register(@RequestBody User user){
         service.register(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @PostMapping(value = "/check/{email}",produces="application/json; charset=utf-8")
    public ResponseDto<Integer> checkEMail(@PathVariable String email){
         service.checkEmail(email);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);

    }
    @PostMapping("/login")
    public void login(){

    }

}

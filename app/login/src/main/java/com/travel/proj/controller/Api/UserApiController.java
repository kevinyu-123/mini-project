package com.travel.proj.controller.Api;

import com.travel.proj.dto.ResponseDto;
import com.travel.proj.model.User;
import com.travel.proj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

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

    @PostMapping("/email")
    public boolean sendMail(@RequestBody Map<String, String> info, HttpServletRequest request){
        boolean result = service.sendMail(info,request);
        return result;
    }

    @PostMapping("/login")
    public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
       User info =  service.login(user);
       log.info(String.valueOf(info));
       if(info != null){
           session.setAttribute("userInfo",info);
       }
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}

package com.masters.pay.bank.controller;

import com.masters.pay.bank.request.UserLogInRequest;
import com.masters.pay.bank.request.UserSignUpRequest;
import com.masters.pay.bank.response.BaseResponse;
import com.masters.pay.bank.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse userSignup(@RequestBody UserSignUpRequest userSignUpRequest) {
        log.info("Sign UP request received");
        BaseResponse baseResponse = userService.userSignUp(userSignUpRequest);
        return baseResponse;
    }

    @PostMapping(path = "login", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse userLogin(@RequestBody UserLogInRequest userLoginRequest) {
        log.info("Login request received");
        BaseResponse baseResponse = userService.userLogin(userLoginRequest);
        return baseResponse;
    }
}

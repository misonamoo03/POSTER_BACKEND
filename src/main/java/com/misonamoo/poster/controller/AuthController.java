package com.misonamoo.poster.controller;

import com.misonamoo.poster.domain.User;
import com.misonamoo.poster.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    ApiService apiService;

    @GetMapping("/signup")
    public void insertUser(@RequestParam("ID") String id,@RequestParam("EMAIL") String email,@RequestParam("PASSWORD") String password) {
        System.out.println("ID : "+id);
        System.out.println("EMAIL : "+ email);
        System.out.println("PASSWORD : "+password);
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setPassword(password);
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡUserㅡㅡㅡㅡㅡㅡㅡㅡ : " + user);
        //apiService.createUser(userMap);
    }
}

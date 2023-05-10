package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.services.Interfaces.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
     private RegisterService registerService;
    @PostMapping("/Register")
    public String Register(@RequestBody UserDto newUser) {
        registerService.Register(newUser);
        return "Register Successfully!!";

    }
}

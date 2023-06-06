package com.example.brfapi.brfapi.controller;

import com.example.brfapi.brfapi.user.User;
import com.example.brfapi.brfapi.user.UserRegisterData;
import com.example.brfapi.brfapi.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    public void register(@RequestBody UserRegisterData dados){
        repository.save(new User(dados));
    }

}

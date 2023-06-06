package com.example.brfapi.brfapi.controller;

import com.example.brfapi.brfapi.user.UserRegisterData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @PostMapping
    public void register(@RequestBody UserRegisterData json){
        System.out.println(json);
    }

}

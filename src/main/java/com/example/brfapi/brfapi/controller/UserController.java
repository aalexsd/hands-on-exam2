package com.example.brfapi.brfapi.controller;

import com.example.brfapi.brfapi.user.User;
import com.example.brfapi.brfapi.user.UserRegisterData;
import com.example.brfapi.brfapi.user.UserRepository;
import com.example.brfapi.brfapi.user.UserUpdateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody UserRegisterData data){
        repository.save(new User(data));
    }

    @GetMapping
    public List<User> list(){
        return repository.findAll();
    }


    @PutMapping
    @Transactional
    public void update(@RequestBody UserUpdateData data){
        var user = repository.getReferenceById(data.id());
        user.updateInfo(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}

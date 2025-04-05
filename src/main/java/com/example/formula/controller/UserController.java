package com.example.formula.controller;

import com.example.formula.entity.User;
import com.example.formula.repository.UserRepository;
import com.example.formula.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/public")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserService userService;

//    @PostMapping("/create-user")
//    public String hello() {
//        User user = new User();
//        user.setName("bob");
//        User temp = userRepository.save(user);
//        return "User saved successfully";
//    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") ObjectId id){
        User user = userService.GetUserbyId(id);
        if(user==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<User> createUser(@RequestBody Map<String, String> payload){
        try{
            User dummy = new User();
            dummy.setEmail(payload.get("email"));
            dummy.setAuthid(payload.get("AuthOid"));
            dummy.setName(payload.get("name"));
            User us = userService.SaveUser(dummy);
            if(us==null) return new ResponseEntity<>(HttpStatus.MULTIPLE_CHOICES);
            return new ResponseEntity<>(us,HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
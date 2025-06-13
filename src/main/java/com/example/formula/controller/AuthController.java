package com.example.formula.controller;

import com.example.formula.dto.LoginRequest;
import com.example.formula.dto.SignUpRequest;
import com.example.formula.dto.AuthResponse;
import com.example.formula.entity.UserJwt;
import com.example.formula.services.UserJwtService;
import com.example.formula.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserJwtService userJwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignUpRequest signUpRequest){
        if(userJwtService.existsuser(signUpRequest.getEmail())) return new ResponseEntity<>(HttpStatus.CONFLICT);

        UserJwt userJwt = new UserJwt();
        userJwt.setName(signUpRequest.getName());
        userJwt.setEmail(signUpRequest.getEmail());
        userJwt.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        userJwtService.saveuser(userJwt);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setEmail(userJwt.getEmail());
        authResponse.setJwtToken(jwtUtil.generateToken(userJwt.getEmail()));
        return new ResponseEntity<>(authResponse,HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
        if(!userJwtService.existsuser(loginRequest.getEmail())) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        UserJwt userJwt = userJwtService.getuser(loginRequest.getEmail());
        if (!passwordEncoder.matches(loginRequest.getPassword(), userJwt.getPassword())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        AuthResponse authResponse = new AuthResponse();
        authResponse.setEmail(userJwt.getEmail());
        authResponse.setJwtToken(jwtUtil.generateToken(userJwt.getEmail()));
        return new ResponseEntity<>(authResponse,HttpStatus.OK);
    }
}

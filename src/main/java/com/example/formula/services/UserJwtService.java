package com.example.formula.services;

import com.example.formula.entity.UserJwt;
import com.example.formula.repository.UserJwtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserJwtService {
    @Autowired
    private UserJwtRepository userJwtRepository;

    public boolean saveuser(UserJwt userJwt){
        try{
            userJwtRepository.save(userJwt);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public UserJwt getuser(String email){
        return userJwtRepository.findByEmail(email);
    }

    public boolean existsuser(String email){
        return userJwtRepository.existsByEmail(email);
    }
}

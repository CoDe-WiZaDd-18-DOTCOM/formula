package com.example.formula.services;

import com.example.formula.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.formula.entity.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User SaveUser(User user){
        if(userRepository.existsByAuthid(user.getAuthid())) return null;
        return userRepository.save(user);
    }

    public User GetUserbyId(ObjectId id){
        return userRepository.findById(id).orElse(null);
    }

    public User GetUserbyAuth(String id){
        return userRepository.findByAuthid(id).orElse(null);
    }

//    public User UpdateUser(Long id, User user){
//        User dbuser = GetUserbyId(id);
//        if(dbuser==null) return null;
//        if(!dbuser.getEmail().equals(user.getEmail())) {
//            dbuser.setEmail(user.getEmail());
//            dbuser.setPassword(user.getPassword());
//            return SaveUser(dbuser);
//        }
//        dbuser.setPassword(user.getPassword());
//        return userRepo.save(dbuser);
//    }
//
//    public Boolean DeleteUser(Long id){
//        if(!userRepo.existsById(id)) return false;
//        userRepo.deleteById(id);
//        return true;
//    }
}

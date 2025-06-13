package com.example.formula.repository;

import com.example.formula.entity.User;
import com.example.formula.entity.UserJwt;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJwtRepository extends MongoRepository<UserJwt, ObjectId> {
    UserJwt findByEmail(String email);
    boolean existsByEmail(String email);
}

package com.example.formula.repository;

import com.example.formula.entity.FormResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormResponseRepository extends MongoRepository<FormResponse,String> {

}

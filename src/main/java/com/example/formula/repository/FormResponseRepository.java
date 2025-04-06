package com.example.formula.repository;

import com.example.formula.entity.FormResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormResponseRepository extends MongoRepository<FormResponse,String> {

    List<FormResponse> findAllByFormTemplateId(String formTemplateId);
}

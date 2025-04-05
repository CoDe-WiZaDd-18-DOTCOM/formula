package com.example.formula.repository;

import com.example.formula.entity.FormTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormTemplateRepository extends MongoRepository<FormTemplate,String> {
    List<FormTemplate> findAllByOwnerId(String ownerId);
}

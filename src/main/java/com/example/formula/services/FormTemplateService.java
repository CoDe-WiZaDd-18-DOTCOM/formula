package com.example.formula.services;

import com.example.formula.entity.FormTemplate;
import com.example.formula.repository.FormTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormTemplateService {
    @Autowired
    private FormTemplateRepository formTemplateRepository;

    public FormTemplate getForm(String id){
        return formTemplateRepository.findById(id).orElse(null);
    }

    public List<FormTemplate> getAllForms(String ownerId){
        return formTemplateRepository.findAllByOwnerId(ownerId);
    }

    public FormTemplate postForm(FormTemplate formTemplate){
        return formTemplateRepository.save(formTemplate);
    }
}

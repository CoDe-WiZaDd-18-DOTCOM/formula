package com.example.formula.services;

import com.example.formula.entity.FormResponse;
import com.example.formula.repository.FormResponseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormResponseService {
    @Autowired
    private FormResponseRepository formResponseRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<FormResponse> getFormResponse(String formTemplateId) {
        List<FormResponse> response = formResponseRepository.findAllByFormTemplateId(formTemplateId);
        return response;
    }


    public void saveFormResponse(FormResponse request) {
        FormResponse response = new FormResponse();
        response.setFormTemplateId(request.getFormTemplateId());
        response.setResponderId(request.getResponderId());
        response.setAnswers(request.getAnswers());
        FormResponse savedResponse = formResponseRepository.save(response);
    }

}

package com.example.formula;

import com.example.formula.dto.FormResponseRequest;
import com.example.formula.entity.FormResponse;
import com.example.formula.repository.FormResponseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Map;

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

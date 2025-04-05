package com.example.formula;

import com.example.formula.dto.FormResponseRequest;
import com.example.formula.entity.FormResponse;
import com.example.formula.repository.FormResponseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FormResponseService {
    @Autowired
    private FormResponseRepository formResponseRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public FormResponse getFormResponse(String formTemplateId) {
        FormResponse response = formResponseRepository.findByFormTemplateId(formTemplateId);
        return response;
    }

    public void saveFormResponse(FormResponseRequest request) {
        FormResponse response = new FormResponse();
        response.setFormTemplateId(request.getFormTemplateId());
        response.setResponderId(request.getResponderId());
        Map<String, Object> answersMap = objectMapper.convertValue(request.getAnswers(), Map.class);
        response.setAnswers(answersMap);
        FormResponse savedResponse = formResponseRepository.save(response);
    }

}

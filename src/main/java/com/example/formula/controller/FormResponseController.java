package com.example.formula.controller;

import com.example.formula.FormResponseService;
import com.example.formula.dto.FormResponseRequest;
import com.example.formula.entity.FormResponse;
import com.example.formula.repository.FormResponseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class FormResponseController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FormResponseService formResponseService;

    @GetMapping("/public/form-responses/{formTemplateId}")
    public ResponseEntity<?> getFormResponse(@PathVariable String formTemplateId) {
       try{
           FormResponse formResponse = formResponseService.getFormResponse(formTemplateId);
           return ResponseEntity.ok(formResponse);
       }
       catch(Exception e){
           return ResponseEntity.badRequest().body("Error fetching form response: " + e.getMessage());
       }
    }

    @PostMapping("/public/form-responses")
    public ResponseEntity<?> createFormResponse(@RequestBody FormResponseRequest request) {
        try{
            formResponseService.saveFormResponse(request);
            return ResponseEntity.ok(request);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error saving form response: " + e.getMessage());
        }
    }
}

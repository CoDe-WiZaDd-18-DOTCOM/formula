package com.example.formula.controller;

import com.example.formula.entity.FormTemplate;
import com.example.formula.services.FormTemplateService;
import com.example.formula.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class FormTemplateController {

    @Autowired
    private FormTemplateService formTemplateService;

    @GetMapping("/forms/{ownerId}")
    public ResponseEntity<List<FormTemplate>> getall(@PathVariable String ownerId){
        try {
            List<FormTemplate> forms = formTemplateService.getAllForms(ownerId);
            return new ResponseEntity<>(forms, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/forms/id/{id}")
    public ResponseEntity<FormTemplate> getone(@PathVariable String id){
        try {
            FormTemplate formTemplate = formTemplateService.getForm(id);
            return new ResponseEntity<>(formTemplate,HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/forms")
    public ResponseEntity<FormTemplate> postone(@RequestBody FormTemplate formTemplate){
        try {
            FormTemplate form = formTemplateService.postForm(formTemplate);
            return new ResponseEntity<>(form,HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

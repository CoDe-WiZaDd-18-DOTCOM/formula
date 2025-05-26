package com.example.formula.controller;

import com.example.formula.services.FormResponseService;
import com.example.formula.entity.FormResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
public class FormResponseController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FormResponseService formResponseService;

    @GetMapping("/public/form-responses/{formTemplateId}")
    public ResponseEntity<?> getFormResponse(@PathVariable String formTemplateId) {
       try{
//           FormResponse formResponse = formResponseService.getFormResponse(formTemplateId);
           return ResponseEntity.ok(null);
       }
       catch(Exception e){
           return ResponseEntity.badRequest().body("Error fetching form response: " + e.getMessage());
       }
    }

    @GetMapping("/public/form-responses/{formTemplateId}/csv")
    public ResponseEntity<?> downloadFormResponsesAsCSV(@PathVariable String formTemplateId) {
        try {
            List<FormResponse> responses = formResponseService.getFormResponse(formTemplateId); // Note: plural

            StringWriter writer = new StringWriter();
            CSVPrinter csvPrinter = new CSVPrinter(writer,
                    CSVFormat.DEFAULT.withHeader("Response ID", "Template ID", "Responder ID", "Answers"));

            ObjectMapper objectMapper = new ObjectMapper();

            for (FormResponse response : responses) {
                csvPrinter.printRecord(
                        response.getId(),
                        response.getFormTemplateId(),
                        response.getResponderId(),
                        objectMapper.writeValueAsString(response.getAnswers())
                );
            }

            csvPrinter.flush();

            byte[] csvBytes = writer.toString().getBytes(StandardCharsets.UTF_8);
            ByteArrayResource resource = new ByteArrayResource(csvBytes);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"form_responses.csv\"")
                    .contentType(MediaType.parseMediaType("text/csv"))
                    .contentLength(csvBytes.length)
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error generating CSV: " + e.getMessage());
        }
    }


    @PostMapping("/public/form-responses")
    public ResponseEntity<?> createFormResponse(@RequestBody FormResponse request) {
        try{
            formResponseService.saveFormResponse(request);
            return ResponseEntity.ok(request);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error saving form response: " + e.getMessage());
        }
    }
}

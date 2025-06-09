package com.example.formula.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "form_responses")
public class FormResponse {
    @Id
    private String id;
    private String formTemplateId;
    private String responderId;
    private Map<String, List<Object>> answers;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFormTemplateId() {
        return formTemplateId;
    }

    public void setFormTemplateId(String formTemplateId) {
        this.formTemplateId = formTemplateId;
    }

    public String getResponderId() {
        return responderId;
    }

    public void setResponderId(String responderId) {
        this.responderId = responderId;
    }

    public Map<String, List<Object>> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, List<Object>> answers) {
        this.answers = answers;
    }
}


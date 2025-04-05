package com.example.formula.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Map;

@Document(collection = "form_responses")
@Data
@NoArgsConstructor
public class FormResponse {
    @Id
    private String id;
    private String formTemplateId;
    private String responderId;
    private Map<String, Object> answers;

}


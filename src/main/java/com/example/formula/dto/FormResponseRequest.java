package com.example.formula.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class FormResponseRequest {
    private String formTemplateId;
    private String responderId;
    private Map<String, Object> answers;
}


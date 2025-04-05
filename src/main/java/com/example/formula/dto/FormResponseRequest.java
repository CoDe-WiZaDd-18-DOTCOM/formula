package com.example.formula.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FormResponseRequest {
    private String formTemplateId;
    private String responderId;
    private FormAnswers answers;
}


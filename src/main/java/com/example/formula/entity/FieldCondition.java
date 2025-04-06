package com.example.formula.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FieldCondition {
    private String triggerFieldId;
    private String state;
    private String value;
    private String targetFieldId;
    private String action;
}

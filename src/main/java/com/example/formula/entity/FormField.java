package com.example.formula.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FormField {
    private String id;
    private String label;
    private String type;
    private List<String> options;
    private boolean required;

}

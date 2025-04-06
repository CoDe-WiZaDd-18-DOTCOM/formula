package com.example.formula.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "form_templates")
@Data
@NoArgsConstructor
public class FormTemplate {
    @Id
    private String id;
    private String title;
    private String description;
    private String ownerId;
    private List<FormField> fields;

    private List<FieldCondition> fieldConditions;
}


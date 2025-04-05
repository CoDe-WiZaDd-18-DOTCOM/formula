package com.example.formula.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class FormAnswers {
    private Heading heading;
    private String fullName;
    private String email;
    private Address address;
    private String phoneNumber;
    private Date date;
    private Appointment appointment;
    private String textBox;
    private String selectOneOption;
    private List<String> selectMultipleOption;
    private String uploadFile;
    private int rateExperience;
}

@Data
@NoArgsConstructor
class Heading {
    private String title;
    private String subTitle;
}

@Data
@NoArgsConstructor
class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
}

@Data
@NoArgsConstructor
class Appointment {
    private Date appointmentDate;
    private String appointmentTime;
}

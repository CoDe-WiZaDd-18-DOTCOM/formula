package com.example.formula.entity;


public class FieldCondition {
    private String triggerFieldId;
    private String state;
    private String value;
    private String targetFieldId;
    private String action;

    public String getTriggerFieldId() {
        return triggerFieldId;
    }

    public void setTriggerFieldId(String triggerFieldId) {
        this.triggerFieldId = triggerFieldId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTargetFieldId() {
        return targetFieldId;
    }

    public void setTargetFieldId(String targetFieldId) {
        this.targetFieldId = targetFieldId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}

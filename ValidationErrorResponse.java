package com.task.api.dto;

import java.util.List;

public class ValidationErrorResponse {

    private String message;
    private List<String> errors;
    public void setMessage(String string) {
        // TODO Auto-generated method stub

    }
    public void setErrors(List<String> collect) {
        // TODO Auto-generated method stub

    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }
}

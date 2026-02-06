package com.example.bookmanagement.presentation;

import java.util.List;

public class ErrorMessage {
    private List<String> errors;    // list of error messages(errors not always singular)
    public ErrorMessage(List<String> errors){
        this.errors = errors;
    }
    public List<String> getErrors() {
        return errors;
    }
}

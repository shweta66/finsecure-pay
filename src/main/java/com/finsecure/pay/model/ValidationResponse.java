package com.finsecure.pay.model;

public class ValidationResponse {

    private String status;
    private String message;

    public ValidationResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}

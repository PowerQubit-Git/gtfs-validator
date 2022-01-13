package tml.centralapi.validatormain.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ResponseMessage {
    private String message;

    public Notice getValidationResult() {
        return this.validationResult;
    }

    public void setValidationResult(Notice validationResult) {
        this.validationResult = validationResult;
    }

    private Notice validationResult;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

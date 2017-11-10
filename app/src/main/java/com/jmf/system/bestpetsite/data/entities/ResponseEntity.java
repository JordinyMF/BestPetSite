package com.jmf.system.bestpetsite.data.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by JORDINY on 7/11/2017.
 */

public class ResponseEntity {

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("description")
    private String description;
    @SerializedName("errors")
    private List<ErrorEntity> errors;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ErrorEntity> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorEntity> errors) {
        this.errors = errors;
    }
}

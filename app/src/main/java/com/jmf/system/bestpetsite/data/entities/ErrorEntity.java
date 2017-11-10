package com.jmf.system.bestpetsite.data.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by JORDINY on 7/11/2017.
 */

public class ErrorEntity {
    @SerializedName("code")
    private int code;
    @SerializedName("field")
    private int field;
    @SerializedName("message")
    private int message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }
}

package com.jmf.system.bestpetsite.domain.models;

/**
 * Created by JORDINY on 24/11/2017.
 */

public class CodesCatalog {
    private int id;
    private String description;
    private String value;
    private String picture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

package com.jmf.system.bestpetsite.data.entities;

import com.google.gson.annotations.SerializedName;

import java.sql.Time;
import java.util.Date;

/**
 * Created by JORDINY on 25/11/2017.
 */

public class PetControlTypeEntity {
    @SerializedName("id")
    private int id;
    @SerializedName("pet_id")
    private int petId;
    @SerializedName("description")
    private String description;
    @SerializedName("startDateAttention")
    private Date startDateAttention;
    @SerializedName("attentionHour")
    private Time attentionHour;
    @SerializedName("controlType")
    private int controlType;
    @SerializedName("frequency")
    private int frequency;
    @SerializedName("notes")
    private String notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDateAttention() {
        return startDateAttention;
    }

    public void setStartDateAttention(Date startDateAttention) {
        this.startDateAttention = startDateAttention;
    }

    public Time getAttentionHour() {
        return attentionHour;
    }

    public void setAttentionHour(Time attentionHour) {
        this.attentionHour = attentionHour;
    }

    public int getControlType() {
        return controlType;
    }

    public void setControlType(int controlType) {
        this.controlType = controlType;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

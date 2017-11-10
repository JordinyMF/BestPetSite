package com.jmf.system.bestpetsite.data.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by JORDINY on 8/11/2017.
 */

public class CustomerEntity {
    @SerializedName("id")
    private int id;
    @SerializedName("idCustomerType")
    private int idCustomerType;
    @SerializedName("firstName")
    private int firstName;
    @SerializedName("lastName")
    private int lastName;
    @SerializedName("phone")
    private int phone;
    @SerializedName("direction")
    private int direction;
    @SerializedName("creationDate")
    private int creationDate;
    @SerializedName("modificationDate")
    private int modificationDate;
    @SerializedName("status")
    private int status;

    public CustomerEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCustomerType() {
        return idCustomerType;
    }

    public void setIdCustomerType(int idCustomerType) {
        this.idCustomerType = idCustomerType;
    }

    public int getFirstName() {
        return firstName;
    }

    public void setFirstName(int firstName) {
        this.firstName = firstName;
    }

    public int getLastName() {
        return lastName;
    }

    public void setLastName(int lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(int creationDate) {
        this.creationDate = creationDate;
    }

    public int getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(int modificationDate) {
        this.modificationDate = modificationDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

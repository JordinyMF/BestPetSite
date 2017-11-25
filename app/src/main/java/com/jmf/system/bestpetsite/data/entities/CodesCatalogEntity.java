package com.jmf.system.bestpetsite.data.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by JORDINY on 24/11/2017.
 */

public class CodesCatalogEntity {

 @SerializedName("id")
 private int id;
 @SerializedName("description")
 private String description;
 @SerializedName("value")
 private String value;
 @SerializedName("picture")
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

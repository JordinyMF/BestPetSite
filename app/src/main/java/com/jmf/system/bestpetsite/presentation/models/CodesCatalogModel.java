package com.jmf.system.bestpetsite.presentation.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JORDINY on 24/11/2017.
 */

public class CodesCatalogModel implements Parcelable {
    private int id;
    private String description;
    private String value;
    private String picture;

    public CodesCatalogModel() {
    }

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


    protected CodesCatalogModel(Parcel in) {
        id = in.readInt();
        description = in.readString();
        value = in.readString();
        picture = in.readString();
    }

    public static final Creator<CodesCatalogModel> CREATOR = new Creator<CodesCatalogModel>() {
        @Override
        public CodesCatalogModel createFromParcel(Parcel in) {
            return new CodesCatalogModel(in);
        }

        @Override
        public CodesCatalogModel[] newArray(int size) {
            return new CodesCatalogModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(description);
        dest.writeString(value);
        dest.writeString(picture);
    }

    @Override
    public String toString() {
        return description;
    }
}

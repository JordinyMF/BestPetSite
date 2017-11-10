package com.jmf.system.bestpetsite.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by JORDINY on 7/11/2017.
 */

public class BaseResponseEntity<T> implements Parcelable {
    @SerializedName("result")
    private boolean isOk;
    @SerializedName("response")
    private ResponseEntity response;
    @SerializedName("content")
    private T content;

    public BaseResponseEntity() {

    }

    protected BaseResponseEntity(Parcel in) {
       // isOk = in.readByte() != 0;
    }

    public static final Creator<BaseResponseEntity> CREATOR = new Creator<BaseResponseEntity>() {
        @Override
        public BaseResponseEntity createFromParcel(Parcel in) {
            return new BaseResponseEntity(in);
        }

        @Override
        public BaseResponseEntity[] newArray(int size) {
            return new BaseResponseEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        //parcel.writeByte((byte) (isOk ? 1 : 0));
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public ResponseEntity getResponse() {
        return response;
    }

    public void setResponse(ResponseEntity response) {
        this.response = response;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }


}

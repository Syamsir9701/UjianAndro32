package com.juaracoding.katalogfrontend.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Response implements Parcelable {
    @SerializedName("statuscode")
    private int statusCode;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    public List<Katalog> data;

    public Response(int statusCode, String message, List<Katalog> data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }



    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Katalog> getData() {
        return data;
    }

    public void setData(List<Katalog> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.statusCode);
        dest.writeString(this.message);
        dest.writeList(this.data);
    }

    public void readFromParcel(Parcel source) {
        this.statusCode = source.readInt();
        this.message = source.readString();
        this.data = new ArrayList<Katalog>();
        source.readList(this.data, Katalog.class.getClassLoader());
    }

    protected Response(Parcel in) {
        this.statusCode = in.readInt();
        this.message = in.readString();
        this.data = new ArrayList<Katalog>();
        in.readList(this.data, Katalog.class.getClassLoader());
    }

    public static final Parcelable.Creator<Response> CREATOR = new Parcelable.Creator<Response>() {
        @Override
        public Response createFromParcel(Parcel source) {
            return new Response(source);
        }

        @Override
        public Response[] newArray(int size) {
            return new Response[size];
        }
    };
}

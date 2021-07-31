package com.juaracoding.katalogfrontend.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Katalog implements Parcelable {
    @SerializedName("id")
    private long id;
    @SerializedName("namaproduk")
    private String namaproduk;
    @SerializedName("price")
    private String price;
    @SerializedName("description")
    private String description;
    @SerializedName("variant")
    private String variant;

    public Katalog(long id, String namaproduk, String price, String description, String variant) {
        this.id = id;
        this.namaproduk = namaproduk;
        this.price = price;
        this.description = description;
        this.variant = variant;
    }


    public Katalog(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaproduk() {
        return namaproduk;
    }

    public void setNamaproduk(String namaproduk) {
        this.namaproduk = namaproduk;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.namaproduk);
        dest.writeString(this.price);
        dest.writeString(this.description);
        dest.writeString(this.variant);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readLong();
        this.namaproduk = source.readString();
        this.price = source.readString();
        this.description = source.readString();
        this.variant = source.readString();
    }

    protected Katalog(Parcel in) {
        this.id = in.readLong();
        this.namaproduk = in.readString();
        this.price = in.readString();
        this.description = in.readString();
        this.variant = in.readString();
    }

    public static final Parcelable.Creator<Katalog> CREATOR = new Parcelable.Creator<Katalog>() {
        @Override
        public Katalog createFromParcel(Parcel source) {
            return new Katalog(source);
        }

        @Override
        public Katalog[] newArray(int size) {
            return new Katalog[size];
        }
    };
}

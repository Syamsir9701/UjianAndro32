package com.juaracoding.katalogfrontend.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit retrovit;
    public static final String URL = "http://14cc209808f9.ngrok.io/katalog/";


    public static Retrofit getRetrovit() {
        if (retrovit == null) {
            retrovit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrovit;
    }
}

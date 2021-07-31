package com.juaracoding.katalogfrontend.service;

import com.juaracoding.katalogfrontend.entity.Response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KatalogInterface {

    @GET("/katalog")
    Call<Response> getAllKatalog();


}

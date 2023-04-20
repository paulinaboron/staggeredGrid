package com.example.staggeredgrid02;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CitiesApi {
    @GET("/v1/8cd48005-d2aa-42b7-9cab-aa073894d940")
    Call<List<City>> getAll();
}

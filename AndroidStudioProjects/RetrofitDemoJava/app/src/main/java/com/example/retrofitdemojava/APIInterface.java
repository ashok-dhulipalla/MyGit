package com.example.retrofitdemojava;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("/posts")
    Call<List<Post>> getPosts();
}

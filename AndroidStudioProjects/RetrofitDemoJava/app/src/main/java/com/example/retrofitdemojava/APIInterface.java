package com.example.retrofitdemojava;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/posts")
    Call<List<Post>> getPosts();

    @GET("/posts/{id}")
    Call<Post> getPost(@Path("id") Integer postId);

    @GET("/comments")
    Call<List<Comments>> getComments(@Query("postId") Integer postId);
}

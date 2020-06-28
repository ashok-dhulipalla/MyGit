package com.example.retrofitdemojava;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit= new Retrofit.Builder()
                //.baseUrl("https://jsonplaceholder.typicode.com/")
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIInterface service = retrofit.create(APIInterface.class);

        Callback<List<Post>> callBack= new Callback<List<Post>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                response.body().stream().forEach(n -> System.out.println("SkillSetGo: "+n));
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                t.printStackTrace();
            }
        };

        //service.getPosts().enqueue(callBack);

        Callback<Post> callBack2= new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                System.out.println("SkillSetGo: "+response.body());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t.printStackTrace();
            }
        };

        //service.getPost(1).enqueue(callBack2);
        //service.getPost(1).enqueue(callBack2);
        //service.getPost(1).enqueue(callBack2);

        Callback<List<Comments>> commentsCallBack= new Callback<List<Comments>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                response.body().stream().forEach(n -> System.out.println("SkillSetGo: "+n));
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {
                t.printStackTrace();
            }
        };

        //service.getComments(1).enqueue(commentsCallBack);


        Callback<Post> postCallback= new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                System.out.println("SkillSetGo: "+response.body().toString());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t.printStackTrace();
            }
        };

        service.postReqDemo().enqueue(postCallback);
    }
}

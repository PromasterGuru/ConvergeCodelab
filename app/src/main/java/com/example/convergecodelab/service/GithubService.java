package com.example.convergecodelab.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubService {

    public GithubApi GithubService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GithubApi service = retrofit.create(GithubApi.class);
        return service;
    }
}

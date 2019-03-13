package com.example.convergecodelab.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubService {

    private static final String BASE_URL="https://api.github.com/";
    private static Retrofit retrofit = null;

    public static GithubApi getGithubApi() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(GithubApi.class);
    }
}

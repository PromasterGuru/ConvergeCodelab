package com.example.convergecodelab.service;

import com.example.convergecodelab.model.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubApi {
    @GET("search/users?q=+language:java+location:nairobi")
    Call<GithubUsersResponse> githubUsersList();
}


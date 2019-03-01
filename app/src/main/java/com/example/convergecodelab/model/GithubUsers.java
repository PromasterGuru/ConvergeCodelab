package com.example.convergecodelab.model;

import com.google.gson.annotations.SerializedName;

public class GithubUsers {

    // Declaration of variables that holds each Github user information
    @SerializedName("login")
    private String userName;

    @SerializedName("avatar_url")
    private String profileImage;

    @SerializedName("created_at")
    private String stringDate;

    //Getter methods that returns each user information
    public String getUserName() {
        return userName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getStringDate() {
        return stringDate;
    }

}


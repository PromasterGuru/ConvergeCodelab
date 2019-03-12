package com.example.convergecodelab.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class GithubUsers{

    // Declaration of variables that holds each Github user information
    @SerializedName("login")
    private String userName;

    @SerializedName("avatar_url")
    private String profileImage;

    @SerializedName("created_at")
    private String stringDate;

    //Defult constructor
    public GithubUsers(String userName, String profileImage, String stringDate) {
        this.userName = userName;
        this.profileImage = profileImage;
        this.stringDate = stringDate;
    }

    protected GithubUsers(Parcel in) {
        userName = in.readString();
        profileImage = in.readString();
        stringDate = in.readString();
    }

    public static final Parcelable.Creator<GithubUsers> CREATOR = new Parcelable.Creator<GithubUsers>() {
        @Override
        public GithubUsers createFromParcel(Parcel in) {
            return new GithubUsers(in);
        }

        @Override
        public GithubUsers[] newArray(int size) {
            return new GithubUsers[size];
        }
    };

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


    //Setter methods
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public void setStringDate(String stringDate) {
        this.stringDate = stringDate;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(profileImage);
        dest.writeString(stringDate);
    }

}


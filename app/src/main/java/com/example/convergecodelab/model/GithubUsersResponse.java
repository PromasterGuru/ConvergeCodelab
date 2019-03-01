package com.example.convergecodelab.model;

import java.util.ArrayList;

public class GithubUsersResponse {

    //An ArrayList to hold a list of Github users
    private ArrayList<GithubUsers> githubUsersList;

    //Default constructor that accepts data from the Github API
    public GithubUsersResponse(ArrayList<GithubUsers> githubUsersList) {
        this.githubUsersList = githubUsersList;
    }

    //Getter method that returns a list of Github users
    public ArrayList<GithubUsers> getGithubUsersList() {
        return githubUsersList;
    }
}

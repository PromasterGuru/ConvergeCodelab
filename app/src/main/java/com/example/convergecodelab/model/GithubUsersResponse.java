package com.example.convergecodelab.model;

import java.util.List;

public class GithubUsersResponse {

    //An ArrayList to hold a list of Github users
    private final  List githubUsersList;

    //Default constructor that accepts data from the Github API
    public GithubUsersResponse(List githubUsersList) {
        this.githubUsersList = githubUsersList;
    }

    //Getter method that returns a list of Github users
    public List getGithubUsersList() {
        return githubUsersList;
    }
}

package com.example.convergecodelab.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.convergecodelab.R;
import com.example.convergecodelab.adapter.GithubAdapter;
import com.example.convergecodelab.model.GithubUsers;
import com.example.convergecodelab.presenter.GithubPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GithubUsersView {

    GithubAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private final List<String> usernames = new ArrayList<>();
    private final List<String> imageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GithubPresenter presenter = new GithubPresenter(this);
        presenter.getGithubUsers();
    }

    @Override
    public void githubReadyUsers(List<GithubUsers> githubUsers) {
        for (GithubUsers githubUser: githubUsers) {
            imageUrls.add(githubUser.getProfileImage());
            usernames.add(githubUser.getUserName());
        }
        initRecyclerView();
    }
    public void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new GithubAdapter(this, usernames, imageUrls);
        recyclerView.setAdapter(adapter);
    }

}

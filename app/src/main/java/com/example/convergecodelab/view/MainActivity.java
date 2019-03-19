package com.example.convergecodelab.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.convergecodelab.R;
import com.example.convergecodelab.adapter.GithubAdapter;
import com.example.convergecodelab.model.GithubUsers;
import com.example.convergecodelab.presenter.GithubPresenter;
import com.example.convergecodelab.util.NetworkUtility;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GithubUsersView {

    ProgressDialog progressDialog;
    GithubAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private final List<String> usernames = new ArrayList<>();
    private final List<String> imageUrls = new ArrayList<>();
    SwipeRefreshLayout swipeRefreshLayout;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fetchDataHelper();
    }

    @Override
    public void githubReadyUsers(List<GithubUsers> githubUsers) {
        for (GithubUsers githubUser: githubUsers) {
            imageUrls.add(githubUser.getProfileImage());
            usernames.add(githubUser.getUserName());
        }
        initRecyclerView();
        progressDialog.dismiss();
    }
    public void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new GithubAdapter(this, usernames, imageUrls);
        recyclerView.setAdapter(adapter);
    }

    public void loadGithubUsers(){
        final GithubPresenter presenter = new GithubPresenter(this);
        presenter.getGithubUsers();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading Github Users...");
        progressDialog.setMessage("Please wait.");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
        progressDialog.show();

        swipeRefreshLayout = findViewById(R.id.swipeToReflesh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        presenter.getGithubUsers();
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });
    }
    public void fetchDataHelper(){
        NetworkUtility networkUtility = new NetworkUtility();
        if(networkUtility.networkAvailable(this)) {
            loadGithubUsers();
        }
        else {
            Snackbar.make(findViewById(R.id.main_layout), "No internet connection", Snackbar.LENGTH_INDEFINITE).setDuration(60000)
                    .setAction("Retry", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            loadGithubUsers();
                        }
                    })
                    .show();
        }
    }
}

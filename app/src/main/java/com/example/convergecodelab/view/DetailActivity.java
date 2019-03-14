package com.example.convergecodelab.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.convergecodelab.R;
import com.example.convergecodelab.model.GithubUserProfile;
import com.example.convergecodelab.presenter.GithubProfilePresenter;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity implements GithubUserProfileView {
    CircleImageView imgProfile;
    TextView txtUsername,txtCreate_date,txtOrg,txtFollowers,txtFollowing,txtRepos,txtGists,txtBio;

    private String profileUrl;
    private String organization;
    private String joinDate;
    private String repos;
    private String followers;
    private String following;
    private String bioInfo;
    private String gists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgProfile = (CircleImageView) findViewById(R.id.userProfile);
        txtUsername = (TextView)findViewById(R.id.userName);
        txtCreate_date = (TextView)findViewById(R.id.userCreate_date);
        txtOrg = (TextView)findViewById(R.id.userOrgs);
        txtFollowers = (TextView)findViewById(R.id.userFollowers);
        txtFollowing = (TextView)findViewById(R.id.userFollowing);
        txtRepos = (TextView)findViewById(R.id.userRepositories);
        txtGists = (TextView)findViewById(R.id.userGists);
        txtBio = (TextView)findViewById(R.id.userBioInformation);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        GithubProfilePresenter profilePresenter= new GithubProfilePresenter(this);
        profilePresenter.getGithubProfiles(username);

        Picasso.get().load(intent.getStringExtra("imageUrl")).into(imgProfile);
        txtUsername.setText(username);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void getReadyProfiles(GithubUserProfile githubUser) {
        this.profileUrl = githubUser.getProfileUrl();
        this.organization = githubUser.getCompany();
        this.joinDate = githubUser.getJoinDate();
        this.repos = githubUser.getRepos();
        this.followers = githubUser.getFollowers();
        this.following = githubUser.getFollowing();
        this.bioInfo = githubUser.getBio();
        this.gists = githubUser.getGists();
        getProfiles();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void getProfiles(){
        try {
            joinDate = dateConverter();
        } catch (ParseException e) {
            Log.d("Error", "An error occurred " + e.getMessage());
        }
        if(this.organization == null){
            this.organization = "User has no bio";
        }
        if(this.bioInfo == null){
            this.bioInfo = "User has no bio";
        }
        String date = "Joined on " + joinDate;
        txtCreate_date.setText(date);
        txtOrg.setText(organization);
        txtFollowers.setText(followers);
        txtFollowing.setText(following);
        txtRepos.setText(repos);
        txtGists.setText(gists);
        txtBio.setText(bioInfo);

        txtUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse(profileUrl));
                startActivity(in);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String dateConverter() throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat("MMM, d yyyy", Locale.ENGLISH);
        Date date = inputFormat.parse(joinDate);
        return outputFormat.format(date);
    }
}

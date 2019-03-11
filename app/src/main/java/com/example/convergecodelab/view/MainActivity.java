package com.example.convergecodelab.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.convergecodelab.R;

public class MainActivity extends AppCompatActivity {
    RelativeLayout detailsView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detailsView = (RelativeLayout) findViewById(R.id.detailsView);

        detailsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDetails();
            }
        });
    }

    /*Launch DetailActivity to view user profile*/
    public void viewDetails(){
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

}

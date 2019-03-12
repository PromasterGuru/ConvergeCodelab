package com.example.convergecodelab.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.convergecodelab.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.ViewHolder>{

    ArrayList<String> usernames = new ArrayList<>();
    ArrayList<String> imageUrls = new ArrayList<>();

    public GithubAdapter(Context context, ArrayList<String> usernames, ArrayList<String> imageUrls) {
        this.usernames = usernames;
        this.imageUrls = imageUrls;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public final View itemView;
        public final TextView username;
        public final CircleImageView imageUrl;
        public final CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            username = itemView.findViewById(R.id.txtUsername);
            imageUrl = itemView.findViewById(R.id.imgUser);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_users, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.username.setText(usernames.get(viewHolder.getAdapterPosition()));
        Picasso.get().load(imageUrls.get(viewHolder.getAdapterPosition())).into(viewHolder.imageUrl);

    }

    @Override
    public int getItemCount() {
        if(usernames != null){
            return usernames.size();
        }
        else{
            return 0;
        }
    }
}

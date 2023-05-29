package com.example.daiscrivi_mobileapp_semester4.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daiscrivi_mobileapp_semester4.Adapter.Constant;
import com.example.daiscrivi_mobileapp_semester4.Models.Post;
import com.example.daiscrivi_mobileapp_semester4.Models.response.StoriesResponse;
import com.example.daiscrivi_mobileapp_semester4.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapterHome extends  RecyclerView.Adapter<PostAdapterHome.PostsHolder>{

    private Context context;

    private StoriesResponse storiesResponse;

    public PostAdapterHome(Context context, StoriesResponse storiesResponse) {
        this.context = context;
        this.storiesResponse = storiesResponse;
    }

    @NonNull
    @Override
    public PostsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_post_home, parent, false);
        return new PostsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsHolder holder, int position) {

        Picasso.get().load(Constant.URL+"storage/posts/"+storiesResponse.getData().get(position).getCover());
        holder.txtName.setText(storiesResponse.getData().get(position).getUser().getUsername());
        holder.txtLikes.setText(String.valueOf(storiesResponse.getData().get(position).getLikes_count()));
        holder.txtDate.setText(storiesResponse.getData().get(position).getCreated_at());
        holder.txtDesc.setText(storiesResponse.getData().get(position).getSynopsis());
    }

    @Override
    public int getItemCount() {
        return storiesResponse.getData().size();
    }

    class PostsHolder extends RecyclerView.ViewHolder{

        private TextView txtName,txtDate,txtDesc,txtLikes,txtComments;
        private CircleImageView imgProfile;
        private ImageView imgPost;
        private ImageButton btnPostOption,btnComment;

        public PostsHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtPostName);
            txtDate = itemView.findViewById(R.id.txtPostDate);
            txtDesc = itemView.findViewById(R.id.txtPostDesc);
            txtLikes = itemView.findViewById(R.id.txtPostLikes);
            txtComments = itemView.findViewById(R.id.txtPostComments);
            imgProfile = itemView.findViewById(R.id.imgPostProfile);
            imgPost = itemView.findViewById(R.id.imgPostPhoto);
            btnPostOption = itemView.findViewById(R.id.btnPostOption);
            btnComment = itemView.findViewById(R.id.btnPostComment);
            btnPostOption.setVisibility(View.GONE);
        }
    }
}

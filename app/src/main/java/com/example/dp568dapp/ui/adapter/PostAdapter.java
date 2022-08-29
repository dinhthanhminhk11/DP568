package com.example.dp568dapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dp568dapp.R;
import com.example.dp568dapp.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<Post> listData;

    public PostAdapter(List<Post> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_newspost, parent, false);
        return new PostAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = listData.get(position);
        if (post != null) {
            holder.count.setText("" + post.getCount());
            holder.namePost.setText(post.getTitle());
            holder.kingOfPost.setText(post.getKingOfPost());
            holder.image.setBackgroundResource(post.getImage());
        }
    }

    @Override
    public int getItemCount() {
        return listData == null ? 0 : listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView namePost;
        private TextView kingOfPost;
        private TextView count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            namePost = (TextView) itemView.findViewById(R.id.namePost);
            kingOfPost = (TextView) itemView.findViewById(R.id.kingOfPost);
            count = (TextView) itemView.findViewById(R.id.count);

        }
    }
}

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

public class PostFeedBackAdapter extends RecyclerView.Adapter<PostFeedBackAdapter.ViewHolder> {
    private List<Post> data;

    public PostFeedBackAdapter(List<Post> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feedback, parent, false);
        return new PostFeedBackAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = data.get(position);
        if (post != null) {
            holder.count.setText("" + post.getCount());
            holder.tvTenKhachSan.setText(post.getTitle());
            holder.kingOfPost.setText(post.getKingOfPost());
            holder.image.setBackgroundResource(post.getImage());
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView tvTenKhachSan;
        private TextView kingOfPost;
        private TextView count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            tvTenKhachSan = (TextView) itemView.findViewById(R.id.tvTenKhachSan);
            kingOfPost = (TextView) itemView.findViewById(R.id.kingOfPost);
            count = (TextView) itemView.findViewById(R.id.count);

        }
    }
}

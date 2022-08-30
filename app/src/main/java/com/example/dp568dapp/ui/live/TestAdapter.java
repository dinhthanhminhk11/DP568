package com.example.dp568dapp.ui.live;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;


import com.example.dp568dapp.databinding.ItemCommentBinding;
import com.example.dp568dapp.databinding.ItemLoadBeforeBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestAdapter extends ListAdapter<Object, RecyclerView.ViewHolder> {

    private final int TYPE_COMMENT = 1;
    private final int TYPE_LOAD_BEFORE = 2;

    private Context context;
    private OnLoadMoreCommentListener loadMoreCommentListener;

    private static LiveCommentDiffCallback DIFF_CALLBACK = new LiveCommentDiffCallback();

    protected TestAdapter(@NonNull DiffUtil.ItemCallback<Object> diffCallback) {
        super(diffCallback);
    }

    public TestAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    public void setLoadMoreCommentListener(OnLoadMoreCommentListener loadMoreCommentListener) {
        this.loadMoreCommentListener = loadMoreCommentListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_COMMENT) {
            ItemCommentBinding binding = ItemCommentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new VH(binding);
        } else if (viewType == TYPE_LOAD_BEFORE) {
            ItemLoadBeforeBinding binding = ItemLoadBeforeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new CommentLoaderVH(binding);
        } else {
            return new EmptyVH(new View(parent.getContext()));
        }
    }

    @Override
    public void submitList(@Nullable List<Object> list) {
        if (list != null) {
            super.submitList(new ArrayList<>(list));
        }
    }

    @Override
    public int getItemViewType(int position) {
        Object obj = getItem(position);
        if (obj instanceof Comment) return TYPE_COMMENT;
        else if (obj instanceof LoadBeforeObj) return TYPE_LOAD_BEFORE;
        else return super.getItemViewType(position);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VH) {
            VH vh = (VH) holder;
            vh.setData((Comment) getItem(position));
        } else if (holder instanceof CommentLoaderVH) {
            CommentLoaderVH commentLoaderVH = (CommentLoaderVH) holder;
            commentLoaderVH.setData();
        }
    }

    public class VH extends RecyclerView.ViewHolder {

        private ItemCommentBinding binding;

        public VH(@NonNull ItemCommentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setData(Comment comment) {
            binding.tvMes.setText(comment.content);
            String name[] = {"Phong Max Official đã ghim", "QUYÊN BÍCH", "Trang Thu", "Thơm Trần", "Lê T.Nhật Lệ",
                    "Dũng",
                    "Mai Lan",
                    "Quy Maingoc",
                    "Chu Lan Anh",
                    "Quách Trung Dương",
                    "Lan Nguyễn",
                    "Phạm Thùy Linh",
                    "Đỗ Quân",
            };
            Random random = new Random();
            int index = random.nextInt(name.length - 0) + 0;
            binding.tvUser.setText(name[index]);
        }
    }

    public class CommentLoaderVH extends RecyclerView.ViewHolder {

        private ItemLoadBeforeBinding binding;

        public CommentLoaderVH(@NonNull ItemLoadBeforeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setData() {
            binding.tvLoadMore.setOnClickListener(v -> {
                if (loadMoreCommentListener != null) {
                    loadMoreCommentListener.onLoadMoreComment();
                }
            });
        }
    }

    public class EmptyVH extends RecyclerView.ViewHolder {
        public EmptyVH(@NonNull View itemView) {
            super(itemView);
        }
    }

    public interface OnLoadMoreCommentListener {
        void onLoadMoreComment();
    }
}

package com.example.dp568dapp.ui.live;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class LiveCommentDiffCallback extends DiffUtil.ItemCallback<Object> {
    @Override
    public boolean areItemsTheSame(@NonNull Object oldItem, @NonNull Object newItem) {
        if (oldItem instanceof Comment && newItem instanceof Comment) {
            Comment oldComment = (Comment) oldItem;
            Comment newComment = (Comment) newItem;
            return oldComment.content.equals(newComment.content);
        }
        return oldItem instanceof LoadBeforeObj && newItem instanceof LoadBeforeObj;
    }

    @Override
    public boolean areContentsTheSame(@NonNull Object oldItem, @NonNull Object newItem) {
        if (oldItem instanceof Comment && newItem instanceof Comment) {
            Comment oldComment = (Comment) oldItem;
            Comment newComment = (Comment) newItem;
            return oldComment.content.equals(newComment.content);
        }
        return oldItem instanceof LoadBeforeObj && newItem instanceof LoadBeforeObj;
    }
}

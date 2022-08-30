package com.example.dp568dapp.ui.live;

import android.os.Handler;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class LiveCommentViewModel extends ViewModel {

    private MutableStateLiveData<List<Comment>> beforeCommentLiveData = new MutableStateLiveData<>();
    private Handler handler = new Handler();

    public void getBeforeData(final int count) {
        handler.postDelayed(() -> {
            List<Comment> result = new ArrayList<>();
            for (int i = 10; i >= 1; i--) {
                int id = count - i;
                result.add(new Comment(id, "Comment " + id));
            }
            beforeCommentLiveData.postSuccess(result);
        }, 300);
    }

    public MutableStateLiveData<List<Comment>> getBeforeCommentLiveData() {
        return beforeCommentLiveData;
    }
}

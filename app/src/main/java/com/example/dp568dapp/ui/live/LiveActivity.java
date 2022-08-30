package com.example.dp568dapp.ui.live;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dp568dapp.databinding.ActivityLiveBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class LiveActivity extends AppCompatActivity
        implements FakeThread.Callback, LiveCommentConsumer.OnNewLiveCommentListener, TestAdapter.OnLoadMoreCommentListener {

    private final int MAX_QUEUE_SIZE = 100;
    private int THRESHOLD = 40;
    private final int PIVOT = MAX_QUEUE_SIZE / 2;

    private List<Object> liveCommentList;
    private int count = 0;
    private TestAdapter mLiveStreamCommentAdapter;

    private ActivityLiveBinding mBinding;

    private ExecutorService liveCommentPool;
    private LiveCommentConsumer liveCommentConsumer;
    private BlockingQueue<Object> liveCommentBlockingQueue;
    private FakeThread fakeThread;
    private LinearLayoutManager mLayoutManager;
    private boolean isLoading = false;
    private LiveCommentViewModel liveCommentViewModel;
    private int startCommentIndexInList = 0;
    private CommentLoaderMode commentLoaderMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityLiveBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        liveCommentBlockingQueue = new LinkedBlockingQueue<>();

        liveCommentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            liveCommentList.add(new Comment(i, "Bình luận " + i));
            count++;
        }

        liveCommentViewModel = new ViewModelProvider(this).get(LiveCommentViewModel.class);
        liveCommentViewModel.getBeforeCommentLiveData().observe(this, this::handleCommentData);

        mLiveStreamCommentAdapter = new TestAdapter(this);
        mLiveStreamCommentAdapter.setLoadMoreCommentListener(this);
        mLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mBinding.commentList.setLayoutManager(mLayoutManager);
        mBinding.commentList.setAdapter(mLiveStreamCommentAdapter);
        liveCommentList.add(0, new LoadBeforeObj());
        mLiveStreamCommentAdapter.submitList(liveCommentList);

        mBinding.commentList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (mLayoutManager != null) {
                    int currentPosition = mLayoutManager.findLastCompletelyVisibleItemPosition();
                    Log.d("anh.dt2", "currentPos = " + currentPosition + " & mode = " + (currentPosition >= PIVOT));
                }
            }
        });

        mBinding.showNewComment.setOnClickListener(v->{
            mBinding.commentList.getLayoutManager().scrollToPosition(liveCommentList.size()-1);
        });
        liveCommentPool = Executors.newScheduledThreadPool(3);
        liveCommentConsumer = new LiveCommentConsumer(liveCommentBlockingQueue, this);
        liveCommentConsumer.start();

        //start add data
        fakeThread = new FakeThread(count, this);
        fakeThread.start();
    }

    private void handleCommentData(StateData<List<Comment>> listStateData) {
        switch (listStateData.getStatus()) {
            case LOADING:
                break;
            case SUCCESS:
                List<Comment> commentList = listStateData.getData();
                if (commentList != null && commentList.size() > 0) {
                    if (liveCommentList.size() > 0) {
                        Object obj1 = liveCommentList.get(0);
                        if (obj1 instanceof LoadBeforeObj) {
                            liveCommentList.remove(obj1);
                        }
                        startCommentIndexInList = commentList.get(0).id;
                        liveCommentList.addAll(0, commentList);
                        liveCommentList.add(0, new LoadBeforeObj());
                        runOnUiThread(() -> {
                            if (mLiveStreamCommentAdapter != null) {
                                mLiveStreamCommentAdapter.submitList(liveCommentList);
                            }
                        });
                    }
                }
                isLoading = false;
                break;
        }
    }

    @Override
    public void newLiveComment(Comment comment) {
        LiveCommentProducer liveCommentProducer = new LiveCommentProducer(liveCommentBlockingQueue, comment);
        if (liveCommentPool != null && !liveCommentPool.isShutdown()) {
            liveCommentPool.execute(liveCommentProducer);
        }
    }

    @Override
    public void onNewLiveCommentListener(Object o) {
        if (liveCommentList != null) {

            liveCommentList.add(o);
            if (mLiveStreamCommentAdapter != null) {
                mLiveStreamCommentAdapter.submitList(liveCommentList);
                if (mLayoutManager != null) {
                    int lastVisibleItemPosition = mLayoutManager.findLastVisibleItemPosition();
                    if (lastVisibleItemPosition + 2 >= liveCommentList.size() - 1) {
                        mBinding.showNewComment.setVisibility(View.GONE);
                        mBinding.commentList.smoothScrollToPosition(liveCommentList.size() - 1);
                    } else {
                        mBinding.showNewComment.setVisibility(View.VISIBLE);
                    }

                    int commentListSize = liveCommentList.size();
                    if (lastVisibleItemPosition >= MAX_QUEUE_SIZE * 2 / 3 && commentListSize > MAX_QUEUE_SIZE) {
                        Log.d("anh.dt2", "trigger remove datas");
                        liveCommentList.subList(0, commentListSize - MAX_QUEUE_SIZE + THRESHOLD
                        ).clear();
                        if (mLiveStreamCommentAdapter != null) {
                            if (liveCommentList.size() > 0) {
                                Object obj1 = liveCommentList.get(0);
                                startCommentIndexInList = ((Comment) obj1).id;
                            }
                            liveCommentList.add(0, new LoadBeforeObj());
                            mLiveStreamCommentAdapter.submitList(liveCommentList);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onLiveCommentRemoveRequested() {

    }

    @Override
    public void onLoadMoreComment() {
        if (!isLoading) {
            isLoading = true;
            liveCommentViewModel.getBeforeData(startCommentIndexInList);
        }
    }
}
package com.example.dp568dapp.ui.live;

import android.os.Handler;
import android.util.Log;

import java.util.concurrent.BlockingQueue;

public class LiveCommentConsumer extends Thread {

    private BlockingQueue<Object> queue;
    private final int DELAY_TIME = 100;
    private OnNewLiveCommentListener onNewLiveCommentListener;
    private Handler handler;
    private final Object lock = new Object();

    public LiveCommentConsumer(BlockingQueue<Object> queue, OnNewLiveCommentListener onNewLiveCommentListener) {
        this.queue = queue;
        this.onNewLiveCommentListener = onNewLiveCommentListener;
        this.handler = new Handler();
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (queue.size() == 0) {
                    Thread.sleep(50);
                    continue;
                }
//                if (queue.size() > Constants.MAX_LIVE_COMMENT_COUNT) {
//                    for (int i = 0; i < queue.size() / 2; i++) {
//                        queue.poll();
//                    }
//                    onNewLiveCommentListener.onLiveCommentRemoveRequested();
//                }

                int queueSize = queue.size();
                if (queueSize > 0) {
                    Constants.LIVE_COMMENT_DELAY_TIME = Math.max(1000 / queueSize, 50);
                } else {
                    Constants.LIVE_COMMENT_DELAY_TIME = Constants.LIVE_COMMENT_DELAY_TIME_DEFAULT;
                }

                Object o = queue.take();
                Runnable runnable = () -> {
                    if (onNewLiveCommentListener != null) {
                        onNewLiveCommentListener.onNewLiveCommentListener(o);
                    }
                    synchronized (lock) {
                        lock.notify();
                    }
                };
                handler.post(runnable);
                try {
                    synchronized (lock) {
                        lock.wait(200);
                    }
                } catch (InterruptedException e) {
                    Log.d("anh.dt2", "LiveCommentConsumer lock " + e.getMessage());
                    break;
                }
                Thread.sleep(Constants.LIVE_COMMENT_DELAY_TIME);
            }
        } catch (InterruptedException e) {
            Log.d("anh.dt2", "LiveCommentConsumer " + e.getMessage());
        }
    }

    public interface OnNewLiveCommentListener {
        void onNewLiveCommentListener(Object o);

        void onLiveCommentRemoveRequested();
    }
}

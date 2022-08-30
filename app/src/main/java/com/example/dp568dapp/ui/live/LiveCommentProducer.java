package com.example.dp568dapp.ui.live;

import java.util.concurrent.BlockingQueue;

public class LiveCommentProducer implements Runnable {
    private BlockingQueue<Object> queue;
    private Comment comment;

    public LiveCommentProducer(BlockingQueue<Object> queue, Comment comment) {
        this.queue = queue;
        this.comment = comment;
    }

    @Override
    public void run() {
        if (comment != null) {
            try {
                queue.put(comment);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

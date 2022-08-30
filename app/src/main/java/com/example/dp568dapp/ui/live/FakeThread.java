package com.example.dp568dapp.ui.live;

public class FakeThread extends Thread {

    private int intCount = 0;
    private Callback callback;

    public FakeThread(int intCount, Callback callback) {
        this.intCount = intCount;
        this.callback = callback;
    }

    @Override
    public void run() {
        putNewComment();
    }

    private void putNewComment() {
        Comment comment = new Comment(intCount, "Comment " + intCount++);
        if (callback != null) {
            callback.newLiveComment(comment);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        putNewComment();
    }

    public interface Callback {
        void newLiveComment(Comment comment);
    }
}

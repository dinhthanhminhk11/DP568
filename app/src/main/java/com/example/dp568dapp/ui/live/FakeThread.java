package com.example.dp568dapp.ui.live;

import java.util.ArrayList;
import java.util.Random;

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
        String name[] = {
                "Totally slayed it !!! \uD83D\uDD25⚔️",
                "This background is simply incredible",
                "Love this song since I was a child , when I was practicing martial arts. Your version is amazing awesome!!\uD83D\uDC4D\uD83D\uDC96\uD83D\uDC96\uD83D\uDC96\uD83D\uDC96!!!",
                "no one can't beat down huang fei hung when this banger play",
                "I am addicted to this song! Listened to it 1000 times already \uD83E\uDD70\uD83E\uDD70\uD83E\uDD70",
                "Great music, love Wukong",
                "Makes me want to practice Shaolin kung-fu and Hung-Gar",
                "I cracked up when I first heard it. Now I am listening to it everyday.",
                "love this so much ❤",
                "Fantastic music by the legendary Foshan Wong Fei Hung played by two martial artist starts Jet Li and Vincent zhao",
                "Its amazing. I love it. Thank to this song im so happy right now haha. Thanks u. From Vietnam ❤️",
                "great music \uD83D\uDD25\uD83D\uDD25\uD83D\uDD25",
                "A very good song\n" +
                        "一首非常好的歌\n" +
                        "Một bài nhạc rất hay",
                "Quả nhạc quá cháy, chất lượng video quá tuyệt vời!! Amazing ❤️❤️",
                "Nhạc cháy quá \uD83D\uDD25\uD83D\uDD25\uD83D\uDD25 VFX đỉnh thật sự",
                "i enjoyed this track. can you give me mp3 version",
                "Sau khi nghe bài này và làm 1 hơi đá, tôi đã xách phóng đi cháy phố, rất hảo hán",
                "Haha as an Asian my buddy used to play the song in class in front of everyone and ppl are like wtfff lmaoooo",
                "Kênh Music của VN luôn đỉnh :)))",
                "well done guys",
                "Ohhhh shittttt !!!! Tuyệt zời \uD83D\uDC4F",
                "bản hay nhất toi từng nghe aaaaaaaaaa\uD83E\uDD75",
                "无意间听到这首歌上头啊 \uD83D\uDE01\uD83D\uDE01\uD83D\uDE01",
                "hands up \uD83D\uDD25\uD83E\uDD18\uD83E\uDD18\uD83E\uDD18\uD83D\uDD25",

        };
        Random random = new Random();
        int index = random.nextInt(name.length - 0) + 0;
        Comment comment = new Comment(intCount, " " + name[index] + " ");
        if (callback != null) {
            callback.newLiveComment(comment);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        putNewComment();
    }

    public interface Callback {
        void newLiveComment(Comment comment);
    }
}

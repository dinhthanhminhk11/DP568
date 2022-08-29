package com.example.dp568dapp.model;

public class Post {
    private int id;
    private String title;
    private String kingOfPost;
    private String content;
    private int count;
    private int image;

    public Post(int id, String title, String kingOfPost, String content, int count, int image) {
        this.id = id;
        this.title = title;
        this.kingOfPost = kingOfPost;
        this.content = content;
        this.count = count;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKingOfPost() {
        return kingOfPost;
    }

    public void setKingOfPost(String kingOfPost) {
        this.kingOfPost = kingOfPost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

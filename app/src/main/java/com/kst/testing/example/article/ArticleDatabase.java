package com.kst.testing.example.article;

public class ArticleDatabase {

    private ArticleListener articleListener;
    private User user;

    public void addListener(ArticleListener articleListener) {
        this.articleListener = articleListener;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
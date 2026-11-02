package com.news;

import java.sql.Timestamp;

public class News {
    private final int id;
    private final String title;
    private final String content;
    private final Timestamp createdAt;

    public News(int id, String title, String content, Timestamp createdAt) {
        this.id = id; this.title = title; this.content = content; this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public Timestamp getCreatedAt() { return createdAt; }
}

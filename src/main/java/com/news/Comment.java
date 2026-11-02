package com.news;

import java.sql.Timestamp;

public class Comment {
    private final String author;
    private final String text;
    private final Timestamp createdAt;

    public Comment(String author, String text, Timestamp createdAt) {
        this.author = author; this.text = text; this.createdAt = createdAt;
    }

    public String getAuthor() { return author; }
    public String getText() { return text; }
    public Timestamp getCreatedAt() { return createdAt; }
}

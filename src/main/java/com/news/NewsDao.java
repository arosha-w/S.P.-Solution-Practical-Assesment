package com.news;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDao {

    public List<Category> getCategories() throws SQLException {
        var list = new ArrayList<Category>();
        try (var c = DB.get();
             var s = c.createStatement();
             var rs = s.executeQuery("SELECT id, name FROM category ORDER BY name")) {
            while (rs.next()) list.add(new Category(rs.getInt(1), rs.getString(2)));
        }
        return list;
    }

    public Category getCategory(int id) throws SQLException {
        try (var c = DB.get();
             var ps = c.prepareStatement("SELECT id, name FROM category WHERE id = ?")) {
            ps.setInt(1, id);
            try (var rs = ps.executeQuery()) {
                return rs.next() ? new Category(rs.getInt(1), rs.getString(2)) : null;
            }
        }
    }

    public List<News> getNewsByCategory(int categoryId) throws SQLException {
        String sql = """
            SELECT n.id, n.title, n.content, n.created_at
            FROM news n
            JOIN news_category nc ON nc.news_id = n.id
            WHERE nc.category_id = ?
            ORDER BY n.created_at DESC
            """;
        var list = new ArrayList<News>();
        try (var c = DB.get(); var ps = c.prepareStatement(sql)) {
            ps.setInt(1, categoryId);
            try (var rs = ps.executeQuery()) {
                while (rs.next())
                    list.add(new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4)));
            }
        }
        return list;
    }

    public News getNews(int id) throws SQLException {
        try (var c = DB.get();
             var ps = c.prepareStatement(
                 "SELECT id, title, content, created_at FROM news WHERE id = ?")) {
            ps.setInt(1, id);
            try (var rs = ps.executeQuery()) {
                return rs.next()
                    ? new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4))
                    : null;
            }
        }
    }

    public List<Comment> getComments(int newsId) throws SQLException {
        var list = new ArrayList<Comment>();
        try (var c = DB.get();
             var ps = c.prepareStatement(
                 "SELECT author, text, created_at FROM comment WHERE news_id = ? ORDER BY created_at DESC, id DESC")) {
            ps.setInt(1, newsId);
            try (var rs = ps.executeQuery()) {
                while (rs.next())
                    list.add(new Comment(rs.getString(1), rs.getString(2), rs.getTimestamp(3)));
            }
        }
        return list;
    }

    public void addComment(int newsId, String author, String text) throws SQLException {
        try (var c = DB.get();
             var ps = c.prepareStatement(
                 "INSERT INTO comment(news_id, author, text) VALUES (?, ?, ?)")) {
            ps.setInt(1, newsId);
            ps.setString(2, author);
            ps.setString(3, text);
            ps.executeUpdate();
        }
    }
}

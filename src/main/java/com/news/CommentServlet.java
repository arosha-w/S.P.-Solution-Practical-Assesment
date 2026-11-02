package com.news;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            int newsId = Integer.parseInt(req.getParameter("newsId"));
            String author = req.getParameter("author");
            String text = req.getParameter("text");
            author = author == null ? "" : author.trim();
            text = text == null ? "" : text.trim();
            if (!author.isEmpty() && !text.isEmpty()) {
                new NewsDao().addComment(newsId, author, text);
            }
            resp.sendRedirect(req.getContextPath() + "/news?id=" + newsId);
        } catch (NumberFormatException e) {
            resp.sendError(400, "Invalid news id");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

package com.news;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            var dao = new NewsDao();
            News news = dao.getNews(id);
            if (news == null) { resp.sendError(404, "News not found"); return; }
            req.setAttribute("news", news);
            req.setAttribute("comments", dao.getComments(id));
            req.getRequestDispatcher("/news.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            resp.sendError(400, "Invalid news id");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

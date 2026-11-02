package com.news;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            var dao = new NewsDao();
            Category category = dao.getCategory(id);
            if (category == null) { resp.sendError(404, "Category not found"); return; }
            req.setAttribute("category", category);
            req.setAttribute("newsList", dao.getNewsByCategory(id));
            req.getRequestDispatcher("/category.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            resp.sendError(400, "Invalid category id");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

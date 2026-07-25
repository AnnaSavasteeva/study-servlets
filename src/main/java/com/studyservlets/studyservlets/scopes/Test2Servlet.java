package com.studyservlets.studyservlets.scopes;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Test2Servlet", value = "/test2")
public class Test2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Берем область Servlet Context и БЕРЕМ из нее данные по ключу
        ServletContext servletContext = getServletContext();
        String message = (String) servletContext.getAttribute("message");
        resp.getWriter().println("message: " + message);
    }
}

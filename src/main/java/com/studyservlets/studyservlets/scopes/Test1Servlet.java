package com.studyservlets.studyservlets.scopes;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/test1")
public class Test1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Берем область Servlet Context и КЛАДЕМ в нее данные
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("message", "Hello, World!");
    }
}

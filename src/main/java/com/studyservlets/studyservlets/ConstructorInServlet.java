package com.studyservlets.studyservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/constructor") // http://localhost:8081/constructor
public class ConstructorInServlet extends HttpServlet {

    public ConstructorInServlet(String name) {
        System.out.println("В stacktrace ошибки не будет, но запрос приведет к 404-й");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }
}

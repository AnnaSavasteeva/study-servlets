package com.studyservlets.studyservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/lifecycle")
public class LifeCycleExampleServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("LifeCycleExampleServlet = init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LifeCycleExampleServlet = service");
        super.service(req, resp); // НЕ УДАЛЯТЬ, иначе doGet, doPost... перестанут работать
    }

    @Override
    public void destroy() {
        System.out.println("LifeCycleExampleServlet = destroy");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Hello, World!");
    }
}

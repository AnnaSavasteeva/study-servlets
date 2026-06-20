package com.studyservlets.studyservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/greeting") // Этот сервлет обрабатывает запрос, когда в браузере вводится http://localhost:8081/greeting
public class GreetingServlet extends HttpServlet {

    @Override // Этот метод обрабатывает GET-запрос для ручки http://localhost:8081/greeting?name=Denis&age=22
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        // getWriter().println() — выводим данные в браузер
        resp.getWriter().println("Hello, %s!".formatted(name));
        resp.getWriter().println("Your age is %s!".formatted(age));
    }
}

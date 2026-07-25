package com.studyservlets.studyservlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
/*
// Этот сервлет обрабатывает одинаково несколько запросов:
- когда в браузер вводится http://localhost:8081/greeting
- когда в браузер вводится http://localhost:8081/hello
Еще можно сказать, что данный сервлет работает по такому-то пути: http://localhost:8081/greeting
 */
@WebServlet(urlPatterns = {"/greeting", "/hello"})
public class GreetingServlet extends HttpServlet {

    // Этот метод обрабатывает GET-запрос по адресу http://localhost:8081/greeting?name=Denis&age=22
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        // getWriter().println() — выводим данные в браузер
        resp.getWriter().println("Hello, %s!".formatted(name));
        resp.getWriter().println("Your age is %s!".formatted(age));
    }
}

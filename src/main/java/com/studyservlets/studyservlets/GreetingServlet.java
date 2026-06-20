package com.studyservlets.studyservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/greeting") // Этот сервлет обрабатывает запрос, когда в браузере вводится http://localhost:8080/greeting
public class GreetingServletGet extends HttpServlet {

    @Override // Этот метод обрабатывает GET-запрос по http://localhost:8080/greeting
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello World!");
    }
}

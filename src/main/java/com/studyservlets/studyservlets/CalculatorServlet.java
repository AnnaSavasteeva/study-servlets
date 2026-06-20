package com.studyservlets.studyservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/calc") // http://localhost:8081/calc?num1=2&num2=5&type=mul
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer num1 = Integer.parseInt(req.getParameter("num1"));
        Integer num2 = Integer.parseInt(req.getParameter("num2"));
        String type = req.getParameter("type");

        int result = switch (type) {
            case "add" -> num1 + num2;
            case "sub" -> num1 - num2;
            case "mul" -> num1 * num2;
            default -> 0;
        };

        resp.getWriter().println("Result = %d".formatted(result));
    }
}

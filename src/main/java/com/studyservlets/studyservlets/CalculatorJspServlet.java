package com.studyservlets.studyservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/calcjsp") // GET http://localhost:8081/calcjsp
public class CalculatorJspServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String version = req.getParameter("version");

        System.out.println(version);

        Integer result = Integer.parseInt(num1) + Integer.parseInt(num2);
        req.setAttribute("result", result);

        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }
}

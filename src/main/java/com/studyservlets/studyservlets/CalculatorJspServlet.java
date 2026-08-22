package com.studyservlets.studyservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/calcjsp") // GET http://localhost:8081/calcjsp
public class CalculatorJspServlet extends HttpServlet {

    private final InMemoryOperationStorage storage = new InMemoryOperationStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("version"));

        Integer num1 = Integer.parseInt(req.getParameter("num1"));
        Integer num2 = Integer.parseInt(req.getParameter("num2"));
        Integer result = num1 + num2;

        Operation operation = new Operation();
        operation.setId(UUID.randomUUID());
        operation.setNum1(num1);
        operation.setNum2(num2);
        operation.setResult(result);

        storage.addOperation(operation);

        req.setAttribute("result", result);

        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }
}

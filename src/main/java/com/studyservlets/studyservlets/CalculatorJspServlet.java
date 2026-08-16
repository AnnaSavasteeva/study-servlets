package com.studyservlets.studyservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/calcjsp") // GET http://localhost:8081/calcjsp
public class CalculatorJspServlet extends HttpServlet {

    private final InMemoryStorage storage = new InMemoryStorage();

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

//        Если в num1 и num2 будет null (пользователь отправил путсую форму) или буквы, то получим 500-ю.
//        Поэтому по-хорошему нжуно добавлять валидацию данных в фильтре или самом сервлете и в случае их невалидности
//        отправлять клиенту 400-ю (например, сделать под ошибку отдельную jsp)
        Integer result = Integer.parseInt(num1) + Integer.parseInt(num2);

        String formatted = "%s + %s = %s".formatted(num1, num2, result);
        storage.addOperation(formatted);

        req.setAttribute("result", result);

        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }
}

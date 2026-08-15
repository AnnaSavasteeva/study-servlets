package com.studyservlets.studyservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hellojsp")
public class GreetingJspServlet extends HttpServlet {

    @Override // GET http://localhost:8081/hellojsp?name=Vasya
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

//        Записываем данные в request context
        req.setAttribute("name", name);

//        Обращаемся к компоненту 'диспетчер запросов': направляем запрос из данного doGet на другой doGet или еще в какой-то метод.
//        Так можно создавать цепочку сервлетов. Удобно, например, для поэтапной регистрации с разными страницами, формами и т.д.
//        При форварде запроса передаются аргументы req и resp, а в req предварительно записали атрибут name
        getServletContext().getRequestDispatcher("/pages/hello.jsp").forward(req, resp);
    }
}

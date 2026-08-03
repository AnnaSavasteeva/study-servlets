package com.studyservlets.studyservlets.scopes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session1")
public class SessionContext1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        Получаем доступ к сессии и кладем в нее атрибут.
        Если запускать сервлет в разных браузерах или вкладках инкогнито и передавать разные имена в get-параметре name,
        то в каждом браузере будут выводиться разные имена, а не одно на всех как если бы даннеы хранились в Servlet Context
         */
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        session.setAttribute("message", "Hello, %s!".formatted(name));
    }
}

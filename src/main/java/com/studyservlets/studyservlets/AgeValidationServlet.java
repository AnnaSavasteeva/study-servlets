package com.studyservlets.studyservlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/age") // http://localhost:8081/age?age=20
public class AgeValidationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ageEntered = req.getParameter("age");

        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        if (ageEntered == null || ageEntered.isEmpty()) {
            resp.getWriter().println("Возраст не был указан");
        } else if (!ageEntered.matches("\\d+")) {
            resp.getWriter().println("Неверный формат данных");
        } else {
            int ageInt = Integer.parseInt(ageEntered);
            if (ageInt == 0 || ageInt > 120) {
                resp.getWriter().println("Такого возраста не существует");
            } else {
                String isAdults = (ageInt >= 18) ? "Совершеннолетний" : "Несовершеннолетний";
                resp.getWriter().println(isAdults);
            }
        }

    }
}

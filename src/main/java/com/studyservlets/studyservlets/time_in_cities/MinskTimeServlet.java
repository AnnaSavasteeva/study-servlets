package com.studyservlets.studyservlets.time_in_cities;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DateTimeUtil;

import java.io.IOException;
import java.time.ZoneId;

@WebServlet("/minsk") // http://localhost:8081/minsk
public class MinskTimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ZoneId minskZone = ZoneId.of("Europe/Minsk");
        String minskTime = DateTimeUtil.getCurrentTimeForZoneId(minskZone);

//        Для отображения кириллицы в HttpServletResponse
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("Текущее время в Минске: %s".formatted(minskTime));
    }
}

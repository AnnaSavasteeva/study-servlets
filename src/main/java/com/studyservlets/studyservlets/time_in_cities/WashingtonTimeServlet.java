package com.studyservlets.studyservlets.time_in_cities;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DateTimeUtil;

import java.io.IOException;
import java.time.ZoneId;

@WebServlet("/washington")
public class WashingtonTimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ZoneId washingtonZone = ZoneId.of("America/New_York");
        String washingtonTime = DateTimeUtil.getCurrentTimeForZoneId(washingtonZone);

//        Для отображения кириллицы в HttpServletResponse
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("Текущее время в Вашингтоне: %s".formatted(washingtonTime));
    }
}

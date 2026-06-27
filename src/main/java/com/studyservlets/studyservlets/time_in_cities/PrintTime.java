package com.studyservlets.studyservlets.time_in_cities;

import jakarta.servlet.http.HttpServletResponse;
import util.DateTimeUtil;

import java.io.IOException;
import java.time.ZoneId;

final class PrintTime {

    static void printTime(ZoneId zoneId, HttpServletResponse resp, String cityName) throws IOException {
//        Для отображения кириллицы в HttpServletResponse
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String timeByZoneId = DateTimeUtil.getCurrentTimeForZoneId(zoneId);
        resp.getWriter().println("Текущее время в %s: %s".formatted(cityName.concat("е"), timeByZoneId));
    }
}

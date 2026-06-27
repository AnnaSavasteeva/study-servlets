package com.studyservlets.studyservlets.time_in_cities;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZoneId;

@WebServlet("/beijing")
public class BeijingTimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ZoneId beijingZone = ZoneId.of("Asia/Shanghai");
        PrintTime.printTime(beijingZone, resp, "Пекин");
    }
}

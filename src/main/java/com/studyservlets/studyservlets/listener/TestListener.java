package com.studyservlets.studyservlets.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class TestListener implements ServletContextListener, HttpSessionListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        Это событие создания экземпляра мапы ServletContext — можно, например, сразу положить в нее какие-то данные
        ServletContext servletContext = sce.getServletContext();
//        some code
    }
}

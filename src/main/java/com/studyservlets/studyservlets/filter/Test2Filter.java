package com.studyservlets.studyservlets.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(servletNames = {"FilteredServlet"})
public class Test2Filter extends HttpFilter {

    @Override
    public void init() throws ServletException {
        System.out.println("init filter 2");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter 2 called");
        chain.doFilter(req, res);
    }
}

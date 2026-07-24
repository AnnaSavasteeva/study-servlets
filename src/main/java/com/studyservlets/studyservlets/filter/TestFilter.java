package com.studyservlets.studyservlets.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebFilter(servletNames = {"FilteredServlet"})
public class TestFilter extends HttpFilter {

    @Override
    public void init() throws ServletException {
        System.out.println("init filter 1");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter 1 called");

        String name = req.getParameter("name");
        if(Objects.isNull(name)) {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            res.getWriter().println("Oooooops, error!");
        } else {
            chain.doFilter(req, res); // без этого сервлет просто не отработает, т.к. цепочка не будет продолжена
        }

    }
}

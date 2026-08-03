package com.studyservlets.studyservlets.scopes;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebFilter(servletNames = {"ServletContext2Servlet"})
public class ServletContextFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();
        String message = (String) servletContext.getAttribute("message");

        if (Objects.isNull(message)) {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            res.getWriter().println("Oooooops, error!");
        } else {
            chain.doFilter(req, res);
        }
    }
}

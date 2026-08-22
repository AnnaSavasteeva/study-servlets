package com.studyservlets.studyservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@WebServlet("/operation/view")
public class OperationViewServlet extends HttpServlet {

    private final InMemoryOperationStorage storage = new InMemoryOperationStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Optional<Operation> operationById = storage.getOperationById(UUID.fromString(id));
        if (operationById.isPresent()) {
            Operation operation = operationById.get();
            req.setAttribute("operation", operation);
            getServletContext().getRequestDispatcher("/pages/operation.jsp").forward(req, resp);
        } else {
            resp.sendError(404);
        }
    }
}

package com.studyservlets.studyservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/avatar")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024
        , maxFileSize = 1024 * 1024 * 10
        , maxRequestSize = 1024 * 1024 * 100
)
public class AvatarUploadServlet extends HttpServlet {

    private static final Map<String, byte[]> avatars = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/avatar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part avatar = req.getPart("avatar");

//        Для учебных целей — просто посмотреть, что файл записался:
        avatar.write("avatar.jpg");

//        Более универсальный и правильный подход: перегнать файл в байты и потом восстановить из байт там, где требуется
        InputStream inputStream = avatar.getInputStream();
        byte[] bytes = inputStream.readAllBytes();
        avatars.put(avatar.getSubmittedFileName(), bytes);
    }
}

package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.StudentBuilder;

@WebServlet(name = "Builder", urlPatterns = {"/builder"})
public class Builder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // (#2.1 Melakukan request Dispatch ke builder JSP)
        request.getRequestDispatcher("builder.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String message = "";

        // (#2.2 Melakukan pengecekan apakah getParam table sama dengan Student)
        if ("Student".equals(request.getParameter("table"))) {

            // (#2.3 Membuat objek StudentBuilder)
            StudentBuilder studentBuilder = new StudentBuilder();

            // (#2.4 memanggil createTable dari objek)
            studentBuilder.createTable();

            // (#2.5 menyimpan dan memanggil getMessage dari objek)
            message = studentBuilder.getMessage();

            // (#2.6 melakukan request setAtribute dengan parsing data message)
            request.setAttribute("message", message);
        }

        // (#2.7 melakukan request Dispatch ke builder JSP)
        request.getRequestDispatcher("builder.jsp").forward(request, response);
    }

}

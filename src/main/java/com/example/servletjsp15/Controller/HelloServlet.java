package com.example.servletjsp15.Controller;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

            response.sendRedirect("sales_register");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("product_name")!=null){
            req.setAttribute("product", req.getParameter("product_name"));
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
        }
    }

    public void destroy() {
    }
}
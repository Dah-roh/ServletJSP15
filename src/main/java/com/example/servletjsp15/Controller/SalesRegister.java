package com.example.servletjsp15.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="SalesRegister", value = "/sales_register")
public class SalesRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("register.jsp");
        String name = "Gadibia";
//        HttpSession session  = req.getSession();
        req.setAttribute("username", name);
        RequestDispatcher  dispatcher =  req.getRequestDispatcher("register.jsp");

        System.out.println(name);
        dispatcher.forward(req, resp);
    }


}

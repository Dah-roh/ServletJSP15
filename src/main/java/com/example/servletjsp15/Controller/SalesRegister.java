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

    //using the doGet to handle get method requests below
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "Gadibia";
        //how to access a user's session info below (Note: it is just a side-note)
        //HttpSession session  = req.getSession();


        //storing a value as request attribute
        // using the request.setAttribute( "key", value);
        req.setAttribute("username", name);


        //declaring the destination of the request and response
        // using the RequestDispatcher below
        RequestDispatcher  dispatcher =  req.getRequestDispatcher("register.jsp");

        //sending our response back, alongside
        // our "username" request attribute
        dispatcher.forward(req, resp);
    }


}

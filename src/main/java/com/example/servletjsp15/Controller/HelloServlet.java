package com.example.servletjsp15.Controller;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.servletjsp15.DAO.RecieptDAO;
import com.example.servletjsp15.Model.Reciept;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    //using the doGet method to handle get method requests below
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    //redirect from "hello-servlet" to "sales_register" servlet
            response.sendRedirect("sales_register");
    }

    //using the doPost to handle post requests
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecieptDAO  recieptDAO = new RecieptDAO();
        Reciept reciept = new Reciept();
        //using the request.getParameter(with the input field name as key)
        //to access input sent from the Form in the register.jsp
        if (req.getParameter("product_name")!=null){
            reciept.setPrice(req.getParameter("price"));
            reciept.setProduct_name(req.getParameter("product_name"));
            reciept.setQuantity(req.getParameter("quantity"));
            try {
                recieptDAO.insertReciept(reciept);
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }



            req.setAttribute("product", req.getParameter("product_name"));
            //declaring our response destination below
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");

            //sending our response and it's request attribute to our
            // "index.jsp" destination now.
            dispatcher.forward(req, resp);
        }
    }

    public void destroy() {

    }
}
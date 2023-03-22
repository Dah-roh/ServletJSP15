package com.example.servletjsp15.Controller;

import com.example.servletjsp15.DAO.RecieptDAO;
import com.example.servletjsp15.Model.Reciept;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PurchasesServlet", value = "/purchase-servlet")
public class PurchasesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Reciept> recieptList;
        RecieptDAO recieptDAO = new RecieptDAO();
        try {
            recieptList = recieptDAO.findAllReciept();
            req.setAttribute("listOfReceipt", recieptList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(req, resp);
    }
}

package com.example.servletjsp15.DAO;

import com.example.servletjsp15.Config.DatabaseConfig;
import com.example.servletjsp15.Model.Reciept;

import java.sql.*;

public class RecieptDAO {
    private String jdbcUrl;
    private String jdbcUsername;
    private String jdbcPassword;

    public RecieptDAO() {
        DatabaseConfig databaseConfig =  new DatabaseConfig();
        this.jdbcUrl = databaseConfig.getJdbcUrl();
        this.jdbcUsername = databaseConfig.getJdbcUsername();
        this.jdbcPassword = databaseConfig.getJdbcPassword();
    }
    private Connection connection;


    public void setConnection() throws SQLException {
        if (connection==null||connection.isClosed()){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            connection = DriverManager
                    .getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
        }
    }


    public void closeConnection() throws SQLException {
        if (!connection.isClosed()||connection!=null){
            connection.close();
        }
    }

    public boolean insertReciept(Reciept reciept) throws SQLException {
        String sql = "INSERT INTO receipt (product_name, price, quantity) VALUES (?, ?, ?)";
        setConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, reciept.getProduct_name());
        preparedStatement.setString(2, reciept.getPrice());
        preparedStatement.setString(3, reciept.getQuantity());
        boolean rowsInserted = preparedStatement.executeUpdate() > 0;//difference between executeUpdate() and executeQuery()
        preparedStatement.close();
        closeConnection();
        return rowsInserted;
    }


}

package com.example.servletjsp15.DAO;

import com.example.servletjsp15.Config.DatabaseConfig;
import com.example.servletjsp15.Model.Reciept;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecieptDAO {
    private String jdbcUrl;
    private String jdbcUsername;
    private String jdbcPassword;

    public RecieptDAO() {
        //STILL A VERY USEFUL CODE!!
//        DatabaseConfig databaseConfig =  new DatabaseConfig();
//        this.jdbcUrl = databaseConfig.getJdbcUrl();
//        this.jdbcUsername = databaseConfig.getJdbcUsername();
//        this.jdbcPassword = databaseConfig.getJdbcPassword();
    }
    private Connection connection;


    public void setConnection() throws SQLException {
        if (connection==null||connection.isClosed()){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
                    DatabaseConfig databaseConfig =  new DatabaseConfig();
            connection = DriverManager
                    .getConnection(databaseConfig.getJdbcUrl(),
                            databaseConfig.getJdbcUsername(), databaseConfig.getJdbcPassword());
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


    public List<Reciept> findAllReciept() throws SQLException {
        //WHERE, JOIN, AND, INNER-JOIN, OUTER JOIN ...
        String sql = "SELECT * from receipt";
        setConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        Reciept reciept;
        List<Reciept> recieptList = new ArrayList<>();
        while (resultSet.next()){
            reciept = new Reciept();
            reciept.setId(resultSet.getInt(1));
            reciept.setProduct_name(resultSet.getString(2));
            reciept.setQuantity(resultSet.getString(3));
            reciept.setPrice(resultSet.getString(4));
            recieptList.add(reciept);
        }
        System.out.println(recieptList);
        return recieptList;
    }


}

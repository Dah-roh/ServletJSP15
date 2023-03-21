package com.example.servletjsp15.Config;

import lombok.Data;

@Data
public class DatabaseConfig {
    private final String jdbcUrl = "jdbc:mysql://localhost:3306/store";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "password";
}

package com.example.InvoiceSimilarityMatcher;

import java.sql.*;

public class DatabaseManager {

    private static final String URL = DatabaseConfig.getUrl();
    private static final String USERNAME = DatabaseConfig.getUsername();
    private static final String PASSWORD = DatabaseConfig.getPassword();

    public static ResultSet getAllInvoices() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        String query = "SELECT invoice_number, text FROM invoices";
        return statement.executeQuery(query);
    }
}

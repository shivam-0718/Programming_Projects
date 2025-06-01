package org.projects;

import java.sql.*;

public class DBConnection {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("This is not a correct JDBC Driver. Check it again!");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        final String URL = "jdbc:mysql://localhost:3306/projects";
        final String USERNAME = "shivam";
        final String PASSWORD = "Shivam18";
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void closeConnection(Statement statement, Connection connection) throws SQLException {
        statement.close();
        connection.close();
    }

    public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
        resultSet.close();
        statement.close();
        connection.close();
    }


}
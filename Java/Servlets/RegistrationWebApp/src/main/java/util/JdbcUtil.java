package util;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class JdbcUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connection established successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("This is not a correct JDBC Driver. Check it again!");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        final String URL = "jdbc:mysql://localhost:3306/servlets";
        final String USERNAME = "shivam";
        final String PASSWORD = "Shivam18";
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void closeConnection(Statement statement, Connection connection) throws SQLException {
        if (statement != null)
            statement.close();
        if (connection != null)
            connection.close();
    }

    public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
        if (resultSet != null)
            resultSet.close();
        if (statement != null)
            statement.close();
        if (connection != null)
            connection.close();
    }


}
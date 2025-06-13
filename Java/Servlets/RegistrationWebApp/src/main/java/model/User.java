package model;

import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String uname;
    private String email;
    private String password;
    private String ucity;
    private Connection connection = null;
    private PreparedStatement statement = null;

    public User() {
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUcity() {
        return ucity;
    }

    public void setUcity(String ucity) {
        this.ucity = ucity;
    }

    public int register() {
        String sql_register = "INSERT INTO personalinfo (uname, email, password, ucity) VALUES (?, ?, ?, ?);";
        int rowsAffected = 0;
        try {
            connection = JdbcUtil.getConnection();
            statement = connection.prepareStatement(sql_register);

            statement.setString(1, uname);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, ucity);

            rowsAffected = statement.executeUpdate();
            System.out.println("Registration attempt - Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            System.err.println("Registration failed with SQL error: " + e.getMessage()); // Log the error
            e.printStackTrace();
            return 0;
        } finally {
            try {
                JdbcUtil.closeConnection(statement, connection);
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return rowsAffected;
    }

    public User login() {
        String sql_login = "SELECT uname, email, ucity FROM personalinfo WHERE email = ? AND password = ?";
        User authenticatedUser = null;

        try {
            connection = JdbcUtil.getConnection();
            statement = connection.prepareStatement(sql_login);

            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                authenticatedUser = new User();
                authenticatedUser.setUname(resultSet.getString("uname"));
                authenticatedUser.setEmail(resultSet.getString("email"));
                authenticatedUser.setUcity(resultSet.getString("ucity"));
            }

        } catch (SQLException e) {
            System.err.println("Login failed with SQL error: " + e.getMessage());
            e.printStackTrace();
            return null; // Return null to indicate failure
        } finally {
            try {
                JdbcUtil.closeConnection(statement, connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return authenticatedUser;
    }
}

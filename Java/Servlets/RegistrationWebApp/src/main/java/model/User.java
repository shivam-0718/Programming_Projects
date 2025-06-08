package model;

import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        int rowsAffected;
        try {
            connection = JdbcUtil.getConnection();
            statement = connection.prepareStatement(sql_register);

            statement.setString(1, uname);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, ucity);

            rowsAffected = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JdbcUtil.closeConnection(statement, connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rowsAffected;
    }

}

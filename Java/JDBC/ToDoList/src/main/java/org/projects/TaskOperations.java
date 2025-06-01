package org.projects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskOperations {

    public void addTask() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Task Description: ");
        String description = sc.nextLine();

        Connection connection = DBConnection.getConnection();

        String query = "INSERT INTO projects.todolist (description, status) VALUES (?, 'pending')";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, description);

        int rows = statement.executeUpdate();
        if(rows > 0) {
            System.out.println("Task added successfully!");
        } else {
            System.out.println("Invalid! Enter proper short description");
        }

        DBConnection.closeConnection(statement, connection);
    }

    public List<Task> showTasks() throws SQLException, ClassNotFoundException {
        List<Task> tasks = new ArrayList<>();
        String query = "select * from projects.todolist;";

        Connection connection = DBConnection.getConnection();

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);

        while(result.next()){
            int id = (result.getInt("id"));
            String description = (result.getString("description"));
            String status = (result.getString("status"));
            tasks.add(new Task(id, description, status));
        }
        DBConnection.closeConnection(result, statement, connection);;
        return tasks;
    }

    public void updateTask() throws SQLException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter new status(completed/pending): ");
        String newStatus = sc.nextLine();

        Connection connection = DBConnection.getConnection();
        String query = "UPDATE projects.todolist SET status = ? WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, newStatus);
        statement.setInt(2, id);

        int rows = statement.executeUpdate();
        if(rows > 0) {
            System.out.println("Task added successfully!");
        } else {
            System.out.println("Wrong Task ID");
        }

        DBConnection.closeConnection(statement, connection);
    }

    public void deleteTask() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Task ID: ");
        int id = sc.nextInt();

        Connection connection = DBConnection.getConnection();

        String query = "DELETE FROM projects.todolist WHERE id = ?";
        PreparedStatement statement =connection.prepareStatement(query);
        statement.setInt(1, id);

        int rows = statement.executeUpdate();
        if(rows > 0) {
            System.out.println("Task added successfully!");
        } else {
            System.out.println("Wrong Task ID");
        }

        DBConnection.closeConnection(statement, connection);
    }
}
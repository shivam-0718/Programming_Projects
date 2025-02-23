package org.projects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskOperations {

    public void addTask() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add the task that you want to add (Write it in SQL query form - - ID, Description, Status): ");
        String query = sc.nextLine();
        Connection connection = DBConnection.getConnection();
        System.out.println("Connection established successfully!");
        Statement statement = connection.createStatement();
        boolean status = statement.execute(query);
        if(!status){
           System.out.println("Task added successfully");
        } else {
           System.out.println("Error! Please try again");
        }
        connection.close();
    }

    public List<Task> showTasks() throws SQLException, ClassNotFoundException {
        List<Task> tasks = new ArrayList<>();
        String query = "select * from projects.todolist;";
        Connection connection = DBConnection.getConnection();
        System.out.println("Connection established successfully!");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        while(result.next()){
            int id = (result.getInt("id"));
            String description = (result.getString("description"));
            String status = (result.getString("status"));
            tasks.add(new Task(id, description, status));
        }
        result.close();
        statement.close();
        connection.close();
        return tasks;
    }

    public void updateTask() throws SQLException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Add the task that you want to update (Write it in SQL query form): ");
        String query = sc.nextLine();
        Connection connection = DBConnection.getConnection();
        System.out.println("Connection established successfully!");
        Statement statement =connection.createStatement();
        boolean status = statement.execute(query);
        if(!status){
            System.out.println("Task updated successfully");
        } else {
            System.out.println("Error! Please try again");
        }
        statement.close();
        connection.close();
    }

    public void deleteTask() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add the task that you want to delete (Write it in SQL query form): ");
        String query = sc.nextLine();
        Connection connection = DBConnection.getConnection();
        System.out.println("Connection established successfully!");
        Statement statement =connection.createStatement();
        boolean status = statement.execute(query);
        if(!status){
            System.out.println("Task deleted successfully");
        } else {
            System.out.println("Error! Please try again");
        }
        statement.close();
        connection.close();
    }
}
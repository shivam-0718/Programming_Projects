package org.projects;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskOperations operation = new TaskOperations();
        Scanner scanner = new Scanner(System.in);
        boolean start = true;
        while(start){
            System.out.println("\n===== To-Do List Application =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed/Pending");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            try{
                switch (choice){
                    case 1:
                        operation.addTask();
                        break;
                    case 2:
                        List<Task> tasks = operation.showTasks();
                        if(tasks.isEmpty()){
                            System.out.println("No tasks found in database!");
                        } else {
                            for (Task task : tasks) System.out.println(task);
                        }
                        break;
                    case 3:
                        operation.updateTask();
                        break;
                    case 4:
                        operation.deleteTask();
                        break;
                    case 5:
                        start = false;
                        System.out.println("Exiting application...");
                        break;
                    default:
                        System.out.println("Invalid number! Please try again.");
                }
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Connection failed!: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
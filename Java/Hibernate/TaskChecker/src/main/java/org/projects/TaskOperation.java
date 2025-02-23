package org.projects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class TaskOperation {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void addTask(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Task Description: ");
        String description = sc.nextLine();

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Task task = new Task(description, "pending");
        session.persist(task);
        tx.commit();
        System.out.println("Task added successfully!");

        session.close();
    }

    public List<Task> showTasks(){
        Session session = sessionFactory.openSession();
        List<Task> tasks = session.createQuery("FROM Task", Task.class).list();
        session.close();
        return tasks;
    }

    public void updateTask(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new status(completed/pending): ");
        String newStatus = sc.nextLine();

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Task task = session.get(Task.class, id);
        if (task != null){
            task.setStatus(newStatus);
            session.merge(task);
            tx.commit();
            System.out.println("Task updated successfully!");
        }else {
            System.out.println("Task ID not found!");
        }
    }

    public void deleteTask(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Task ID: ");
        int id = sc.nextInt();

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Task task = session.get(Task.class, id);
        if (task != null){
            session.remove(task);
            tx.commit();
            System.out.println("Task deleted successfully!");
        }else {
            System.out.println("Task ID not found!");
        }
    }

}

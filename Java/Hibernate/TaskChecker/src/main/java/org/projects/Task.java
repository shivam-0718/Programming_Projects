package org.projects;

import jakarta.persistence.*;

@Entity
@Table(name = "TaskChecker")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    @Column(name = "status", length = 10, nullable = false)
    private String status;

    public Task(){}

    public Task(String description, String status) {
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", Description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

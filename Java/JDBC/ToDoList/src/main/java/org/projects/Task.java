package org.projects;

public class Task {
    private final int id;
    private String description;
    private String status;

    public Task(int id, String description, String status) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", Description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

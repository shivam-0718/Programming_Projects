# 📝 ToDoList Project (Java Console App)

The ToDoList Project is a beginner-friendly, console-based application designed to help users manage their daily tasks efficiently. Built using Java and JDBC (Java Database Connectivity), this project demonstrates how to perform basic CRUD (Create, Read, Update, Delete) operations on a relational database. The application allows users to add, view, update, and delete tasks from a to-do list, making it a practical example for those learning about Java programming, database integration, and command-line interfaces.

Whether you are a student, a developer new to Java, or someone looking to understand how Java applications interact with databases, this project provides a clear and simple foundation. The code is organized for readability and ease of understanding, and the setup instructions will guide you through running the project on your own system.

---

## 📂 Project Structure
```
ToDoList/
├── pom.xml
├── README.md
├── src
│ └── main
│ └── java
│       └── org.projects
│           ├── DBConnection.java
│           ├── Main.java
│           ├── Task.java
│           └── TaskOperations.java
└── target
   └── classes
       └── org.projects
            ├── DBConnection.class
            ├── Main.class
            ├── Task.class
            └── TaskOperations.class
```

## 🛠️ Setup Instructions

Follow the steps below to set up and run the project:

### 1. Prerequisites
- JDK 8 or later
- MySQL Database (or any other database)
- IDE (e.g., IntelliJ IDEA, Eclipse)
- Maven (for dependency management and building)

### 2. Database Setup
#### For MySQL:

1. Install MySQL and create a database named `projects` or any other name as per your choice.
2. Execute the following SQL query to create the `todolist` table:

```sql
CREATE TABLE todolist (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL
);
```
### 3. Project Configuration

1. Clone or download the project from this repository.
2. Open the project in your IDE (e.g., IntelliJ Idea, Eclipse).
3. Add the appropriate JDBC Driver (MySQL or PostgreSQL or any other database of your choice) to the project’s build path.

### 4. Update Database Connection in `DBConnection.java`

Modify the following variables in the `DBConnection.java` file based on your database choice. For this project, I have used MySQL:

#### For MySQL:

```java
Class.forName("com.mysql.cj.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/projects";
String userName = "shivam";
String password = "Shivam18";
```

## 🔍 Features
This project provides a simple command-line interface (CLI) for managing a to-do list. The main features include:
- Adding new tasks to the list
- Viewing all existing tasks
- Updating the status of tasks (e.g., marking as complete)
- Deleting tasks from the list

## File description

| File Name           | Description                                                                 |
|---------------------|-----------------------------------------------------------------------------|
| DBConnection.java   | Handles database connection setup and provides utility methods for closing connections. |
| Main.java           | The entry point of the application; provides a CLI for managing tasks.      |
| Task.java           | Model class representing a task entity with fields for id, description, and status. |
| TaskOperations.java | Contains methods for performing CRUD operations on tasks in the database.   |

## Dependencies
This project relies on the following dependencies:
- **Java 8 or later**: The programming language used for development.
- **JDBC API**: Java Database Connectivity API for database operations.
- **MySQL Connector/J** (or other JDBC driver): Required for connecting Java applications to the database.
- **Maven**: For managing project dependencies and building the project.

## Support
- For issues, questions, or contributions, please open an issue in this repository or contact me at **sh.vy.007@gmail.com**.

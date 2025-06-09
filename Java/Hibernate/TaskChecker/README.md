# 📌 TaskChecker Project (Hibernate Console App)

The **TaskChecker** project is a console-based Java application built using Hibernate ORM (Object-Relational Mapping). It demonstrates the use of Hibernate to perform basic CRUD (Create, Read, Update, Delete) operations on a MySQL database. This project is ideal for beginners who are learning Hibernate integration with Java SE.

It allows users to manage tasks by inserting, updating, retrieving, and deleting records using Hibernate's ORM framework — abstracting away the manual SQL code.

---

## 📂 Project Structure

```
TaskChecker/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/projects/
│   │   │       ├── HibernateUtil.java     # Manages Hibernate SessionFactory and configuration
│   │   │       ├── Main.java              # Console interface and application entry point
│   │   │       ├── Task.java              # Entity class mapping to TaskChecker table
│   │   │       └── TaskOperation.java     # Implements CRUD operations using Hibernate
│   │   └── resources/
│   │       └── hibernate.cfg.xml          # Database and Hibernate configuration
├── pom.xml                                # Maven dependencies and build settings
├── .gitignore                             # Git ignore patterns
└── README.md                              # Project documentation
```


---

## 🛠️ Setup Instructions

### 1. Prerequisites
- JDK 8 or later
- Maven
- MySQL (or compatible RDBMS)
- IDE like IntelliJ IDEA or Eclipse

### 2. Database Setup

1. Install MySQL and create a database named `projects`.
2. Run the following SQL to create the `task` table:

```sql
CREATE TABLE task (
    id INT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(100),
    status VARCHAR(50)
);
```
### 3. Project Configuration
- Clone or download the project.
- Open the project in your IDE.
- Ensure you have Maven and MySQL Connector dependency in your pom.xml.

### 4. Configure Database in `hibernate.cfg.xml`
Update the following properties as per your system:
```xml
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/projects</property>
<property name="hibernate.connection.username">shivam</property>
<property name="hibernate.connection.password">your_password</property>
<property name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>
```

## 🔍 Features

### Core Functionality
- **Task Creation**
    - Add new tasks with descriptions
    - Set initial status (Pending/Completed)


- **Task Management**
    - View all existing tasks
    - Update task status
    - Delete tasks from the system
    - Filter tasks by status

### User Interface
- **Console-Based Interface**
    - Clear menu-driven operations
    - Simple and intuitive commands
    - Immediate feedback on actions

### Data Persistence
- **Hibernate ORM Integration**
    - Reliable data storage in MySQL database
    - Automatic transaction management
    - Entity mapping with annotations

### Error Handling
- Input validation
- Database operation error handling
- Graceful error messages

### System Features
- Session management with Hibernate
- Automatic ID generation
- Clean exit functionality

## 📜 File Descriptions

| File Name | Description |
|-----------|-------------|
| `Main.java` | Entry point of the application; provides a CLI for managing tasks |
| `Task.java` | Entity class mapped to the database table with Hibernate annotations |
| `HibernateUtil.java` | Manages Hibernate SessionFactory configuration and initialization |
| `TaskOperation.java` | Implements CRUD operations using Hibernate persistence methods |
| `hibernate.cfg.xml` | Configuration file for database connection and Hibernate settings |

## 🔗 Dependencies

| GroupId | ArtifactId | Version | Purpose |
|---------|------------|---------|----------|
| `org.hibernate.orm` | `hibernate-core` | 6.2.7.Final | Core ORM functionality |
| `com.mysql` | `mysql-connector-j` | 8.0.33 | MySQL database connectivity |
| `javax.persistence` | `javax.persistence-api` | 2.2 | JPA annotations support |
| `org.hibernate.common` | `hibernate-commons-annotations` | 6.0.6.Final | Hibernate annotations |
| `org.apache.maven` | `maven-core` | 3.9.5 | Maven build system |

## 👥 Support & Contact

For questions, issues, or contributions:
- **Email:** sh.vy.007@gmail.com
- **GitHub Issues:** Create an issue in this repository
- **Documentation:** Refer to inline code comments and this README
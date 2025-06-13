# 👤 Registration Web App (MVC using Servlet, JSP, and JDBC)

This project demonstrates the implementation of the **Model‑View‑Controller (MVC)** pattern using **Servlets**, **JSP**, and **JDBC** to create a simple user registration application.

---

## 📂 Project Structure:
```
RegistrationWebApp/
├── src
│   └── main
│       ├── java
│       │   ├── model
│       │   │   └── User.java
│       │   ├── servlet
│       │   │   ├── Home.java
│       │   │   ├── Login.java
│       │   │   └── Register.java
│       │   └── util
│       │       └── JdbcUtil.java
│       ├── resources/
│       └── webapp
│           ├── WEB-INF/
│           ├── dashboard.jsp
│           ├── failure.jsp
│           ├── index.html
│           ├── login.jsp
│           ├── logout.jsp
│           └── success.jsp
├── target/
├── .gitignore
├── pom.xml
└── README.md
```
---

## 🛠️ Setup Instructions

Follow the steps below to set up and run the project:

### 1. Prerequisites
- JDK 8 or later
- Apache Tomcat Server 9.0 or later
- MySQL or PostgreSQL Database
- Eclipse IDE (or any Java‑supported IDE)
- JDBC Driver for MySQL or PostgreSQL

### 2. Database Setup

#### For MySQL:
1. Create a database named `projects` or any other name as per your choice.
2. Run the following SQL command to create the `personinfo` table:

```sql
CREATE TABLE personinfo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    uname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    upassword VARCHAR(255) NOT NULL,
    ucity VARCHAR(255)
);
```
#### For PostgreSQL:
1. Create a database named `projects` or any other name as per your choice.
2. Run the following SQL command to create the `personinfo` table:

```sql
CREATE TABLE personinfo (
    id SERIAL PRIMARY KEY,
    uname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    upassword VARCHAR(255) NOT NULL,
    ucity VARCHAR(255)
);
```
---

### Project Configuration
1. Clone or download the project.
2. Open it in your IDE.
3. Add the JDBC driver (MySQL or PostgreSQL) to the build path.
4. Update the database connection details in `JdbcUtil.java`:
   ```java
   public static final String DB_URL = "jdbc:mysql://localhost:3306/projects"; // For MySQL
   // public static final String DB_URL = "jdbc:postgresql://localhost:5432/projects"; // For PostgreSQL
   public static final String USER = "your_username";
   public static final String PASS = "your_password";
   ```
   
5. Build the project to generate the WAR file or deploy your project on Apache Tomcat via your IDE.
6. Start the Apache Tomcat server.
7. Access the application at `http://localhost:8080/RegistrationWebApp/` in your web browser.

---
## 📜 File Descriptions

| File Name          | Purpose                                                                 |
|--------------------|-------------------------------------------------------------------------|
| `JdbcUtil.java`     | Manages database connectivity (DB connection setup and utility methods). |
| `User.java`         | Model class representing the user entity with fields like name, email, etc. |
| `Register.java`     | Servlet to handle user registration and database insertion.             |
| `Login.java`        | Servlet to handle user login and credential verification.               |
| `Home.java`         | Servlet to manage navigation to the homepage/dashboard after login.     |
| `index.html`        | Entry point of the application containing the registration form.        |
| `login.jsp`         | Login form interface for registered users.                              |
| `dashboard.jsp`     | Displayed after successful login; acts as the user dashboard.           |
| `success.jsp`       | Shows confirmation after successful registration.                       |
| `failure.jsp`       | Indicates registration failure or login error.                          |
| `logout.jsp`        | Handles user logout and session termination.                            |
| `web.xml`           | Deployment descriptor file; defines servlet mappings and URL patterns.  |

---
## 🔗 Dependencies
- MySQL Connector/J or PostgreSQL JDBC driver
- Apache Tomcat Server
- Servlet & JSP API
- JSTL (JavaServer Pages Standard Tag Library)
- Maven (for dependency management)

---
## Support
For any issues or questions, feel free to open an issue on the GitHub repository or contact at `sh.vy.007@gmail.com`.




<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
            background-color: #f8f9fa;
        }
        .dashboard-container {
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            display: inline-block;
            border-left: 5px solid #007bff;
        }
        h1 {
            color: #007bff;
            margin-bottom: 20px;
        }
        .user-info {
            color: #555;
            font-size: 18px;
            margin-bottom: 20px;
        }
        .logout-link {
            background-color: #dc3545;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            display: inline-block;
            margin-top: 20px;
        }
        .logout-link:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <%
    String name = (String) session.getAttribute("name");
    String email = (String) session.getAttribute("email");
    String ucity = (String) session.getAttribute("ucity");

    if (name == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    %>

    <div class="dashboard-container">
        <h1>Welcome to Dashboard!</h1>
        <div class="user-info">
            <p><strong>Name:</strong> <%= name %></p>
            <p><strong>Email:</strong> <%= email %></p>
            <p><strong>City:</strong> <%= ucity %></p>
        </div>
        <a href="logout.jsp" class="logout-link">Logout</a>
    </div>
</body>
</html>

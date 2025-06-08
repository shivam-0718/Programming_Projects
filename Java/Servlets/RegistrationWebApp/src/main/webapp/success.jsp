<!-- success.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
            background-color: #f0f8f0;
        }
        .success-container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            display: inline-block;
            border-left: 5px solid #28a745;
        }
        h1 {
            color: #28a745;
            margin-bottom: 20px;
        }
        .message {
            color: #555;
            font-size: 18px;
            margin-bottom: 20px;
        }
        .back-link {
            background-color: #28a745;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            display: inline-block;
        }
        .back-link:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <% String name = (String) session.getAttribute("name"); %>
    <div class="success-container">
        <h1>Registration Successful!</h1>
        <h2>Hey, <%= name %>, welcome to the platform</h2>
        <p class="message">Your account has been created successfully.</p>
        <a href="login.jsp" class="back-link">Go to Login</a>
    </div>
</body>
</html>

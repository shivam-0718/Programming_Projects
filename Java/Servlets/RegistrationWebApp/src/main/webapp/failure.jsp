<!-- failure.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Failed</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
            background-color: #fdf2f2;
        }
        .failure-container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            display: inline-block;
            border-left: 5px solid #dc3545;
        }
        h1 {
            color: #dc3545;
            margin-bottom: 20px;
        }
        .message {
            color: #555;
            font-size: 18px;
            margin-bottom: 20px;
        }
        .back-link {
            background-color: #dc3545;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            display: inline-block;
            margin: 5px;
        }
        .back-link:hover {
            background-color: #c82333;
        }
        .retry-link {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            display: inline-block;
            margin: 5px;
        }
        .retry-link:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <% String name = (String) session.getAttribute("name"); %>
    <div class="failure-container">
        <h1>Registration Failed!</h1>
        <h2>Sorry <%= name %>, we could not create your account</h2>
        <p class="message">Please check your details and try again.</p>
        <div>
            <a href="register.jsp" class="retry-link">Try Again</a>
            <a href="index.jsp" class="back-link">Go Home</a>
        </div>
    </div>
</body>
</html>
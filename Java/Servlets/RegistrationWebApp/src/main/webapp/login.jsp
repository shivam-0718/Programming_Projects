<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Login Form</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        .form-container {
            background: white;
            padding: 50px 40px;
            border-radius: 10px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 450px;
            border: 1px solid #e8e8e8;
        }

        h2 {
            margin-bottom: 35px;
            font-size: 28px;
            text-align: center;
            color: #2c3e50;
            font-weight: 600;
            letter-spacing: -0.5px;
        }

        .form-group {
            margin-bottom: 25px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 500;
            color: #555;
            font-size: 14px;
        }

        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 15px 16px;
            border: 1px solid #ddd;
            border-radius: 6px;
            box-sizing: border-box;
            font-size: 16px;
            transition: all 0.2s ease;
            background: #fafafa;
        }

        input[type="email"]:focus,
        input[type="password"]:focus {
            outline: none;
            border-color: #667eea;
            background: white;
            box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
        }

        input[type="submit"] {
            width: 100%;
            padding: 16px;
            background: #667eea;
            border: none;
            border-radius: 6px;
            color: white;
            font-size: 16px;
            font-weight: 500;
            cursor: pointer;
            transition: all 0.2s ease;
            margin-top: 15px;
        }

        input[type="submit"]:hover {
            background: #5a67d8;
            transform: translateY(-1px);
            box-shadow: 0 4px 12px rgba(102, 126, 234, 0.3);
        }

        input[type="submit"]:active {
            transform: translateY(0);
        }

        .links {
            text-align: center;
            margin-top: 25px;
            padding-top: 20px;
            border-top: 1px solid #eee;
        }

        .links a {
            color: #667eea;
            text-decoration: none;
            font-weight: 500;
            transition: color 0.2s ease;
        }

        .links a:hover {
            color: #5a67d8;
            text-decoration: underline;
        }

        /* Professional subtle animations */
        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .form-container {
            animation: fadeIn 0.4s ease;
            position: relative;
        }

        /* Professional styling touches */
        .form-container::before {
            content: '';
            position: absolute;
            top: 0;
            left: 50%;
            transform: translateX(-50%);
            width: 50px;
            height: 4px;
            background: #667eea;
            border-radius: 0 0 4px 4px;
        }

        /* Error message styling */
        .error-message {
            background: #fee;
            color: #c53030;
            padding: 12px;
            border-radius: 6px;
            margin-bottom: 20px;
            border: 1px solid #feb2b2;
            font-size: 14px;
            text-align: center;
        }

        /* Responsive design */
        @media (max-width: 480px) {
            .form-container {
                padding: 40px 25px;
                margin: 10px;
            }

            h2 {
                font-size: 24px;
                margin-bottom: 30px;
            }
        }
    </style>
</head>
<body>
<div class="form-container">
    <form action="./login" method="POST">
        <h2>User Login</h2>

        <%
        String error = request.getParameter("error");
        if ("invalid".equals(error)) {
        %>
            <div class="error-message">
                Invalid email or password. Please try again.
            </div>
        <% } %>

        <div class="form-group">
            <label for="email">Email Address</label>
            <input type="email" id="email" name="email" required>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
        </div>

        <input type="submit" value="Login">
    </form>

    <div class="links">
        <a href="index.html">Don't have an account? Register here</a>
    </div>
</div>
</body>
</html>

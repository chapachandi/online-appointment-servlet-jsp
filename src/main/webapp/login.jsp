<%--
  Created by IntelliJ IDEA.
  User: Chapa
  Date: 9/6/2023
  Time: 12:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Appointment Scheduling System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-container {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            padding: 20px;
            width: 300px;
            text-align: center;
        }
        .login-container h2 {
            color: #007bff;
            margin-bottom: 20px;
        }
        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 86%;
            padding: 10px;
            margin: 8px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .login-container button {
            width: 86%;
            padding: 10px;
            background-color: #007bff;
            border: none;
            border-radius: 3px;
            color: #fff;
            cursor: pointer;
        }
        .btn-signup{
            background: white !important;
            color: blue !important;
        }
        .login-link {
            color: #007bff;
            text-decoration: none;
        }
        select{
            width: 86%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Login</h2>
    <form action="/login" method="post">
        <input type="text" id="username" name="username" placeholder="Username" required>
        <input type="password" id="password" name="password" placeholder="Password" required>
        <select id="userType" name="userType"  placeholder="Select User Type" required>
            <option value="user">User</option>
            <option value="consultant">Consultant</option>
            <option value="admin">Admin</option>
        </select>
        <br/>
        <button type="submit">Login</button>
        <br/>
        <hr/>
        <button class="btn-signup"><a class="login-link" href="signup.jsp">Sign Up</a></button>
    </form>
</div>
</body>
</html>

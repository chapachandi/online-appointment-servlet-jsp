<%--
  Created by IntelliJ IDEA.
  User: Chapa
  Date: 9/6/2023
  Time: 12:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <style>
        /* Your CSS styles for the sign-up page go here */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 400px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }
        h1 {
            color: #007bff;
            text-align: center;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            font-weight: bold;
        }
        input[type="text"],
        input[type="email"],
        input[type="tel"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        select{
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        button[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            padding: 10px 20px;
            cursor: pointer;
            width: 100%;
        }
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
        p {
            text-align: center;
        }
        .login-link {
            color: #007bff;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Sign Up</h1>
    <form action="/register" method="post">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="phoneNumber">Phone Number:</label>
            <input type="tel" id="phoneNumber" name="phoneNumber" required>
        </div>
        <div class="form-group">
            <label for="userType">User Type:</label>
            <select id="userType" name="userType" required>
                <option value="user">User</option>
                <option value="consultant">Consultant</option>
                <option value="admin">Admin</option>
            </select>
        </div>
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
            <button type="submit">Sign Up</button>
        </div>
    </form>
    <p>Already have an account? <a class="login-link" href="login.jsp">Log in</a></p>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Chapa
  Date: 9/6/2023
  Time: 8:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - Job Consultancy</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .navbar {
            background-color: #007bff;
            padding: 10px 0;
        }
        .navbar-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
        }
        .logo {
            color: #fff;
            font-size: 24px;
            font-weight: bold;
        }
        .nav-links {
            list-style: none;
            margin: 0;
            padding: 0;
            display: flex;
        }
        .nav-links li {
            margin-right: 20px;
        }
        .nav-links a {
            text-decoration: none;
            color: #fff;
            font-weight: bold;
        }
        .dashboard {
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }
        .section-title {
            font-size: 24px;
            margin-bottom: 20px;
        }
        .data-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        .data-table th,
        .data-table td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }
    </style>
</head>
<body>
<div class="navbar">
    <div class="navbar-container">
        <div class="logo">Admin Dashboard</div>
        <ul class="nav-links">
            <li><a href="#">Home</a></li>
            <li><a href="#">Consultants</a></li>
            <li><a href="#">Job Seekers</a></li>
            <li><a href="#">Appointments</a></li>
            <li><a href="#">Login</a></li>
        </ul>
    </div>
</div>
<div class="dashboard">
    <h1 class="section-title">Consultant Details</h1>
    <!-- Consultant Details Table -->
    <table class="data-table">
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
        </tr>
        </thead>
        <tbody>
        <!-- Insert consultant details here -->
        </tbody>
    </table>

    <h1 class="section-title">Job Seekers Details</h1>
    <!-- Job Seekers Details Table -->
    <table class="data-table">
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
        </tr>
        </thead>
        <tbody>
        <!-- Insert job seekers details here -->
        </tbody>
    </table>

    <h1 class="section-title">Appointments Details</h1>
    <!-- Appointments Details Table -->
    <table class="data-table">
        <thead>
        <tr>
            <th>Job Seeker Name</th>
            <th>Consultant Name</th>
            <th>Date</th>
            <th>Time</th>
        </tr>
        </thead>
        <tbody>
        <!-- Insert appointment details here -->
        </tbody>
    </table>
</div>
</body>
</html>

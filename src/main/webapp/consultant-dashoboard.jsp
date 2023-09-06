<%--
  Created by IntelliJ IDEA.
  User: Chapa
  Date: 9/6/2023
  Time: 8:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consultants - Job Consultancy</title>
    <style>
        <!--    body {-->
        <!--        font-family: Arial, sans-serif;-->
        <!--        margin: 0;-->
        <!--        padding: 0;-->
        <!--    }-->
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }
        h1 {
            color: #124174;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
        }
        th {
            background-color: #598dc5;
            color: #fff;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .action-buttons {
            display: flex;
            justify-content: space-between;
        }
        .approve-button, .cancel-button {
            padding: 5px 10px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        .approve-button {
            background-color: #28a745;
            color: #fff;
        }
        .cancel-button {
            background-color: #dc3545;
            color: #fff;
        }

        <!--------->


            .crud-card {
                background-color: #fff;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
                margin: 20px;
                padding: 20px;
                width: 400px;
                text-align: center;
            }
        .crud-card h2 {
            color: #007bff;
            margin-bottom: 20px;
        }
        .form-group {
            text-align: left;
            margin-bottom: 15px;
        }
        .form-group label {
            font-weight: bold;
        }
        .form-group input[type="text"],
        .form-group input[type="email"],
        .form-group input[type="tel"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .form-group button {
            background-color: #007bff;
            border: none;
            border-radius: 3px;
            color: #fff;
            cursor: pointer;
            padding: 10px 20px;
        }
        .consultant-list {
            text-align: left;
            margin-top: 20px;
        }
        .consultant-item {
            margin-bottom: 10px;
        }
        .consultant-item h3 {
            font-size: 18px;
        }
        .consultant-item p {
            margin: 0;
        }

        .navbar {
            background-color: #094d50;
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
        .consultant-card {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            margin: 20px;
            padding: 20px;
            width: 400px;
            text-align: center;
        }
        .consultant-card img {
            max-width: 100%;
            border-radius: 50%;
        }
        .consultant-card h3 {
            color: #007bff;
            margin-top: 10px;
        }
        .consultant-card p {
            margin: 0;
            padding: 0;
        }
        <!--------------------------->

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
        input[type="tel"] {
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
        .consultant-card {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            margin: 20px;
            padding: 20px;
            text-align: center;
        }
        .consultant-card h2 {
            color: #007bff;
        }
        .consultant-card p {
            margin: 10px 0;
        }
        .action-buttons {
            display: flex;
            justify-content: space-around;
        }
        .edit-button, .delete-button {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            padding: 5px 10px;
            cursor: pointer;
        }
        .delete-button {
            background-color: #dc3545;
        }
        .div_flex{
            display: flex;
        }

    </style>
</head>
<body>

<div class="navbar">
    <div class="navbar-container">
        <div class="logo">Job Consultancy</div>
        <ul class="nav-links">
            <li><a href="#home" id="con_home">Home</a></li>
            <li><a href="#details" id="con_details">Add Consultant Details</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Login</a></li>
        </ul>
    </div>
</div>

<div id="home" class="container">
    <h1>Job Seeker Appointments</h1>
    <table>
        <thead>
        <tr>
            <th>Job Seeker</th>
            <th>Consultant</th>
            <th>Date</th>
            <th>Time</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>John Doe</td>
            <td>Consultant 1</td>
            <td>2023-09-15</td>
            <td>10:00 AM</td>
            <td class="action-buttons">
                <button class="approve-button">Approve</button>
                <button class="cancel-button">Cancel</button>
            </td>
        </tr>
        <!-- Add more appointment rows as needed -->
        </tbody>
    </table>
</div>


<!---->
<div id="details">
    <div>
        <div class="container">
            <h1>Consultant Details</h1>
            <form action="#" method="post">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" id="name" name="name" required>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="phone">Phone:</label>
                    <input type="tel" id="phone" name="phone" required>
                </div>
                <div class="form-group">
                    <button type="submit">Save</button>
                </div>
            </form>
        </div>
        <!--    <div class="consultant-card">-->
        <!--      <h2>Consultant Name</h2>-->
        <!--      <p>Email: consultant@example.com</p>-->
        <!--      <p>Phone: +1 123-456-7890</p>-->
        <!--      <div class="action-buttons">-->
        <!--        <button class="edit-button">Edit</button>-->
        <!--        <button class="delete-button">Delete</button>-->
        <!--      </div>-->
        <!--    </div>-->

    </div>

</div>

<script >

    var home = document.getElementById("home");
    var details = document.getElementById("details");

    home.style.display='block';
    details.style.display='none';


    var con_home = document.getElementById("con_home");
    con_home.addEventListener('click',function () {
        home.style.display='block';
        details.style.display='none';

    });
    var con_details = document.getElementById("con_details");
    con_details.addEventListener('click',function () {
        home.style.display='none';
        details.style.display='block';
    });

</script>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Chapa
  Date: 9/6/2023
  Time: 1:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Job Consultancy - Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            /*background-image: url('background-image.jpg'); !* Replace 'background-image.jpg' with your actual background image URL *!*/
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;

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
        .job-fields {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 5px;
            margin: 20px;
        <!--            max-width: 400px;-->
        }
        .job-fields h2 {
            font-size: 24px;
            margin-bottom: 10px;
        }
        .dropdown {
            margin-bottom: 10px;
            margin-right: 20px;
            width: 50%;
        }
        .dropdown select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .login-icon {
            color: #fff;
            font-size: 24px;
            margin-left: 10px;
            cursor: pointer;
        }
        .card {
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin: 20px;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .job-card {
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin: 20px;
            padding: 20px;
            max-width: 400px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .job-card h3 {
            font-size: 20px;
            margin-bottom: 10px;
        }
        .job-card p {
            margin: 0;
            padding: 0;
        }
        .img-bg{
            width: 100%;
        }
        .display-flex{
            display: flex;
        }
        .btn{
            width: 250px;
            height: 36px;
            /* border-radius: 5px; */
            background: #126cbb;
            border-radius: 5px;
            border: 1px;
            font-size: 15px;
            color: white;
            cursor: pointer;
        }
        .job-details-div{
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }
        .job-title{
            text-align: center;
            color: #044176;
            font-size: 24px;
        }
        .details{
            display: flex;
            flex-direction: column;
            align-content: center;
            align-items: center;
        }
        .btn-div{
            display: flex;
            justify-content: center;
            margin: 10px;
        }
        .jd-label{
            width: 150px;
            text-align: center;
            color: #918e8e;
            margin: 10px;
        }
        .overlay {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.7);
            justify-content: center;
            align-items: center;
            z-index: 1000;
        }
        .popup {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            padding: 20px;
            max-width: 600px;
            text-align: center;
        }
        .popup h2 {
            color: #007bff;
        }
        .popup label {
            font-weight: bold;
        }
        .popup input[type="text"],
        .popup input[type="email"],
        .popup input[type="number"],
        .popup input[type="date"],
        .popup input[type="time"] {
            width: 92%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .popup button {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            padding: 10px 20px;
            cursor: pointer;
        }

        h1 {
            color: #007bff;
            text-align: center;
        }
        .form-group {
            margin-bottom: 20px;
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

    </style>
</head>
<body>
<div class="navbar">
    <div class="navbar-container">
        <div class="logo">Job Consultancy</div>
        <ul class="nav-links">
            <li><a href="#">Home</a></li>
            <li><a href="#">Services</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
            <li><a href="#">Login</a></li>
        </ul>
    </div>
</div>
<div>
    <img src="assets/Sky_Overseas_Banner_0bqQRWy_f2bUOk7_JZqWJOE.jpg" class="img-bg">
</div>
<div class="job-fields">
    <div class="card">
        <h2>Find Your Dream Job Abroad</h2>
        <div class="display-flex">
            <div class="dropdown">
                <label for="country">Select Country:</label>
                <select id="country" name="country">
                    <option value="usa">USA</option>
                    <option value="canada">Canada</option>
                    <option value="uk">UK</option>
                    <!-- Add more countries as needed -->
                </select>
            </div>
            <div class="dropdown">
                <label for="job-type">Select Job Type:</label>
                <select id="job-type" name="job-type">
                    <option value="it">IT</option>
                    <option value="healthcare">Healthcare</option>
                    <option value="finance">Finance</option>
                    <!-- Add more job types as needed -->
                </select>
            </div>
        </div>
        <button type="button" class="btn">Search Jobs</button>
    </div>

    <!-- Previous content here -->

    <div class="job-details-div">
        <div class="job-card">
            <h3 class="job-title">Tech Lead</h3>
            <hr class="hr"/>
            <div class="details">
                <!--                <p class="jd-p"><strong>Company</strong></p>-->
                <label class="jd-label">IBM</label>
                <!--                <p><strong>Location</strong></p>-->
                <label class="jd-label">New York</label>
                <!--                <p><strong>Type</strong> </p>-->
                <label class="jd-label">IT Field</label>
                <!--                <p><strong>Posted</strong></p>-->
                <label class="jd-label">12 Aug 2023</label>
                <!--                <p><strong>Description</strong></p>-->
                <label class="jd-label"> Lorem ipsum dolor sit amet, consectetur adipiscing elit...</label>
            </div>
            <div class="btn-div">
                <button type="button" class="btn" onclick="openPopup()">Schedule Appointment</button>
            </div>
        </div>
        <div class="job-card">
            <h3 class="job-title">Senior SE</h3>
            <hr class="hr"/>
            <div class="details">
                <!--                <p class="jd-p"><strong>Company</strong></p>-->
                <label class="jd-label">Microsoft</label>
                <!--                <p><strong>Location</strong></p>-->
                <label class="jd-label">New York</label>
                <!--                <p><strong>Type</strong> </p>-->
                <label class="jd-label">IT Field</label>
                <!--                <p><strong>Posted</strong></p>-->
                <label class="jd-label">23 Aug 2023</label>
                <!--                <p><strong>Description</strong></p>-->
                <label class="jd-label"> Lorem ipsum dolor sit amet, consectetur adipiscing elit...</label>
            </div>
            <div class="btn-div">
                <button type="button" class="btn">Contact Consultant</button>
            </div>
        </div>
        <div class="job-card">
            <h3 class="job-title">Software Architecture</h3>
            <hr class="hr"/>
            <div class="details">
                <!--                <p class="jd-p"><strong>Company</strong></p>-->
                <label class="jd-label">Microsoft</label>
                <!--                <p><strong>Location</strong></p>-->
                <label class="jd-label">New York</label>
                <!--                <p><strong>Type</strong> </p>-->
                <label class="jd-label">IT Field</label>
                <!--                <p><strong>Posted</strong></p>-->
                <label class="jd-label">23 Aug 2023</label>
                <!--                <p><strong>Description</strong></p>-->
                <label class="jd-label"> Lorem ipsum dolor sit amet, consectetur adipiscing elit...</label>
            </div>
            <div class="btn-div">
                <button type="button" class="btn">Contact Consultant</button>
            </div>
        </div>

    </div>

    <!-- Repeat the above job card structure for each job result -->
    <div class="overlay" id="appointmentPopup">
        <div class="popup">
            <h2>Schedule Appointment</h2>
            <form action="appointment_process.php" method="post">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" id="name" name="name" required>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="number">Contact Number</label>
                    <input type="number" id="number" name="number" required>
                </div>
                <div class="form-group">
                    <label for="date">Date:</label>
                    <input type="date" id="date" name="date" required>
                </div>
                <div class="form-group">
                    <label for="time">Time:</label>
                    <input type="time" id="time" name="time" required>
                </div>
                <div class="form-group">
                    <button type="submit">Schedule</button>
                </div>
            </form>
            <!--            <form action="#" method="post">-->
            <!--                <label for="date">Date:</label>-->
            <!--                <input type="date" id="date" name="date" required>-->
            <!--                <label for="time">Time:</label>-->
            <!--                <input type="time" id="time" name="time" required>-->
            <!--                <button type="submit">Schedule</button>-->
            <!--            </form>-->
            <button onclick="closePopup()">Close</button>
        </div>
    </div>

    <!-- Button to open the popup -->
    <!--    <button onclick="openPopup()">Schedule Appointment</button>-->

    <script>
        // JavaScript functions to show and hide the popup
        function openPopup() {
            document.getElementById("appointmentPopup").style.display = "flex";
        }

        function closePopup() {
            document.getElementById("appointmentPopup").style.display = "none";
        }
    </script>

</div>
</body>
</html>

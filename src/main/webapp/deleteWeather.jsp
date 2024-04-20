<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Weather</title>
<style>
/* Container styles */
.container {
    max-width: 800px;
    margin: 20px auto;
    background-color: #f9f9f9;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

/* Heading styles */
h1 {
    color: #333;
}

/* Form styles */
form {
    margin-top: 20px;
}

/* Input styles */
input[type="submit"] {
    padding: 10px 20px;
    background-color: #dc3545;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

/* Navigation menu styles */
ul {
    list-style-type: none;
    padding: 0;
    margin-top: 20px;
}

ul li {
    display: inline-block;
    margin-right: 20px;
}

ul li a {
    color: #333;
    text-decoration: none;
}

ul li a:hover {
    color: #666;
}
</style>
</head>
<body>
    <div class="container">
        <h1>Delete Weather</h1>
        <!-- Form or confirmation message for deleting weather record -->
        <form action="deleteWeather" method="post">
            <label for="locationId">Location ID:</label>
            <input type="text" id="locationId" name="locationId" value="<%= request.getParameter("locationId") %>">
            <input type="submit" value="Delete">
        </form>
    </div>

    <!-- Navigation menu -->
    <div class="container">
        <ul>
            <li><a href="addWeather.jsp">Add Weather</a></li>
            <li><a href="viewWeather.jsp">View Weather</a></li>
            <li><a href="updateWeatherForm.html">Update Weather</a></li>
            <li><a href="deleteWeather.jsp">Delete Weather</a></li>
        </ul>
    </div>
</body>
</html>

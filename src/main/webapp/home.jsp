<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
/* CSS styles for navigation menu */
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

.container {
    max-width: 800px;
    margin: 20px auto;
    background-color: #fff;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(0,0,0,0.1);
}

h1 {
    color: #333;
}

ul {
    list-style-type: none;
    padding: 0;
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
        <h1>Weather Monitoring System</h1>
        <ul>
            <li><a href="addWeather.jsp">Add Weather</a></li>
            <li><a href="viewWeather.jsp">View Weather</a></li>
            <li><a href="updateWeather.jsp">Update Weather</a></li>
            <li><a href="deleteWeather.jsp">Delete Weather</a></li>
        </ul>
    </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.WeatherData" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Weather</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<style>
/* Container styles */
.container {
    max-width: 800px;
    margin: 20px auto;
    padding: 20px;
    background-color: #f9f9f9;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

/* Heading styles */
h1 {
    color: #333;
    text-align: center;
}

/* Table styles */
table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

th, td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ccc;
}

th {
    background-color: #007bff;
    color: white;
}

/* Action links styles */
td a {
    margin-right: 10px;
    color: #007bff;
    text-decoration: none;
}

td a:hover {
    color: #0056b3;
}
</style>
</head>
<body>
    <div class="container">
        <h1>Weather Records</h1>
        <table border="1">
            <tr>
                <th>Location ID</th>
                <th>Temperature</th>
                <th>Humidity</th>
                <th>Wind Speed</th>
                <th>Condition</th>
                <th>Observation Time</th>
                <th>Actions</th>
            </tr>
            <!-- Iterate over weather data list and display weather records -->
            <% for (WeatherData weatherData : (List<WeatherData>) request.getAttribute("weatherDataList")) { %>
                <tr>
                    <td><%= weatherData.getLocationId() %></td>
                    <td><%= weatherData.getTemperature() %></td>
                    <td><%= weatherData.getHumidity() %></td>
                    <td><%= weatherData.getWindSpeed() %></td>
                    <td><%= weatherData.getCondition() %></td>
                    <td><%= weatherData.getObservationTime() %></td>
                    <td>
                        <a href="updateWeather.jsp">Edit</a>
                        <a href="deleteWeather.jsp">Delete</a>
                    </td>
                </tr>
            <% } %>
        </table>
    </div>
</body>
</html>

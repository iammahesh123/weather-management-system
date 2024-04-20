<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Weather</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<style>
/* Container styles */
.container {
    max-width: 600px;
    margin: 20px auto;
    padding: 20px;
    background-color: #f9f9f9;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

/* Heading styles */
h1 {
    color: #333;
    text-align: center;
}

/* Form styles */
form {
    margin-top: 20px;
}

/* Label styles */
label {
    display: block;
    margin-bottom: 5px;
}

/* Input styles */
input[type="text"],
input[type="datetime-local"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

/* Submit button styles */
input[type="submit"] {
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

/* Submit button hover effect */
input[type="submit"]:hover {
    background-color: #0056b3;
}
</style>
</head>
<body>
    <div class="container">
        <h1>Update Weather</h1>
        <form action="updateWeatherServlet" method="post">
            <label for="locationId">Location ID:</label>
            <input type="text" id="locationId" name="locationId" value="${param.locationId}">
            <button type="button" onclick="fetchWeatherData()">Fetch Data</button><br> <!-- Add button for fetching data -->
            <label for="temperature">Temperature:</label>
            <input type="text" id="temperature" name="temperature" value="${temperature}"><br>
            <label for="humidity">Humidity:</label>
            <input type="text" id="humidity" name="humidity" value="${humidity}"><br>
            <label for="windSpeed">Wind Speed:</label>
            <input type="text" id="windSpeed" name="windSpeed" value="${windSpeed}"><br>
            <label for="condition">Condition:</label>
            <input type="text" id="condition" name="condition" value="${condition}"><br>
            <label for="observationTime">Observation Time:</label>
            <input type="datetime-local" id="observationTime" name="observationTime" value="${observationTime}"><br>
            <input type="submit" value="Update">
        </form>
    </div>

    <script>
        function fetchWeatherData() {
            var locationId = document.getElementById("locationId").value;
            // Redirect to a servlet or JavaScript function to fetch data based on location ID
            window.location.href = "fetchWeatherDataServlet?locationId=" + locationId;
        }
    </script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Weather</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<style>
/* Form container */
.container {
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
    background-color: #f9f9f9;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

/* Form heading */
h1 {
    text-align: center;
    color: #333;
}

/* Form input fields */
form input[type="text"],
form input[type="datetime-local"] {
    width: 100%;
    padding: 10px;
    margin: 5px 0;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

/* Submit button */
form input[type="submit"] {
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

/* Submit button hover effect */
form input[type="submit"]:hover {
    background-color: #0056b3;
}
</style>
</head>
<body>
    <div class="container">
        <h1>Add Weather</h1>
        <form action="addWeather" method="post">
            Location ID: <input type="text" name="locationId"><br>
            Temperature: <input type="text" name="temperature"><br>
            Humidity: <input type="text" name="humidity"><br>
            Wind Speed: <input type="text" name="windSpeed"><br>
            Condition: <input type="text" name="condition"><br>
            Observation Time: <input type="datetime-local" name="observationTime"><br>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>

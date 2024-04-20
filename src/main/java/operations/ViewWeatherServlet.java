package operations;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConfig.DatabaseConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.WeatherData;



@WebServlet("/viewWeather")
public class ViewWeatherServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<WeatherData> weatherDataList = new ArrayList<>();
        
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM Weather";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                WeatherData weatherData = new WeatherData();
                weatherData.setLocationId(resultSet.getInt("location_id"));
                weatherData.setTemperature(resultSet.getDouble("temperature"));
                weatherData.setHumidity(resultSet.getDouble("humidity"));
                weatherData.setWindSpeed(resultSet.getDouble("wind_speed"));
                weatherData.setCondition(resultSet.getString("condition"));
                weatherData.setObservationTime(resultSet.getTimestamp("observation_time"));
                weatherDataList.add(weatherData);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exception
        }

        // Set the weatherDataList attribute
        request.setAttribute("weatherDataList", weatherDataList);
        
        // Forward the request to the viewWeather.jsp page
        request.getRequestDispatcher("viewWeather.jsp").forward(request, response);
    }
}


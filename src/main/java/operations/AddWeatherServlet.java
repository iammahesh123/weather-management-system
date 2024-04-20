package operations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbConfig.DatabaseConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addWeather")
public class AddWeatherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String locationId = request.getParameter("locationId");
        String temperature = request.getParameter("temperature");
        String humidity = request.getParameter("humidity");
        String windSpeed = request.getParameter("windSpeed");
        String condition = request.getParameter("condition");
        String observationTime = request.getParameter("observationTime");

        if (locationId == null || temperature == null || humidity == null || windSpeed == null || condition == null || observationTime == null ||
            locationId.isEmpty() || temperature.isEmpty() || humidity.isEmpty() || windSpeed.isEmpty() || condition.isEmpty() || observationTime.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "All parameters are required.");
            return;
        }

        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO Weather (location_id, temperature, humidity, wind_speed, `condition`, observation_time) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, locationId);
            statement.setString(2, temperature);
            statement.setString(3, humidity);
            statement.setString(4, windSpeed);
            statement.setString(5, condition);
            statement.setString(6, observationTime);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                response.sendRedirect("viewWeather.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to add weather data.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
        }
    }
}


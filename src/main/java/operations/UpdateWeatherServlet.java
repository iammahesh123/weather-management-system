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





@WebServlet("/updateWeatherServlet")
public class UpdateWeatherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
        int locationId = Integer.parseInt(request.getParameter("locationId"));
        float temperature = Float.parseFloat(request.getParameter("temperature"));
        float humidity = Float.parseFloat(request.getParameter("humidity"));
        float windSpeed = Float.parseFloat(request.getParameter("windSpeed"));
        String condition = request.getParameter("condition");
        String observationTime = request.getParameter("observationTime");

        // Update weather information in the database
        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement stmt = conn.prepareStatement("UPDATE Weather SET temperature=?, humidity=?, wind_speed=?, condition=?, observation_time=? WHERE location_id=?")) {
            stmt.setFloat(1, temperature);
            stmt.setFloat(2, humidity);
            stmt.setFloat(3, windSpeed);
            stmt.setString(4, condition);
            stmt.setString(5, observationTime);
            stmt.setInt(6, locationId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                // Weather information updated successfully
                response.sendRedirect("viewWeather.jsp");
            } else {
                // Error occurred while updating weather information
                response.getWriter().println("Failed to update weather information.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred: " + e.getMessage());
        }
    }
}




package operations;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConfig.DatabaseConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;





@WebServlet("/fetchWeatherDataServlet") // Define the servlet mapping
public class FetchWeatherDataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve location ID from request parameter
        String locationId = request.getParameter("locationId");
        
        // Initialize database connection and variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            // Establish the database connection
            conn = DatabaseConnector.getConnection();
            
            // Prepare the SQL query to fetch weather data based on location ID
            String sql = "SELECT temperature, humidity, wind_speed, `condition`, observation_time FROM Weather WHERE location_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, locationId);
            
            // Execute the query
            rs = stmt.executeQuery();
            
            // Check if any results were returned
            if (rs.next()) {
                // Retrieve weather data from the result set
                double temperature = rs.getDouble("temperature");
                double humidity = rs.getDouble("humidity");
                double windSpeed = rs.getDouble("wind_speed");
                String condition = rs.getString("condition");
                String observationTime = rs.getString("observation_time");
                
                // Send the weather data as JSON response
                response.setContentType("application/json");
                PrintWriter out = response.getWriter();
                out.println("{ \"temperature\": " + temperature + ", \"humidity\": " + humidity + ", \"windSpeed\": " + windSpeed + ", \"condition\": \"" + condition + "\", \"observationTime\": \"" + observationTime + "\" }");
            } else {
                // If no data found for the given location ID, send an error response
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "No weather data found for the provided location ID.");
            }
        } catch (SQLException e) {
            // Handle any exceptions
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
        } finally {
            // Close the database resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

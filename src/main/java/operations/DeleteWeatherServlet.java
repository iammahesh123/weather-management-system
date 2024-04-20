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



@WebServlet("/deleteWeather")
public class DeleteWeatherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String locationId = request.getParameter("locationId");

        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "DELETE FROM Weather WHERE location_id=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, locationId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exception
        }

        response.sendRedirect("viewWeather.jsp");
    }
}



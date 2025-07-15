package com.dilshanmp.pahana_edu;

import com.dilshanmp.pahana_edu.util.DBConnection;

import java.io.*;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "pahana_edu", value = "/db-status")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            if (conn != null && !conn.isClosed()) {
                resp.getWriter().println("<h3 style='color:green;'>✅ Database connection successful!</h3>");
            } else {
                resp.getWriter().println("<h3 style='color:red;'> Database connection failed!</h3>");
            }
        } catch (Exception e) {
            resp.getWriter().println("<h3 style='color:red;'>Error connecting to database: " + e.getMessage() + "</h3>");
        }
    }
}
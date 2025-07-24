package com.dilshanmp.pahana_edu.controller;

import com.dilshanmp.pahana_edu.model.User;
import com.dilshanmp.pahana_edu.service.AuthService;
import com.dilshanmp.pahana_edu.service.impl.AuthServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private AuthService authService;

    @Override
    public void init() throws ServletException {
        super.init();
        authService = new AuthServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //Firstly, Check if user is already logged in ?
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            resp.sendRedirect(req.getContextPath() + "/jsp/dashboard.jsp");
            return;
        }
        // Forward to login page
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            // Authenticate user
            User user = authService.authenticate(username, password);

            // Create session and store user
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            session.setAttribute("username", user.getUsername());
            session.setAttribute("fullName", user.getFullName());
            // Set session timeout (30 minutes)
            session.setMaxInactiveInterval(30 * 60);
            // Redirect to dashboard
            resp.sendRedirect(req.getContextPath() + "/jsp/dashboard.jsp");


        } catch (Exception e) {
            // Set error message
            req.setAttribute("error", e.getMessage());
            req.setAttribute("username", username);
            // Forward back to login page with error
            req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
        }
    }
}

package com.dilshanmp.pahana_edu.controller;

import com.dilshanmp.pahana_edu.dao.impl.UserDAO;
import com.dilshanmp.pahana_edu.dao.impl.impl.UserDAOImpl;
import com.dilshanmp.pahana_edu.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/JSP/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Optional<User> user = userDAO.authenticate(username, password);

        if (user.isPresent()) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user.get());
            response.sendRedirect(request.getContextPath() + "/JSP/dashboard.jsp");
        } else {
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("/JSP/login.jsp").forward(request, response);
        }
    }

}
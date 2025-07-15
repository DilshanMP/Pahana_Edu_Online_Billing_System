<%--
  Created by IntelliJ IDEA.
  User: pasiy
  Date: 7/15/2025
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - Pahana Edu</title>
    <link rel="stylesheet" href="/CSS/style.css">
</head>
<body>
<div class="container">
    <h1>Pahana Edu Billing System</h1>
    <h2>Login</h2>

    <% if (request.getAttribute("error") != null) { %>
    <p class="error"><%= request.getAttribute("error") %></p>
    <% } %>

    <form action="login" method="post">
        <label>Username:</label>
        <input type="text" name="username" required><br><br>

        <label>Password:</label>
        <input type="password" name="password" required><br><br>

        <button type="submit">Login</button>
    </form>

    <p>Use: admin/admin123</p>
</div>
</body>
</html>
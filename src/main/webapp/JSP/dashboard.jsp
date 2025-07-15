<%@ page import="com.dilshanmp.pahana_edu.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard - Pahana Edu</title>
    <link rel="stylesheet" href="/CSS/style.css">
</head>
<body>
<div class="header">
    <h1>Pahana Edu Billing System</h1>
    <p>Welcome, <%= user.getFullName() %> | <a href="logout">Logout</a></p>
</div>

<div class="menu">
    <a href="dashboard.jsp">Dashboard</a>
    <a href="customers">Customers</a>
    <a href="items">Items</a>
    <a href="billing">Billing</a>
    <a href="help.jsp">Help</a>
</div>

<div class="container">
    <h2>Dashboard</h2>
    <div class="cards">
        <div class="card">
            <h3>Customers</h3>
            <p>Manage customer information</p>
            <a href="customers">View Customers</a>
        </div>

        <div class="card">
            <h3>Items</h3>
            <p>Manage bookstore items</p>
            <a href="items">View Items</a>
        </div>

        <div class="card">
            <h3>Billing</h3>
            <p>Create customer bills</p>
            <a href="billing">Create Bill</a>
        </div>
    </div>
</div>
</body>
</html>
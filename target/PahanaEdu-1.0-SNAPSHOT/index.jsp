<%@ page import="com.dilshanmp.pahana_edu.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    User currentUser = (User) session.getAttribute("user");
    if (currentUser == null) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
%>
<html>
<head>
    <title>Dashboard - Pahana Edu</title>
    <link rel="stylesheet" href="/CSS/style.css">
</head>
<body>
<div class="header">
    <h1>Pahana Edu Billing System</h1>
    <div class="user-info">
        Welcome, <%= currentUser.getFullName() %> |
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>

<div class="nav-menu">
    <a href="${pageContext.request.contextPath}/dashboard.jsp">Dashboard</a>
    <a href="${pageContext.request.contextPath}/customers">Customers</a>
    <a href="${pageContext.request.contextPath}/items">Items</a>
    <a href="${pageContext.request.contextPath}/billing">Billing</a>
    <a href="${pageContext.request.contextPath}/help">Help</a>
</div>
</html>

</body>


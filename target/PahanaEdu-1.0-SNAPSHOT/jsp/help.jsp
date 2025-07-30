<%--
  Created by IntelliJ IDEA.
  User: pasiy
  Date: 7/19/2025
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Help - Pahana Edu Billing System</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        .feature-icon {
            width: 60px;
            height: 60px;
            border-radius: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 24px;
            color: white;
            margin-bottom: 15px;
        }
        .bg-gradient-primary {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        }
        .bg-gradient-success {
            background: linear-gradient(135deg, #48bb78 0%, #38a169 100%);
        }
        .bg-gradient-info {
            background: linear-gradient(135deg, #4299e1 0%, #3182ce 100%);
        }
        .bg-gradient-warning {
            background: linear-gradient(135deg, #ed8936 0%, #dd6b20 100%);
        }
    </style>
</head>
<body class="bg-light">
<!-- Navigation Bar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/dashboard">
            <i class="bi bi-shop me-2"></i>Pahana Edu
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/dashboard">
                        <i class="bi bi-speedometer2 me-1"></i>Dashboard
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/customer">
                        <i class="bi bi-people me-1"></i>Customers
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/item">
                        <i class="bi bi-box me-1"></i>Items
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/bill">
                        <i class="bi bi-receipt me-1"></i>Billing
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/help">
                        <i class="bi bi-question-circle me-1"></i>Help
                    </a>
                </li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="bi bi-person-circle me-1"></i>${sessionScope.fullName}
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">
                                <i class="bi bi-box-arrow-right me-2"></i>Logout
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Main Content -->
<div class="container my-4">
    <h2 class="mb-4"><i class="bi bi-question-circle me-2"></i>Help & About</h2>

    <!-- About Section -->
    <div class="card mb-4">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0"><i class="bi bi-info-circle me-2"></i>About Pahana Edu</h5>
        </div>
        <div class="card-body">
            <p class="lead">
                Pahana Edu Online Billing System is a comprehensive solution designed for educational institutions
                and retail businesses to manage their billing operations efficiently.
            </p>
            <div class="row">
                <div class="col-md-6">
                    <h6>Project Information:</h6>
                    <ul>
                        <li><strong>Module:</strong> ICBT CIS6003 - Advanced Programming</li>
                        <li><strong>Technology:</strong> Java EE (Servlets, JSP, JDBC)</li>
                        <li><strong>Database:</strong> MySQL</li>
                        <li><strong>Architecture:</strong> MVC + DAO + Service Layer</li>
                        <li><strong>UI Framework:</strong> Bootstrap 5</li>
                    </ul>
                </div>
                <div class="col-md-6">
                    <h6>Key Features:</h6>
                    <ul>
                        <li>User Authentication & Session Management</li>
                        <li>Customer Management</li>
                        <li>Item/Product Management</li>
                        <li>Bill Generation & Tracking</li>
                        <li>Dashboard with Statistics</li>
                        <li>Responsive UI Design</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <!-- Features Section -->
    <div class="card mb-4">
        <div class="card-header bg-success text-white">
            <h5 class="mb-0"><i class="bi bi-star me-2"></i>System Features</h5>
        </div>
        <div class="card-body">
            <div class="row g-4">
                <div class="col-md-6 col-lg-3">
                    <div class="text-center">
                        <div class="feature-icon bg-gradient-primary mx-auto">
                            <i class="bi bi-people"></i>
                        </div>
                        <h6>Customer Management</h6>
                        <p class="text-muted">Add, edit, delete, and search customers. Maintain complete customer records.</p>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3">
                    <div class="text-center">
                        <div class="feature-icon bg-gradient-success mx-auto">
                            <i class="bi bi-box"></i>
                        </div>
                        <h6>Item Management</h6>
                        <p class="text-muted">Manage inventory with stock tracking, price management, and low stock alerts.</p>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3">
                    <div class="text-center">
                        <div class="feature-icon bg-gradient-info mx-auto">
                            <i class="bi bi-receipt"></i>
                        </div>
                        <h6>Billing System</h6>
                        <p class="text-muted">Create bills, calculate totals automatically, and maintain billing history.</p>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3">
                    <div class="text-center">
                        <div class="feature-icon bg-gradient-warning mx-auto">
                            <i class="bi bi-graph-up"></i>
                        </div>
                        <h6>Dashboard Analytics</h6>
                        <p class="text-muted">View sales statistics, revenue tracking, and business insights at a glance.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- How to Use Section -->
    <div class="card mb-4">
        <div class="card-header bg-info text-white">
            <h5 class="mb-0"><i class="bi bi-book me-2"></i>How to Use</h5>
        </div>
        <div class="card-body">
            <div class="accordion" id="helpAccordion">
                <div class="accordion-item">
                    <h2 class="accordion-header">
                        <button class="accordion-button" type="button" data-bs-toggle="collapse"
                                data-bs-target="#collapseOne">
                            <i class="bi bi-box-arrow-in-right me-2"></i>Getting Started
                        </button>
                    </h2>
                    <div id="collapseOne" class="accordion-collapse collapse show"
                         data-bs-parent="#helpAccordion">
                        <div class="accordion-body">
                            <ol>
                                <li>Login using your credentials (default: admin/admin123)</li>
                                <li>You'll be redirected to the Dashboard</li>
                                <li>Navigate using the top menu bar</li>
                                <li>Logout when you're done</li>
                            </ol>
                        </div>
                    </div>
                </div>

                <div class="accordion-item">
                    <h2 class="accordion-header">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#collapseTwo">
                            <i class="bi bi-people me-2"></i>Managing Customers
                        </button>
                    </h2>
                    <div id="collapseTwo" class="accordion-collapse collapse"
                         data-bs-parent="#helpAccordion">
                        <div class="accordion-body">
                            <ol>
                                <li>Go to Customers section</li>
                                <li>Click "Add New Customer" to create a customer</li>
                                <li>Fill in customer details (name is mandatory)</li>
                                <li>Use the search box to find customers quickly</li>
                                <li>Click Edit to modify customer information</li>
                                <li>Click Delete to remove a customer (if no bills exist)</li>
                            </ol>
                        </div>
                    </div>
                </div>

                <div class="accordion-item">
                    <h2 class="accordion-header">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#collapseThree">
                            <i class="bi bi-box me-2"></i>Managing Items
                        </button>
                    </h2>
                    <div id="collapseThree" class="accordion-collapse collapse"
                         data-bs-parent="#helpAccordion">
                        <div class="accordion-body">
                            <ol>
                                <li>Navigate to Items section</li>
                                <li>Add new items with name, price, and stock quantity</li>
                                <li>Monitor stock levels (items below 10 units show warnings)</li>
                                <li>Update item prices and stock as needed</li>
                                <li>Delete items that are no longer needed</li>
                            </ol>
                        </div>
                    </div>
                </div>

                <div class="accordion-item">
                    <h2 class="accordion-header">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#collapseFour">
                            <i class="bi bi-receipt me-2"></i>Creating Bills
                        </button>
                    </h2>
                    <div id="collapseFour" class="accordion-collapse collapse"
                         data-bs-parent="#helpAccordion">
                        <div class="accordion-body">
                            <ol>
                                <li>Go to Billing section</li>
                                <li>Select a customer from the dropdown</li>
                                <li>Add items to the bill by selecting from available items</li>
                                <li>Specify quantities (stock availability is shown)</li>
                                <li>System automatically calculates totals</li>
                                <li>Click "Create Bill" to generate the bill</li>
                                <li>View and print bills from the bill list</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Technical Details -->
    <div class="card">
        <div class="card-header bg-secondary text-white">
            <h5 class="mb-0"><i class="bi bi-gear me-2"></i>Technical Implementation</h5>
        </div>
        <div class="card-body">
            <h6>Design Patterns & Principles:</h6>
            <ul>
                <li><strong>Singleton Pattern:</strong> Database connection management</li>
                <li><strong>MVC Pattern:</strong> Separation of concerns</li>
                <li><strong>DAO Pattern:</strong> Data access abstraction</li>
                <li><strong>Service Layer:</strong> Business logic encapsulation</li>
            </ul>

            <h6>OOP Concepts Demonstrated:</h6>
            <ul>
                <li><strong>Encapsulation:</strong> Private fields with getters/setters</li>
                <li><strong>Inheritance:</strong> BaseModel class extended by entities</li>
                <li><strong>Abstraction:</strong> Abstract methods and interfaces</li>
                <li><strong>Polymorphism:</strong> Interface implementations</li>
            </ul>

            <h6>SOLID Principles Applied:</h6>
            <ul>
                <li><strong>S</strong>ingle Responsibility: Each class has one reason to change</li>
                <li><strong>O</strong>pen/Closed: Classes open for extension, closed for modification</li>
                <li><strong>L</strong>iskov Substitution: Derived classes substitutable for base classes</li>
                <li><strong>I</strong>nterface Segregation: Specific interfaces for specific needs</li>
                <li><strong>D</strong>ependency Inversion: Depend on abstractions, not concretions</li>
            </ul>

            <h6>Java Collections Used:</h6>
            <ul>
                <li><strong>ArrayList:</strong> For managing bill items</li>
                <li><strong>HashMap:</strong> For sales summary statistics</li>
            </ul>
        </div>
    </div>
</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
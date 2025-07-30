<%--
  Created by IntelliJ IDEA.
  User: pasiy
  Date: 7/19/2025
  Time: 8:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Pahana Edu Billing System</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        .navbar-brand {
            font-weight: bold;
        }
        .stat-card {
            border: none;
            border-radius: 15px;
            transition: transform 0.2s;
        }
        .stat-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 5px 20px rgba(0,0,0,0.1);
        }
        .stat-icon {
            width: 60px;
            height: 60px;
            border-radius: 15px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 24px;
            color: white;
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
        .chart-container {
            position: relative;
            height: 300px;
            margin-top: 20px;
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
                    <a class="nav-link active" href="${pageContext.request.contextPath}/dashboard">
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
                    <a class="nav-link" href="${pageContext.request.contextPath}/help">
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
    <div class="row mb-4">
        <div class="col">
            <h2>Dashboard</h2>
        </div>
        <div class="col text-end">
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown">
                    <i class="bi bi-download me-2"></i>Export Reports
                </button>
                <ul class="dropdown-menu">
                    <li>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/export?type=customers&format=excel">
                            <i class="bi bi-file-earmark-excel me-2"></i>Export Customers
                        </a>
                    </li>
                    <li>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/export?type=items&format=excel">
                            <i class="bi bi-file-earmark-excel me-2"></i>Export Inventory
                        </a>
                    </li>
                    <li>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/export?type=sales&format=excel">
                            <i class="bi bi-file-earmark-excel me-2"></i>Export Sales Report
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <!-- Error Alert -->
    <c:if test="${not empty error}">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <i class="bi bi-exclamation-triangle-fill me-2"></i>${error}
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
    </c:if>

    <!-- Statistics Cards -->
    <div class="row g-4 mb-4">
        <!-- Total Customers -->
        <div class="col-md-6 col-lg-3">
            <div class="card stat-card h-100">
                <div class="card-body">
                    <div class="d-flex align-items-center">
                        <div class="stat-icon bg-gradient-primary me-3">
                            <i class="bi bi-people"></i>
                        </div>
                        <div>
                            <h6 class="text-muted mb-1">Total Customers</h6>
                            <h3 class="mb-0">${totalCustomers}</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Total Items -->
        <div class="col-md-6 col-lg-3">
            <div class="card stat-card h-100">
                <div class="card-body">
                    <div class="d-flex align-items-center">
                        <div class="stat-icon bg-gradient-success me-3">
                            <i class="bi bi-box"></i>
                        </div>
                        <div>
                            <h6 class="text-muted mb-1">Total Items</h6>
                            <h3 class="mb-0">${totalItems}</h3>
                            <c:if test="${lowStockCount > 0}">
                                <small class="text-warning">
                                    <i class="bi bi-exclamation-triangle"></i> ${lowStockCount} low stock
                                </small>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Total Bills -->
        <div class="col-md-6 col-lg-3">
            <div class="card stat-card h-100">
                <div class="card-body">
                    <div class="d-flex align-items-center">
                        <div class="stat-icon bg-gradient-info me-3">
                            <i class="bi bi-receipt"></i>
                        </div>
                        <div>
                            <h6 class="text-muted mb-1">Total Bills</h6>
                            <h3 class="mb-0">${totalBills}</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Total Revenue -->
        <div class="col-md-6 col-lg-3">
            <div class="card stat-card h-100">
                <div class="card-body">
                    <div class="d-flex align-items-center">
                        <div class="stat-icon bg-gradient-warning me-3">
                            <i class="bi bi-currency-dollar"></i>
                        </div>
                        <div>
                            <h6 class="text-muted mb-1">Total Revenue</h6>
                            <h3 class="mb-0">Rs. <fmt:formatNumber value="${totalRevenue}" pattern="#,##0.00"/></h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Charts Row -->
    <div class="row mb-4">
        <!-- Monthly Sales Chart -->
        <div class="col-lg-8">
            <div class="card">
                <div class="card-header">
                    <h5 class="mb-0"><i class="bi bi-graph-up me-2"></i>Monthly Sales Trend</h5>
                </div>
                <div class="card-body">
                    <div class="chart-container">
                        <canvas id="monthlySalesChart"></canvas>
                    </div>
                </div>
            </div>
        </div>

        <!-- Top Selling Items -->
        <div class="col-lg-4">
            <div class="card">
                <div class="card-header">
                    <h5 class="mb-0"><i class="bi bi-award me-2"></i>Top Selling Items</h5>
                </div>
                <div class="card-body">
                    <div class="chart-container">
                        <canvas id="topItemsChart"></canvas>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Second Charts Row -->
    <div class="row mb-4">
        <!-- Weekly Sales -->
        <div class="col-lg-6">
            <div class="card">
                <div class="card-header">
                    <h5 class="mb-0"><i class="bi bi-calendar-week me-2"></i>Last 7 Days Sales</h5>
                </div>
                <div class="card-body">
                    <div class="chart-container">
                        <canvas id="weeklySalesChart"></canvas>
                    </div>
                </div>
            </div>
        </div>

        <!-- Customer Distribution -->
        <div class="col-lg-6">
            <div class="card">
                <div class="card-header">
                    <h5 class="mb-0"><i class="bi bi-pie-chart me-2"></i>Customer Distribution</h5>
                </div>
                <div class="card-body">
                    <div class="chart-container">
                        <canvas id="customerDistChart"></canvas>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Sales Summary -->
    <c:if test="${not empty salesSummary}">
        <div class="card">
            <div class="card-header bg-primary text-white">
                <h5 class="mb-0"><i class="bi bi-calculator me-2"></i>Sales Summary</h5>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-md-6">
                        <p><strong>Average Bill Amount:</strong>
                            Rs. <fmt:formatNumber value="${salesSummary.averageBillAmount}" pattern="#,##0.00"/>
                        </p>
                        <p><strong>Highest Bill Amount:</strong>
                            Rs. <fmt:formatNumber value="${salesSummary.highestBillAmount}" pattern="#,##0.00"/>
                        </p>
                        <p><strong>Lowest Bill Amount:</strong>
                            Rs. <fmt:formatNumber value="${salesSummary.lowestBillAmount}" pattern="#,##0.00"/>
                        </p>
                    </div>
                    <div class="col-md-6">
                        <p><strong>Best Selling Item:</strong> ${salesSummary.bestSellingItem}
                            (${salesSummary.bestSellingItemCount} units)
                        </p>
                        <p><strong>Unique Items Sold:</strong> ${salesSummary.uniqueItemsSold}</p>
                        <c:if test="${lowStockCount > 0}">
                            <p class="mb-0">
                                <button class="btn btn-warning btn-sm" onclick="sendLowStockAlert()">
                                    <i class="bi bi-envelope me-2"></i>Send Low Stock Alert
                                </button>
                            </p>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </c:if>

    <!-- Quick Actions -->
    <div class="card mt-4">
        <div class="card-header bg-secondary text-white">
            <h5 class="mb-0"><i class="bi bi-lightning me-2"></i>Quick Actions</h5>
        </div>
        <div class="card-body">
            <div class="row g-3">
                <div class="col-md-3">
                    <a href="${pageContext.request.contextPath}/customer?action=add"
                       class="btn btn-outline-primary w-100">
                        <i class="bi bi-person-plus me-2"></i>Add Customer
                    </a>
                </div>
                <div class="col-md-3">
                    <a href="${pageContext.request.contextPath}/item?action=add"
                       class="btn btn-outline-success w-100">
                        <i class="bi bi-plus-circle me-2"></i>Add Item
                    </a>
                </div>
                <div class="col-md-3">
                    <a href="${pageContext.request.contextPath}/bill"
                       class="btn btn-outline-info w-100">
                        <i class="bi bi-receipt-cutoff me-2"></i>New Bill
                    </a>
                </div>
                <div class="col-md-3">
                    <a href="${pageContext.request.contextPath}/bill?action=list"
                       class="btn btn-outline-warning w-100">
                        <i class="bi bi-list-ul me-2"></i>View Bills
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Chart.js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.9.1/dist/chart.min.js"></script>

<script>
    // Load chart data on page load
    document.addEventListener('DOMContentLoaded', function() {
        loadChartData();
    });

    function loadChartData() {
        fetch('${pageContext.request.contextPath}/api/chart?type=dashboard')
            .then(response => response.json())
            .then(data => {
                createMonthlyChart(data.monthly);
                createWeeklyChart(data.weekly);
                createTopItemsChart(data.topItems);
                createCustomerDistChart(data.customerTypes);
            })
            .catch(error => console.error('Error loading charts:', error));
    }

    function createMonthlyChart(data) {
        const ctx = document.getElementById('monthlySalesChart').getContext('2d');
        new Chart(ctx, {
            type: 'line',
            data: {
                labels: Object.keys(data),
                datasets: [{
                    label: 'Monthly Sales (Rs.)',
                    data: Object.values(data),
                    borderColor: 'rgb(102, 126, 234)',
                    backgroundColor: 'rgba(102, 126, 234, 0.1)',
                    tension: 0.1
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        display: false
                    }
                },
                scales: {
                    y: {
                        beginAtZero: true,
                        ticks: {
                            callback: function(value) {
                                return 'Rs. ' + value.toLocaleString();
                            }
                        }
                    }
                }
            }
        });
    }

    function createWeeklyChart(data) {
        const ctx = document.getElementById('weeklySalesChart').getContext('2d');
        new Chart(ctx, {
            type: 'bar',
            data: {
                labels: Object.keys(data),
                datasets: [{
                    label: 'Daily Sales (Rs.)',
                    data: Object.values(data),
                    backgroundColor: 'rgba(72, 187, 120, 0.8)'
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        display: false
                    }
                },
                scales: {
                    y: {
                        beginAtZero: true,
                        ticks: {
                            callback: function(value) {
                                return 'Rs. ' + value.toLocaleString();
                            }
                        }
                    }
                }
            }
        });
    }

    function createTopItemsChart(data) {
        const ctx = document.getElementById('topItemsChart').getContext('2d');
        new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: data.map(item => item.name),
                datasets: [{
                    data: data.map(item => item.quantity),
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.8)',
                        'rgba(54, 162, 235, 0.8)',
                        'rgba(255, 205, 86, 0.8)',
                        'rgba(75, 192, 192, 0.8)',
                        'rgba(153, 102, 255, 0.8)'
                    ]
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        position: 'bottom'
                    }
                }
            }
        });
    }

    function createCustomerDistChart(data) {
        const ctx = document.getElementById('customerDistChart').getContext('2d');
        new Chart(ctx, {
            type: 'pie',
            data: {
                labels: Object.keys(data),
                datasets: [{
                    data: Object.values(data),
                    backgroundColor: [
                        'rgba(66, 153, 225, 0.8)',
                        'rgba(237, 137, 54, 0.8)',
                        'rgba(114, 75, 162, 0.8)'
                    ]
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        position: 'bottom'
                    }
                }
            }
        });
    }

    function sendLowStockAlert() {
        if (confirm('Send low stock alert email to admin?')) {
            fetch('${pageContext.request.contextPath}/export', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: 'action=sendLowStockAlert'
            })
                .then(response => response.text())
                .then(data => {
                    alert(data);
                })
                .catch(error => {
                    alert('Error sending alert: ' + error);
                });
        }
    }
</script>
</body>
</html>
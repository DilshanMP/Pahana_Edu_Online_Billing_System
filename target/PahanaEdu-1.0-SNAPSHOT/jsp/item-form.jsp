<%--
  Created by IntelliJ IDEA.
  User: pasiy
  Date: 7/19/2025
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${not empty item.id ? 'Edit' : 'Add'} Item - Pahana Edu</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css" rel="stylesheet">
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
                    <a class="nav-link active" href="${pageContext.request.contextPath}/item">
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
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/item">Items</a></li>
            <li class="breadcrumb-item active">${not empty item.id ? 'Edit' : 'Add'} Item</li>
        </ol>
    </nav>

    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">
                    <h5 class="mb-0">
                        <i class="bi bi-${not empty item.id ? 'pencil-square' : 'plus-circle'} me-2"></i>
                        ${not empty item.id ? 'Edit' : 'Add New'} Item
                    </h5>
                </div>
                <div class="card-body">
                    <!-- Error Alert -->
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            <i class="bi bi-exclamation-triangle-fill me-2"></i>${error}
                            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                        </div>
                    </c:if>

                    <!-- Item Form -->
                    <form action="${pageContext.request.contextPath}/item" method="post">
                        <input type="hidden" name="action" value="${not empty item.id ? 'update' : 'save'}">
                        <c:if test="${not empty item.id}">
                            <input type="hidden" name="id" value="${item.id}">
                        </c:if>

                        <div class="mb-3">
                            <label for="name" class="form-label">
                                <i class="bi bi-box me-1"></i>Item Name <span class="text-danger">*</span>
                            </label>
                            <input type="text"
                                   class="form-control"
                                   id="name"
                                   name="name"
                                   value="${item.name}"
                                   placeholder="Enter item name"
                                   required>
                        </div>

                        <div class="mb-3">
                            <label for="description" class="form-label">
                                <i class="bi bi-card-text me-1"></i>Description
                            </label>
                            <textarea class="form-control"
                                      id="description"
                                      name="description"
                                      rows="3"
                                      placeholder="Enter item description (optional)">${item.description}</textarea>
                        </div>

                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="unitPrice" class="form-label">
                                    <span class="me-1">₨</span>Unit Price (LKR) <span class="text-danger">*</span>

                                </label>
                                <input type="number"
                                       class="form-control"
                                       id="unitPrice"
                                       name="unitPrice"
                                       value="${item.unitPrice}"
                                       placeholder="0.00"
                                       step="0.01"
                                       min="0"
                                       required>
                                <div class="form-text">Enter price in Rupees (e.g., 150.00)</div>
                            </div>

                            <div class="col-md-6 mb-3">
                                <label for="stockQuantity" class="form-label">
                                    <i class="bi bi-boxes me-1"></i>Stock Quantity <span class="text-danger">*</span>
                                </label>
                                <input type="number"
                                       class="form-control"
                                       id="stockQuantity"
                                       name="stockQuantity"
                                       value="${item.stockQuantity}"
                                       placeholder="0"
                                       min="0"
                                       required>
                                <div class="form-text">Enter available quantity</div>
                            </div>
                        </div>

                        <hr class="my-4">

                        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                            <a href="${pageContext.request.contextPath}/item"
                               class="btn btn-secondary">
                                <i class="bi bi-x-circle me-1"></i>Cancel
                            </a>
                            <button type="submit" class="btn btn-primary">
                                <i class="bi bi-check-circle me-1"></i>
                                ${not empty item.id ? 'Update' : 'Save'} Item
                            </button>
                        </div>
                    </form>
                </div>
            </div>

            <!-- Stock Info Card (for edit mode) -->
            <c:if test="${not empty item.id}">
                <div class="card mt-3">
                    <div class="card-body">
                        <h6 class="card-title">Stock Information</h6>
                        <p class="mb-1">
                            <strong>Current Stock:</strong>
                            <c:choose>
                                <c:when test="${item.stockQuantity == 0}">
                                    <span class="text-danger">Out of Stock</span>
                                </c:when>
                                <c:when test="${item.stockQuantity < 10}">
                                    <span class="text-warning">${item.stockQuantity} units (Low Stock)</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="text-success">${item.stockQuantity} units</span>
                                </c:otherwise>
                            </c:choose>
                        </p>
                        <small class="text-muted">
                            <i class="bi bi-info-circle me-1"></i>
                            Items with less than 10 units are marked as low stock
                        </small>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    // Ensure price has two decimal places
    document.getElementById('unitPrice').addEventListener('blur', function() {
        if (this.value) {
            this.value = parseFloat(this.value).toFixed(2);
        }
    });
</script>
</body>
</html>
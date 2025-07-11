<p align="center">
  <img src="src/main/webapp/assets/Logo.png" alt="Pahana Edu Logo" width="190">
</p>


# Pahana Edu Online Billing System BookStore 🏢

This project was developed as part of my Advanced Programming module (CIS6003) at ICBT.  
I wanted to build something practical and real, so I chose to create an online billing system for “Pahana Edu,” a bookstore inspired by my own experience with bookshops in Sri Lanka.


** ************************************************************************* **
---

## 🎯 Overview

The Pahana Edu Online Billing System is an academic project that provides a simple yet comprehensive billing solution for educational institutions. It allows users to manage customers, items, and generate bills with a clean, user-friendly interface.

### Key Objectives
- Demonstrate mastery of OOP concepts
- Implement SOLID principles
- Apply design patterns effectively
- Use Java Collections and Generics
- Follow software engineering best practices

---

## ✨ Key Features

- **Login system**: Secure login, only registered users can access the system.
- **Customer management**: Add, edit, and delete customers, with checks for duplicate phone numbers and email addresses.
- **Item management**: Manage books or stationery items with their price per unit.
- **Bill calculation**: Calculate bills instantly based on item and quantity, with the result shown on-screen and saved in the system.
- **Simple, clean interface**: Easy to use, even for a beginner—tested by a few friends!
- **Help page**: Added some basic instructions for new users.

## 🛠 Technologies Used

- **Backend**: Java 8, Java Servlets, JDBC, JSP
- **Database**: MySQL 8.0
- **Frontend**: HTML5, CSS3, JSP
- **Build Tool**: Maven
- **App Server**: Apache Tomcat 9.x
- **IDE**: IntelliJ IDEA (recommended)

---
## 🎨 Design Patterns & Principles

- **MVC (Model-View-Controller)**: Separation of concerns
- **DAO (Data Access Object)**: Database abstraction
- **Singleton Pattern**: Database connection management
- **Service Layer Pattern**: Business logic encapsulation

**OOP Principles:**
- Encapsulation, Inheritance, Abstraction, Polymorphism

**SOLID Principles:**
- Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion


## 🏗 System Architecture

- **Presentation Layer**: JSP files provide user interface screens for login, dashboard, customer, item, and billing management. Styling is handled via CSS.
- **Controller Layer**: Java Servlets handle HTTP requests and responses, orchestrate data flow between the view and business logic, and manage user sessions.
- **Service Layer**: Business logic is encapsulated here. Services handle operations such as billing calculations, validation, and any complex business rules, keeping controllers slim.
- **DAO Layer**: Data Access Objects (DAOs) interact directly with the MySQL database using JDBC, performing CRUD operations for users, customers, and items.
- **Database Layer**: The persistent storage where all data is kept. MySQL tables store users, customers, items, and bill records.


** ************************************************************************* **
---












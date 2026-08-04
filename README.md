# 🎓 CampusSphere

> **A Centralized Student Resource Exchange & Collaboration Platform**

CampusSphere is a full-stack web application developed using **Java Spring Boot** that provides a single platform for college students to exchange academic resources, offer freelance services, seek guidance from seniors, and manage lost & found items within the campus.

---

## 🚀 Project Overview

Students often rely on scattered WhatsApp groups, Telegram channels, and social media for buying books, finding freelancers, seeking guidance, and reporting lost items.

**CampusSphere** solves this problem by bringing all these services into one secure, college-focused platform.

---

# ✨ Features

## 🔐 Authentication Module
- Student Registration
- Secure Login
- Password Encryption (BCrypt)
- Spring Security
- Role-Based Authentication
- Session Management

---

## 📚 Buy & Sell Marketplace
- Create Listings
- Browse Listings
- Search Listings
- Category Filter
- Upload Product Images
- Edit Listings
- Delete Listings
- My Listings
- Seller Information
- Availability Status

---

## 💼 Freelance Services Hub
Students can offer services like:

- Resume Design
- PPT Creation
- Coding Help
- Poster Design
- Record Writing
- Video Editing

Features:
- Create Service
- Browse Services
- Search Services
- Categories
- Edit/Delete Services
- My Services

---

## 🎯 Senior Guidance Hub

Students can receive guidance regarding:

- Internship Guidance
- Placement Guidance
- Subject Guidance
- Hackathon Guidance

Features:
- Create Guidance Posts
- Browse Guidance
- Search
- Edit
- Delete

---

## 🔎 Lost & Found Portal

Features:

- Report Lost Items
- Report Found Items
- Browse Reports
- Search Reports
- Category Filter
- Resolution Status
- Edit/Delete Reports

---

# 🛠 Tech Stack

## Backend

- ☕ Java 17
- 🌱 Spring Boot
- 🔒 Spring Security
- 🧩 Spring MVC
- 🗄 Spring Data JPA (Hibernate)

## Frontend

- 🌐 HTML5
- 🎨 CSS3
- 🅱 Bootstrap 5
- ⚡ JavaScript
- 🍃 Thymeleaf

## Database

- 🐬 MySQL

## Build Tool

- 📦 Maven

## Development Tools

- VS Code
- MySQL Workbench
- Git
- GitHub

---

# 🏗 Project Architecture

```
Client (Browser)
        │
        ▼
Thymeleaf Templates
        │
        ▼
Spring MVC Controllers
        │
        ▼
Service Layer
(Business Logic)
        │
        ▼
Spring Data JPA
        │
        ▼
MySQL Database
```

---

# 📁 Project Structure

```
CampusSphere
│
├── src
│   ├── main
│   │   ├── java
│   │   │
│   │   └── com.campussphere
│   │       ├── auth
│   │       │   ├── controller
│   │       │   ├── dto
│   │       │   ├── entity
│   │       │   ├── repository
│   │       │   ├── service
│   │       │   └── security
│   │       │
│   │       ├── marketplace
│   │       │   ├── controller
│   │       │   ├── dto
│   │       │   ├── entity
│   │       │   ├── repository
│   │       │   └── service
│   │       │
│   │       ├── freelance
│   │       │   ├── controller
│   │       │   ├── dto
│   │       │   ├── entity
│   │       │   ├── repository
│   │       │   └── service
│   │       │
│   │       ├── guidance
│   │       │   ├── controller
│   │       │   ├── dto
│   │       │   ├── entity
│   │       │   ├── repository
│   │       │   └── service
│   │       │
│   │       ├── lostfound
│   │       │   ├── controller
│   │       │   ├── dto
│   │       │   ├── entity
│   │       │   ├── repository
│   │       │   └── service
│   │       │
│   │       ├── common
│   │       └── config
│   │
│   │
│   ├── resources
│   │   ├── static
│   │   ├── templates
│   │   └── application.properties
│   │
│   └── test
│
├── pom.xml
├── README.md
└── .gitignore
```

---

# 📌 Completed Phases

| Phase | Module | Status |
|--------|--------|--------|
| ✅ Phase 1 | Authentication & Foundation | Completed |
| ✅ Phase 2 | Buy & Sell Marketplace | Completed |
| ✅ Phase 3 | Freelance Services Hub | Completed |
| ✅ Phase 4 | Senior Guidance Hub | Completed |
| ✅ Phase 5 | Lost & Found Portal | Completed |

---

# 🚧 Future Enhancements

- 🔔 Real-Time Notifications
- 💬 Live Chat System
- 🔑 Google OAuth Login
- 📱 Android Mobile App
- ⭐ Ratings & Reviews
- ❤️ Wishlist
- 🤖 AI-Based Recommendations
- 📊 Admin Dashboard
- ☁ Cloud Deployment (AWS / Azure)
- 📈 Analytics Dashboard

---

# ⚙️ Installation

```bash
git clone https://github.com/Yuvanesh-RS-12/CampusSphere.git

cd CampusSphere

mvn spring-boot:run
```

Open:

```
http://localhost:8080
```

---

# 📖 Learning Objectives

This project demonstrates:

- Spring Boot Architecture
- MVC Design Pattern
- Layered Architecture
- Spring Security
- Hibernate & JPA
- MySQL Integration
- CRUD Operations
- File Upload Handling
- DTO Pattern
- Repository Pattern

---

# 👨‍💻 Developed By

**Yuvanesh R S**

Computer Science & Engineering  
Chennai Institute of Technology

---

# ⭐ Project Status

🚀 **Actively Under Development**

Current Progress:
- ✅ Core Backend Modules Completed
- 🔄 Advanced Features in Progress

---

## 🌟 If you found this project useful, consider giving it a ⭐ on GitHub!

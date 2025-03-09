# 🏢 Job Portal Backend

## 📌 Overview
This project is a **Job Portal Backend** built using **Spring Boot**, which enables users to:
- **Employers**: Post jobs, manage applications, and review job seekers.
- **Job Seekers**: Apply for jobs, upload resumes, and track application status.
- **Admins**: Manage users and oversee the job portal system.

## 🚀 Technologies Used
- **Java 17**
- **Spring Boot 3+**
- **Spring Security (JWT, BCrypt)**
- **Spring Data JPA**
- **MySQL Database**
- **Postman (for API testing)**

## 📂 Project Structure
- **job_portal/**
    - **src/**
        - **main/**
            - **java/com/portal_backend/job_portal/**
                - **controllers/** → Handles HTTP requests
                - **services/** → Business logic layer
                - **dto/** → Database object models
                - **entities/** → Database models
                - **repositories/** → Database access layer
                - **enums/** → Constants like roles and statuses
                - `JobPortalApplication.java` → Main application entry point
        - **resources/**
            - `application.properties` → Configuration file
    - `pom.xml` → Maven dependencies
    - `README.md` → Project documentation



## ⚙️ How to Run the Project
### **Step 1: Clone the Repository**
```sh
git clone https://github.com/UraniaTumani/job-portal.git
cd job-portal-backend

## Step 2: Configure Database

Update `application.properties` to match your MySQL database credentials.

---

## Step 3: Build and Run

Run the following commands to build and start the application:

```sh
mvn clean install
mvn spring-boot:run



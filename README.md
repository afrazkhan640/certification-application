# Certification Generation System (In-Memory)

## Project Overview
This is a Spring Boot based Certification Generation System built using an in-memory data storage approach.

The project manages users, courses, and certificate generation through REST APIs while following layered architecture principles.

The application simulates a real certification workflow where:

* Users can be created
* Courses can be assigned to users
* Courses can be started and completed
* Certificates can be generated only after successful course completion


# Tech Stack
* Java
* Spring Boot
* REST APIs
* DTO Architecture
* Exception Handling
* In-Memory Data Storage (HashMap)


# Architecture Used
The project follows layered architecture:
Controller → Service → In-Memory Storage (HashMap)

# DTO-Based Design
Separate DTOs are used for request and response handling to maintain clean API structure.

### Request DTOs
* UserRequestDto
* CourseRequestDto

### Response DTOs
* UserResponseDto
* CourseResponseDto
* CertificateResponseDto
This approach helps in controlling API data flow and avoids exposing internal entity structures directly.


# Features Implemented

## User Management
* Create User

## Course Management
* Create Course
* Start Course
* Complete Course

## Certificate Management
* Generate Certificate after course completion

# Business Logic Implemented
* A course can only be started if its status is CREATED
* A course can only be completed if its status is STARTED
* A certificate can only be generated if the course status is COMPLETED
* Duplicate certificate generation is prevented

# Status Flow
CREATED → STARTED → COMPLETED

# Exception Handling
Global exception handling is implemented using @RestControllerAdvice
Runtime exceptions are handled centrally to keep controller logic clean and improve response handling.
### Handled Scenarios

* User not found
* Course not found
* Invalid course state transitions
* Certificate already generated
* Certificate generation before course completion

# Validation
Request validation is implemented using @Valid for validating incoming request data.

# In-Memory Storage
The application currently uses HashMap for storing:
* Users
* Courses
* Certificates
This project was intentionally designed using in-memory storage to focus on backend logic, flow control, DTO handling,
and business rules before integrating a database.

# Key Concepts Practiced
* Layered Architecture
* Dependency Injection
* DTO Design Pattern
* REST API Development
* Exception Handling
* Business Logic Validation
* State Management
* In-Memory Data Handling

# Learning Outcome
This project helped in understanding:
* How backend request flow works internally
* How service layer handles business logic
* How exceptions propagate and are handled globally
* How DTOs improve API design
* How state-based workflows are managed in backend applications

# Future Improvements
* Database Integration (MySQL/PostgreSQL)
* Custom Exceptions
* Structured Error Responses
* JWT Authentication
* Role-Based Access
* PDF Certificate Generation
* Email Notification Support

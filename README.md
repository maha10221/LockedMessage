🔐 Locked Message Application

A secure web application built with Java Spring Boot that allows users to encrypt and decrypt messages safely using AES encryption for messages and BCrypt hashing for passwords. The application provides a user-friendly interface using Thymeleaf and Bootstrap, along with backend validation and error handling.

**Features**

Message Encryption: Encrypt messages with AES algorithm using a randomly generated 16-character secret key.

Password Security: Passwords are securely hashed using BCrypt.

Secret Key Management: Automatically generates secret keys for encryption and stores them securely.

Responsive Frontend: Built with Thymeleaf and Bootstrap 5 for smooth user experience.

Real-Time Feedback: Character and word counters for message input to ensure limits are not exceeded.

Error Handling: Displays clear messages for invalid inputs, incorrect passwords, or failed encryption/decryption.

Postman Testing: APIs available for encryption, decryption, and fetching all entries.

**Tech Stack**

Backend: Java, Spring Boot, Spring Data JPA

Database: MySQL / H2 (for testing)

Encryption: AES (for messages), BCrypt (for password hashing)

Frontend: Thymeleaf, Bootstrap 5, JavaScript

Build Tool: Maven

Tools: Postman, Git/GitHub

Installation

Clone the repository

git clone https://github.com/Maha10221/locked-message-app.git
cd locked-message-app


Configure Database
Update application.properties with your database configuration:

spring.datasource.url=jdbc:mysql://localhost:3306/locked_message_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update


Build and Run Application

mvn clean install
mvn spring-boot:run


Open in Browser
Navigate to: http://localhost:8080/

Usage

Encrypt Message:

Enter your message (up to 1000 characters).

Enter a password (up to 255 characters).

Click Generate Secret Key to encrypt.

Decrypt Message:

Enter your secret key.

Enter the password used during encryption.

Click Decrypt Message to view the original message.

API Endpoints (for Postman)
Method	Endpoint	Description
POST	/encrypt	Encrypt message and password
POST	/decrypt	Decrypt message using key
GET	/getAllEntries	Fetch all messages from database
Project Structure
src/main/java
│
├── com.mahesh.controller        # Spring MVC controllers
├── com.mahesh.entity            # JPA entity classes
├── com.mahesh.repository        # Spring Data JPA repositories
├── com.mahesh.service           # Service interfaces
├── com.mahesh.serviceimplimentation  # Service implementations
└── com.mahesh.util              # AES encryption utilities

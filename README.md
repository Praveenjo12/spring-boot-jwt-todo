# Spring Boot JWT Todo Application

A RESTful Todo application built using **Spring Boot**, **MongoDB**, and **JWT authentication**.

---

## 🚀 Features
- User Registration & Login
- JWT-based Authentication
- Protected Todo APIs
- MongoDB integration
- RESTful CRUD operations
- Stateless security with Spring Security

---

## 🛠️ Tech Stack
- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- MongoDB
- Maven

---

## 🔐 Authentication Flow
1. Register user → `/auth/register`
2. Login user → `/auth/login`
3. Receive JWT token
4. Pass token in headers:
5. Access protected Todo APIs

---

## 📌 API Endpoints

### Auth
- `POST /auth/register`
- `POST /auth/login`

### Todo (Protected)
- `GET /api/v2/todo`
- `GET /api/v2/todo/{id}`
- `POST /api/v2/todo/create`
- `PUT /api/v2/todo/{id}`
- `DELETE /api/v2/todo/{id}`

---

## ▶️ Run the Project
```bash
mvn spring-boot:run



---

## 💡 Pro tip (for interviews)
A good README shows:
- what the project does
- how auth works
- how to run it
- what tech you used

You’re **very close to a professional-level repo** now 👌

---

If you want, next I can help you:
- make README **even cleaner**
- add **API request/response examples**
- add **Postman screenshots**
- make it **resume-ready**

Just tell me 👍


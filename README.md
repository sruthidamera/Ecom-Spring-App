# E-commerce Full Stack Practice Project

This is a basic full-stack application built to practice using **Java Spring Boot** for the backend and **React** for the frontend. The project simulates a simple e-commerce system with product listing features.

## 📁 Project Structure

```
ecom-backend/     # Java Spring Boot backend
ecom-frontend/    # React frontend
```

---

## 🚀 Features

- RESTful API with Spring Boot
- Product CRUD operations
- React frontend integrated with the backend
- Organized project structure for full-stack development

---

## 🛠️ Tech Stack

- **Backend:** Java, Spring Boot, Spring Data JPA
- **Frontend:** React, JavaScript
- **Database:** H2 (in-memory)
- **Build Tool:** Maven

---

## 🔧 Setup Instructions

### Backend (Spring Boot)

1. Navigate to the backend folder:
   ```bash
   cd ecom-backend
   ```

2. Run the Spring Boot application:


3. Access backend (default): `http://localhost:8080`

### Frontend (React)

1. Navigate to the frontend folder:
   ```bash
   cd ecom-frontend
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the React application:
   ```bash
   npm run dev
   ```

4. Access frontend (default): `http://localhost:5173`

---

## ⚙️ API Endpoints

| Method | Endpoint           | Description            |
|--------|--------------------|------------------------|
| GET    | `/api/products`    | Get all products       |
| GET    | `/api/product/{id}`| Get product by ID      |
| POST   | `/api/products`    | Add a new product      |
| PUT    | `/api/products`    | Update a product       |
| DELETE | `/api/product/{id}`| Delete product by ID   |


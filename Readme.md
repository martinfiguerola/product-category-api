# 🛠️ Practice Project: Product & Category API

> This project was developed to review essential backend concepts with Spring Boot, including:
> - Bidirectional relationships in JPA
> - Using DTOs to decouple the domain layer from the API
> - Validations with Bean Validation
> - Global error handling with `@ControllerAdvice`

---

## 🧠 Project Overview
This is a simple RESTful API built with Spring Boot that manages products and categories.  
Each product belongs to a category, and each category can have many products, modeled with bidirectional JPA relationships.
---

## 🛠 Technologies Used
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- Lombok
- Bean Validation (Jakarta)

---

## Setup & Run

```bash
  git clone https://github.com/martinfiguerola/product-category-api.git
  cd product-category-api
  mvn clean install
  mvn spring-boot:run
```
API will be available at: http://localhost:8080

---

## 🔗 API Endpoints

### Product Endpoints

| Method  | Endpoint          | Description                         |
|---------|-------------------|-------------------------------------|
| GET     | `/products`       | List all products                   |
| GET     | `/products/{id}`  | Get product by ID with category ref |
| POST    | `/products`       | Create a new product                |
| PUT     | `/products/{id}`  | Update an existing product          |
| DELETE  | `/products/{id}`  | Delete a product                    |

### Category Endpoints

| Method  | Endpoint           | Description                         |
|---------|--------------------|-------------------------------------|
| GET     | `/categories`      | List all categories                 |
| GET     | `/categories/{id}` | Get category by ID with product ref |
| POST    | `/categories`      | Create a new category               |
| PUT     | `/categories/{id}` | Update an existing category         |
| DELETE  | `/categories/{id}` | Delete a category                   |

---

## 🙋‍♂️ Author

**Martín Figuerola**  
[GitHub](https://github.com/martinfiguerola)

---




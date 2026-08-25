# BadaBazaar 🛒

BadaBazaar is a robust e-commerce backend application built using Spring Boot. It provides a complete set of REST APIs for managing an online marketplace, supporting both customers and sellers. The application features secure authentication using JWT, PostgreSQL for data persistence, and comprehensive API documentation via Swagger UI.

## Features ✨

- **Role-based Authentication**: Secure registration and login for `CUSTOMER` and `SELLER` roles using JWT.
- **Product Management**: Sellers can list, update, view, and delete their products.
- **Cart System**: Customers can add items to their cart, view their cart, and checkout.
- **Order Processing**: Seamless order placement and management.
- **Payment Cards**: Customers can securely save and manage payment cards for checkout.
- **Admin Dashboard**: APIs to retrieve user statistics and lists based on roles.
- **API Documentation**: Fully documented APIs with descriptions, request/response models, and examples using Springdoc OpenAPI.

## Tech Stack 🛠️

- **Framework**: Spring Boot 3.2.x
- **Language**: Java 21
- **Database**: PostgreSQL
- **Security**: Spring Security with JWT
- **Documentation**: Springdoc OpenAPI (Swagger UI)
- **Other Dependencies**: MapStruct, Lombok, Twilio, Redis (optional caching)

## Prerequisites 📋

Before running the application, make sure you have the following installed:
- [Java 21](https://jdk.java.net/21/) or higher
- [Maven](https://maven.apache.org/) (optional, wrapper provided)
- [PostgreSQL](https://www.postgresql.org/)

## Setup Instructions 🚀

### 1. Database Configuration
Create a new database in PostgreSQL named `bada_bazaar`:
```sql
CREATE DATABASE bada_bazaar;
```
Ensure your `application.properties` or `application.yml` has the correct database credentials for your local PostgreSQL instance.

### 2. Build and Run the Application
Navigate to the root directory of the project and run the application using Maven wrapper:

```bash
# Build the project
./mvnw clean install

# Run the Spring Boot application
./mvnw spring-boot:run
```

### 3. Accessing API Documentation
Once the application is running, you can explore the APIs interactively using Swagger UI.
Open your browser and navigate to:
👉 **[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)**

## API Endpoints Overview 🌐

- **Authentication (`/v1/auth`)**: Endpoints to register as a seller or customer, and login to receive a JWT token.
- **Admin (`/v1/admin`)**: Endpoints to fetch users filtered by roles.
- **Cards (`/v1/cards`)**: Add, remove, or fetch payment cards for customers.
- **Cart (`/v1/carts`)**: Manage shopping cart items and proceed to checkout.
- **Items (`/v1/items`)**: Public endpoints to view specific product items.
- **Orders (`/v1/orders`)**: Endpoints for placing and managing orders.
- **Products (`/v1/products`)**: Endpoints for sellers to add, update, delete, and view products.

## Testing the APIs

1. Register a user (as a `SELLER` or `CUSTOMER`) via `/v1/auth/register`.
2. Login via `/v1/auth/login` to obtain the JWT token.
3. In Swagger UI, click the **Authorize** button at the top and paste your JWT token to authenticate subsequent requests.
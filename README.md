# Microservices Architecture - Invoice Management System

## Architecture Overview

This is a comprehensive microservices application for managing invoices containing products and belonging to customers.

### Services

1. **Discovery Service (Eureka)** - Port 8761
   - Service registry and discovery
   - Enables dynamic service location

2. **Config Service** - Port 8888
   - Centralized configuration management
   - Git-based configuration repository

3. **API Gateway** - Port 8080
   - Routes requests to microservices
   - Static and dynamic routing configuration
   - Service name: `api-gateway`

4. **Customer Service** - Port 8081
   - Manages customers
   - REST endpoints for CRUD operations
   - Service name: `customer-service`

5. **Inventory Service** - Port 8082
   - Manages products
   - REST endpoints for product management
   - Service name: `inventory-service`

6. **Billing Service** - Port 8083
   - Manages invoices and bills
   - Uses Open Feign to communicate with Customer and Inventory services
   - Service name: `billing-service`

7. **Authentication Service** - Port 8084
   - User authentication and authorization
   - JWT token generation
   - Service name: `authentication-service`

## Prerequisites

- Java 17+
- Maven 3.8+
- Git

## Getting Started

### 1. Start Discovery Service (Eureka)
```bash
cd discovery-service
mvn spring-boot:run
```
Eureka Dashboard: http://localhost:8761

### 2. Start Config Service
```bash
cd config-service
mvn spring-boot:run
```

### 3. Start Microservices
```bash
# Customer Service
cd customer-service
mvn spring-boot:run

# In another terminal - Inventory Service
cd inventory-service
mvn spring-boot:run

# In another terminal - Billing Service
cd billing-service
mvn spring-boot:run

# In another terminal - Authentication Service
cd authentication-service
mvn spring-boot:run
```

### 4. Start API Gateway
```bash
cd gateway
mvn spring-boot:run
```

## API Endpoints

### Via Gateway (Port 8080)

**Customers:**
- GET /api/customers - List all customers
- POST /api/customers - Create a customer
- GET /api/customers/{id} - Get customer details
- PUT /api/customers/{id} - Update customer
- DELETE /api/customers/{id} - Delete customer

**Products:**
- GET /api/products - List all products
- POST /api/products - Create a product
- GET /api/products/{id} - Get product details
- PUT /api/products/{id} - Update product
- DELETE /api/products/{id} - Delete product

**Bills:**
- GET /api/bills - List all bills
- POST /api/bills - Create a bill
- GET /api/bills/{id} - Get bill details
- PUT /api/bills/{id} - Update bill
- DELETE /api/bills/{id} - Delete bill

### Direct Service Calls

**Discovery Service:**
- http://localhost:8761 - Eureka Dashboard

**Config Service:**
- http://localhost:8888/customer-service/default
- http://localhost:8888/inventory-service/default
- http://localhost:8888/billing-service/default

## Configuration

### Dynamic Routing
The gateway discovers services dynamically via Eureka and routes traffic based on service names and paths.

### Static Routing Configuration
Configured in `gateway/src/main/resources/application.properties`:
- `/api/customers/**` → customer-service
- `/api/products/**` → inventory-service
- `/api/bills/**` → billing-service

## Service Communication

- **Inter-service communication**: Uses Spring Cloud OpenFeign
- **Service discovery**: Netflix Eureka
- **Configuration management**: Spring Cloud Config
- **API Gateway**: Spring Cloud Gateway
- **Authentication**: Spring Security + JWT

## Technology Stack

- **Framework**: Spring Boot 3.2.0
- **Cloud**: Spring Cloud 2023.0.0
- **Discovery**: Netflix Eureka
- **Gateway**: Spring Cloud Gateway
- **Config**: Spring Cloud Config
- **REST Clients**: Spring Cloud OpenFeign
- **Database**: H2 (in-memory)
- **Security**: Spring Security + JWT
- **Build**: Maven
- **Java**: 17+

## Development Notes

1. All services are registered with Eureka discovery service
2. Configuration can be centrally managed via Config Service
3. The Gateway provides a single entry point for all API calls
4. Services communicate with each other using OpenFeign clients
5. JWT tokens are used for authentication

## Next Steps

1. Create Angular client for UI
2. Implement comprehensive error handling
3. Add logging and monitoring
4. Deploy using Docker/Kubernetes
5. Add API documentation (Swagger/OpenAPI)
6. Implement circuit breakers with Resilience4j

## Authors

Nada BETTACH

## Repository

https://github.com/Nadabet/BETTACH-Nada-Une-Architecture-Micro-Services


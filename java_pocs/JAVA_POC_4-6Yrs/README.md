
# Employee Management System Web App 

This project is based on Employee Management System using Java8, Spring Boot, Microservices, Spring Data JPA. 
The app empowers administrators to efficiently manage employees, departments and their respective organizations.

It is majorly focused on the backend API's development to perform various functionalities by user and implementation of Eureka Server, Eureka Client, Circuit Breaker, Resilience4J, FeignClient, RestTemplate & Swagger.



## TechStacks Used

**Framework :** Springboot 2, Microservices ,Spring Data JPA

**Database :** MySQL

**Application Server :** Tomcat

**Java Version :** JDK 1.8

**Testing tool :** Postman

**IDE :** Eclipse

## Modules

- **API Gateway**   **-** API Gateway which is responsible to route the request to specific microservice. 

- **Config Server** **-**  Provides a centralized server for delivering external configuration properties to this app.

- **Service Registry** **-**  Eureka service registry.

- **Department Service** **-**  Department microservice.

- **Employee Service** **-**  Employee microservice.

- **Organization Service** **-**  Organization microservice.


## Project Setup


**1.** Clone the repository: `git clone https://github.com/v2dev/java-pocs.git`

**2.** Build the project- `mvn clean install package`

**3.** Run the app using `mvn spring-boot:start` from project root directory.
## Endpoints to access the Functionalities

### Employee Service 
#### Add new employee

```http
  http://localhost:9191/api/employee/add
```
#### Get employee by Id

```http
  http://localhost:9191/api/employee/getbyid/{emp-id}
```
#### Get all employee

```http
  http://localhost:9191/api/employee/getall
```
#### Update employee

```http
  http://localhost:9191/api/employee/update/{emp-id}
```
#### Delete employee

```http
  http://localhost:9191/api/employee/delete/{emp-id}
```
### Department Service
#### Add new department

```http
  http://localhost:9191/api/departments/add
```
#### Get department by code

```http
  http://localhost:9191/api/departments/getbycode/{department-code}
```
#### Get all departments

```http
  http://localhost:9191/api/departments/getall
```
#### Update department

```http
  http://localhost:9191/api/departments/update/{department-code}
```
#### Delete department

```http
  http://localhost:9191/api/departments/delete/{department-code}
```

### Organization Service
#### Add new Organization

```http
  http://localhost:9191/api/organization/add
```
#### Get Organization by code

```http
  http://localhost:9191/api/organization/getbycode/{organizationCode}
```
#### Get all Organizations

```http
  http://localhost:9191/api/organization/getall
```
#### Update Organization

```http
  http://localhost:9191/api/organization/update/{organization-code}
```
#### Delete Organization

```http
  http://localhost:9191/api/organization/delete/{organization-code}
```

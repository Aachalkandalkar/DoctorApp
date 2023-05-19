# **About Assignment**

## Name :- DoctorApp
## Framework :- Spring
## Language :- Java

# Data Flow

### Application Properties

spring.datasource.url=jdbc:mysql://localhost:3306/HospitalManagement
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true


### Controller Package

This Package Handles the HTTP Request from the client. It contains the Three classes

* AppointmentController
* DoctorController
* PatientController

These models have mainly CRUD Operation Request

1.@GetMapping: The @GetMapping annotation is used to map HTTP GET requests to a specific method in the controller class. It is used to retrieve or fetch data from the server. It can be applied to a class or a specific method. In the example, @GetMapping is used on the getAllStudents method to map a GET request to the /api/students endpoint, which retrieves a list of all students.

2.@PostMapping :  
i.The @PostMapping annotation is used to map HTTP POST requests to a specific method in the controller class.  
ii.It is used to submit or create new data on the server.   
iii.It can be applied to a class or a specific method.

3.@PutMapping :  
i.The @PutMapping annotation is used to map HTTP PUT requests to a specific method in the controller class.  
ii.It is used to update or modify existing data on the server.  
iii.It can be applied to a class or a specific method.

4.@DeleteMapping :  
i.The @DeleteMapping annotation is used to map HTTP DELETE requests to a specific method in the controller class.  
ii.It is used to delete or remove data from the server.  
iii.It can be applied to a class or a specific method.

### Service Package
This is a Java Spring Boot service class that contains methods for performing CRUD (Create, Read, Update, Delete) operations on job objects. It is annotated with @Service, which is a Spring stereotype annotation indicating that this class is a service. This package also consist of Four classes and One Interface.

AppointmentService
AuthenticationService
DoctorService
PatientService
IAuthService<>

### Repository Package
This package consist of interfaces. Which defines a set of methods that can be used to interact with the underlying database. The interface extends the JpaRepository interface and specifies the Job entity and the data type of its primary key Integer. The interface contains several custom finder methods that use the naming convention of Spring Data JPA to automatically generate the queries. In summary, this code implements a simple REST ful API for managing Job objects with endpoints for performing CRUD operations.

1.IAppointmentRepo  
2.IDoctorRepo   
3.IPatientRepo              
4.ITokenRepo   

### Model package    

Model package Consist of Five Classes and One Enum

1.Appointment   
2.AppointmentKey   
3.AuthenticationToken  
4.Doctor   
5.Patient  
6.Specialization  

All below annotations are applied on each class above:

1.@Entity: Indicates that this class is a JPA entity and should be mapped to a database table.  
2.@Table: Specifies the name of the database table to which this entity is mapped.  
3.@Id: Indicates that the id field is the primary key of the entity.  
4.@GeneratedValue: Specifies the strategy for generating values for the primary key. In this case, it uses GenerationType.AUTO.


### dto

This is Data-To-Object package used for SignIn and SignOut

1.SignInInput  
2.SignInOutput  
3.SignUpInput  
4.SignUpOutput  
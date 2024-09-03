# smartjob
Repositorio con prueba para consultora SmartJob.

# Proyecto Spring Boot - Gestión de Usuarios

Este proyecto es una aplicación de ejemplo construida con Spring Boot que gestiona usuarios. Incluye características como registro de usuarios, validación de datos y generación de tokens JWT, ademas Swagger y los respectivos test unitarios para cada clase construida.

## Requisitos previos

Antes de comenzar, asegúrate de tener los siguientes requisitos instalados en tu sistema:

- [Java 17](https://adoptopenjdk.net/)
- [Maven 3.6+](https://maven.apache.org/)
- [Git](https://git-scm.com/)

## Instalación

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/erbirr/smartjob.git
   cd smartjob/prueba

2. **Compila el proyecto:**:

Navega al directorio del proyecto y ejecuta Maven para compilar:

   mvn clean install

Tambien lo puedes hacer con el wrapper de Maven:

   ./mvnw spring-boot:run

3. **Ejecuta la aplicación:**:

   mvn spring-boot:run

O con el wrapper de Maven:

   ./mvnw spring-boot:run

4. **Base de Datos H2:**:

   El proyecto incluye una base de datos en memoria H2 para facilitar el desarrollo y las pruebas. No es necesaria ninguna configuración adicional. Puedes acceder a la consola H2 de la siguiente forma:

	http://localhost:8080/h2-console
	
	JDBC URL: jdbc:h2:mem:testdb
	User: test
	Password: prueba

5. **Swagger:**:

Además, Swagger está habilitado para facilitar la documentación de la API. Puedes acceder a la interfaz de Swagger en:

   http://localhost:8080/swagger-ui/index.html


6. **Ejecución de Test Unitarios:**:

Para ejecutar los tests unitarios, utiliza el siguiente comando:

   mvn test

7. **Estructura del Proyecto:**:

prueba/
│
├── .gitignore
├── pom.xml
├── mvnw
├── mvnw.cmd
├── README.md
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/smartjob/prueba/
│   │   │       ├── controller/       # Controladores REST
│   │   │       │   └── UserController.java
│   │   │       ├── dto/              # Clases DTO (Data Transfer Object)
│   │   │       │   ├── UserRequestDTO.java
│   │   │       │   └── PhoneDTO.java
│   │   │       ├── model/            # Entidades JPA
│   │   │       │   ├── User.java
│   │   │       │   └── Phone.java
│   │   │       ├── repository/       # Repositorios JPA
│   │   │       │   └── UserRepository.java
│   │   │       └── service/          # Clases de servicio
│   │   │           └── UserService.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties # Configuraciones de la aplicación
│   │       ├── static/                # Archivos estáticos (CSS, JS, etc., si los hay)
│   │       └── templates/             # Plantillas (Thymeleaf u otro motor de plantillas, si se usa)
│   │
│   └── test/                          # Directorio para los test unitarios
│       ├── java/
│       │   └── com/smartjob/prueba/
│       │       ├── controller/        # Test para los controladores REST
│       │       │   └── UserControllerTest.java
│       │       ├── dto/               # Test para las clases DTO
│       │       │   ├── UserRequestDTOTest.java
│       │       │   └── PhoneDTOTest.java
│       │       ├── model/             # Test para las entidades JPA
│       │       │   ├── UserTest.java
│       │       │   └── PhoneTest.java
│       │       ├── repository/        # Test para los repositorios JPA
│       │       │   └── UserRepositoryTest.java
│       │       └── service/           # Test para las clases de servicio
│       │           └── UserServiceTest.java
│       │
│       └── resources/                 # Recursos utilizados en los test (si los hay)
│
└── target/                            # Directorio generado durante la compilación, no se incluye en Git


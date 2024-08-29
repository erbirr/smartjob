# smartjob
Repositorio con prueba para consultora SmartJob.


# Proyecto Spring Boot - Gestión de Usuarios

Este proyecto es una aplicación de ejemplo construida con Spring Boot que gestiona usuarios. Incluye características como registro de usuarios, validación de datos y generación de tokens JWT, ademas de la utilización de Swagger para la documentación y los respectivos Test Unitarios para cada clase.

## Requisitos previos

Antes de comenzar, asegúrate de tener los siguientes requisitos instalados en tu sistema:

- [Java 17](https://adoptopenjdk.net/)
- [Maven 3.6+](https://maven.apache.org/)
- [Git](https://git-scm.com/)

## Instalación

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/erbirr/smartjob.git
   cd /smartjob/prueba


2. **Compila el proyecto:**:

Navega al directorio del proyecto y ejecuta Maven para compilar:

	mvn clean install


Tambien lo puedes hacer con el Wrapper de Maven:

	./mvnw clean install


3. **Ejecuta la aplicación**:

Ejecuta el siguiente comando para iniciar la aplicación.

	mvn spring-boot:run


Tambien lo puedes hacer con el Wrapper

	./mvnw spring-boot:run



4. **Base de Datos**:

La Base de Datos utilizada es una base de datos en memoria (H2), una vez iniciada la aplicación la puedes revisar la consola en el siguiente link.

	http://localhost:8080/h2-console

	JDBC URL: jdbc:h2:mem:testdb
	User: test
	Password: prueba


5. **Swagger**:

Además, Swagger está habilitado para facilitar la documentación de la API. Puedes acceder a la interfaz de Swagger en:

	http://localhost:8080/swagger-ui.html



6. **Pruebas Unitarias**:

Para ejecutar las pruebas unitarias del proyecto puedes ejecutar el siguiente comando maven.

	mvn test


7. **Estructura del proyecto**:


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



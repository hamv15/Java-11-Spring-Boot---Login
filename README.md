# Java-11-Spring-Boot---Login

**Autor: Hugo Adrian Meza Vega**

Microservicio de autenticación con base de datos PostgreSQL. Seguridad a través de JWT.
Se utiliza una aplicación base obtenida a través Spring Initializr agregando las siguientes dependencias:
* ✅ **Spring Web**: Esta dependencia proporciona características para el desarrollo de aplicaciones web, incluido el manejo de solicitudes HTTP.
* ✅ **Spring Data JPA**: Se utiliza esta dependencia para trabajar con la capa de acceso a datos a través de JPA (Java Persistence API).
* ✅ **Validation**: Se utiliza esta dependencia para trabajar con las validaciones de javax.validation o jakarta.validation 
* ✅ **PostgreSQL Driver**: Dependencia para habilitar la conectividad con una base de datos PostgreSQL. Spring Boot utilizará esta dependencia para establecer la conexión con la base de datos.
* ✅ **Spring Security**: Dependencia para habilitar la seguridad en tu aplicación. Spring Security es una parte importante para implementar autenticación y autorización.
* ✅ **Spring Boot DevTools** (opcional): Se puede incluir esta dependencia para facilitar el desarrollo y la recarga automática de la aplicación durante el desarrollo.
* ✅ **Spring Boot Configuration Processor** (opcional): Esta dependencia ayuda a procesar configuraciones personalizadas que se puede definir en el proyecto.
* ✅ **JSON Web Token (JWT)**: Se debe agregar una dependencia que permita trabajar con JWT en Spring Boot. Se puede utilizar una dependencia como `io.jsonwebtoken:jjwt` para generar y verificar tokens JWT.
![image](https://github.com/hamv15/Java-11-Spring-Boot---Login/assets/47130351/70e7bfa3-0842-4e33-b823-01bd5ee5b976)


Es importante mencionar que Spring initializr sugiere utilizar un **JDK distribuido por bellsoft.** Para este proyecto se está utilizando JDK 11 LTS el cual se puede encontrar en el siguiente link: https://bell-sw.com/pages/downloads/#/java-11-lts
  

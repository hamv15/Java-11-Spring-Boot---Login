package com.hamv.login.microservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="users",
uniqueConstraints = {
    @UniqueConstraint(columnNames = "username"),
    @UniqueConstraint(columnNames = "email")
})
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("Identificador del usuario")
    private Long userId;

    @NotBlank(message="El usuario no puede ser nulo")
    @Size(max = 50) //Anotación para indicar el número máximo de caracteres
    @Comment("Columna para almacenar el username del usuario")
    private String username;
    
    @NotBlank(message="El email del usuario no puede ser nulo")
    @Email
    @Comment("Columna para almacenar el email del usuario")
    private String email;

    @NotBlank(message="El email del usuario no puede ser nulo")
    @JsonIgnore
    @Comment("Columna para almacenar el password del usuario")
    private String password;


}

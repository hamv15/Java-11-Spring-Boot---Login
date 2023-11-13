package com.hamv.login.microservice.entities;

import org.hibernate.annotations.Comment;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "NombresUsuarios")
public class NombresUsuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("Identificador del nombre del usuario")
    private Long nombreUsuarioId;

    @NotBlank(message = "El nombre o nombres del usuario no puede ser nulo")
    @Comment("Columna para almacenar el nombre o nombres del usuario")
    private String nombresUsuario;

    @NotBlank(message = "El primer apellido del usuario no puede ser nulo")
    @Comment("Columna para almacenar el primer apellido del usuario")
    private String primerApellidoUsuario;

    @NotBlank(message = "El segundo apellido del usuario no puede ser nulo")
    @Comment("Columna para almacenar el segundo apellido del usuario")
    private String segundoApellidoUsuario;

    //Constructores de la clase
    public NombresUsuarios(){
        //Constructor vacío, necesario para JPA
    }

    public NombresUsuarios(String nombresUsario, String primerApellidoUsuario, String segundoApellidoUsuario){
        this.nombresUsuario=nombresUsario;
        this.primerApellidoUsuario=primerApellidoUsuario;
        this.segundoApellidoUsuario=segundoApellidoUsuario;
    }

    //Zona de getters
    public Long getNombreUsuarioId() {
        return nombreUsuarioId;
    }

    public String getNombresUsuario() {
        return nombresUsuario;
    }

    public String getPrimerApellidoUsuario() {
        return primerApellidoUsuario;
    }

    public String getSegundoApellidoUsuario() {
        return segundoApellidoUsuario;
    }

    //Zona de setters
    public void setNombresUsuario(String nombresUusario) {
        this.nombresUsuario = nombresUusario;
    }

    public void setPrimerApellidoUsuario(String primerApellidoUsario) {
        this.primerApellidoUsuario = primerApellidoUsario;
    }

    public void setSegundoApellidoUsuario(String segundoApellidoUsario) {
        this.segundoApellidoUsuario = segundoApellidoUsario;
    }

    


}

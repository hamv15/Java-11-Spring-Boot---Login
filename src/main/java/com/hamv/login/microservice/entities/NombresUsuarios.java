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
    private String nombresUsario;

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
        this.nombresUsario=nombresUsario;
        this.primerApellidoUsuario=primerApellidoUsuario;
        this.segundoApellidoUsuario=segundoApellidoUsuario;
    }

    //Zona de getters
    public Long getNombreUsuarioId() {
        return nombreUsuarioId;
    }

    public String getNombresUusario() {
        return nombresUsario;
    }

    public String getPrimerApellidoUsario() {
        return primerApellidoUsuario;
    }

    public String getSegundoApellidoUsario() {
        return segundoApellidoUsuario;
    }

    //Zona de setters
    public void setNombreUsuarioId(Long nombreUsuarioId) {
        this.nombreUsuarioId = nombreUsuarioId;
    }

    public void setNombresUusario(String nombresUusario) {
        this.nombresUsario = nombresUusario;
    }

    public void setPrimerApellidoUsario(String primerApellidoUsario) {
        this.primerApellidoUsuario = primerApellidoUsario;
    }

    public void setSegundoApellidoUsario(String segundoApellidoUsario) {
        this.segundoApellidoUsuario = segundoApellidoUsario;
    }

    


}

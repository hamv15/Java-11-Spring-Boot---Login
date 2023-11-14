package com.hamv.login.microservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="usuarios",
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuarios_roles",
                joinColumns = @JoinColumn(name="user_id"),
                inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Roles> roles = new HashSet<>();

    @OneToOne()
    @JoinColumn(name = "numbre_usuario_id")
    @Comment("Columna que almacena el ID del nombre completo del usuario")
    private NombresUsuarios nombresUsuario;

    @JsonIgnore
    @Comment("Columna para almacenar el ultimo inicio de sesión del usuario")
    private Date ultimoInicioSesion;

    @JsonIgnore
    @Comment("Columna para almacenar el estado del usuario: activo/inactivo")
    private Boolean estadoUsuario;

    @JsonIgnore
    @Comment("Columna para almacenar la ip del usuario.")
	private String ip;

    //Constructores de la clase
    public Usuarios(){
        //Constructor vacío necesario para JPA
    }

    public Usuarios(String username, String email, String password){
        this.username=username;
        this.email=email;
        this.password=password;
    }

    //Getters
    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public NombresUsuarios getNombresUsuario() {
        return nombresUsuario;
    }

    public Date getUltimoInicioSesion() {
        return ultimoInicioSesion;
    }

    public Boolean getEstadoUsuario() {
        return estadoUsuario;
    }

    public String getIp() {
        return ip;
    }

    //Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public void setNombresUsuario(NombresUsuarios nombresUsuario) {
        this.nombresUsuario = nombresUsuario;
    }

    public void setUltimoInicioSesion(Date ultimoInicioSesion) {
        this.ultimoInicioSesion = ultimoInicioSesion;
    }

    public void setEstadoUsuario(Boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


    
    


}

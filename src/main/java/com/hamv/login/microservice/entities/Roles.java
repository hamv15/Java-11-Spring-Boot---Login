package com.hamv.login.microservice.entities;

import org.hibernate.annotations.Comment;

import jakarta.persistence.*;

public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("Columna para almacenar el id del role")
    private Integer roleId;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    @Comment("Columna para almacenar el nombre del rol")
    private EnumRole nombreRole;

    //Constructores de la clase
    public Roles(){
        //Constructor requerido por JPA
    }
    public Roles(EnumRole nombreRole){
        this.nombreRole=nombreRole;
    }

    //Zona de getters 
    public Integer getRoleId() {
        return roleId;
    }
    public EnumRole getNombreRole() {
        return nombreRole;
    }

    //Zona de setters
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public void setNombreRole(EnumRole nombreRole) {
        this.nombreRole = nombreRole;
    }
    
}

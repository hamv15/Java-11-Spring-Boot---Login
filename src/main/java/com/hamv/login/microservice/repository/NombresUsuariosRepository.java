package com.hamv.login.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hamv.login.microservice.entities.NombresUsuarios;

public interface NombresUsuariosRepository extends JpaRepository<NombresUsuarios, Long>{
    
}

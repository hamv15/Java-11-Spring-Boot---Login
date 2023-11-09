package com.hamv.login.microservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hamv.login.microservice.entities.Usuarios;

@Repository
public interface UsuariosRepository {
    Optional<Usuarios> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<Usuarios> findByUsernameAndEmail(String username, String email);
    
    @Query(value="delete from {h-schema}user_roles where user_id=:id", nativeQuery=true)
    Boolean borrarRoles(long id);
}

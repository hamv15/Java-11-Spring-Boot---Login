package com.hamv.login.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hamv.login.microservice.entities.EnumRole;
import com.hamv.login.microservice.entities.Roles;

import java.util.Optional;


@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>{
    Optional<Roles> findByNombreRole(EnumRole nombre);

}
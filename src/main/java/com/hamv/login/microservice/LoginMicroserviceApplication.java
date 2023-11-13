package com.hamv.login.microservice;

import java.sql.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hamv.login.microservice.entities.EnumRole;
import com.hamv.login.microservice.entities.NombresUsuarios;
import com.hamv.login.microservice.entities.Roles;
import com.hamv.login.microservice.entities.Usuarios;
import com.hamv.login.microservice.repository.NombresUsuariosRepository;
import com.hamv.login.microservice.repository.RolesRepository;
import com.hamv.login.microservice.repository.UsuariosRepository;

@SpringBootApplication
public class LoginMicroserviceApplication {

	private NombresUsuariosRepository userNombreRepository;
	@Autowired
	public void userNombreRepository(NombresUsuariosRepository userNombreRepository){
		this.userNombreRepository=userNombreRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LoginMicroserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(RolesRepository rol, UsuariosRepository user, NombresUsuariosRepository nombresUsuarios){
		return (args) -> {

			rol.save(new Roles(1L, EnumRole.ROLE_ADMIN));
			rol.save(new Roles(2L, EnumRole.ROLE_ALTAS));
			rol.save(new Roles(3L, EnumRole.ROLE_CANCELACION));

			// Usuario administrador
			NombresUsuarios nombreUsuarioAdmin = new NombresUsuarios();
			nombreUsuarioAdmin.setNombresUsuario("HUGO ADRIAN");
			nombreUsuarioAdmin.setPrimerApellidoUsuario("MEZA");
			nombreUsuarioAdmin.setSegundoApellidoUsuario("VEGA");
			userNombreRepository.save(nombreUsuarioAdmin);
			Usuarios u = new Usuarios("hugo.meza"
									, "hamv15@hotmail.com"
									,"$2a$10$j.pEAoU1QWMN1IFUfm8Sh.VbxSt2MDg2VAVFOsbcTVt1r4/4xZw8q"); //hola123
			u.setUltimoInicioSesion(new Date(0));
		};
	}
}

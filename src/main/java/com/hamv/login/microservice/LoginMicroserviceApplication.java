package com.hamv.login.microservice;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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

	private UsuariosRepository userRepository;
	@Autowired
	public void userRepository(UsuariosRepository userRepository){
		this.userRepository=userRepository;
	}

	private RolesRepository rolesRepository;
	@Autowired
	public void rolesRepository(RolesRepository rolesRepository){
		this.rolesRepository=rolesRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LoginMicroserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(RolesRepository rol, UsuariosRepository user, NombresUsuariosRepository nombresUsuarios){
		return (args) -> {
			//Inserción de los roles
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
			Set<Roles> r = new HashSet<>();
			Roles adminRole=rolesRepository.findByNombreRole(EnumRole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			r.add(adminRole);
			u.setNombresUsuario(nombreUsuarioAdmin);
			u.setRoles(r);
			userRepository.save(u);

		};
	}
}

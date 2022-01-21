package com.gmail.mathias.martinez018.lp3tpf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import clases.repositorios.UsuarioRepositorio;
import clases.usuario.Usuario;

@SpringBootApplication
@EntityScan({"clases.usuario", "clases.organizacion", "clases.remuneracion", "clases.servicio", "clases.invitacion"})
@ComponentScan({"clases.servicio", "clases.controladores"})
@EnableJpaRepositories("clases.repositorios")
public class Lp3TpfApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(Lp3TpfApplication.class, args);
	}
}

@Component
class DemoCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepositorio userRepo;
	
	@Override
	public void run(String... args) throws Exception {
		Usuario user = new Usuario();
		user.setNombre("Mathias Martinez");
		userRepo.save(user);
	}
}
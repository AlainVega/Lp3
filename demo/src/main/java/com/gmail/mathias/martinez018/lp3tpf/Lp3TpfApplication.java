package com.gmail.mathias.martinez018.lp3tpf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"clases.usuario", "clases.organizacion", "clases.remuneracion", "clases.servicio", "clases.invitacion", "clases.pago"})
@ComponentScan({"clases.servicio", "clases.controladores"})
@EnableJpaRepositories("clases.repositorios")
public class Lp3TpfApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(Lp3TpfApplication.class, args);
	}
}
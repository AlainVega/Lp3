package com.gmail.mathias.martinez018.lp3tpf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import clases.usuario.Usuario;

@SpringBootApplication
public class Lp3TpfApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lp3TpfApplication.class, args);
		Usuario user_test = new Usuario();
		user_test.nombre = "Mathias Martinez";
	}

}

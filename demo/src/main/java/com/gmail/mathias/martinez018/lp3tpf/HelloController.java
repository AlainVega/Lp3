package com.gmail.mathias.martinez018.lp3tpf;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@GetMapping("/usuario/{id}")
	public String get_user_by_id(@PathVariable String id) {
		return "This is user with ID " + id;
	}

}

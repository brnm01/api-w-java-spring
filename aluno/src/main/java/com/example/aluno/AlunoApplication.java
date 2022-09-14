package com.example.aluno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController   //esta classe será um bean do tipo Controller
public class AlunoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlunoApplication.class, args);
	}
	
	@GetMapping("/")
	public String index() {
		return "Hello word";
	}

}

package com.solutis.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "solutis Car API", version = "1.0", description = "Documentation Solutis Car API v1.0"))
@SpringBootApplication
@EnableScheduling
public class SolutisCarApplication {
	public static void main(String[] args) {
		SpringApplication.run(SolutisCarApplication.class, args);
	}

}

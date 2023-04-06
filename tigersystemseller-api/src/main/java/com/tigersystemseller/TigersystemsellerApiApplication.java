package com.tigersystemseller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.annotation.WebServlet;

@SpringBootApplication
@RestController
public class TigersystemsellerApiApplication extends SpringBootServletInitializer {
	@Autowired
    private Environment env;
	@GetMapping("/")
	public String getEnvironment() {
		String currentEnvironment = "NENHUM AMBIENTE ATIVO";
		if(env.getActiveProfiles().length >0) {
			 currentEnvironment = env.getActiveProfiles()[0];
		}
		String appName = env.getProperty("spring.application.name");
		return String.format("Ambiente: %s | App Name: %s", currentEnvironment, appName);
	}
	public static void main(String[] args) {
		SpringApplication.run(TigersystemsellerApiApplication.class, args);
	}

}

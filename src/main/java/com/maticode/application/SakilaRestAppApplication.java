package com.maticode.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = { "com.maticode.configuration", "com.maticode.controller",
		"com.maticode.dtos", "com.maticode.exception", "com.maticode.model", "com.maticode.queries",
		"com.maticode.repository", "com.maticode.service" })
public class SakilaRestAppApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SakilaRestAppApplication.class, args);

		// Visto en https://www.youtube.com/watch?v=aS9SQITRocc
//		ApplicationContext apc = SpringApplication.run(SakilaRestAppApplication.class, args);
//		for (String nombreDelBean : apc.getBeanDefinitionNames()) {
//			System.out.println(nombreDelBean);
//		}
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:4200") // Reemplaza con la URL de tu aplicación
																			// Angular
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
	}

}

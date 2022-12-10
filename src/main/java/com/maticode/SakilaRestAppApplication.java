package com.maticode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.maticode.controller","com.maticode.service","com.maticode.model","com.maticode.repository","com.maticode.queries"})
public class SakilaRestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SakilaRestAppApplication.class, args);
	}

}

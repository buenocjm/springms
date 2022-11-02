package com.taller.registereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegistereurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistereurekaApplication.class, args);
	}

}

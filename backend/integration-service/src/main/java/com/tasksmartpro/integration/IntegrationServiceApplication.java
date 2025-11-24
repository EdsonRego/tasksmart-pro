package com.tasksmartpro.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.tasksmartpro.integration.feign")
public class IntegrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationServiceApplication.class, args);
	}

}

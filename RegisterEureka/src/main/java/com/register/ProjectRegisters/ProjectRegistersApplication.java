package com.register.ProjectRegisters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ProjectRegistersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectRegistersApplication.class, args);
	}

}

package com.qualification.ProjectQualifications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProjectQualificationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectQualificationsApplication.class, args);
	}

}

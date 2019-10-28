package com.company.EurekaSvcRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaSvcRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaSvcRegistryApplication.class, args);
	}

}

package com.example.BabaFoodUser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.repo")
@ComponentScan("com")
@EntityScan("com")
@EnableEurekaClient
public class BabaFoodUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(BabaFoodUserApplication.class, args);
	}

}

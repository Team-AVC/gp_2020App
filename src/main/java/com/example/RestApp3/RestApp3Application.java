package com.example.RestApp3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestApp3Application {

	public static void main(String[] args) {
		SpringApplication.run(RestApp3Application.class, args);
	}

}

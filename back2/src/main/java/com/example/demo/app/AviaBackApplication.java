package com.example.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import service.ServicesConfig;

@SpringBootApplication

@Import(ServicesConfig.class)
@ComponentScan(basePackages = {"com"})
public class AviaBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(AviaBackApplication.class, args);
	}

}

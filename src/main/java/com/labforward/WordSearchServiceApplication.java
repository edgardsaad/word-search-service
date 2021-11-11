package com.labforward;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.labforward"})
@SpringBootApplication
@Configuration
public class WordSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordSearchServiceApplication.class, args);
	}

}

package com.javarush.art;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
// This tells that application is using Spring boot libraries
@SpringBootApplication
// Component scan, helps the application to find all the components
@ComponentScan({"com"})
// Helps to find entities, like Userr class
@EntityScan("com")
public class ArtApplication {
// Runs the project, finds all the components
	public static void main(String[] args) {

		SpringApplication.run(ArtApplication.class, args);
	}

}

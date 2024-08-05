package com.sunbeaminfo.curiositees.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

// This annotation marks the class as a Spring Boot application
@SpringBootApplication
// This annotation is used to specify the packages to scan for entity classes
// The entity classes are used to map the database tables to Java objects
@EntityScan({"com.curiositees.common.entity"})
public class CuriositeesBackendApplication {

  // The main method is used to start the Spring Boot application by running the SpringApplication.run() method
  // with the CuriositeesBackendApplication class and the command-line arguments
  public static void main(String[] args) {
    SpringApplication.run(CuriositeesBackendApplication.class, args);
  }

}

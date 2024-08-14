package com.sunbeaminfo.curiositees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.curiositees.common.entity")
public class CuriositeesFrontendApplication {

  public static void main(String[] args) {
    SpringApplication.run(CuriositeesFrontendApplication.class, args);
  }

}



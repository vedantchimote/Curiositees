package com.sunbeaminfo.curiositees.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.curiositees.common.entity", "com.sunbeaminfo.curiositees.admin.user"})
public class CuriositeesBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(CuriositeesBackendApplication.class, args);
  }

}

package com.zerobase.whataday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
public class WhatADayApplication {

  public static void main(String[] args) {
    SpringApplication.run(WhatADayApplication.class, args);
  }

}
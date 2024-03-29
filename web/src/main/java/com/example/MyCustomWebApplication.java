package com.example;

import jakarta.persistence.criteria.Predicate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@ServletComponentScan
@SpringBootApplication(scanBasePackages = {"com.example"}, exclude =
    { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})
@EntityScan("com.example")
@EnableJpaAuditing
public class MyCustomWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(MyCustomWebApplication.class, args);
  }
}
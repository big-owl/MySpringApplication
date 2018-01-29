package com.bigowl.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.bigowl.service"})
public class RootConfig {
  @Bean
  UserService getUserService() {
    return new UserService();
  }
}

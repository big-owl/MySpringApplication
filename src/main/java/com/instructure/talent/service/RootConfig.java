package com.instructure.talent.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.instructure.talent.service"})
public class RootConfig {
  @Bean
  UserService getUserService() {
    return new UserService();
  }
}

package com.app.service;

import com.app.user.UserDto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {

  @Bean
  UserDto userDto() {
    return new UserDto();
  }
}

package com.app.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {"com.app.controller", "com.app.web", "com.app.validator"})
public class WebConfig implements WebMvcConfigurer {

  // ViewResolver is configured in application.properties
  // No need for @EnableWebMvc - Spring Boot auto-configures MVC

  // Configure static resource handling, in order to serve static HTML files.
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/**")
              .addResourceLocations("/");
  }

}

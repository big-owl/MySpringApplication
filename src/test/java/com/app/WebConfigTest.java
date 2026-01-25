package com.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.app.config", "com.app.controller", "com.app.web", "com.app.validator", "com.app.service"})
public class WebConfigTest implements WebMvcConfigurer {

}
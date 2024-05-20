package com.spring_02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ServletComponentScan
@SpringBootApplication
public class Spring02Application {

  public static void main(String[] args) {
    SpringApplication.run(Spring02Application.class, args);
  }

// 스프링 부트가 다 해줌
//  @Bean
//  ViewResolver internalResourceViewResolver() {
//    return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
//  }
}

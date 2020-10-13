package com.lcomputerstudy.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {	
	   @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	            .allowedOrigins("http://localhost:8080") // vue 서버의 도메인, 포트로 수정
	            .allowedMethods("*")
	        	.exposedHeaders("jwt-token");
	    }
	   


}

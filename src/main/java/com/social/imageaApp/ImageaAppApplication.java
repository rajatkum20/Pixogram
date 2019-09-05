package com.social.imageaApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
@EntityScan("com.social.imageApp.model")
@ComponentScan({"com.social.imageaApp","com.social.imageApp"})
public class ImageaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageaAppApplication.class, args);
	}
	/*
	 * @Bean public MultipartResolver multipartResolver() { return new
	 * CommonsMultipartResolver(); }
	 */
	
}

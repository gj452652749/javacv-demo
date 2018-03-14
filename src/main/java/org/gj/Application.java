package org.gj;

import org.gj.file.FileHandler;
import org.gj.microservice.http.util.HttpRest;
import org.gj.microservice.http.util.HttpRestImp;
import org.gj.microservice.http.util.SpringRestImp;
import org.opencv.core.Core;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application extends SpringBootServletInitializer{
	@Bean
	public HttpRest httpRest() {
		return new SpringRestImp();
	}
	@Bean
	public HttpRest commonHttpRest() {
		return new HttpRestImp();
	}
	@Bean
	public FileHandler fileHandler() {
		return new FileHandler();
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		SpringApplication.run(Application.class, args);
	}
}
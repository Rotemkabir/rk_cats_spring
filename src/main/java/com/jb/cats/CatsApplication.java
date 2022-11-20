package com.jb.cats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = { "com.jb.cats" },
		excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "com.jb.cats.clr.off.*"))
public class CatsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(CatsApplication.class, args);
		System.out.println("Cat as a Service is running");
	}

}

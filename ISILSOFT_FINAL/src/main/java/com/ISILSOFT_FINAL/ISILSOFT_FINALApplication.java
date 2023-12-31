package com.ISILSOFT_FINAL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ISILSOFT_FINAL"})
public class ISILSOFT_FINALApplication {

	public static void main(String[] args) {
		SpringApplication.run(ISILSOFT_FINALApplication.class, args);
	}

}

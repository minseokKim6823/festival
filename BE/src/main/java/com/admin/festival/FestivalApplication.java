package com.admin.festival;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FestivalApplication {
	public static void main(String[] args) {
		SpringApplication.run(FestivalApplication.class, args);
	}

}

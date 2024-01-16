package com.seloger.propertyPart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AnnounceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnounceApplication.class, args);
	}

}

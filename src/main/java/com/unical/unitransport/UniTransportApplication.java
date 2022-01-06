package com.unical.unitransport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.unical.unitransport.controller.DatabaseManager;

@SpringBootApplication
public class UniTransportApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniTransportApplication.class, args);
		DatabaseManager.getConnection();
	}

}

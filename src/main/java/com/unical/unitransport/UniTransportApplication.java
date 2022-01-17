package com.unical.unitransport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.unical.unitransport.controller.persistence.account.AccountsDAO;
import com.unical.unitransport.controller.persistence.account.Role;
import com.unical.unitransport.controller.persistence.account.RolesDAO;

@SpringBootApplication
public class UniTransportApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniTransportApplication.class, args);
	}

}

package com.unical.unitransport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.unical.unitransport.controller.persistence.account.AccountsManager;
import com.unical.unitransport.controller.persistence.shipment.Shipment;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsDAO;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsManager;

@SpringBootApplication
public class UniTransportApplication {

	public static void main(String[] args) {
	//Per la prima volta che si utilizza l'applicazione decommentare (e poi ricommentare) la rigua successiva per inizializzare il db
	//	UniTransportApplication.initDB();
		SpringApplication.run(UniTransportApplication.class, args);
	}
	
	
	//just adds some basic accounts ( admin, corriere, user ), the most basic roles and a simple shipment
	private static void initDB() {
		AccountsManager.registerRole( "admin" );
		AccountsManager.registerRole( "corriere" );
		AccountsManager.registerRole( "user" );
		
		AccountsManager.registerAccount( "admin@unitransport.com", "admin", "admin" );
		AccountsManager.registerAccount( "corriere@unitransport.com", "corriere", "corriere" );
		AccountsManager.registerAccount( "user@unitransport.com", "user", "user" );
		
		AccountsManager.registerAccount( "user1@unitransport.com", "user1", "user" );
		AccountsManager.registerAccount( "user2@unitransport.com", "user2", "user" );
		
		ShipmentsManager.registerShipment( "user1@unitransport.com", "user2@unitransport.com", "COSENZA (CS)", "MILANO (MI)" );
	}

}

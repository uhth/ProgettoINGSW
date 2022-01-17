package com.unical.unitransport.controller.page;

import java.io.IOException;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unical.unitransport.controller.persistence.shipment.Shipment;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsDAO;
import com.unical.unitransport.controller.persistence.spedizioniUtente.SpedizioneUtente;
import com.unical.unitransport.controller.persistence.spedizioniUtente.SpedizioneUtenteDAO;

@Controller
public class ShipmentsPageController {
	
	@GetMapping("spedisci")
	public String spedisci() {
		return "effettua_spedizione";
	}
	
	@GetMapping("spedizione_tracciabile")
	public String spedizioneTracciabile() {
		return "effettua_spedizione_tracciabile";
	}
	
	@GetMapping("spedizione_express")
	public String spedizioneExpress() {
		return "effettua_spedizione_express";
	}
	
	@GetMapping("spedizione_assicurata")
	public String spedizioneAssicurata() {
		return "effettua_spedizione_assicurata";
	}
	
	@GetMapping("/prenotaRitiro")
	public String prenota() {
		return "prenota_ritiro";
	}
	
	@PostMapping("/prenotaService")
	public String prenota( HttpServletRequest req,
						 HttpServletResponse res, 
						 @RequestParam( value = "luogo", required = true ) String luogo ) throws IOException {

		HttpSession session = req.getSession(true);

		String tracking = trackingCasuale();
		while (ShipmentsDAO.getByTrackingNumber( tracking )!=null) {
			tracking = trackingCasuale();
		}
        
        System.out.println(tracking);
        

        Shipment spedizione = new Shipment(tracking);
        ShipmentsDAO.insert(spedizione);
        
        System.out.println(req.getSession().getAttribute("email"));
        System.out.println(luogo);
        
        SpedizioneUtente spedizione_utente = new SpedizioneUtente(tracking, (String) req.getSession().getAttribute("email"), luogo);
        if (SpedizioneUtenteDAO.insert(spedizione_utente))
        	return "index";
        else return "prenota_ritiro";
	}
	
	public String trackingCasuale() {
		String tracking;
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = lower.toUpperCase();
        String numeri = "0123456789";
        String perRandom = upper + lower + numeri;
        int lunghezzaRandom = 10;

        SecureRandom sr = new SecureRandom();
        StringBuilder sb = new StringBuilder(lunghezzaRandom);
        for (int i = 0; i < lunghezzaRandom; i++) {
            int randomInt = sr.nextInt(perRandom.length());
            char randomChar = perRandom.charAt(randomInt);
            sb.append(randomChar);
        }
        
        tracking = sb.toString();
        return tracking;
		
	}


}

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
import com.unical.unitransport.controller.persistence.shipment.ShipmentsManager;
import com.unical.unitransport.controller.persistence.spedizioniUtente.SpedizioneUtente;
import com.unical.unitransport.controller.persistence.spedizioniUtente.SpedizioneUtenteDAO;

@Controller
public class ShipmentsPageController {
	
	@GetMapping("/spedisci")
	public String spedisci() {
		return "effettua_spedizione";
	}

	@GetMapping("/spedizione_tracciabile")
	public String spedizioneTracciabile() {
		return "effettua_spedizione_tracciabile";
	}
	
	@GetMapping("/spedizione_express")
	public String spedizioneExpress() {
		return "effettua_spedizione_express";
	}
	
	@GetMapping("/spedizione_assicurata")
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
						 @RequestParam( value = "luogoRitiro", required = true ) String luogoRitiro,
						 @RequestParam( value = "luogoConsegna", required = true ) String luogoConsegna,
						 @RequestParam( value = "emailDestinatario", required = true ) String emailDestinatario ) throws IOException {

		HttpSession session = req.getSession(true);

		String tracking = trackingCasuale();
		while (ShipmentsDAO.getByTrackingNumber( tracking )!=null) {
			tracking = trackingCasuale();
		}
        

        Shipment spedizione = new Shipment(tracking);
		spedizione.setSenderLocation(luogoRitiro);
        spedizione.setReceiverLocation(luogoConsegna);
        ShipmentsDAO.insert(spedizione);
        
        ShipmentsManager.registerShipment(tracking,(String) req.getSession().getAttribute("email"), emailDestinatario);
        
        System.out.println(spedizione.getTrackingNumber());
        
        System.out.println(req.getSession().getAttribute("email"));
        System.out.println(luogoRitiro);
        System.out.println(luogoConsegna);
        System.out.println(emailDestinatario);
        
        
        
        SpedizioneUtente spedizione_utente = new SpedizioneUtente(spedizione.getTrackingNumber(), (String) req.getSession().getAttribute("email"));
        if (SpedizioneUtenteDAO.insert(spedizione_utente)) {
        	session.setAttribute("validoGenerico", tracking);
        	session.setAttribute("validoGenerico_p", "Ti servirà per monitorare il pacco, ma non preoccuparti se lasci la pagina,<br> potrai sempre visionarlo nel tuo profilo!");
        	return "validoGenerico";
        }
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

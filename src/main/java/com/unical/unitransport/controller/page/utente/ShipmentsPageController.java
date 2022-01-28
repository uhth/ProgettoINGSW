package com.unical.unitransport.controller.page.utente;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unical.unitransport.controller.persistence.shipment.Shipment;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsManager;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsSenderReceiverDAO;
import com.unical.unitransport.controller.persistence.shipment.state.HistoricalShipment;
import com.unical.unitransport.controller.persistence.shipment.state.HistoricalShipmentDAO;

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
	public String prenota(	Model model,
							HttpServletRequest req,
							HttpServletResponse res, 
							@RequestParam( value = "luogoRitiro", required = true ) String luogoRitiro,
							@RequestParam( value = "luogoConsegna", required = true ) String luogoConsegna,
							@RequestParam( value = "emailDestinatario", required = true ) String emailDestinatario ) throws IOException {

		HttpSession session = req.getSession(true);
    
        Shipment spedizione = ShipmentsManager.registerShipment( (String) req.getSession().getAttribute("email"), emailDestinatario, luogoRitiro, luogoConsegna);
		
        HistoricalShipmentDAO.insert(new HistoricalShipment(spedizione.getTrackingNumber(),spedizione.getCreatedOn(),spedizione.getStatus(),spedizione.getLastLocation()));

        
        if ( ShipmentsSenderReceiverDAO.getBySenderEmail( (String) session.getAttribute( "email" ) ) != null ) {
        	model.addAttribute("validoGenerico", spedizione.getTrackingNumber());
        	model.addAttribute("validoGenerico_p", "Ti servirà per monitorare il pacco, ma non preoccuparti se lasci la pagina,<br> potrai sempre visionarlo nel tuo profilo!");
        	return "validoGenerico";
        }
        else return "prenota_ritiro";
	}
	
	
	
}

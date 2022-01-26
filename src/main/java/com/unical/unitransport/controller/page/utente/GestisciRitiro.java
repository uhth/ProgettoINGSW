package com.unical.unitransport.controller.page.utente;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.unical.unitransport.controller.persistence.shipment.Shipment;
import com.unical.unitransport.controller.persistence.shipment.ShipmentSenderReceiver;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsDAO;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsManager;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsSenderReceiverDAO;
import com.unical.unitransport.controller.persistence.spedizioniUtente.SpedizioneUtenteDAO;

@Controller
public class GestisciRitiro {
	
	@GetMapping("/gestisciRitiro")
	public String gestisciRitiro(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		session.setAttribute("codiceDaAggiornare", null);
		return "gestisciRitiro";
	}
	
	@PostMapping("/cercaTrackingModifica")
	public String controllaTrackingModifica(HttpServletRequest req, String trackingModifica) {
		HttpSession session = req.getSession(true);
		
		session.setAttribute("codiceDaAggiornare", null);

		if (ShipmentsDAO.getByTrackingNumber(trackingModifica)!=null) {
			session.setAttribute("codiceDaAggiornare", trackingModifica);			
		} else {
			session.setAttribute("codiceDaAggiornare", null);
			session.setAttribute("erroreGenerico", "LA SPEDIZIONE NON ESISTE");
			return "erroreGenerico";
		}

		
		
		return "gestisciRitiro";
			
		
	}
	
	@PostMapping("/aggiornaRitiro")
	public String aggiornaRitiro(HttpServletRequest req, String luogoRitiroNuovo) {
		HttpSession session = req.getSession(true);
		
		if (session.getAttribute("codiceDaAggiornare")!=null) {			
			Shipment spedizione = ShipmentsDAO.getByTrackingNumber((String) session.getAttribute("codiceDaAggiornare"));
			if (spedizione.getStatus() >= 1)
				return "erroreGenerico";
			
			ShipmentsDAO.updateRitiro(spedizione, spedizione.getStatus(), luogoRitiroNuovo);
			if (spedizione.getLastLocation().equals(spedizione.getSenderLocation())) {
				spedizione.setLastLocation(luogoRitiroNuovo);
			}
			spedizione.setSenderLocation(luogoRitiroNuovo);
		

			List<String> spedizioni = ShipmentsSenderReceiverDAO.getAllString((String)req.getSession().getAttribute("email"));
			boolean utenteValido = false;
			for (String spedizioneUtenteCorrente: spedizioni) {
				if (spedizioneUtenteCorrente.equals( (String) session.getAttribute("codiceDaAggiornare")))
					utenteValido=true;
				}
			
			if(utenteValido) {
				session.setAttribute("validoGenerico", "LA SPEDIZIONE È STATA CORRETTAMENTE AGGIORNATA");
				session.setAttribute("validoGenerico_p", null);
				return "validoGenerico";
			}
		}

		session.setAttribute("erroreGenerico", "LA SPEDIZIONE NON APPARTIENE ALL'UTENTE CHE NE FA RICHIESTA");
		session.setAttribute("erroreGenerico_p", null);
			return "erroreGenerico";
		
	}
	
	

}

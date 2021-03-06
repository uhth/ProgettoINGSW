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
import com.unical.unitransport.controller.persistence.spedizioniCorriere.SpedizioneCorriere;
import com.unical.unitransport.controller.persistence.spedizioniCorriere.SpedizioneCorriereDAO;
import com.unical.unitransport.controller.persistence.spedizioniUtente.SpedizioneUtenteDAO;

@Controller
public class GestisciRitiro {
	
	@GetMapping("/gestisciRitiro")
	public String gestisciRitiro(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		session.setAttribute("codiceDaAggiornare", null);
		return "gestisciRitiro";
	}
	
	@GetMapping("/cancellaRitiro")
	public String cancellaRitiro(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		session.setAttribute("codiceDaAggiornare", null);
		return "cancellaRitiro";
	}
	
	@GetMapping("/modificaSpedizione")
	public String modificaSpedizione(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		session.setAttribute("codiceDaAggiornare", null);
		return "modificaSpedizioneUtente";
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
		
		Shipment spedizione = ShipmentsDAO.getByTrackingNumber((String) session.getAttribute("codiceDaAggiornare"));

		
		if (session.getAttribute("codiceDaAggiornare")!=null) {			
			if (spedizione.getStatus() >= 1) {
				session.setAttribute("erroreGenerico", "LA SPEDIZIONE NON PUO' ESSERE MODIFICATA");
				session.setAttribute("erroreGenerico_p", "La spedizione ?? in stato troppo avanzato");
				return "erroreGenerico";
			}
			

		

			List<String> spedizioni = ShipmentsSenderReceiverDAO.getAllString((String)req.getSession().getAttribute("email"));
			boolean utenteValido = false;
			for (String spedizioneUtenteCorrente: spedizioni) {
				if (spedizioneUtenteCorrente.equals( (String) session.getAttribute("codiceDaAggiornare")))
					utenteValido=true;
				}
			
			if(utenteValido) {
				ShipmentsDAO.updateRitiro(spedizione, spedizione.getStatus(), luogoRitiroNuovo);
					if (spedizione.getLastLocation().equals(spedizione.getSenderLocation())) {
						spedizione.setLastLocation(luogoRitiroNuovo);
					}
				spedizione.setSenderLocation(luogoRitiroNuovo);

				session.setAttribute("validoGenerico", "LA SPEDIZIONE ?? STATA CORRETTAMENTE AGGIORNATA");
				session.setAttribute("validoGenerico_p", null);
				session.setAttribute("codiceDaAggiornare", null);
				return "validoGenerico";
			}
		}

			session.setAttribute("erroreGenerico", "LA SPEDIZIONE NON APPARTIENE ALL'UTENTE CHE NE FA RICHIESTA");
			session.setAttribute("erroreGenerico_p", null);
			return "erroreGenerico";
		
	}
	
	
	@PostMapping("/cercaTrackingCancella")
	public String controllaTrackingElimina(HttpServletRequest req, String trackingModifica) {
		HttpSession session = req.getSession(true);
		

		if (ShipmentsDAO.getByTrackingNumber(trackingModifica)!=null) {
			List<String> spedizioni = ShipmentsSenderReceiverDAO.getAllString((String)req.getSession().getAttribute("email"));
			if (ShipmentsDAO.getByTrackingNumber(trackingModifica).getStatus() >= 1) {
				session.setAttribute("erroreGenerico", "LA SPEDIZIONE NON PUO' ESSERE MODIFICATA");
				session.setAttribute("erroreGenerico_p", "La spedizione ?? in stato troppo avanzato");
				return "erroreGenerico";
			}
			
			boolean utenteValido = false;
				for (String spedizioneUtenteCorrente: spedizioni) {
					if (spedizioneUtenteCorrente.equals( trackingModifica  ))
						utenteValido=true;
					}
			
				if(utenteValido) {
					ShipmentsDAO.remove(ShipmentsDAO.getByTrackingNumber(trackingModifica));	
					SpedizioneCorriereDAO.remove(trackingModifica);
					session.setAttribute("codiceDaAggiornare", null);
					session.setAttribute("validoGenerico", "LA SPEDIZIONE E' STATA ELIMINATA CON SUCCESSO");
					session.setAttribute("validoGenerico_p", null);
					return "validoGenerico";
				} else {
			session.setAttribute("codiceDaAggiornare", null);
			session.setAttribute("erroreGenerico", "LA SPEDIZIONE NON TI APPARTIENE ");
			session.setAttribute("erroreGenerico_p", null);
			return "erroreGenerico";
				}
		}
		
		return null;
		

		
		
	}

		
		
			
		
	
	

	
	@PostMapping("/cercaTrackingModificaSpedizione")
	public String controllaTrackingModificaConsegna(HttpServletRequest req, String trackingModifica) {
		HttpSession session = req.getSession(true);
		
		session.setAttribute("codiceDaAggiornare", null);

		if (ShipmentsDAO.getByTrackingNumber(trackingModifica)!=null) {
			session.setAttribute("codiceDaAggiornare", trackingModifica);			
		} else {
			session.setAttribute("codiceDaAggiornare", null);
			session.setAttribute("erroreGenerico", "LA SPEDIZIONE NON ESISTE");
			return "erroreGenerico";
		}

		
		
		return "modificaSpedizioneUtente";
			
		
	}
	
	@PostMapping("/aggiornaSpedizioneUtente")
	public String aggiornaConsegna(HttpServletRequest req, String luogoConsegnaNuovo) {
		HttpSession session = req.getSession(true);
		
		if (session.getAttribute("codiceDaAggiornare")!=null) {
			List<String> spedizioni = ShipmentsSenderReceiverDAO.getAllString((String)req.getSession().getAttribute("email"));
				if (ShipmentsDAO.getByTrackingNumber((String) session.getAttribute("codiceDaAggiornare")).getStatus() >= 1) {
					session.setAttribute("erroreGenerico", "LA SPEDIZIONE NON PUO' ESSERE MODIFICATA");
					session.setAttribute("erroreGenerico_p", "La spedizione ?? in stato troppo avanzato");
					return "erroreGenerico";
				}
			boolean utenteValido = false;
			for (String spedizioneUtenteCorrente: spedizioni) {
				if (spedizioneUtenteCorrente.equals( (String) session.getAttribute("codiceDaAggiornare")))
					utenteValido=true;
				}
			
			if(utenteValido) {
				Shipment spedizione = ShipmentsDAO.getByTrackingNumber((String) session.getAttribute("codiceDaAggiornare"));
				ShipmentsDAO.updateLuogoConsegna(spedizione, spedizione.getStatus(), luogoConsegnaNuovo);
				spedizione.setReceiverLocation(luogoConsegnaNuovo);
				session.setAttribute("validoGenerico", "LA SPEDIZIONE ?? STATA CORRETTAMENTE AGGIORNATA");
				session.setAttribute("validoGenerico_p", null);
				return "validoGenerico";
			}
		}

		session.setAttribute("erroreGenerico", "LA SPEDIZIONE NON APPARTIENE ALL'UTENTE CHE NE FA RICHIESTA");
		session.setAttribute("erroreGenerico_p", null);
			return "erroreGenerico";
		
	}
	

}

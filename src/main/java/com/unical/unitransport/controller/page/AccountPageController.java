package com.unical.unitransport.controller.page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unical.unitransport.controller.persistence.shipment.Shipment;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsDAO;
import com.unical.unitransport.controller.persistence.spedizioniCorriere.SpedizioneCorriere;
import com.unical.unitransport.controller.persistence.spedizioniCorriere.SpedizioneCorriereDAO;
import com.unical.unitransport.controller.persistence.spedizioniUtente.SpedizioneUtenteDAO;

@Controller
public class AccountPageController {
	
	List<String> spedizioniCorriere = null;
	
	@GetMapping("/profilo_utente")
	public String profilo(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		List<String> spedizioni = SpedizioneUtenteDAO.getAllString((String)req.getSession().getAttribute("email"));
		session.setAttribute("listaSpedizioni", spedizioni);
		
		return "profilo_utente_tmp";
	}
	
	
	@GetMapping("/areaCorriere")
	public String areaCorriere(HttpServletRequest req) {
		
		HttpSession session = req.getSession(true);
		List<String> spedizioniTotali = SpedizioneCorriereDAO.getAllDisponibiliString();
		session.setAttribute("listaSpedizioniTotale", spedizioniTotali);
		List<String> spedizioniCorriere = SpedizioneCorriereDAO.getAllSpedizioniCorriere((String)req.getSession().getAttribute("email"));
		session.setAttribute("listaSpedizioni", spedizioniCorriere);

		return "area_corriere";
	}
	
	@GetMapping("spedizioniCorriere")
	public String spedizioniAttive(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		session.setAttribute("listaSpedizioniAnteprima", null);
		session.setAttribute("listaSpedizioni", null);

		
		List<String> spedizioniCorriere = SpedizioneCorriereDAO.getAllSpedizioniCorriere((String)req.getSession().getAttribute("email"));
		session.setAttribute("listaSpedizioni", spedizioniCorriere);
		List<String> anteprima = new ArrayList<String>();
		

		for (String anteprimaTracking: spedizioniCorriere) {
			for (Shipment spedizione: ShipmentsDAO.getAll()) {
				if (anteprimaTracking.equals(spedizione.getTrackingNumber()) && spedizione.getLastLocation()!=null) {
					anteprima.add((String) spedizione.getLastLocation());
				} else if (anteprimaTracking.equals(spedizione.getTrackingNumber()) && spedizione.getLastLocation()==null) {
					anteprima.add( "NON ANCORA PARTITO");
				}
			}
		}

		session.setAttribute("listaSpedizioniAnteprima", anteprima);

		
		
		return "spedizioni_corriere";
	}
	
	@PostMapping("richiestaTrackingCorriere")
	public String setTracking(HttpServletRequest req, HttpServletResponse res, String trackingRichiesto) throws IOException {
		HttpSession session = req.getSession(true);
		session.setAttribute("trackingRichiesto", trackingRichiesto);
		
		return "tracking_gmaps";
		

	}
	
	@PostMapping("richiestaTrackingCorriereModifica")
	public String setTrackingGestione(HttpServletRequest req, HttpServletResponse res, String modificaCodiceTracking) throws IOException {
		HttpSession session = req.getSession(true);
		session.setAttribute("codiceRichiestoCorriere", modificaCodiceTracking);
		System.out.println("FATTO");
		
		return "gestioneSpedizioneCorriere";
		

	}
	
	@PostMapping("richiestaCorriere")
	public String richiestaConsegna(HttpServletRequest req, HttpServletResponse res, String richiestaSpedizione) throws IOException {
		HttpSession session = req.getSession(true);
		
		if (ShipmentsDAO.getByTrackingNumber(richiestaSpedizione)!=null) {
			SpedizioneCorriere richiesta = new SpedizioneCorriere(richiestaSpedizione, (String) session.getAttribute("email"));
			if (!SpedizioneCorriereDAO.spedizioneGiaAssegnata(richiestaSpedizione)) {
				SpedizioneCorriereDAO.insert(richiesta);
				res.sendRedirect("/areaCorriere");
				} else { 
					session.setAttribute("erroreGenerico", "HAI GIÀ PRESO IN CARICO QUESTA SPEDIZIONE");
					return "erroreGenerico";
				}
					
		}
		
		session.setAttribute("erroreGenerico", "LA SPEDIZIONE NON ESISTE");
		return "erroreGenerico";
	}
	
	
	

}

//
//codiceRichiestoCorriere
//
//
//<form  method="post" action="richiestaTrackingCorriere">
//	 <button type="button" name="modificaCodiceTracking" type="submit" class="btn btn-primary btn-sm"><a href="aggiornaStato" class="text-decoration-none" style="color: white;">${singolaSpedizione}</a></button>
//

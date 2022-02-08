package com.unical.unitransport.controller.page.corriere;

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
public class AccountPageControllerCorriere {
	
	List<String> spedizioniCorriere = null;
	
	@GetMapping("/areaCorriere")
	public String areaCorriere(HttpServletRequest req) {
		
		HttpSession session = req.getSession(true);
		List<String> spedizioniTotali = SpedizioneCorriereDAO.getAllDisponibiliString();
		session.setAttribute("listaSpedizioniTotale", spedizioniTotali);
		List<String> spedizioniCorriere = SpedizioneCorriereDAO.getAllSpedizioniCorriere((String)req.getSession().getAttribute("email"));
		session.setAttribute("listaSpedizioni", spedizioniCorriere);

		return "area_corriere";
	}
	
	@GetMapping("/spedizioniCorriere")
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
					anteprima.add(spedizione.getLastLocation());
				} else if (anteprimaTracking.equals(spedizione.getTrackingNumber()) && spedizione.getLastLocation()==null) {
					anteprima.add( "NON ANCORA PARTITO");
				}
			}
		}
		
		
		

		session.setAttribute("listaSpedizioniAnteprima", anteprima);

		
		
		return "spedizioni_corriere";
	}
	
	@PostMapping("/richiestaTrackingCorriere")
	public String setTracking(HttpServletRequest req, HttpServletResponse res, String trackingRichiesto) throws IOException {
		HttpSession session = req.getSession(true);
		session.setAttribute("trackingRichiesto", trackingRichiesto);
		
		return "tracking_gmaps";
		

	}
	
	@PostMapping("/richiestaTrackingCorriereModifica")
	public String setTrackingGestione(HttpServletRequest req, HttpServletResponse res, String modificaCodiceTracking) throws IOException {
		HttpSession session = req.getSession(true);
		session.setAttribute("codiceRichiestoCorriere", modificaCodiceTracking);
		
		return "gestioneSpedizioneCorriere";
		

	}
	
	@PostMapping("/richiestaCorriere")
	public String richiestaConsegna(HttpServletRequest req, HttpServletResponse res, String richiestaSpedizione) throws IOException {
		HttpSession session = req.getSession(true);
		
		if (ShipmentsDAO.getByTrackingNumber(richiestaSpedizione)!=null) {
			SpedizioneCorriere richiesta = new SpedizioneCorriere(richiestaSpedizione, (String) session.getAttribute("email"));
			if (!SpedizioneCorriereDAO.spedizioneGiaAssegnata(richiestaSpedizione)) {
				SpedizioneCorriereDAO.insert(richiesta);
				res.sendRedirect("/areaCorriere");
				} else { 
					session.setAttribute("erroreGenerico", "HAI GIÀ PRESO IN CARICO QUESTA SPEDIZIONE");
					session.setAttribute("erroreGenerico_p", null);
					return "erroreGenerico";
				}
					
		}
		
		session.setAttribute("erroreGenerico", "LA SPEDIZIONE NON ESISTE");
		session.setAttribute("erroreGenerico_p", null);
		return "erroreGenerico";
	}
	
	@PostMapping("/richiestaCorriereTutto")
	public String richiestaConsegnaTutte(HttpServletRequest req, HttpServletResponse res, String richiestaSpedizione) throws IOException {
		
		HttpSession session = req.getSession(true);
		
		List<String> all = SpedizioneCorriereDAO.getAllDisponibiliString();
		for (String spedizione: all) {
			SpedizioneCorriere nuova = new SpedizioneCorriere(spedizione,  (String) session.getAttribute("email"));
			if (!SpedizioneCorriereDAO.spedizioneGiaAssegnata(spedizione)) {
				SpedizioneCorriereDAO.insert(nuova);
			}
		}
		
		res.sendRedirect("/areaCorriere");
		
		session.setAttribute("erroreGenerico", "NON E' POSSIBILE ESEGUIRE LA RICHIESTA");
		session.setAttribute("erroreGenerico_p", null);
		return "erroreGenerico";
	}
	
	
	

}

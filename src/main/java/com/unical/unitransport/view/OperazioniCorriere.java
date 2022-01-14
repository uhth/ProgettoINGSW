package com.unical.unitransport.view;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.unical.unitransport.controller.persistence.shipment.Shipment;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsDAO;

@Controller
public class OperazioniCorriere {
	
	private String last_code;
	
	@GetMapping("aggiornaStato")
	public String aggiornaStato(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		session.setAttribute("last_code", null);
		// last_stato=null;
		session.setAttribute("luogoAttuale", null);
		return "gestioneSpedizioneCorriere";
	}
	
	@PostMapping("/corriereServiceCode")
	public String searchID(HttpServletRequest req, HttpServletResponse res, String codice) throws IOException {
		

		HttpSession session = req.getSession(true);
		session.setAttribute("luogoAttuale", null);

		Shipment spedizione = ShipmentsDAO.getByTrackingNumber(codice);
		
		if (spedizione!=null) {
			session.setAttribute("last_code", codice);
			last_code=codice;
			session.setAttribute("luogoAttuale", spedizione.localita());
		}
		
		return "gestioneSpedizioneCorriere";
		
	}
	
	
	@PostMapping("/corriereService")
	public String changeByID(HttpServletRequest req, HttpServletResponse res, String luogo) throws IOException {
		

		HttpSession session = req.getSession(true);

		Shipment spedizione = ShipmentsDAO.getByTrackingNumber(last_code);
		
		String scelta = req.getParameter("scelta");
		
		int scelta_cod = Integer.parseInt(scelta);
		
		if (spedizione!=null) {
			ShipmentsDAO.update(spedizione, scelta_cod, luogo);
		}
		

		
		return "gestioneSpedizioneCorriere";
		
	}

}

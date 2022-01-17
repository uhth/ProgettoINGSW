package com.unical.unitransport.view;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.unical.unitransport.controller.persistence.shipment.Shipment;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsDAO;

@Controller
public class TrackingPage {
	
	
	@GetMapping("tracking_page")
	public String tracking(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		session.setAttribute("codice",  null);
		return "tracking_page";
	}
	
	@GetMapping("tracking_information")
	public String trackinginfo() {
		return "trackingInformation";
	}

	
	@PostMapping("/trackingService")
	public String getByCode(HttpServletRequest req, HttpServletResponse res, String codice_inserito){
		
		HttpSession session = req.getSession(true);
		
		
		
		Shipment spedizione = ShipmentsDAO.getByTrackingNumber(codice_inserito);
		
			if (spedizione!=null) {
			session.setAttribute("codice",  codice_inserito);
			session.setAttribute("stato",  spedizione.stato());
			session.setAttribute("luogo",  spedizione.localita());
		} else {
			session.setAttribute("stato",  "Spedizione inesistente");
			session.setAttribute("luogo",  "SCONOSCIUTO");
		}


			
		
		return "trackingInformation";
	}
	
}
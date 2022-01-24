package com.unical.unitransport.controller.page.utility;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unical.unitransport.controller.persistence.shipment.Shipment;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsDAO;

@Controller
public class TrackingPageController {

	
	@PostMapping("/trackingService")
	public String check( Model model, HttpServletRequest req, HttpServletResponse res,
			@RequestParam(value = "tracking_box", required = true) String tracking) throws IOException {

		Shipment spedizione = ShipmentsDAO.getByTrackingNumber(tracking);

		// HttpSession session;
		if (spedizione == null) {
			return "tracking_gmapsFallito";
		}
		/* TEST STATE/UPDATE/TIME
		spedizione.setStatus(1);
		spedizione.setStatus(2);
		spedizione.setStatus(3);		
		spedizione.setLastUpdate(new Timestamp(0));
		spedizione.setLastUpdate(new Timestamp(0));
		spedizione.setLastUpdate(new Timestamp(0));
		spedizione.setLastLocation("Milano MI");
		spedizione.setLastLocation("ROMA RM");
		*/ 
		
		
		loadMarkers( spedizione, model );
		loadTable( spedizione, model );
		model.addAttribute("tracking_number", spedizione.getTrackingNumber());

		return "tracking_gmapsPositivo";
	}

	public void loadTable(Shipment spedizione, Model model ) {
		
		System.out.println(spedizione.getRegisterState().size() + " - " + spedizione.getRegisterLocation().size() + " - " + spedizione.getRegisterDate().size());
		int[] x = {spedizione.getRegisterState().size(), spedizione.getRegisterLocation().size(), spedizione.getRegisterDate().size()};
        Arrays.sort(x);
        
		model.addAttribute("sizeofevents", x[0]-1); //da testare
		model.addAttribute("statosped", spedizione.getRegisterState());
		model.addAttribute("luogosped", spedizione.getRegisterLocation());
		model.addAttribute("dataeora", spedizione.getRegisterDate()); // spedizione.getCreatedOn().toString().substring(0, 19) );
		model.addAttribute("destFinale", spedizione.getReceiverLocation());
	}
	
	public void loadMarkers( Shipment spedizione, Model model ) {
		
		AddressToCoordinate coordCorriere = new AddressToCoordinate();

		if (spedizione.getRegisterLocation().size() == 1) { 
			coordCorriere = new AddressToCoordinate(spedizione.getLastLocation());
	        double str1 = Double.parseDouble( coordCorriere.getLatitude());
	        double str2 = Double.parseDouble( coordCorriere.getLongitude());
			model.addAttribute("corrierelat", str1 - 0.1 );
			model.addAttribute("corrierelong", str2- 0.1 );
		} else {
			coordCorriere = new AddressToCoordinate(spedizione.getLastLocation());
			model.addAttribute("corrierelat", coordCorriere.getLatitude());
			model.addAttribute("corrierelong", coordCorriere.getLongitude());
		}
		
		AddressToCoordinate coordDestinatario = new AddressToCoordinate(spedizione.getReceiverLocation());
		AddressToCoordinate coordMittente = new AddressToCoordinate(spedizione.getSenderLocation());
		
		model.addAttribute("destinatariolat", coordDestinatario.getLatitude());
		model.addAttribute("destinatariolong", coordDestinatario.getLongitude());		
		model.addAttribute("mittentelat", coordMittente.getLatitude());
		model.addAttribute("mittentelong", coordMittente.getLongitude());	
	}

}
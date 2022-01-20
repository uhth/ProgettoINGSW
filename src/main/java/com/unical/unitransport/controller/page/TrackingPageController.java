package com.unical.unitransport.controller.page;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

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
	
		loadMarkers( spedizione, model );
		loadTable( spedizione, model );
		
		return "tracking_gmapsPositivo";
	}

	public void loadTable(Shipment spedizione, Model model ) {
		// String dataOra = spedizione.getData();
		String stato = spedizione.stato();
		String luogo = spedizione.getLastLocation();
	
		model.addAttribute("statosped", stato);
		model.addAttribute("luogosped", luogo);
		model.addAttribute( "dataeora", spedizione.getCreatedOn().toString().substring(0, 19) );
		
	}
	
	public void loadMarkers( Shipment spedizione, Model model ) {
		
		AddressToCoordinate coordCorriere = new AddressToCoordinate();

		if (spedizione.getLastLocation() != null ) {
			coordCorriere = new AddressToCoordinate(spedizione.getLastLocation());
		}
		
		AddressToCoordinate coordDestinatario = new AddressToCoordinate(spedizione.getReceiverLocation());
		AddressToCoordinate coordMittente = new AddressToCoordinate(spedizione.getSenderLocation());

		if (spedizione.getLastLocation() == null || spedizione.getLastLocation().isEmpty()) {
			model.addAttribute("corrierelat", coordCorriere.getLatitude());
			model.addAttribute("corrierelong", coordCorriere.getLongitude());
		}
		
		model.addAttribute("destinatariolat", coordDestinatario.getLatitude());
		model.addAttribute("destinatariolong", coordDestinatario.getLongitude());
		
		model.addAttribute("mittentelat", coordMittente.getLatitude());
		model.addAttribute("mittentelong", coordMittente.getLongitude());	
	}

}


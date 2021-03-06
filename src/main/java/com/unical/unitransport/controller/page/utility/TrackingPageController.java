package com.unical.unitransport.controller.page.utility;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unical.unitransport.controller.persistence.shipment.Shipment;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsDAO;
import com.unical.unitransport.controller.persistence.shipment.state.HistoricalShipment;
import com.unical.unitransport.controller.persistence.shipment.state.HistoricalShipmentDAO;

@Controller
public class TrackingPageController {

	
	@PostMapping("/trackingService")
	public String check( Model model, HttpServletRequest req, HttpServletResponse res,
			@RequestParam(value = "tracking_box", required = true) String tracking) throws IOException {

		Shipment spedizione = ShipmentsDAO.getByTrackingNumber(tracking);

		if (spedizione == null) {
			return "tracking_gmapsFallito";
		}	 
		
		loadMarkers( spedizione, model );
		loadTable( spedizione, model );
		model.addAttribute("tracking_number", spedizione.getTrackingNumber());

		return "tracking_gmapsPositivo";
	}

	public void loadTable(Shipment spedizione, Model model ) {
	
		ArrayList<HistoricalShipment> array = new ArrayList<HistoricalShipment>(HistoricalShipmentDAO.getByTrackingNumber(spedizione.getTrackingNumber()));
		model.addAttribute("sizeofevents", array.size()-1);  
		
		model.addAttribute("statosped", array);
		model.addAttribute("luogosped", array);
		model.addAttribute("dataeora", array); 
		model.addAttribute("destFinale", spedizione.getReceiverLocation());
	}
	
	public void loadMarkers( Shipment spedizione, Model model ) {
		
		AddressToCoordinate coordCorriere = new AddressToCoordinate();
		if (spedizione.getStatus() <= 1) { 
			try {
			coordCorriere = new AddressToCoordinate(spedizione.getLastLocation());
	        double str1 = Double.parseDouble( coordCorriere.getLatitude());
	        double str2 = Double.parseDouble( coordCorriere.getLongitude());
			model.addAttribute("corrierelat", str1 - 0.1 );
			model.addAttribute("corrierelong", str2- 0.1 );
			} catch (Exception e){
				model.addAttribute("corrierelat", 0);
				model.addAttribute("corrierelong", 0 );
			}
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
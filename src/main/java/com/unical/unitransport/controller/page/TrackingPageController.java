package com.unical.unitransport.controller.page;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unical.unitransport.controller.persistence.shipment.Shipment;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsDAO;

@Controller
public class TrackingPageController {

	
	@PostMapping("/trackingService")
	public String check(HttpServletRequest req, HttpServletResponse res,
			@RequestParam(value = "tracking_box", required = true) String tracking) throws IOException {

		Shipment spedizione = ShipmentsDAO.getByTrackingNumber(tracking);

		System.out.println("NTracking: " + tracking);
		System.out.println(spedizione);

		// HttpSession session;
		if (spedizione == null) {
			return "tracking_gmapsFallito";
		}

	
		loadMarkers(spedizione,req);
		loadTable(spedizione,req);
		
		return "tracking_gmapsPositivo";
	}

	public void loadTable(Shipment spedizione,HttpServletRequest req) {
		// String dataOra = spedizione.getData();
		String stato = spedizione.stato();
		String luogo = spedizione.getLastLocation();
	
		req.setAttribute("statosped", stato);
		req.setAttribute("luogosped", luogo);
		
	}
	
	public void loadMarkers(Shipment spedizione,HttpServletRequest req) {
		AddressToCoordinate coordCorriere = new AddressToCoordinate(spedizione.getLastLocation());
		AddressToCoordinate coordDestinatario = new AddressToCoordinate(spedizione.getLastLocation());
		AddressToCoordinate coordMittente = new AddressToCoordinate(spedizione.getLastLocation());

		req.setAttribute("corrierelat", coordCorriere.getLatitude());
		req.setAttribute("corrierelong", coordCorriere.getLongitude());
		
		req.setAttribute("destinatariolat", coordDestinatario.getLatitude());
		req.setAttribute("destinatariolong", coordDestinatario.getLongitude());
		
		req.setAttribute("mittentelat", coordMittente.getLatitude());
		req.setAttribute("mittentelong", coordMittente.getLongitude());
		
		System.out.println(coordCorriere.getLatitude());
	}

}


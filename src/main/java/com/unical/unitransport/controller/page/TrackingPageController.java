package com.unical.unitransport.controller.page;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unical.unitransport.controller.persistence.shipment.Shipment;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsDAO;

@Controller
public class TrackingPageController {
	

	@PostMapping("/trackingService")
	public String check( HttpServletRequest req,
						 HttpServletResponse res, 
						 @RequestParam( value = "tracking_box", required = true ) String tracking ) throws IOException {

		Shipment spedizione = ShipmentsDAO.getByTrackingNumber( tracking );

		System.out.println("NTracking: " + tracking);
		System.out.println(spedizione);

		HttpSession session;
		if (spedizione == null) {
			return "tracking_gmapsFallito";
		}

		// check spedizione e draw coordinate
		String posCorriere = spedizione.getLastLocation();
		String posDestinatario = spedizione.getLastLocation();
		String posMittente = spedizione.getLastLocation();


		// draw on js


		return "tracking_gmapsPositivo";
	}


}

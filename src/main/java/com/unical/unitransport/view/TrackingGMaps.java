package com.unical.unitransport.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrackingGMaps {
	
	
	@GetMapping("tracking_gmaps")
	public String map() {
		return "tracking_gmaps";
	}

}

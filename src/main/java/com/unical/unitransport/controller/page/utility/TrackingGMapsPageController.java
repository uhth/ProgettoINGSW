package com.unical.unitransport.controller.page.utility;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrackingGMapsPageController {
	
	
	@GetMapping("/tracking_gmaps")
	public String map() {
		return "tracking_gmaps";
	}

}

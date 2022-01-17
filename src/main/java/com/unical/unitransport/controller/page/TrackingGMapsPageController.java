package com.unical.unitransport.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrackingGMapsPageController {
	
	
	@GetMapping("tracking_page")
	public String map() {
		return "tracking_gmaps";
	}

}

package com.unical.unitransport.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrackingPage {
	
	
	@GetMapping("tracking_page")
	public String tracking() {
		return "tracking_page";
	}


}

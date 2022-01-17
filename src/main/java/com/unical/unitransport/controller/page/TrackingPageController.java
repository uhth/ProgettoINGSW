package com.unical.unitransport.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrackingPageController {
	
	
	@GetMapping("tracking_page")
	public String tracking() {
		return "tracking_page";
	}


}

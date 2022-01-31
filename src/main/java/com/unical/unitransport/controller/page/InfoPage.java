package com.unical.unitransport.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoPage {
	
	@GetMapping("/faq")
	public String faq() {
		return "faq";
	}
	
	@GetMapping("/chi_siamo")
	public String chiSiamo() {
		return "chi_siamo";
	}
}

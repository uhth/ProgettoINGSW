package com.unical.unitransport.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Payment {

	@GetMapping("/payment")
	public String payment() {
		return "payment";
	}
}
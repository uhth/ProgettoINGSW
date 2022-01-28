package com.unical.unitransport.controller.page.utility;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Payment {

	@GetMapping("/payment")
	public String payment() {
		return "payment";
	}
	@GetMapping("/payment_error")
	public String errore() {
		return "payment_error";
	}
}
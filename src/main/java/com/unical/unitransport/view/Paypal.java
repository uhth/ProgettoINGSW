package com.unical.unitransport.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Paypal {
	
	@GetMapping("paypal")
	public String payment() {
		return "paypal";
	}
}

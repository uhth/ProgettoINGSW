package com.unical.unitransport.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePage {
	
	@GetMapping("/")
	@RequestMapping
	public String homePage() {
		System.out.println("s");
		return "index";
	}

}


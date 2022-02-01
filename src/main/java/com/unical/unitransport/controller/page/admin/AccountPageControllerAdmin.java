package com.unical.unitransport.controller.page.admin;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountPageControllerAdmin {
	

	@GetMapping("/profiloAmministratore")
	public String areaAmministratore(HttpServletRequest req) {
		
		return "profilo_amministratore";
	}
	

}

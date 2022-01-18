package com.unical.unitransport.controller.page;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unical.unitransport.controller.persistence.spedizioniUtente.SpedizioneUtenteDAO;

@Controller
public class AccountPageController {
	
	@GetMapping("profilo_utente")
	public String profilo(HttpServletRequest req) {		
//		List<String> spedizioni = SpedizioneUtenteDAO.getAllString((String)req.getSession().getAttribute("email"));
//		req.setAttribute("listaSpedizioni", spedizioni);
//
//		System.out.println(spedizioni);
		
		return "profilo_utente";
	}

}

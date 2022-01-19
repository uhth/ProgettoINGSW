package com.unical.unitransport.controller.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unical.unitransport.controller.persistence.account.AccountsManager;

@Controller
public class IndexPageController {
	
	@GetMapping("/")
	@RequestMapping
	public String homePage( Model model, HttpServletRequest req, HttpServletResponse res ) {
		if( AccountsManager.isLoggedIn( req ) )
			model.addAttribute( "email", req.getSession().getAttribute( "email" ) );
		return "index";
	}

}


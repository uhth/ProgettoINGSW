package com.unical.unitransport.controller.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	@RequestMapping
	public String homePage( Model model, HttpServletRequest req, HttpServletResponse res ) {
		if( req.isRequestedSessionIdValid() ) {
			String email = (String) req.getSession().getAttribute( "email" );
			model.addAttribute( "email", email );
		}
		return "index";
	}

}


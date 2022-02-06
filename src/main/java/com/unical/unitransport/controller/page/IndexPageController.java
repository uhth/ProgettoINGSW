package com.unical.unitransport.controller.page;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.gson.Gson;
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
	
	@GetMapping("/errore")
	public String erroreGenerico() {
		return "erroreGenerico";
	}
	
	@GetMapping("/valido")
	public String validoGenerico() {
		return "validoGenerico";
	}
	
	@GetMapping("/session")
	public void getEmail( HttpServletRequest req, HttpServletResponse res ) {
		
		HttpSession session = req.getSession(false);
		if( session == null ) {
			res.setStatus( HttpServletResponse.SC_BAD_REQUEST );
			return;
		}
		String email_ = (String) session.getAttribute( "email" );
		String role_ = (String) session.getAttribute( "role" );
		if( email_ == null ) email_ = "";
		if( role_ == null ) role_ = "";
		res.setStatus( HttpServletResponse.SC_ACCEPTED );
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		
		Gson gson = new Gson();
		String obj = gson.toJson( new SessAtt( email_, role_ ) );
		try {
			PrintWriter writer = res.getWriter();
			writer.print( obj );
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	class SessAtt {
		private String email;
		private String role;
		public SessAtt( String email, String role ) {
			this.email = email;
			this.role = role;
		}
		public String getEmail() {
			return email;
		}
		public String getRole() {
			return role;
		}
	}

}


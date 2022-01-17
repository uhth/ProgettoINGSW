package com.unical.unitransport.controller.page;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unical.unitransport.controller.persistence.account.AccountsDAO;
import com.unical.unitransport.controller.persistence.account.AccountsManager;

@Controller
public class LoginPageController {
	
	@GetMapping("/login")
	public String loginPage( HttpServletRequest req ) {
		if( req.isRequestedSessionIdValid() ) {
			if( req.getAttribute( "email " ) != null )
				return "index";
		}
		return "login";
	}
	
	@GetMapping("/iscrizione")
	public String iscrizionePage() {
		return "iscrizione";
	}
	
	@GetMapping("/logout")
	public void logout (HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		res.sendRedirect("/");
	}
	
	@PostMapping("/loginService")
	public String login(HttpServletRequest req,
			HttpServletResponse res,
			@RequestParam( value = "email", required = true ) String email,
			@RequestParam( value = "password", required = true ) String password ) throws IOException {
		
		HttpSession session;
		
		if( AccountsManager.login( email, password ) ) { 
			session = req.getSession(false);
			if( session != null ) session.invalidate();
		}
		
		else return "loginFallito";
		
		session = req.getSession( true );
		session.setAttribute( "email", email );
		
		return "index";
		
	}

}
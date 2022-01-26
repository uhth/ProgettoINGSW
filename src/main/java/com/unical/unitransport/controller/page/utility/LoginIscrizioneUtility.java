package com.unical.unitransport.controller.page.utility;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.unical.unitransport.controller.persistence.account.Account;
import com.unical.unitransport.controller.persistence.account.AccountsDAO;
import com.unical.unitransport.controller.persistence.account.AccountsManager;
import com.unical.unitransport.controller.persistence.account.Role;
import com.unical.unitransport.controller.persistence.account.RolesDAO;

@Controller
public class LoginIscrizioneUtility {
	
	
	@PostMapping("/loginServiceExpress")
	public String loginExpress(
			Model model,
			HttpServletRequest req,
			HttpServletResponse res,
			@RequestParam( value = "email", required = true ) String email,
			@RequestParam( value = "password", required = true ) String password ) {
		
		HttpSession session;
		
		
		if( AccountsManager.login( email, password ) ) { 
			session = req.getSession(false);
			if( session != null ) session.invalidate();
		}
		
		else return "loginFallito";
		
		session = req.getSession( true );
		session.setAttribute( "email", email );
		
		Account account = AccountsDAO.getByEmail( email );
		Role role = AccountsManager.getUserRole( account );
		if( role == null ) role = RolesDAO.getByName( "user" );
		session.setAttribute( "role" , role.getRoleName() );
		
		return "effettua_spedizione_express";
		
	}
	
	@PostMapping("/iscrizioneServiceExpress")
	public String registerUserExpress( HttpServletResponse res,
			HttpServletRequest req,
			@RequestParam( value = "email", required = true ) String email,
			@RequestParam( value = "password", required = true ) String password,
			@RequestParam( value = "password_ripetuta", required = true ) String password_ripetuta ) throws IOException {
		
		HttpSession session = req.getSession(true);
		
		int diff = password.compareTo( password_ripetuta );
		if( diff != 0 ) {
			res.sendError( HttpServletResponse.SC_BAD_REQUEST );
		}
		
		Account account = AccountsManager.registerAccount( email, password, "user" );
		if( account == null ) {
			session.setAttribute("erroreGenerico", "ACCOUNT ESISTENTE");
			session.setAttribute("erroreGenerico_p", "Non puoi creare due account con la stessa email");
			return "erroreGenerico";
		

		}
				
		AccountsManager.login( account.getEmail(), account.getPassword() );
		
		session.setAttribute( "email", account.getEmail() );		
		
		
		return "effettua_spedizione_express";
	}	
	@PostMapping("/loginServiceTracciabile")
	public String loginTracciabile(
			Model model,
			HttpServletRequest req,
			HttpServletResponse res,
			@RequestParam( value = "email", required = true ) String email,
			@RequestParam( value = "password", required = true ) String password ) {
		
		HttpSession session;
		
		
		if( AccountsManager.login( email, password ) ) { 
			session = req.getSession(false);
			if( session != null ) session.invalidate();
		}
		
		else return "loginFallito";
		
		session = req.getSession( true );
		session.setAttribute( "email", email );
		
		Account account = AccountsDAO.getByEmail( email );
		Role role = AccountsManager.getUserRole( account );
		if( role == null ) role = RolesDAO.getByName( "user" );
		session.setAttribute( "role" , role.getRoleName() );
		
		return "effettua_spedizione_tracciabile";
		
	}
	
	@PostMapping("/iscrizioneServiceTracciabile")
	public String registerUserTracciabile( HttpServletResponse res,
			HttpServletRequest req,
			@RequestParam( value = "email", required = true ) String email,
			@RequestParam( value = "password", required = true ) String password,
			@RequestParam( value = "password_ripetuta", required = true ) String password_ripetuta ) throws IOException {
		
		HttpSession session = req.getSession(true);
		
		int diff = password.compareTo( password_ripetuta );
		if( diff != 0 ) {
			res.sendError( HttpServletResponse.SC_BAD_REQUEST );
		}
		
		Account account = AccountsManager.registerAccount( email, password, "user" );
		if( account == null ) {
			session.setAttribute("erroreGenerico", "ACCOUNT ESISTENTE");
			session.setAttribute("erroreGenerico_p", "Non puoi creare due account con la stessa email");
			return "erroreGenerico";
		

		}
				
		AccountsManager.login( account.getEmail(), account.getPassword() );
		
		session.setAttribute( "email", account.getEmail() );		
		
		
		return "effettua_spedizione_tracciabile";
	}	
	@PostMapping("/loginServiceAssicurata")
	public String loginAssicurata(
			Model model,
			HttpServletRequest req,
			HttpServletResponse res,
			@RequestParam( value = "email", required = true ) String email,
			@RequestParam( value = "password", required = true ) String password ) {
		
		HttpSession session;
		
		
		if( AccountsManager.login( email, password ) ) { 
			session = req.getSession(false);
			if( session != null ) session.invalidate();
		}
		
		else return "loginFallito";
		
		session = req.getSession( true );
		session.setAttribute( "email", email );
		
		Account account = AccountsDAO.getByEmail( email );
		Role role = AccountsManager.getUserRole( account );
		if( role == null ) role = RolesDAO.getByName( "user" );
		session.setAttribute( "role" , role.getRoleName() );
		
		return "effettua_spedizione_assicurata";
		
	}
	
	@PostMapping("/iscrizioneServiceAssicurata")
	public String registerUserAssicurata( HttpServletResponse res,
			HttpServletRequest req,
			@RequestParam( value = "email", required = true ) String email,
			@RequestParam( value = "password", required = true ) String password,
			@RequestParam( value = "password_ripetuta", required = true ) String password_ripetuta ) throws IOException {
		
		HttpSession session = req.getSession(true);
		
		int diff = password.compareTo( password_ripetuta );
		if( diff != 0 ) {
			res.sendError( HttpServletResponse.SC_BAD_REQUEST );
		}
		
		Account account = AccountsManager.registerAccount( email, password, "user" );
		if( account == null ) {
			session.setAttribute("erroreGenerico", "ACCOUNT ESISTENTE");
			session.setAttribute("erroreGenerico_p", "Non puoi creare due account con la stessa email");
			return "erroreGenerico";
		

		}
				
		AccountsManager.login( account.getEmail(), account.getPassword() );
		
		session.setAttribute( "email", account.getEmail() );		
		
		
		return "effettua_spedizione_assicurata";
	}

}

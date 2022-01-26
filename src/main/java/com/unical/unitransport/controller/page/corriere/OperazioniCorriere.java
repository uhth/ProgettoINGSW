package com.unical.unitransport.controller.page.corriere;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.unical.unitransport.controller.persistence.account.Account;
import com.unical.unitransport.controller.persistence.account.AccountRole;
import com.unical.unitransport.controller.persistence.account.AccountRoleDAO;
import com.unical.unitransport.controller.persistence.account.AccountsDAO;
import com.unical.unitransport.controller.persistence.account.AccountsManager;
import com.unical.unitransport.controller.persistence.account.Role;
import com.unical.unitransport.controller.persistence.shipment.Shipment;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsDAO;
import com.unical.unitransport.controller.persistence.spedizioniCorriere.SpedizioneCorriereDAO;

@Controller
public class OperazioniCorriere {
	
	private String last_code;
	
	@GetMapping("/aggiornaStato")
	public String aggiornaStato( HttpServletRequest req ) {
		
		HttpSession session = req.getSession(true);
		if( !AccountsManager.isLoggedIn( req ) ) return "login";
		
	
		Account account =  AccountsDAO.getByEmail( (String) req.getSession().getAttribute( "email" ) );
		Role role = AccountsManager.getUserRole( account );
		if( role == null || !isCorriere(account) )
			return "index";
		
		session.setAttribute("codiceRichiestoCorriere", null);
		session.setAttribute("luogoAttuale", null);
		return "gestioneSpedizioneCorriere";
	}
	
	@PostMapping("/corriereServiceCode")
	public String searchID( HttpServletRequest req, HttpServletResponse res, String codice) throws IOException {
		

		HttpSession session = req.getSession(true);
		session.setAttribute("luogoAttuale", null);

		Shipment spedizione = ShipmentsDAO.getByTrackingNumber(codice);
		
		if (spedizione!=null) {
			session.setAttribute("last_code", codice);
			last_code=codice;
			session.setAttribute("luogoAttuale", spedizione.localita());
			return "gestioneSpedizioneCorriere";
		}
		
		session.setAttribute("erroreGenerico", "LA SPEDIZIONE NON ESISTE");
		return "erroreGenerico";
		
	}
	
	
	@PostMapping("/corriereService")
	public String changeByID(HttpServletRequest req, HttpServletResponse res, String luogo) throws IOException {

		HttpSession session = req.getSession(true);

		Shipment spedizione = ShipmentsDAO.getByTrackingNumber(last_code);
		
		String scelta = req.getParameter("scelta");
		
		if (scelta==null) {
			session.setAttribute("erroreGenerico", "NON HAI SELEZIONATO ALCUN AGGIORNAMENTO");
			session.setAttribute("erroreGenerico_p", "Assicurati di selezionare uno stato di aggiornamento");
			return "erroreGenerico";
		}
		
		int scelta_cod = Integer.parseInt(scelta);
		

		
		if (spedizione!=null && SpedizioneCorriereDAO.spedizioneAppartenenteCorriere(last_code, (String) session.getAttribute("email"))) {
			ShipmentsDAO.update(spedizione, scelta_cod, luogo);
			session.setAttribute("validoGenerico", "LA SPEDIZIONE È STATA CORRETTAMENTE AGGIORNATA");
			session.setAttribute("validoGenerico_p", null);
			return "validoGenerico";
		}
		
		
		session.setAttribute("erroreGenerico", "LA SPEDIZIONE NON È AFFIDATA A TE");
		session.setAttribute("erroreGenerico_p", "Verifica se non è stata ancora presa in carico da altri operatori e prendi in carico la spedizione");
		return "erroreGenerico";
		
	}
	
	


	
	private boolean isCorriere(Account account) {
		AccountRole role = AccountRoleDAO.getFor(account);
		if (role.getRoleId()==2)
			return true;
		return false;
		
	}



}

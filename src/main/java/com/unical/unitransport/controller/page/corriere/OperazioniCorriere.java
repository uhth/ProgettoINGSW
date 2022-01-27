package com.unical.unitransport.controller.page.corriere;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.unical.unitransport.controller.page.utility.AddressToCoordinate;
import com.unical.unitransport.controller.persistence.account.Account;
import com.unical.unitransport.controller.persistence.account.AccountRole;
import com.unical.unitransport.controller.persistence.account.AccountRoleDAO;
import com.unical.unitransport.controller.persistence.account.AccountsDAO;
import com.unical.unitransport.controller.persistence.account.AccountsManager;
import com.unical.unitransport.controller.persistence.account.Role;
import com.unical.unitransport.controller.persistence.shipment.Shipment;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsDAO;
import com.unical.unitransport.controller.persistence.shipment.state.Stato;
import com.unical.unitransport.controller.persistence.spedizioniCorriere.SpedizioneCorriereDAO;

@Controller
public class OperazioniCorriere {
	
	private String last_code;	
	
	@GetMapping("/aggiornaStato")
	public String aggiornaStato( HttpServletRequest req ) {
		
		HttpSession session = req.getSession(true);
		session.setAttribute("statoPacco", null);
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
	public String searchID(Model model, HttpServletRequest req, HttpServletResponse res, String codice) throws IOException {
		

		HttpSession session = req.getSession(true);
		session.setAttribute("luogoAttuale", null);

		Shipment spedizione = ShipmentsDAO.getByTrackingNumber(codice);

		if (spedizione!=null) {
			session.setAttribute("codiceRichiestoCorriere", codice);
			last_code=codice;
			session.setAttribute("luogoAttuale", spedizione.localita());
			session.setAttribute("statoPacco", spedizione.getStatus());
			
			try {
				loadMarkers(spedizione, model);
			} catch (Exception e) {
				System.out.println("Errore impossibile caricare la mappa (gestione corriere)");
			}
			
			return "gestioneSpedizioneCorriere";
		}
		session.setAttribute("erroreGenerico", "LA SPEDIZIONE NON ESISTE");
		return "erroreGenerico";
		
	}
	
	
	@PostMapping("/corriereService")
	public String changeByID(Model model, HttpServletRequest req, HttpServletResponse res, String luogo) throws IOException {

		HttpSession session = req.getSession(true);

		Shipment spedizione = ShipmentsDAO.getByTrackingNumber(last_code);

		String luogoAggiornato = req.getParameter("luogoAggiornato");
		String scelta = req.getParameter("scelta");
		if (luogoAggiornato==null) {
			session.setAttribute("erroreGenerico", "NON HAI INSERITO L'INDIRIZZO AGGIORNATO");
			session.setAttribute("erroreGenerico_p", "Assicurati di inserire un indirizzo nel campo [Località Aggiornata]");
			return "erroreGenerico";
		}
		
		if (scelta==null) {
			session.setAttribute("erroreGenerico", "NON HAI SELEZIONATO ALCUN AGGIORNAMENTO");
			session.setAttribute("erroreGenerico_p", "Assicurati di selezionare uno stato di aggiornamento");
			return "erroreGenerico";
		}
		
		int scelta_cod = Integer.parseInt(scelta);
		

		
		if (spedizione!=null && SpedizioneCorriereDAO.spedizioneAppartenenteCorriere(last_code, (String) session.getAttribute("email"))) {

			ShipmentsDAO.update(spedizione, scelta_cod, luogoAggiornato);
			spedizione.setStatus(scelta_cod);		
			Date date = new Date();
			spedizione.setLastUpdate(new Timestamp(date.getTime()));
			spedizione.setLastLocation(luogoAggiornato);
			spedizione.setStatusManager(new Stato(scelta_cod));
			session.setAttribute("statoPacco", null);
			session.setAttribute("codiceRichiestoCorriere", null);

			try {
				loadMarkers(spedizione, model);
			} catch (Exception e) {
				System.out.println("Errore impossibile caricare la mappa (gestione corriere)");
			}
			return "gestioneSpedizioneCorriere";

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


public void loadMarkers( Shipment spedizione, Model model ) {
		
		AddressToCoordinate coordCorriere = new AddressToCoordinate();
		if (spedizione.getRegisterLocation() != null) { 
			coordCorriere = new AddressToCoordinate(spedizione.getLastLocation());
			model.addAttribute("corrierelat", coordCorriere.getLatitude());
			model.addAttribute("corrierelong", coordCorriere.getLongitude());
		}
		
		AddressToCoordinate coordDestinatario = new AddressToCoordinate(spedizione.getReceiverLocation());
		AddressToCoordinate coordMittente = new AddressToCoordinate(spedizione.getSenderLocation());
		
		model.addAttribute("destinatariolat", coordDestinatario.getLatitude());
		model.addAttribute("destinatariolong", coordDestinatario.getLongitude());		
		model.addAttribute("mittentelat", coordMittente.getLatitude());
		model.addAttribute("mittentelong", coordMittente.getLongitude());	
	}
}

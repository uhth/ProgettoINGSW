package com.unical.unitransport.controller.page.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.unical.unitransport.controller.persistence.shipment.ShipmentsDAO;
import com.unical.unitransport.controller.persistence.spedizioniCorriere.SpedizioneCorriere;
import com.unical.unitransport.controller.persistence.spedizioniCorriere.SpedizioneCorriereDAO;


@Controller
public class AggiungiRimuoviCorriere {
	
	@GetMapping("/aggiungiCorriere")
	public String aggiungiCorriere(HttpServletRequest req) {
		
		HttpSession session = req.getSession(true);
		session.setAttribute("listaUtentiConvertibili", null);
		
		List<Account> lista = AccountsDAO.getAll();
		List<String> listaUtenti = new ArrayList<String>();
		
		for (Account account: lista) {
			AccountRole ruolo = AccountRoleDAO.getFor(account);
			if (ruolo.getRoleId()==3)
				listaUtenti.add(account.getEmail());
		}
		
		session.setAttribute("listaUtentiConvertibili", listaUtenti);

		return "aggiungi_corriere";
	}
	
	
	@PostMapping("aggiuntaCorriere")
	public void aggiornaCorrieri (HttpServletRequest req, HttpServletResponse res, String richiestaAggiuntaCorriere) throws IOException {
		HttpSession session = req.getSession(true);
		
		AccountsManager.changeAccountRole(richiestaAggiuntaCorriere, "corriere");
		res.sendRedirect("aggiungiCorriere");
		
	
	}
	
	
	@GetMapping("/rimuoviCorriere")
	public String rimuoviCorriere(HttpServletRequest req) {
		
		HttpSession session = req.getSession(true);
		session.setAttribute("listaUtentiConvertibili", null);
		
		List<Account> lista = AccountsDAO.getAll();
		List<String> listaUtenti = new ArrayList<String>();
		
		for (Account account: lista) {
			AccountRole ruolo = AccountRoleDAO.getFor(account);
			if (ruolo.getRoleId()==2)
				listaUtenti.add(account.getEmail());
		}
		
		session.setAttribute("listaUtentiConvertibili", listaUtenti);


		return "rimuovi_corriere";
	}
	
	
	@PostMapping("rimozioneCorriere")
	public void rimuoviCorrieri (HttpServletRequest req, HttpServletResponse res, String richiestaRimozioneCorriere) throws IOException {
		HttpSession session = req.getSession(true);
		
		AccountsManager.changeAccountRole(richiestaRimozioneCorriere, "user");
		res.sendRedirect("rimuoviCorriere");
		
	
	}
	

}


//<div class="richiesta">
//<form  method="post" action="rimozioneCorriere">
//		  <div class="form-group">
//		    <label for="formCorriere"></label>
//		    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="es. mario_rossi@gmail.com" name="richiestaRimozioneCorriere">
//	 	 </div>
//	  <br>								  										  
//    <input  class="btn btn-success" type="submit" value="CONFERMA"/>
//</form>
//</div>	


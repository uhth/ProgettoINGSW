package com.unical.unitransport.controller.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Iscrizione {
	

	
	@PostMapping("/iscrizioneService")
	public String login(HttpServletRequest req, HttpServletResponse res, String username_new, String password_new) throws IOException{
		
		
		//if (tuttoVaBene)
		HttpSession session = req.getSession(true);


		String sql = "INSERT INTO users VALUES ("
				+ "'" + username_new + "' , '" + password_new + "')";
		
		try {
			Connection db = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
			Statement st = db.createStatement();
			st.executeUpdate(sql);
			
			return "iscrizionePositiva";
				
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	 


}

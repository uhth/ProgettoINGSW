package com.unical.unitransport.controller.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	
	@GetMapping("/logout")
	public void logout (HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		res.sendRedirect("/");
	}
	
	@PostMapping("/loginService")
	public String login(HttpServletRequest req, HttpServletResponse res, String username, String pass) throws IOException{
		

		
		String sql = "select * from users where username = '" + username + "'";
		HttpSession session = req.getSession(true);
		
		try {
			Connection db = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if (rs.next()) {
				session.setAttribute("username",  rs.getString("username"));
				res.sendRedirect("/");
				return "index";
			} else {
				return "loginFallito";
			}
			
				
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

}

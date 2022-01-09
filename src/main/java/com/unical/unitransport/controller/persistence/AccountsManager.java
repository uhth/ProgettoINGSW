package com.unical.unitransport.controller.persistence;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public interface AccountsManager {
	
	public static boolean registerAccount( String email, String password, String role_name ) {
		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		String encodedPw = pwEncoder.encode(password);
		Role role = RolesDAO.getByName( role_name );
		if( role == null ) return false;
		Account account = new Account( email, encodedPw );
		if( AccountsDAO.insert( account ) ) {
			AccountRole accountRole = new AccountRole( AccountsDAO.getByEmail( email ).getUserId(), role.getRoleId() );
			if ( AccountRoleDAO.insert( accountRole ) )
				return true;
			else
				AccountsDAO.remove( account );
		}
		return false;
	}
	
	public static void unregisterAccount( String email ) {
		Account account = AccountsDAO.getByEmail( email );
		AccountRoleDAO.removeAllFor( account );
		AccountsDAO.remove( account );
	}
	
	public static boolean registerRole( String role_name ) {
		return RolesDAO.insert( new Role( role_name ) );
	}
	
	public static boolean unregisterRole( String role_name ) {
		return AccountRoleDAO.removeAllFor( RolesDAO.getByName( role_name ) );
	}
	
	public static boolean login( String email, String password ) {
		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		Account account = AccountsDAO.getByEmail( email );
		if( account == null ) return false;
		return pwEncoder.matches( password, account.getPassword() );
	}
	
	public static boolean changeAccountRole( String email, String role_name ) {
		Account account = AccountsDAO.getByEmail( email );
		Role role = RolesDAO.getByName( role_name );
		if( account == null || role == null ) return false;
		return AccountRoleDAO.insert( new AccountRole( account.getUserId(), role.getRoleId() ) );
	}
	
	public static boolean changeAccountEmail( String email ) {
		Account account = AccountsDAO.getByEmail( email );
		if( account == null ) return false;
		return AccountsDAO.updateEmail( account, email );
	}
	
	public static boolean changeAccountPassword( String email, String password ) {
			Account account = AccountsDAO.getByEmail( email );
			if( account == null ) return false;
			BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
			String encodedPw = pwEncoder.encode(password);
			return AccountsDAO.updatePassword( account , encodedPw );
		}

}

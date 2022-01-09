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
	
	public static void unregisterRole( String role_name ) {

	}

}

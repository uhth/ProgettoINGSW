package com.unical.unitransport;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.unical.unitransport.controller.persistence.account.Account;
import com.unical.unitransport.controller.persistence.account.AccountRoleDAO;
import com.unical.unitransport.controller.persistence.account.AccountsDAO;
import com.unical.unitransport.controller.persistence.account.AccountsManager;
import com.unical.unitransport.controller.persistence.account.Role;
import com.unical.unitransport.controller.persistence.account.RolesDAO;

@SpringBootTest
public class AccountsTests {
	
	@BeforeAll
	public static void resetRoles() {
		AccountsDAO.removeAll(); //AccountsRole should be updated to due to its constraints
		RolesDAO.removeAll(); //AccountsRole should be updated to due to its constraints
		RolesDAO.insert( new Role( "test1" ) );
		//test account
		AccountsManager.registerAccount( "ciao", "ciao00" );
	}
	
	@Test
	@DisplayName( "Roles test" )
	void roleTest() {
		//add new role
		assertEquals( true, RolesDAO.insert( new Role( "user" ) ) );
		//get role by name
		assertEquals( "user", RolesDAO.getByName( "user").getRoleName() );
		//add existing role
		assertEquals( false, RolesDAO.insert( new Role( "user" ) ) );
		//delete role
		assertEquals( true, RolesDAO.remove( new Role( "user" ) ) );
	}
	
	
	@Test
	@DisplayName( "Accounts test" )
	void accountTest() {
		//add new account
		assertEquals( true, AccountsDAO.insert( new Account( "mock@email.com", "rawPassword" ) ) );
		//get account by email
		assertEquals( Account.class, AccountsDAO.getByEmail( "mock@email.com" ).getClass() );
		//update account
		String newEmail = "newMockEmail";
		String nRawPassword = "newRawPassword";
		assertEquals( true, AccountsDAO.updateEmail( AccountsDAO.getByEmail("mock@email.com"), "newMockEmail" ) );
		assertEquals( true, AccountsDAO.updatePassword( AccountsDAO.getByEmail(newEmail), "newRawPassword" ) );
		assertEquals( newEmail, AccountsDAO.getByEmail(newEmail).getEmail() );
		assertEquals( nRawPassword, AccountsDAO.getByEmail(newEmail).getPassword() );
		//insert existing account
		assertEquals( false, AccountsDAO.insert( new Account( "newMockEmail", "rawPassword" ) ) );
		
	}
	
	@Test
	@DisplayName( "AccountsManager Test" )
	void accountManagerTest() {
		//add new account
		assertEquals( Account.class, AccountsManager.registerAccount( "mail@mail.com", "rawPass", "test1" ).getClass() );
		assertEquals( Account.class, AccountsManager.registerAccount( "mail2@mail.com", "rawPass", "test1" ).getClass() );
		//insert existing account
		assertEquals( null, AccountsManager.registerAccount( "mail@mail.com", "xasd", "test1" ) );
		//add new account with wrong role
		assertEquals( null, AccountsManager.registerAccount( "nmail@mail.com", "xasd", "nop" ) );
		//good login
		assertEquals( true, AccountsManager.login( "mail@mail.com", "rawPass") );
		//bad login
		assertEquals( false, AccountsManager.login( "mail@mail.com", "badRawPass") );
		//remove account
		assertEquals( true, AccountsManager.unregisterAccount( "mail@mail.com" ) );
		assertEquals( null, AccountsDAO.getByEmail( "mail@mail.com" ) );
		assertEquals( null, AccountRoleDAO.getFor( new Account( "mail@mail.com", "" ) ) );
		
	}
	
}

package com.unical.unitransport;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.unical.unitransport.controller.persistence.account.Account;
import com.unical.unitransport.controller.persistence.account.AccountsDAO;
import com.unical.unitransport.controller.persistence.account.Role;
import com.unical.unitransport.controller.persistence.account.RolesDAO;

@SpringBootTest
class UniTransportApplicationTests {
		
	@BeforeAll
	public static void resetRoles() {
		RolesDAO.removeAll();
		AccountsDAO.removeAll();
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

}

package com.cts.cbc.dao;

import org.junit.Test;
import junit.framework.TestCase;
import com.cts.cbc.exceptions.DBException;

import java.sql.SQLException;


/**
 * This class contains one testXXXX method per XXXXX method in source class.
 *
 * @author
 */
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class LoginUserDAOTest extends TestCase {
	

	
	/**
	 * Test get user data.
	 *
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@Test //public List<UserVo> getUserData()
	public void testGetUserData() throws DBException, SQLException, ClassNotFoundException{
		final LoginUserDAO lud = new LoginUserDAO();
		assertNotNull("success",lud.getUserData());
		
	}
	
	
	

}
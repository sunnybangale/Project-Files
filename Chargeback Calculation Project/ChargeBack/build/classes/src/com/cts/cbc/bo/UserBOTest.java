package com.cts.cbc.bo;

import java.sql.SQLException;

import org.junit.Test;
import junit.framework.TestCase;
import com.cts.cbc.vo.UserVo;
import com.cts.cbc.exceptions.BusinessException;
import com.cts.cbc.exceptions.DBException;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class UserBOTest extends TestCase {
	

	/**
	 * Test validate user.
	 *
	 * @throws BusinessException the business exception
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@Test //public boolean validateUser(UserVo)
	public void testValidateUser() throws BusinessException, DBException, SQLException, ClassNotFoundException{
		boolean flag;
		final UserVo uvObject =new UserVo();
		uvObject.setUserId("Sunny");
		uvObject.setPassword("qwerty");
		uvObject.setRoleType("INDL");
		
		flag=new UserBO().validateUser(uvObject);
		assertTrue("true",flag);
		
		
		
	}
	
	/**
	 * Test validate user1.
	 *
	 * @throws BusinessException the business exception
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@Test //public boolean validateUser(UserVo)
	public void testValidateUser1() throws BusinessException, DBException, SQLException, ClassNotFoundException{
		boolean flag;
		final UserVo uvObject =new UserVo();
		uvObject.setUserId("");
		uvObject.setPassword("");
		uvObject.setRoleType("");
		
		flag=new UserBO().validateUser(uvObject);
		//System.out.println("apna hi hai"+flag);
		assertFalse("false",flag);
		//assertEquals("false",flag);
		
		
		
	}
	

	@Test //public boolean validateUser(UserVo)
	public void testValidateUser3() throws BusinessException, DBException, SQLException, ClassNotFoundException{
		boolean flag;
		final UserVo uvObject =new UserVo();
		uvObject.setUserId("abc");
		uvObject.setPassword("abc");
		uvObject.setRoleType("abc");
		
		flag=new UserBO().validateUser(uvObject);
		assertFalse("false",flag);
		
		
		
	}
	
	

	/**
	 * Test validate user for registration.
	 *
	 * @throws BusinessException the business exception
	 * @throws DBException the dB exception
	 */
	@Test //public boolean validateUserForRegistration(UserVo)
	public void testValidateUserForRegistration() throws BusinessException, DBException{
		boolean flag;
		//UserVo uv =new UserVo("Ashwini", "Menon","ashwini1234","INDL","Female",22,9766639464L,"ash@gmail.com","baner","pune",411007);
		final  UserVo uuObject= new UserVo("Ashwini", "Menon","ashwini1234","INDL","Female",22,9766639464L,"ash@gmail.com","baner","pune",411007,22,"India");
		flag=new UserBO().validateUserForRegistration(uuObject);
		assertTrue("True",flag);
		
	}
	

	
	

	
}

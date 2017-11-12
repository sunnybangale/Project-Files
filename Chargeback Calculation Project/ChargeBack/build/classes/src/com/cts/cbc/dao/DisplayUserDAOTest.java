package com.cts.cbc.dao;

import org.junit.Test;
import junit.framework.TestCase;
import com.cts.cbc.vo.UserVo;
import com.cts.cbc.exceptions.DBException;

import java.sql.SQLException;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class DisplayUserDAOTest extends TestCase {
	

	/**
	 * Test get transactionsdetail for individual user.
	 *
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@Test //public List<TransactiondetailsForIndividualVo> getTransactionsdetailForIndividualUser(UserVo)
	public void testGetTransactionsdetailForIndividualUser() throws DBException, SQLException, ClassNotFoundException{
		final DisplayUserDAO duObject=new DisplayUserDAO();
		final UserVo uvObject=new UserVo();
		
		uvObject.setUserId("Sunny");
		
		assertNotNull("success",duObject.getTransactionsdetailForIndividualUser(uvObject));
		
		
	}
	

	/**
	 * Test get transactionsdetail for fund user.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public List<TransactiondetailsForFundVo> getTransactionsdetailForFundUser(UserVo)
	public void testGetTransactionsdetailForFundUser() throws DBException, ClassNotFoundException, SQLException{
		final DisplayUserDAO duObject=new DisplayUserDAO();
		final UserVo uvObject=new UserVo();
		
		uvObject.setUserId("Vinita");
		
		assertNotNull("success",duObject.getTransactionsdetailForFundUser(uvObject));
	}
	

	
}

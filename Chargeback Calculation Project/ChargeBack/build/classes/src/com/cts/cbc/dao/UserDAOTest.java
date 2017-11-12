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


public class UserDAOTest extends TestCase {
	

	/**
	 * Test get stock id.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public String getStockId(String)
	public void testGetStockId() throws DBException, ClassNotFoundException, SQLException{
		final UserDAO udObject=new UserDAO();
		assertEquals("success","STOCK002",udObject.getStockId("Blackstone"));
	}
	

	/**
	 * Test get balance.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public double getBalance(String)
	public void testGetBalance() throws DBException, ClassNotFoundException, SQLException{
		final UserDAO udObject=new UserDAO();
		assertEquals(30000,udObject.getBalance("Abhishek"),0.001);
	}
	

	/**
	 * Test get sell stock quantity.
	 *
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@Test //public int getSellStockQuantity(String,String)
	public void testGetSellStockQuantity() throws DBException, SQLException, ClassNotFoundException{
		final UserDAO udObject=new UserDAO();
		assertEquals("success",10,udObject.getSellStockQuantity("Sanket","Blackstone"));
	
	}
	

	/**
	 * Test get sell stock data.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public List getSellStockData(String)
	public void testGetSellStockData() throws DBException, ClassNotFoundException, SQLException{
		final UserDAO udObject=new UserDAO();
		assertNotNull("success",udObject.getSellStockData("Sunny"));
	}
	

	/**
	 * Test get range percent.
	 *
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@Test //public double getRangePercent(double)
	public void testGetRangePercent() throws DBException, SQLException, ClassNotFoundException{
		final UserDAO udObject=new UserDAO();
		assertEquals(0.18,udObject.getRangePercent(600),0.001);
	}
	

	/**
	 * Test get buy stock quantity.
	 *
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@Test //public int getBuyStockQuantity(String,String)
	public void testGetBuyStockQuantity() throws DBException, SQLException, ClassNotFoundException{
		final UserDAO udObject=new UserDAO();
		assertEquals("success",10,udObject.getBuyStockQuantity("Sanket","Fox Chase Bancorp"));
	}
	

	
	

	/**
	 * Test get profit range percent.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public double getProfitRangePercent(double)
	public void testGetProfitRangePercent() throws DBException, ClassNotFoundException, SQLException{
		final UserDAO udObject=new UserDAO();
		assertEquals(0.1,udObject.getProfitRangePercent(2),0.001);
	}
	

	/**
	 * Test get buy stock data.
	 *
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@Test //public List getBuyStockData(String)
	public void testGetBuyStockData() throws DBException, SQLException, ClassNotFoundException{
		final UserDAO udObject=new UserDAO();
		assertNotNull("success",udObject.getBuyStockData("Sunny"));
	}
	

	/**
	 * Test get sell stock count.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public int getSellStockCount(String)
	public void testGetSellStockCount() throws DBException, ClassNotFoundException, SQLException{
		final UserDAO udObject=new UserDAO();
		assertEquals(0.1,udObject.getProfitRangePercent(2),0.001);
	}
	


	

	/**
	 * Test get sell price.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public double getSellPrice(String)
	public void testGetSellPrice() throws DBException, ClassNotFoundException, SQLException{
		final UserDAO udObject=new UserDAO();
		assertEquals(60,udObject.getSellPrice("STOCK002"),0.001);
	}
	

	

	/**
	 * Test get of stock.
	 *
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@Test //public List<StockDetailsVo> getOfStock()
	public void testGetOfStock() throws DBException, SQLException, ClassNotFoundException{
		final UserDAO udObject=new UserDAO();
		assertNotNull("success",udObject.getBuyStockDetails());
	}
	

	/**
	 * Test get buy price.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public double getBuyPrice(String)
	public void testGetBuyPrice() throws DBException, ClassNotFoundException, SQLException{
		final UserDAO udObject=new UserDAO();
		assertEquals(30,udObject.getBuyPrice("STOCK002"),0.001);
	}
	
	/**
	 * Test get user data.
	 *
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@Test //public List<UserVo> getUserData()
	public void testGetUserData() throws DBException, SQLException, ClassNotFoundException{
		final UserDAO udObject=new UserDAO();
		assertNotNull("success",udObject.getUserData());
	}
	
}

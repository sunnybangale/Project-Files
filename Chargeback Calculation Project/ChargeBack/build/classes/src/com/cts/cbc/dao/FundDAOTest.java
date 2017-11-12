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


public class FundDAOTest extends TestCase {
	
	@Test //public String getStockId(String)
	public void testGetStockId() throws DBException, ClassNotFoundException, SQLException{
		final FundDAO fdObject = new FundDAO();
		
		assertEquals("success","STOCK002",fdObject.getStockId("Blackstone"));
		
		
		
	}
	
	/**
	 * Test get balance user.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public double getBalanceUser(String)
	public void testGetBalanceUser() throws DBException, ClassNotFoundException, SQLException{
		final FundDAO udObject=new FundDAO();
		assertEquals(20000.0,udObject.getBalanceUser("Sunny"),0.001);
	}
	
	/**
	 * Test get new user data.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public List<UserVo> getNewUserData()
	public void testGetNewUserData()throws DBException, ClassNotFoundException, SQLException{
		final FundDAO e0Obj = new FundDAO();
		
		assertNotNull("success",e0Obj.getNewUserData() );
		
	}
	

	/**
	 * Test get buy stock data.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public List<StockDetailsVo> getBuyStockData()
	public void testGetBuyStockData() throws DBException, ClassNotFoundException, SQLException{
		final FundDAO e0Obj = new FundDAO();
		
		assertNotNull("success",e0Obj.getBuyStockData());
		
		
			}
	

	/**
	 * Test get buy stock data1.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public List getBuyStockData(String)
	public void testGetBuyStockData1() throws DBException, ClassNotFoundException, SQLException{
		final FundDAO e0Obj = new FundDAO();
		assertNotNull("success",e0Obj.getBuyStockData("FUND001"));
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
		final FundDAO e0Obj = new FundDAO();
		
			//final List e0List = e0Obj.getSellStockData("FUND001");
			//TODO Based on your need, provide necessary assertion condition
		assertNotNull("success",e0Obj.getSellStockData("FUND001"));
		
	}
	

	/**
	 * Test get fund stock names.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public List getFundStockNames(String,String)
	public void testGetFundStockNames() throws DBException, ClassNotFoundException, SQLException{
		final FundDAO e0Obj = new FundDAO();
		//List e0 = e0Obj.getFundStockNames("FUND001","STOCK002");
		//TODO Based on your need, provide necessary assertion condition
		assertNotNull("success",e0Obj.getFundStockNames("FUND001","STOCK002"));
	}
	

	
	

	/**
	 * Test get range percent.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public double getRangePercent(double)
	public void testGetRangePercent() throws DBException, ClassNotFoundException, SQLException{
		final FundDAO e0Obj = new FundDAO();
		
			
		assertEquals("success",1.5, e0Obj.getRangePercent(60000));
			}

	/**
	 * Test get no of days stock held.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public int getNoOfDaysStockHeld(String)
	public void testGetNoOfDaysStockHeld() throws DBException, ClassNotFoundException, SQLException{
		final FundDAO e0Obj = new FundDAO();
		
		assertEquals("success",20, e0Obj.getNoOfDaysStockHeld("Vinita"));
		
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
		final FundDAO e0Obj = new FundDAO();
		
		//final int e0number = e0Obj.getSellStockCount("FUND001");
			//TODO Based on your need, provide necessary assertion condition
		assertEquals("success",6, e0Obj.getSellStockCount("FUND001"));
		
	}
	

	/**
	 * Test get buy stock quantity.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public int getBuyStockQuantity(String,String)
	public void testGetBuyStockQuantity() throws DBException, ClassNotFoundException, SQLException{
		final FundDAO e0Obj = new FundDAO();
		
			
		assertEquals("success",0, e0Obj.getBuyStockQuantity("Vinita","American Vanguard" ));
		
	}
	

	/**
	 * Test get sell stock quantity.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public int getSellStockQuantity(String,String)
	public void testGetSellStockQuantity() throws DBException, ClassNotFoundException, SQLException{
		final FundDAO e0Obj = new FundDAO();
		
			//int e0 = e0Obj.getSellStockQuantity("rFheIlQz6bS5gP66","w9R");
			//TODO Based on your need, provide necessary assertion condition
		assertEquals("success",30, e0Obj.getSellStockQuantity("FUND001","Blackstone"));
		
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
		final FundDAO udObject=new FundDAO();
		assertEquals(0.1,udObject.getProfitRangePercent(2),0.001);
	}
	

	/**
	 * Test get only buy stock data.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public List getOnlyBuyStockData(String)
	public void testGetOnlyBuyStockData() throws DBException, ClassNotFoundException, SQLException{
		final FundDAO e0Obj = new FundDAO();
		
		assertNotNull("success",e0Obj.getOnlyBuyStockData("Vinita"));
		
	}
	

	

	/**
	 * Test get buy price from sname.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public double getBuyPriceFromSname(String)
	public void testGetBuyPriceFromSname() throws DBException, ClassNotFoundException, SQLException{
		final FundDAO e0Obj = new FundDAO();
		assertEquals(30, e0Obj.getBuyPriceFromSname("Blackstone"),0.01);
	
	}
	

	/**
	 * Test get fund data.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public List<FundVo> getFundData()
	public void testGetFundData() throws DBException, ClassNotFoundException, SQLException{
		final FundDAO e0Obj = new FundDAO();
			
		assertNotNull("success",e0Obj.getFundData());
	
	}
	
	/**
	 * Test get only buy stock quantity.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public int getOnlyBuyStockQuantity(String,String)
	public void testGetOnlyBuyStockQuantity() throws DBException, ClassNotFoundException, SQLException{
		final FundDAO e0Obj = new FundDAO();
			
		assertEquals("success",0, e0Obj.getOnlyBuyStockQuantity("Vinita","Blackstone"));
		
	}
	

	/**
	 * Test get role type.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public String getRoleType(String)
	public void testGetRoleType() throws DBException, ClassNotFoundException, SQLException{
		final FundDAO e0Obj = new FundDAO();
			
		assertEquals("success","FUND", e0Obj.getRoleType("Vinita"));
		
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
		final FundDAO e0Obj = new FundDAO();
			
		assertEquals(60.0, e0Obj.getSellPrice("STOCK002"),0.01);
		
	}
	

	/**
	 * Test get user fund.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public String[] getUserFund(String)
	public void testGetUserFund() throws DBException, ClassNotFoundException, SQLException{
		final FundDAO e0Obj = new FundDAO();
		
		assertNotNull("success",e0Obj.getUserFund("FUND001"));
	}
	

	/**
	 * Test get user count.
	 *
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	@Test //public int getUserCount(String)
	public void testGetUserCount() throws DBException, ClassNotFoundException, SQLException{
		final FundDAO e0Obj = new FundDAO();
		
		assertEquals("success",2,e0Obj.getUserCount("FUND001"));
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
		final FundDAO e0Obj = new FundDAO();
					
			assertEquals(30.0, e0Obj.getBuyPrice("STOCK002"),0.01);
		
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
		final FundDAO e0Obj = new FundDAO();
		assertEquals(50000.0,e0Obj.getBalance("FUND001"),0.01);
		
	}
	

	
	

	
	
	}
	

	




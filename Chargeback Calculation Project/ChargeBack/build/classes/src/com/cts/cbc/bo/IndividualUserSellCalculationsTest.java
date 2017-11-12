package com.cts.cbc.bo;


import org.junit.Test;
import junit.framework.TestCase;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class IndividualUserSellCalculationsTest extends TestCase {
	

	/**
	 * Test subtract chargeback.
	 */
	@Test //public double subtractChargeback(double,double,double,int)
	public void testSubtractChargeback(){
		final IndividualUserSellCalculations ibc=new IndividualUserSellCalculations();
		assertEquals(1200, ibc.subtractChargeback(1000, 100, 30,10), 0.001);
	}
	


	/**
	 * Test calculate profit.
	 */
	@Test //public double calculateProfit(double,double,int)
	public void testCalculateProfit(){
		final IndividualUserSellCalculations ibc=new IndividualUserSellCalculations();
		assertEquals(1000, ibc.calculateProfit(200, 100, 10), 0.001);
	}
	

	/**
	 * Test calculate commission.
	 */
	@Test //public double calculateCommission(double,double)
	public void testCalculateCommission(){
		final IndividualUserSellCalculations ibc=new IndividualUserSellCalculations();
		assertEquals(1, ibc.calculateCommission(10,10),0.001);
	}
	

	/**
	 * Test calculate profit percent.
	 */
	@Test //public double calculateProfitPercent(double,double,int)
	public void testCalculateProfitPercent(){
		final IndividualUserSellCalculations ibc=new IndividualUserSellCalculations();
		assertEquals(100, ibc.calculateProfitPercent(1000,100,10), 0.001);
	
	}
	

	/**
	 * Test calculate sell chargeback.
	 */
	@Test //public double calculateSellChargeback(double,double,double)
	public void testCalculateSellChargeback(){
		final IndividualUserSellCalculations ibc=new IndividualUserSellCalculations();
		assertEquals(30, ibc.calculateSellChargeback(10,10,10), 0.001);
	}
}

package com.cts.cbc.bo;
import org.junit.Test;
import junit.framework.TestCase;


public class FundUserSellCalculationsTest extends TestCase {
	

	/**
	 * Test calculate commission.
	 */
	@Test //public double calculateCommission(double,double)
	public void testCalculateCommission(){
		final FundUserSellCalculations fuc = new FundUserSellCalculations();
		assertEquals(120, fuc.calculateCommission(0.6, 20000),0.001);
	}
	

	/**
	 * Test calculate profit.
	 */
	@Test //public double calculateProfit(double,double,int)
	public void testCalculateProfit(){
		final FundUserSellCalculations fuc = new FundUserSellCalculations();
		assertEquals(20000, fuc.calculateProfit(4000, 3000, 20),0.001);
	}
	

	/**
	 * Test subtract chargeback.
	 */
	@Test //public double subtractChargeback(double,double,double,int)
	public void testSubtractChargeback(){
		final FundUserSellCalculations fuc = new FundUserSellCalculations();
		assertEquals(2045526.66, fuc.subtractChargeback(1959200,6666.66,340,4000,20),0.001);
	}
	

	/**
	 * Test calculate profit percent.
	 */
	@Test //public double calculateProfitPercent(double,double,int)
	public void testCalculateProfitPercent(){
		final FundUserSellCalculations fuc = new FundUserSellCalculations();
		assertEquals(33.33,fuc.calculateProfitPercent(20000, 3000, 20),0.01);
	}
	

	/**
	 * Test calculate sell chargeback.
	 */
	@Test //public double calculateSellChargeback(double,double,double)
	public void testCalculateSellChargeback(){
		final FundUserSellCalculations fuc = new FundUserSellCalculations();
		assertEquals(1020,fuc.calculateSellChargeback(120,300,600),0.001);
	}
	
	
	/**
	 * Test calculate fees.
	 */
	@Test //public double calculateFees(double,double)
	public void testCalculateFees(){
		final FundUserSellCalculations fuc = new FundUserSellCalculations();
		assertEquals(300,fuc.calculateFees(3000, 20),0.001);
	}
	
	
	/**
	 * Test calculate tax.
	 */
	@Test //public double calculateTax(double,double)
	public void testCalculateTax(){
		final FundUserSellCalculations fuc = new FundUserSellCalculations();
		assertEquals(600,fuc.calculateTax(3000, 20),0.001);
	}
}

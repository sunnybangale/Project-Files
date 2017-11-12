package com.cts.cbc.bo;
import org.junit.Test;
import junit.framework.TestCase;



public class FundUserBuyCalculationsTest extends TestCase {

	/**
	 * Test subtract chargeback.
	 */
	@Test
	// public double subtractChargeback(double,double)
	public void testSubtractChargeback() {
		final FundUserBuyCalculations fbc = new FundUserBuyCalculations();
		assertEquals(1959200,fbc.subtractChargeback(1960000,800),0.001);
	}

	/**
	 * Test calculate total chargeback.
	 */
	@Test
	// public double calculateTotalChargeback(double,double)
	public void testCalculateTotalChargeback() {
		final FundUserBuyCalculations fbc = new FundUserBuyCalculations();
		
		// TODO Based on your need, provide necessary assertion condition
		assertEquals(2400,fbc.calculateTotalChargeback(2,120000),0.001);
	}

	/**
	 * Test calculate individual chargeback.
	 */
	@Test
	// public double calculateIndividualChargeback(double,double,double)
	public void testCalculateIndividualChargeback() {
		final FundUserBuyCalculations fuc = new FundUserBuyCalculations();
		assertEquals(800, fuc.calculateIndividualChargeback(2, 120000,40000),0.001);
	}
}

package com.cts.cbc.bo;

import org.junit.Test;
import junit.framework.TestCase;


/**
 * This class contains one testXXXX method per XXXXX method in source class.
 *
 * @author
 */
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class IndividualUserBuyCalculationsTest extends TestCase {
	

	@Test //public double subtractChargeback(double,double,double)
	public void testSubtractChargeback(){
		final IndividualUserBuyCalculations ibc=new IndividualUserBuyCalculations();
		//assertEquals("Values are equal",500,ibc.subtractChargeback(1000, 12, 488) );
		assertEquals(500, ibc.subtractChargeback(1000, 12, 488), 0.001);
		
	}
	

	
}

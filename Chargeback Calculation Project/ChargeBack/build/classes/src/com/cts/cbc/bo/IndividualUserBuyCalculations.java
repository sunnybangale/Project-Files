package com.cts.cbc.bo;

import com.cts.cbc.exceptions.DBException;

/**
 * The Class IndividualUserBuyCalculations.
 */
public class IndividualUserBuyCalculations {
	
	
		/**
		 * Subtract chargeback.
		 *
		 * @param balance the balance
		 * @param chargeback the chargeback
		 * @param totalStockPrice the total stock price
		 * @return the double
		 */
		public double subtractChargeback(final double balance,final double chargeback,final double totalStockPrice)
			{
				double subtractedBalance;
				
				subtractedBalance= (balance-chargeback)-(totalStockPrice);
				
				return subtractedBalance;
			} 
		
		/**
		 * Generate transaction id.
		 *
		 * @param transactionId the transaction id
		 * @return the string
		 * @throws DBException the dB exception
		 */
		public String generateTransactionId(final String transactionId) throws DBException
		{
			String newTransactionId;
			int sequence;
			
			final String singleZero="0";
			final String doubleZero="00";
			
			
			final StringBuffer tempTransactionId=new StringBuffer();
			tempTransactionId.append("TRAN");
			sequence=Integer.parseInt(transactionId);
			
			if(sequence>0 && sequence<=9)
			{
				tempTransactionId.append(doubleZero).append(sequence);
			}
			else if(sequence>=11 && sequence<=99)
			{
				tempTransactionId.append(singleZero).append(sequence);
			}
			else
			{
				tempTransactionId.append(sequence);
			}
			newTransactionId=tempTransactionId.toString();
			
			//System.out.println("ithe "+newTransactionId);
			return newTransactionId;
		}
		
		
		

	}

package com.cts.cbc.bo;

import com.cts.cbc.exceptions.DBException;

/**
 * The Class FundUserSellCalculations.
 */
public class FundUserSellCalculations {
	
		
	/**
	 * Calculate profit.
	 *
	 * @param sellCost the sell cost
	 * @param buyCost the buy cost
	 * @param quantity the quantity
	 * @return the double
	 */
	public double calculateProfit(final double sellCost,final double buyCost,final int quantity)
	{
		double profit;
		
		profit=(sellCost-buyCost)*quantity;
				
		return profit;
	}
	
	/**
	 * Calculate profit percent.
	 *
	 * @param profit the profit
	 * @param buyCost the buy cost
	 * @param quantity the quantity
	 * @return the double
	 */
	public double calculateProfitPercent(final double profit,final double buyCost,final int quantity)
	{
		double profitPercent;
		
		profitPercent=(profit/(buyCost*quantity))*100;
				
		return profitPercent;
	}
	
	
	/**
	 * Calculate commission.
	 *
	 * @param profitChargeback the profit chargeback
	 * @param profit the profit
	 * @return the double
	 */
	public double calculateCommission(final double profitChargeback,final double profit)
	{
		double commission;
		
		commission=(profitChargeback*profit)/100;
		
		return commission;
	}
	
	/**
	 * Calculate fees.
	 *
	 * @param buyCost the buy cost
	 * @param quantity the quantity
	 * @return the double
	 */
	public double calculateFees(final double buyCost,final double quantity)
	{
		double fees;
		
		fees=(buyCost*quantity*0.5)/100;
		
		return fees;
	}
	
	/**
	 * Calculate tax.
	 *
	 * @param buyCost the buy cost
	 * @param quantity the quantity
	 * @return the double
	 */
	public double calculateTax(final double buyCost,final double quantity)
	{
		double tax;
		
		tax=(buyCost*quantity*1)/100;
		
		return tax;
	}
	
	/**
	 * Calculate sell chargeback.
	 *
	 * @param commission the commission
	 * @param fees the fees
	 * @param tax the tax
	 * @return the double
	 */
	public double calculateSellChargeback(final double commission,final  double fees,final  double tax)
	{
		double sellChargeback;

		sellChargeback=commission+fees+tax;
		
		return sellChargeback;
	}
	
	/**
	 * Subtract chargeback.
	 *
	 * @param balance the balance
	 * @param profit the profit
	 * @param chargeback the chargeback
	 * @param sellCost the sell cost
	 * @param quantity the quantity
	 * @return the double
	 */
	public double subtractChargeback(final double balance,final double profit,final double chargeback,final double sellCost,final int quantity)
	{
		double subtractedBalance;
		
		subtractedBalance= balance+(profit-chargeback) +(sellCost*quantity);
		
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
	
	/**
	 * Generate tl id.
	 *
	 * @param transactionId the transaction id
	 * @param userId the user id
	 * @return the string
	 * @throws DBException the dB exception
	 */
	public String generateTlId(final String transactionId,final String userId) throws DBException
	{
		int sequence;
		String tlId ="";
		
		final String singleZero="0";
		final String doubleZero="00";
		
		final StringBuffer temporaryTlid=new StringBuffer();
		temporaryTlid.append("TL");
		sequence=Integer.parseInt(transactionId);
		if(sequence>0 && sequence<=9)
		{
			temporaryTlid.append(doubleZero).append(sequence);
		}
		else if(sequence>=11 && sequence<=99)
		{
			temporaryTlid.append(singleZero).append(sequence);
		}
		else
		{
			temporaryTlid.append(sequence);
		}
		temporaryTlid.append(userId);
		tlId=temporaryTlid.toString();
		return tlId;
		
	}
}


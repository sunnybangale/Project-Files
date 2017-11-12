
package com.cts.cbc.bo;

import java.sql.SQLException;

import com.cts.cbc.dao.FundDAO;
import com.cts.cbc.exceptions.DBException;


/**
 * The Class FundUserBuyCalculations.
 */
public class FundUserBuyCalculations {
	

	/**
	 * Calculate total chargeback.
	 *
	 * @param cbcPercentRange the cbc percent range
	 * @param totalStockPrice the total stock price
	 * @return the double
	 */
	public double calculateTotalChargeback(final double cbcPercentRange,final double totalStockPrice)
	{
		double chargebackF;

		chargebackF = (totalStockPrice * cbcPercentRange) / 100;

		return chargebackF;
	}

	/**
	 * Calculate individual chargeback.
	 *
	 * @param cbcPercentRange the cbc percent range
	 * @param totalStockPrice the total stock price
	 * @param amountInvested the amount invested
	 * @return the double
	 */
	public double calculateIndividualChargeback(final double cbcPercentRange,final double totalStockPrice,final double amountInvested) {
		double chargebackI;
		
		final double chargebackF = calculateTotalChargeback(cbcPercentRange,totalStockPrice);

		chargebackI = (amountInvested * chargebackF) / totalStockPrice;

		return chargebackI;
	}

	/**
	 * Subtract chargeback.
	 *
	 * @param balance the balance
	 * @param chargebackI the chargeback i
	 * @return the double
	 */
	public double subtractChargeback(final double balance,final double chargebackI) {
		double subtractedBalance;

		subtractedBalance = balance - chargebackI;

		return subtractedBalance;
	}

	/**
	 * Generate transaction id.
	 *
	 * @param transactionId the transaction id
	 * @return the string
	 * @throws DBException the dB exception
	 */
	public String generateTransactionId(final String transactionId)	throws DBException {
		String newTransactionId;
		int sequence;
		final StringBuffer tempTransactionId = new StringBuffer();

		final String singleZero="0";
		final String doubleZero="00";
		
		
		//System.out.println("im here");

		tempTransactionId.append("TRAN");
		sequence = Integer.parseInt(transactionId);

		if (sequence > 0 && sequence <= 9) {
			tempTransactionId.append(doubleZero).append(sequence);
		} else if (sequence >= 11 && sequence <= 99) {
			tempTransactionId.append(singleZero).append(sequence);
		} else {
			tempTransactionId.append(sequence);
		}
		newTransactionId = tempTransactionId.toString();

		//System.out.println("ithe " + newTransactionId);
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
	public String generateTlId(final String transactionId,final  String userId)	throws DBException {
		int sequence;
		String tlId = "";
		
		final String singleZero="0";
		final String doubleZero="00";
		
		final StringBuffer temporaryTlid = new StringBuffer();
		temporaryTlid.append("TL");
		sequence = Integer.parseInt(transactionId);
		if (sequence > 0 && sequence <= 9) {
			temporaryTlid.append(doubleZero).append(sequence);
		} else if (sequence >= 11 && sequence <= 99) {
			temporaryTlid.append(singleZero).append(sequence);
		} else {
			temporaryTlid.append(sequence);
		}
		temporaryTlid.append(userId);
		tlId = temporaryTlid.toString();
		
		return tlId;

	}
	
	//get total fund balance

	/**
	 * Gets the total fund balance.
	 *
	 * @param user the user
	 * @return the total fund balance
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public double getTotalFundBalance(final String user[]) throws DBException, ClassNotFoundException, SQLException
	{
	double totalBalance=0;
	final FundDAO fdObject = new FundDAO();
	int iterator;
	
	for(iterator=0;iterator<user.length;iterator++)
	{
	totalBalance+=fdObject.getBalanceUser(user[iterator]);
	}
	
	return totalBalance;	
	}

	
	/**
	 * Gets the generate fund id.
	 *
	 * @param fundId the fund id
	 * @return the generate fund id
	 */
	public String getGenerateFundId(final String fundId)
	{
		String generatedFundId="";
	
		final int sub = Integer.parseInt(fundId.substring(fundId.length() - 3,fundId.length())) + 1;
		final int length = (int) Math.log10(sub) + 1;
		if (length == 1)
		{	generatedFundId= "FUND00" + sub;
		}
		else if (length == 2)
		{		generatedFundId = "FUND0" + sub;
		}
		else if (length == 3)
		{
			generatedFundId = "FUND" + sub;
		}
		//System.out.println(generatedFundId);
		
		
		
		return generatedFundId;
		
	}
	
	
}

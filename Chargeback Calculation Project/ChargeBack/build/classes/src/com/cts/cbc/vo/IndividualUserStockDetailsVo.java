package com.cts.cbc.vo;

/**
 * The Class IndividualUserStockDetailsVo.
 */
public class IndividualUserStockDetailsVo {


	private String userId;
	private String stockId;
	private int noOfStock;
	private double chargeback;
	private double balance;
	private String transactionType;
	private String transactionDate;

	
	private int sumOfBoughtStocks;
	
	
	
	
	/**
	 * Gets the sum of bought stocks.
	 *
	 * @return the sum of bought stocks
	 */
	public int getSumOfBoughtStocks() {
		return sumOfBoughtStocks;
	}
	
	/**
	 * Sets the sum of bought stocks.
	 *
	 * @param sumOfBoughtStocks the new sum of bought stocks
	 */
	public void setSumOfBoughtStocks(final int sumOfBoughtStocks) {
		this.sumOfBoughtStocks = sumOfBoughtStocks;
	}

	
	/**
	 * Instantiates a new individual user stock details vo.
	 */
	public IndividualUserStockDetailsVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * Instantiates a new individual user stock details vo.
	 *
	 * @param sumOfBoughtStocks the sum of bought stocks
	 */
	public IndividualUserStockDetailsVo(final int sumOfBoughtStocks) {
 this.sumOfBoughtStocks= sumOfBoughtStocks;
 		
	}
	
	
	
	
	
	private String transactionId;
	
	
	/**
	 * Gets the transaction id.
	 *
	 * @return the transaction id
	 */
	public String getTransactionId() {
		return transactionId;
	}
	
	/**
	 * Sets the transaction id.
	 *
	 * @param transactionId the new transaction id
	 */
	public void setTransactionId(final String transactionId) {
		this.transactionId = transactionId;
	}
	
	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(final String userId) {
		this.userId = userId;
	}
	
	/**
	 * Gets the stock id.
	 *
	 * @return the stock id
	 */
	public String getStockId() {
		return stockId;
	}
	
	/**
	 * Sets the stock id.
	 *
	 * @param stockId the new stock id
	 */
	public void setStockId(final String stockId) {
		this.stockId = stockId;
	}
	
	/**
	 * Gets the no of stock.
	 *
	 * @return the no of stock
	 */
	public int getNoOfStock() {
		return noOfStock;
	}
	
	/**
	 * Sets the no of stock.
	 *
	 * @param noOfStock the new no of stock
	 */
	public void setNoOfStock(final int noOfStock) {
		this.noOfStock = noOfStock;
	}
	
	/**
	 * Gets the chargeback.
	 *
	 * @return the chargeback
	 */
	public double getChargeback() {
		return chargeback;
	}
	
	/**
	 * Sets the chargeback.
	 *
	 * @param chargeback the new chargeback
	 */
	public void setChargeback(final double chargeback) {
		this.chargeback = chargeback;
	}
	
	/**
	 * Gets the balance.
	 *
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Sets the balance.
	 *
	 * @param balance the new balance
	 */
	public void setBalance(final double balance) {
		this.balance = balance;
	}
	
	/**
	 * Gets the transaction type.
	 *
	 * @return the transaction type
	 */
	public String getTransactionType() {
		return transactionType;
	}
	
	/**
	 * Sets the transaction type.
	 *
	 * @param transactionType the new transaction type
	 */
	public void setTransactionType(final String transactionType) {
		this.transactionType = transactionType;
	}
	
	/**
	 * Gets the transaction date.
	 *
	 * @return the transaction date
	 */
	public String getTransactionDate() {
		return transactionDate;
	}
	
	/**
	 * Sets the transaction date.
	 *
	 * @param transactionDate the new transaction date
	 */
	public void setTransactionDate(final String transactionDate) {
		this.transactionDate = transactionDate;
	}
	   
	
	
	
	
	
}

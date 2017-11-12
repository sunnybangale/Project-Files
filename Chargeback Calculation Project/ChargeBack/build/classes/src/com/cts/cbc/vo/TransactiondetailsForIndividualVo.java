package com.cts.cbc.vo;

/**
 * The Class TransactiondetailsForIndividualVo.
 */
public class TransactiondetailsForIndividualVo {

	private String transactionId;
	private String  userId;
	private String  stockId;
	private int noOfStock;
	private double chargeBack;
	private double balance;
	private String  transactionType;
	private String  transactionDate;
	
	
	
	/**
	 * Instantiates a new transactiondetails for individual vo.
	 */
	public TransactiondetailsForIndividualVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Instantiates a new transactiondetails for individual vo.
	 *
	 * @param TransactionId the transaction id
	 * @param UserId the user id
	 * @param StockId the stock id
	 * @param NoOfStock the no of stock
	 * @param ChargeBack the charge back
	 * @param Balance the balance
	 * @param TransactionType the transaction type
	 * @param TransactionDate the transaction date
	 */
	public TransactiondetailsForIndividualVo(final String TransactionId,final  String  UserId,final String  StockId,final int NoOfStock,final double ChargeBack,final double Balance,final String  TransactionType,final String  TransactionDate) {
	this.transactionId=TransactionId;
	this.userId=UserId;
	this.stockId=StockId;
	this.noOfStock=NoOfStock;
	this.chargeBack=ChargeBack;
	this.balance=Balance;
	this.transactionType=TransactionType;
	this.transactionDate=TransactionDate;
		
	}


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
	 * Gets the charge back.
	 *
	 * @return the charge back
	 */
	public double getChargeBack() {
		return chargeBack;
	}


	/**
	 * Sets the charge back.
	 *
	 * @param chargeBack the new charge back
	 */
	public void setChargeBack(final double chargeBack) {
		this.chargeBack = chargeBack;
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

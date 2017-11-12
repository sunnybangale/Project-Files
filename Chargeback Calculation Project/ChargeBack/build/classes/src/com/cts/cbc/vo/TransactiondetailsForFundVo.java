package com.cts.cbc.vo;

/**
 * The Class TransactiondetailsForFundVo.
 */
public class TransactiondetailsForFundVo {


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
	 * Gets the stockid.
	 *
	 * @return the stockid
	 */
	public String getStockid() {
		return stockid;
	}

	/**
	 * Sets the stockid.
	 *
	 * @param stockid the new stockid
	 */
	public void setStockid(final String stockid) {
		this.stockid = stockid;
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
	 * Gets the amount invested.
	 *
	 * @return the amount invested
	 */
	public double getAmountInvested() {
		return amountInvested;
	}

	/**
	 * Sets the amount invested.
	 *
	 * @param amountInvested the new amount invested
	 */
	public void setAmountInvested(final double amountInvested) {
		this.amountInvested = amountInvested;
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

	/**
	 * Gets the no of days stock.
	 *
	 * @return the no of days stock
	 */
	public int getNoOfDaysStock() {
		return noOfDaysStock;
	}

	/**
	 * Sets the no of days stock.
	 *
	 * @param noOfDaysStock the new no of days stock
	 */
	public void setNoOfDaysStock(final int noOfDaysStock) {
		this.noOfDaysStock = noOfDaysStock;
	}

	/**
	 * Gets the fund id.
	 *
	 * @return the fund id
	 */
	public String getFundId() {
		return fundId;
	}

	/**
	 * Sets the fund id.
	 *
	 * @param fundId the new fund id
	 */
	public void setFundId(final String fundId) {
		this.fundId = fundId;
	}

	private String transactionId;
	private String userId;
	private String stockid;
	private int noOfStock;
	private double amountInvested;
	private double chargeBack;
	private double balance;
	private String transactionType;
	private String transactionDate;
	private int noOfDaysStock;
	private String fundId;

	/**
	 * Instantiates a new transactiondetails for fund vo.
	 */
	public TransactiondetailsForFundVo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new transactiondetails for fund vo.
	 *
	 * @param Transaction_id the transaction_id
	 * @param User_id the user_id
	 * @param Stock_id the stock_id
	 * @param No_of_stock the no_of_stock
	 * @param Amount_invested the amount_invested
	 * @param Chargeback the chargeback
	 * @param Balance the balance
	 * @param Transaction_type the transaction_type
	 * @param Transaction_date the transaction_date
	 * @param No_Of_days_stock the no_ of_days_stock
	 * @param Fund_id the fund_id
	 */
	public TransactiondetailsForFundVo(final String Transaction_id,final  String User_id,
			final String Stock_id,final  int No_of_stock,final  double Amount_invested,
			final double Chargeback,final  double Balance,final  String Transaction_type,
			final String Transaction_date,final  int No_Of_days_stock,final  String Fund_id) {

		this.transactionId = Transaction_id;
		this.userId = User_id;
		this.stockid = Stock_id;
		this.noOfDaysStock= No_Of_days_stock;
		this.amountInvested = Amount_invested;
		this.chargeBack = Chargeback;
		this.balance = Balance;
		this.transactionType = Transaction_type;
		this.transactionDate = Transaction_date;
		this.noOfStock = No_of_stock;
		this.fundId = Fund_id;

	}

}

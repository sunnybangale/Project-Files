package com.cts.cbc.vo;

/**
 * The Class FundVo.
 */
public class FundVo {
	private String fundId;
	private String fundName;
	private int amountDollar;
	private String stockName;
	private double sellPrice;

	/**
	 * Instantiates a new fund vo.
	 *
	 * @param fundId the fund id
	 * @param fundName the fund name
	 * @param stockName the stock name
	 * @param sellPrice the sell price
	 * @param sumOfBoughtStocks the sum of bought stocks
	 * @param transactionType the transaction type
	 */
	public FundVo(final String fundId,final  String fundName,final  String stockName,
			final double sellPrice,final  int sumOfBoughtStocks,final  String transactionType) {
		this.fundId = fundId;
		this.fundName = fundName;
		this.stockName = stockName;
		this.sellPrice = sellPrice;
		this.sumOfBoughtStocks = sumOfBoughtStocks;
		this.transactionType = transactionType;
	}
	
	/**
	 * Instantiates a new fund vo.
	 *
	 * @param fundId the fund id
	 * @param fundName the fund name
	 * @param stockName the stock name
	 * @param sellPrice the sell price
	 * @param sumOfBoughtStocks the sum of bought stocks
	 */
	public FundVo(final String fundId,final  String fundName,final  String stockName,
			final double sellPrice,final  int sumOfBoughtStocks) {
		this.fundId = fundId;
		this.fundName = fundName;
		this.stockName = stockName;
		this.sellPrice = sellPrice;
		this.sumOfBoughtStocks = sumOfBoughtStocks;
	}
	
	/**
	 * Instantiates a new fund vo.
	 *
	 * @param fundId the fund id
	 * @param fundName the fund name
	 */
	public FundVo(final String fundId,final  String fundName) {
		this.fundId = fundId;
		this.fundName = fundName;
		
	}


	/**
	 * Instantiates a new fund vo.
	 */
	public FundVo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the stock name.
	 *
	 * @return the stock name
	 */
	public String getStockName() {
		return stockName;
	}

	/**
	 * Sets the stock name.
	 *
	 * @param stockName the new stock name
	 */
	public void setStockName(final String stockName) {
		this.stockName = stockName;
	}

	/**
	 * Gets the sell price.
	 *
	 * @return the sell price
	 */
	public double getSellPrice() {
		return sellPrice;
	}

	/**
	 * Sets the sell price.
	 *
	 * @param sellPrice the new sell price
	 */
	public void setSellPrice(final double sellPrice) {
		this.sellPrice = sellPrice;
	}

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

	private int sumOfBoughtStocks;
	private String transactionType;

	/**
	 * Instantiates a new fund vo.
	 *
	 * @param fundId the fund id
	 * @param fundName the fund name
	 * @param amountDollar the amount dollar
	 */
	public FundVo(final String fundId,final  String fundName,final  int amountDollar) {
		this.fundId = fundId;
		this.fundName = fundName;
		this.amountDollar = amountDollar;

	}

	/**
	 * Instantiates a new fund vo.
	 *
	 * @param fname the fname
	 */
	public FundVo(final String fname) {
		// TODO Auto-generated constructor stub
		this.fundName=fname;
		//this.stockName=sname;
		//this.sellPrice=sprice;
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

	/**
	 * Gets the fund name.
	 *
	 * @return the fund name
	 */
	public String getFundName() {
		return fundName;
	}

	/**
	 * Sets the fund name.
	 *
	 * @param fundName the new fund name
	 */
	public void setFundName(final String fundName) {
		this.fundName = fundName;
	}

	/**
	 * Gets the amount dollar.
	 *
	 * @return the amount dollar
	 */
	public int getAmountDollar() {
		return amountDollar;
	}

	/**
	 * Sets the amount dollar.
	 *
	 * @param amountDollar the new amount dollar
	 */
	public void setAmountDollar(final int amountDollar) {
		this.amountDollar = amountDollar;
	}

}

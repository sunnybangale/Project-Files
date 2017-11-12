package com.cts.cbc.vo;

/**
 * The Class StockDetailsVo.
 */
public class StockDetailsVo {
	
	
	private String stockId;
	private String stockName;

	private double buyPrice;
	private double sellPrice;
	
	//private transient int temporary;
	
	
	/**
	 * Instantiates a new stock details vo.
	 */
	public StockDetailsVo() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new stock details vo.
	 *
	 * @param stockId the stock id
	 * @param stockName the stock name
	 * @param buyPrice the buy price
	 */
	public StockDetailsVo(final String stockId,final String stockName,final double buyPrice) {

		this.stockId=stockId;
		this.stockName=stockName;
		
		this.buyPrice=buyPrice;
	}
	
	/**
	 * Instantiates a new stock details vo.
	 *
	 * @param stockName the stock name
	 * @param sellPrice the sell price
	 */
	public StockDetailsVo(final String stockName,final  double sellPrice) {

		this.stockName=stockName;
		this.sellPrice=sellPrice;
	}
	
//////////////////////////
	
	/**
 * Instantiates a new stock details vo.
 *
 * @param stockName the stock name
 * @param buyPrice the buy price
 * @param temporary the temporary
 */
public StockDetailsVo(final String stockName,final  double buyPrice,final int temp) {

	int temporary;
		this.stockName=stockName;
		this.buyPrice=buyPrice;
		temporary= temp;
		
		
		
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
	 * Gets the buy price.
	 *
	 * @return the buy price
	 */
	public double getBuyPrice() {
		return buyPrice;
	}
	
	/**
	 * Sets the buy price.
	 *
	 * @param buyPrice the new buy price
	 */
	public void setBuyPrice(final double buyPrice) {
		this.buyPrice = buyPrice;
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
	
	
	
	

}

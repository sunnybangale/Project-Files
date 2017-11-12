package com.cts.cbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.cts.cbc.exceptions.DBException;
import com.cts.cbc.util.DBConstants;
import com.cts.cbc.util.DBManager;
import com.cts.cbc.vo.FundUserStockDetailsVo;
import com.cts.cbc.vo.FundVo;
import com.cts.cbc.vo.StockDetailsVo;
import com.cts.cbc.vo.UserVo;

public class FundDAO {
	
	public static final Logger LOG=Logger.getLogger(FundDAO.class);
	private transient Connection connnection = null;
	private transient ResultSet resultSet = null;
	private transient ResultSet resultSet1 = null;
	private transient Statement statement = null;
	private transient PreparedStatement prepStatement1 = null;
//	private transient PreparedStatement prepStatement2 = null;

	/**
 * Gets the fund data.
 *
 * @return the fund data
 * @throws DBException the dB exception
 * @throws ClassNotFoundException the class not found exception
 * @throws SQLException the sQL exception
 */
public List<FundVo> getFundData() throws DBException, ClassNotFoundException, SQLException {

		String fundId;
		String fundName;

		int amountDollar;

		final List<FundVo> fundList = new ArrayList<FundVo>();
		FundVo fvObject;

		
			connnection = DBManager.getConnection();
			statement = connnection.createStatement();
		//	System.out.println(DBConstants.GET_FUND_DATA);

			resultSet = statement.executeQuery(DBConstants.GET_FUND_DATA);

			while (resultSet.next()) {

				fundId = resultSet.getString(1);
				fundName = resultSet.getString(2);

				amountDollar = resultSet.getInt(3);
				// amountCurrency=rs.getInt(6);

				fvObject = new FundVo(fundId, fundName, amountDollar);
				fundList.add(fvObject);
				//System.out.println("added!!!");

			}

		
			statement.close();
			resultSet.close();
		//resultSet = null;
		return fundList;

	}

	/**
	 * Gets the new user data.
	 *
	 * @return the new user data
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public List<UserVo> getNewUserData() throws DBException, SQLException, ClassNotFoundException {

		String userId;
		String firstName;
		String lastName;

		long mobile;

		final List<UserVo> appliedFundUsers = new ArrayList<UserVo>();
		UserVo uvObject;

		
			connnection = DBManager.getConnection();
			statement = connnection.createStatement();
			//System.out.println(DBConstants.GET_FUND_REQUEST);
			resultSet1 = statement.executeQuery(DBConstants.GET_FUND_REQUEST);

			//System.out.println("rsOut");
			while (resultSet1.next()) {

				//System.out.println("rsin");
				userId = resultSet1.getString(1);
				firstName = resultSet1.getString(2);

				lastName = resultSet1.getString(3);
				mobile = resultSet1.getLong(4);
				// amountCurrency=rs.getInt(6);

				uvObject = new UserVo(userId, firstName, lastName, mobile, 0, 0);

				appliedFundUsers.add(uvObject);
				//System.out.println("added!!!");

			}

			statement.close();
			resultSet1.close();
			
		return appliedFundUsers;
	}

	/**
	 * Gets the last fund id.
	 *
	 * @return the last fund id
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public String getLastFundID() throws DBException, SQLException, ClassNotFoundException {

		String fundId = "";

		
			connnection = DBManager.getConnection();
			statement = connnection.createStatement();
			//System.out.println(DBConstants.GET_LAST_FUNDID);
			resultSet1 = statement.executeQuery(DBConstants.GET_LAST_FUNDID);

			//System.out.println("rsOut");
			while (resultSet1.next()) {

			//	System.out.println("rsin");
				fundId = resultSet1.getString(1);

			//	System.out.println("added!!!");

			}

			statement.close();
			resultSet1.close();

		
		return fundId;
	}



	/**
	 * Gets the buy stock data.
	 *
	 * @return the buy stock data
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public List<StockDetailsVo> getBuyStockData() throws DBException, ClassNotFoundException, SQLException {

		String Stock_id;
		String Stock_name;

		double Buy_price;
		StockDetailsVo sdv;
		final List<StockDetailsVo> fundList = new ArrayList<StockDetailsVo>();

		
			connnection = DBManager.getConnection();
			statement = connnection.createStatement();
			resultSet = statement.executeQuery(DBConstants.GET_BUY_FUND);

			while (resultSet.next()) {

				Stock_id = resultSet.getString(1);
	//			System.out.println(Stock_id);
				Stock_name = resultSet.getString(2);
//				System.out.println(Stock_name);

				Buy_price = resultSet.getInt(3);
				sdv = new StockDetailsVo(Stock_id, Stock_name, Buy_price);

				fundList.add(sdv);

			}// while ends
		
			statement.close();
			resultSet.close();
		return fundList;

	}

	/**
	 * Gets the sell stock data.
	 *
	 * @param selectedFund the selected fund
	 * @return the sell stock data
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public List getSellStockData(final String selectedFund) throws DBException, SQLException, ClassNotFoundException {

		String fundId;
		String fundName;
		String stockName;
		double sellPrice;
		int sumOfBoughtStocks;

		final List fundList = new ArrayList();

		FundVo fvObject = new FundVo();
		StockDetailsVo sdvObject = new StockDetailsVo();
		FundUserStockDetailsVo fusdvObject = new FundUserStockDetailsVo();

		
			connnection = DBManager.getConnection();
			prepStatement1 = connnection.prepareStatement(DBConstants.GET_SELL_FUND);
			prepStatement1.setString(1, selectedFund);
			prepStatement1.setString(2, selectedFund);
			prepStatement1.setString(3, selectedFund);
			prepStatement1.setString(4, selectedFund);
			prepStatement1.setString(5, selectedFund);
			prepStatement1.setString(6, selectedFund);
			resultSet = prepStatement1.executeQuery();

			while (resultSet.next()) {

				fundId = resultSet.getString(2);
				fundName = resultSet.getString(1);
				stockName = resultSet.getString(3);
				sellPrice = resultSet.getDouble(4);
				sumOfBoughtStocks = resultSet.getInt(5);

				fvObject=new FundVo(fundId, fundName, stockName, sellPrice, sumOfBoughtStocks);

				sdvObject = new StockDetailsVo(stockName, sellPrice);

				fusdvObject = new FundUserStockDetailsVo(sumOfBoughtStocks);

				fundList.add(fvObject);
				fundList.add(sdvObject);
				fundList.add(fusdvObject);

			}

		prepStatement1.close();
		resultSet.close();

		return fundList;
	}

	// get fund name stock name

	/**
	 * Gets the fund stock names.
	 *
	 * @param fundId the fund id
	 * @param stockId the stock id
	 * @return the fund stock names
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public List getFundStockNames(final String fundId,final String stockId) throws DBException, ClassNotFoundException, SQLException {
		//System.out.println("STOCK");
		FundVo fvObject = new FundVo();
		StockDetailsVo sdvObject = new StockDetailsVo();
		String fundName, stockName;
		double sprice;
		final List fundList = new ArrayList();
	
			connnection = DBManager.getConnection();
			prepStatement1 = connnection.prepareStatement(DBConstants.GET_FUND_STOCK);
			//System.out.println(fid);
			//System.out.println("ytyt" + id.trim());
			prepStatement1.setString(1, fundId);
			prepStatement1.setString(2, stockId.trim());
			//System.out.println(preparedStatement1.toString());
			//System.out.println(DBConstants.GET_FUNDNAME_STOCKNAME);
			resultSet = prepStatement1.executeQuery();
			while (resultSet.next()) {
				// System.out.println("inside out");
				fundName = resultSet.getString(1);
				stockName = resultSet.getString(2);
				sprice = resultSet.getDouble(3);
				// System.out.println("price "+sprice);
				fvObject = new FundVo(fundName);
				sdvObject = new StockDetailsVo(stockName, sprice,0);
				fundList.add(fvObject);
				fundList.add(sdvObject);
			}
		
			prepStatement1.close();
			resultSet.close();
			
		return fundList;

	}

	// get count of user of select fund
	/**
	 * Gets the user count.
	 *
	 * @param fundId the fund id
	 * @return the user count
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public int getUserCount(final String fundId) throws DBException, ClassNotFoundException, SQLException {
		int countFundUsers = 0;
		
			connnection = DBManager.getConnection();
			prepStatement1 = connnection.prepareStatement(DBConstants.GET_COUNT_FUND);

			prepStatement1.setString(1, fundId);
			resultSet = prepStatement1.executeQuery();

			while (resultSet.next()) {
				countFundUsers = resultSet.getInt(1);
			}
			//System.out.println(countFundUsers);
		
		
			prepStatement1.close();
			resultSet.close();
			
		return countFundUsers;
	}

	// get users of selected fund

	/**
	 * Gets the user fund.
	 *
	 * @param fundId the fund id
	 * @return the user fund
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public String[] getUserFund(final String fundId) throws DBException, ClassNotFoundException, SQLException {
		String users[] = new String[20];
		int countOfUsers = 0;
		
		
			connnection = DBManager.getConnection();
			prepStatement1 = connnection.prepareStatement(DBConstants.GET_FUND_USERS);

			prepStatement1.setString(1, fundId.trim());
			resultSet = prepStatement1.executeQuery();
//			System.out.println(fundId + " " + DBConstants.GET_FUND_USERS);

			while (resultSet.next()) {
				//System.out.println(i);
				// System.out.println(rs.getString(1));
				users[countOfUsers] = resultSet.getString(1);
				//System.out.println(a[i]);
				countOfUsers = countOfUsers + 1;
			}
			//System.out.println(i);
		
			prepStatement1.close();
			resultSet.close();
			
		return users;
	}

	// for getting balance of selected user
	/**
	 * Gets the balance user.
	 *
	 * @param userId the user id
	 * @return the balance user
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public double getBalanceUser(final String userId) throws DBException, ClassNotFoundException, SQLException {
		double balance = 0.0;

		
			connnection = DBManager.getConnection();
			prepStatement1 = connnection.prepareStatement(DBConstants.GET_BALANCE);

			prepStatement1.setString(1, userId);
			resultSet = prepStatement1.executeQuery();

			while (resultSet.next()) {
				balance = resultSet.getDouble(1);
			}
			// System.out.println(count);
		
			prepStatement1.close();
			resultSet.close();
			
		return balance;
	}

	// for getting percentRange of chargeBack
	
	/**
	 * Gets the range percent.
	 *
	 * @param total_Stock_Price the total_ stock_ price
	 * @return the range percent
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public double getRangePercent(final double total_Stock_Price) throws DBException, ClassNotFoundException, SQLException {
		double percentRange = 0;

		
			connnection = DBManager.getConnection();
			prepStatement1 = connnection.prepareStatement(DBConstants.GET_PERCENT);
			prepStatement1.setDouble(1, total_Stock_Price);
			prepStatement1.setDouble(2, total_Stock_Price);
			//System.out.println(total_Stock_Price);

			resultSet = prepStatement1.executeQuery();
			while (resultSet.next()) {

				percentRange = resultSet.getDouble(1);
			}

		
			prepStatement1.close();
			resultSet.close();
			
		return percentRange;
	}// func ends

	// for updating balance
	/**
	 * Update balance user.
	 *
	 * @param balance the balance
	 * @param currency the currency
	 * @param userId the user id
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public void updateBalanceUser(final double balance,final double currency,final String userId) throws DBException, ClassNotFoundException, SQLException {
		
			connnection = DBManager.getConnection();
			prepStatement1 = connnection.prepareStatement(DBConstants.UPDATE_BAL_USER);

			prepStatement1.setDouble(1, balance);
			prepStatement1.setDouble(2, currency);
			prepStatement1.setString(3, userId);

			prepStatement1.executeUpdate();
			// rs=pst.executeQuery();
			//System.out.println("Updated");
			
			prepStatement1.close();
		
	}

	// for getting no-of-days

	/**
	 * Gets the no of days stock held.
	 *
	 * @param userId the user id
	 * @return the no of days stock held
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public int getNoOfDaysStockHeld(final  String userId) throws DBException, ClassNotFoundException, SQLException {
		
		int daysStockHeld = 0;
		
			connnection = DBManager.getConnection();
			prepStatement1 = connnection.prepareStatement(DBConstants.GET_NO_DAYS);

			prepStatement1.setString(1, userId);
			resultSet = prepStatement1.executeQuery();
			while (resultSet.next()) {

				daysStockHeld = resultSet.getInt(1);
			}

			prepStatement1.close();
			resultSet.close();
		
		return daysStockHeld;
	}

	// for getting role type of user
	/**
	 * Gets the role type.
	 *
	 * @param userId the user id
	 * @return the role type
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public String getRoleType(final String userId) throws DBException, SQLException, ClassNotFoundException {
		String role = "";
	
			connnection = DBManager.getConnection();
			prepStatement1 = connnection.prepareStatement(DBConstants.GET_ROLE_TYPE);

			prepStatement1.setString(1, userId);
			resultSet = prepStatement1.executeQuery();
			while (resultSet.next()) {

				role = resultSet.getString(1);
			}

	

		// rs=pst.executeQuery();
		// System.out.println("Updated");

		// }
			
			prepStatement1.close();
			resultSet.close();
		
		return role;
	}

	/**
	 * Gets the sell stock count.
	 *
	 * @param fundId the fund id
	 * @return the sell stock count
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public int getSellStockCount(final String fundId) throws DBException, ClassNotFoundException, SQLException {
		int countOfStocks = 0;

		
			connnection = DBManager.getConnection();
			prepStatement1 = connnection.prepareStatement(DBConstants.COUNT_SELL_FUND);

			prepStatement1.setString(1, fundId);
			resultSet = prepStatement1.executeQuery();
			while (resultSet.next()) {
				countOfStocks = resultSet.getInt(1);
			}

			prepStatement1.close();
			resultSet.close();

		return countOfStocks;
	}

	/**
	 * Gets the buy stock data.
	 *
	 * @param SelectFund the select fund
	 * @return the buy stock data
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public List getBuyStockData(final String SelectFund) throws DBException, SQLException, ClassNotFoundException {

		String fundId;
		String fundName;
		String stockName;
		double sellPrice;
		int sumOfBoughtStocks;

		final List fundList = new ArrayList();

		FundVo fvObject = new FundVo();
		StockDetailsVo sdvObject = new StockDetailsVo();

		FundUserStockDetailsVo fusdvObject = new FundUserStockDetailsVo();

	
			connnection = DBManager.getConnection();
			prepStatement1 = connnection.prepareStatement(DBConstants.GET_BUY_DATA_FUND);
			prepStatement1.setString(1, SelectFund);
			prepStatement1.setString(2, SelectFund);

			resultSet = prepStatement1.executeQuery();

			while (resultSet.next()) {

				fundId = resultSet.getString(1);
				fundName = resultSet.getString(2);
				stockName = resultSet.getString(3);
				sellPrice = resultSet.getDouble(4);
				sumOfBoughtStocks = resultSet.getInt(5);

				fvObject = new FundVo(fundId, fundName);

				sdvObject = new StockDetailsVo(stockName, sellPrice);

				fusdvObject = new FundUserStockDetailsVo(sumOfBoughtStocks);

				fundList.add(fvObject);
				fundList.add(sdvObject);
				fundList.add(fusdvObject);

			}

			prepStatement1.close();
			resultSet.close();

		return fundList;
	}

	/**
	 * Gets the buy stock quantity.
	 *
	 * @param selectedUser the selected user
	 * @param selectedStockName the selected stock name
	 * @return the buy stock quantity
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public int getBuyStockQuantity(final String selectedUser,final String selectedStockName) throws DBException, SQLException, ClassNotFoundException
	{

int sumOfBoughtStocks = 0;


	connnection = DBManager.getConnection();

	prepStatement1 = connnection.prepareStatement(DBConstants.GET_BUY_SUM_FUND);
	prepStatement1.setString(1, selectedUser);
	prepStatement1.setString(2, selectedUser);
	prepStatement1.setString(3, selectedStockName);

	resultSet = prepStatement1.executeQuery();

	while (resultSet.next()) {
		sumOfBoughtStocks = resultSet.getInt(1);
	}

	prepStatement1.close();
	resultSet.close();

return sumOfBoughtStocks;
}
	
	/**
	 * Gets the sell stock quantity.
	 *
	 * @param SelectFund the select fund
	 * @param selectedStockName the selected stock name
	 * @return the sell stock quantity
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public int getSellStockQuantity(final String SelectFund,final String selectedStockName) throws DBException, SQLException, ClassNotFoundException
	{

int sumOfBoughtStocks = 0;


	connnection = DBManager.getConnection();

	prepStatement1 = connnection.prepareStatement(DBConstants.GET_SELL_SUM_FUND);
	prepStatement1.setString(1, SelectFund);
	prepStatement1.setString(2, SelectFund);
	prepStatement1.setString(3, SelectFund);
	prepStatement1.setString(4, selectedStockName);
	prepStatement1.setString(5, SelectFund);
	prepStatement1.setString(6, SelectFund);
	prepStatement1.setString(7, SelectFund);

	resultSet = prepStatement1.executeQuery();

	while (resultSet.next()) {
		sumOfBoughtStocks = resultSet.getInt(1);
	}

	prepStatement1.close();
	resultSet.close();
	
return sumOfBoughtStocks;
}

	/**
	 * Gets the stock id.
	 *
	 * @param stockName the stock name
	 * @return the stock id
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public String getStockId(final String stockName) throws DBException, ClassNotFoundException, SQLException {
		String stockId = null;

			connnection = DBManager.getConnection();
			prepStatement1 = connnection.prepareStatement(DBConstants.GET_STOCK_ID);
			prepStatement1.setString(1, stockName);
			resultSet = prepStatement1.executeQuery();
			while (resultSet.next()) {
				stockId = resultSet.getString(1);
			}
			
			prepStatement1.close();
			resultSet.close();
			
		return stockId;
	}

	/**
	 * Gets the sell price.
	 *
	 * @param stockId the stock id
	 * @return the sell price
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public double getSellPrice(final String stockId) throws DBException, ClassNotFoundException, SQLException {
		double sellPrice = 0;

	
			connnection = DBManager.getConnection();
			prepStatement1 = connnection.prepareStatement(DBConstants.GET_SELL_PRICE);
			prepStatement1.setString(1, stockId);
			resultSet = prepStatement1.executeQuery();
			while (resultSet.next()) {
				sellPrice = resultSet.getDouble(1);}
		
			
			prepStatement1.close();
			resultSet.close();
			
		return sellPrice;
	}

	/**
	 * Gets the buy price.
	 *
	 * @param stockId the stock id
	 * @return the buy price
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public double getBuyPrice(final String stockId) throws DBException, ClassNotFoundException, SQLException {
		double buyPrice = 0;

		
			connnection = DBManager.getConnection();
			prepStatement1 = connnection.prepareStatement(DBConstants.GET_BUY_PRICE);
			prepStatement1.setString(1, stockId);
			resultSet = prepStatement1.executeQuery();
			while (resultSet.next()) {
				buyPrice = resultSet.getDouble(1);
			}
		
			prepStatement1.close();
			resultSet.close();
			
		return buyPrice;
	}

	/**
	 * Gets the profit range percent.
	 *
	 * @param profitPercent the profit percent
	 * @return the profit range percent
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public double getProfitRangePercent(final double profitPercent) throws DBException, ClassNotFoundException, SQLException {
		double perRangeProfit = 0;

		
			connnection = DBManager.getConnection();
			prepStatement1 = connnection.prepareStatement(DBConstants.GET_PROFIT_PER);

			prepStatement1.setDouble(1, profitPercent);
			prepStatement1.setDouble(2, profitPercent);
			resultSet = prepStatement1.executeQuery();

			while (resultSet.next()) {
				perRangeProfit = resultSet.getDouble(1);
			}
		
			prepStatement1.close();
			resultSet.close();
			
		return perRangeProfit;
	}

	/**
	 * Gets the balance.
	 *
	 * @param fundId the fund id
	 * @return the balance
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public double getBalance(final String fundId) throws DBException, ClassNotFoundException, SQLException {
		double balance = 0;
		
			connnection = DBManager.getConnection();
			prepStatement1 = connnection.prepareStatement(DBConstants.GET_BALANCE_FUND);
			prepStatement1.setString(1, fundId);
			resultSet = prepStatement1.executeQuery();
			while (resultSet.next()) {
				balance = resultSet.getDouble(1);
			}
		
			prepStatement1.close();
			resultSet.close();
			
		return balance;
	}
	
	/**
	 * Update balance fund.
	 *
	 * @param fundId the fund id
	 * @param balance the balance
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public void updateBalanceFund(final String fundId,final double balance) throws DBException, ClassNotFoundException, SQLException {
		
			connnection = DBManager.getConnection();
			prepStatement1 = connnection.prepareStatement(DBConstants.UPDATE_BAL_FUND);

			prepStatement1.setDouble(1, balance);
			prepStatement1.setString(2, fundId);

			prepStatement1.executeUpdate();

			prepStatement1.close();
			
	}
	
	/**
	 * Gets the transaction id.
	 *
	 * @return the transaction id
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public String getTransactionId() throws DBException, ClassNotFoundException, SQLException {
		String transactionId = "";
		
			connnection = DBManager.getConnection();
			statement = connnection.createStatement();
			resultSet = statement.executeQuery(DBConstants.GET_TRANS_ID);

			while (resultSet.next()) {

				transactionId = resultSet.getString(1);
			}// while ends
		
			statement.close();
			resultSet.close();
			
		return transactionId;
	}
	
	/**
	 * Sets the transaction details.
	 *
	 * @param tlId the tl id
	 * @param transactionId the transaction id
	 * @param userId the user id
	 * @param stockId the stock id
	 * @param noOfStocks the no of stocks
	 * @param amount the amount
	 * @param chargeback the chargeback
	 * @param balance the balance
	 * @param transactionType the transaction type
	 * @param fundId the fund id
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public void setTransactionDetails(final String tlId,final String transactionId,final String userId,final String stockId,final int noOfStocks, 
			final double amount,final double chargeback,final double balance,final String transactionType,final String fundId) throws DBException, ClassNotFoundException, SQLException
	{
		Timestamp currentTime;
		LOG.info(new Date()+"transaction details: transactionId- "+transactionId+" userId- "+userId+" Balance- "+balance+" chargeback- "+chargeback);
			connnection = DBManager.getConnection();
			prepStatement1=connnection.prepareStatement(DBConstants.SET_TRANS_FUND);
			
			prepStatement1.setString(1,tlId);
			prepStatement1.setString(2,transactionId);
			prepStatement1.setString(3,userId.trim());
			prepStatement1.setString(4,stockId.trim());
			prepStatement1.setInt(5,noOfStocks);
			prepStatement1.setDouble(6,amount);
			prepStatement1.setDouble(7,chargeback);
			prepStatement1.setDouble(8,balance);
			prepStatement1.setString(9,transactionType);
			
			
			currentTime = new Timestamp(System.currentTimeMillis());
			//System.out.println("T IS "+currentTime);
			
			prepStatement1.setTimestamp(10, currentTime);
			prepStatement1.setInt(11,1);
			prepStatement1.setString(12,fundId);
			//System.out.println(tlId+" "+transactionId+" "+userId+" "+stockId+" "+noOfStocks+" "+amount+" "+chargeback+" "+balance+" "+transactionType+" "+fundId);
			//System.out.println(tlId+""+transactionId+""+userId.trim()+""+stockId.trim()+""+noOfStocks+""+amount+" "+chargeback+" "+balance+" "+transactionType+""+fundId);
			//System.out.println("TLID"+tlId+" ussss "+ userId+" FUND "+fundId+ " USERID "+userId+" STOck "+stockId);
			prepStatement1.executeQuery();
			
			//System.out.println("Added");
			prepStatement1.close();
		
	}
	
	/**
	 * Gets the only buy stock data.
	 *
	 * @param selectedUser the selected user
	 * @return the only buy stock data
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public List getOnlyBuyStockData(final String selectedUser) throws DBException, ClassNotFoundException, SQLException {

		String fundId;
		String fundName;
		
		String stockName;
		double sellPrice;
		int sumOfBoughtStocks;

		final List userList = new ArrayList();

		FundVo fvObject = new FundVo();
		StockDetailsVo sdvObject = new StockDetailsVo();

		FundUserStockDetailsVo fusdvObject = new FundUserStockDetailsVo();

		
			connnection = DBManager.getConnection();
			prepStatement1 = connnection.prepareStatement(DBConstants.GET_ONLY_BUY_FUND);
			prepStatement1.setString(1, selectedUser);
			prepStatement1.setString(2, selectedUser);
			prepStatement1.setString(3, selectedUser);

			resultSet = prepStatement1.executeQuery();

			while (resultSet.next()) {
				fundId = resultSet.getString(1);
				fundName = resultSet.getString(2);
				stockName = resultSet.getString(3);
				sellPrice = resultSet.getDouble(4);
				sumOfBoughtStocks = resultSet.getInt(5);

				fvObject = new FundVo(fundId, fundName);
				
				sdvObject = new StockDetailsVo(stockName, sellPrice);
				

				fusdvObject = new FundUserStockDetailsVo(sumOfBoughtStocks);
				
				userList.add(fvObject);
				userList.add(sdvObject);
				userList.add(fusdvObject);
				

			}

			prepStatement1.close();
			resultSet.close();
		
		return userList;
	}

/**
 * Gets the only buy stock quantity.
 *
 * @param selectedUser the selected user
 * @param selectedStockName the selected stock name
 * @return the only buy stock quantity
 * @throws DBException the dB exception
 * @throws ClassNotFoundException the class not found exception
 * @throws SQLException the sQL exception
 */
public int getOnlyBuyStockQuantity(final String selectedUser,final String selectedStockName) throws DBException, ClassNotFoundException, SQLException {
		
		int sumOfBoughtStocks=0;
		
		
			connnection = DBManager.getConnection();

			prepStatement1=connnection.prepareStatement(DBConstants.GET_ONLY_BS_FUND);
			prepStatement1.setString(1,selectedUser);
			prepStatement1.setString(2,selectedUser);
			prepStatement1.setString(3,selectedStockName);
			prepStatement1.setString(4,selectedUser);

			resultSet=prepStatement1.executeQuery();
			//System.out.println("FUND IS "+selectedUser);
			//System.out.println("STOCK NAME IS "+selectedStockName);
			//System.out.println("STOCK COUNT OF ONLY BUY before while"+sumOfBoughtStocks);
			while (resultSet.next()) 
			{
				sumOfBoughtStocks=resultSet.getInt(1);
			}
			//System.out.println("STOCK COUNT OF ONLY BUY "+sumOfBoughtStocks);

		
			prepStatement1.close();
			resultSet.close();
			
		return sumOfBoughtStocks;
	}



/**
 * Insert new fund.
 *
 * @param newFundId the new fund id
 * @param fundName the fund name
 * @param userId the user id
 * @throws DBException the dB exception
 * @throws SQLException the sQL exception
 * @throws ClassNotFoundException the class not found exception
 */
public void insertNewFund(final String newFundId,final String fundName,final String userId[]) throws DBException, SQLException, ClassNotFoundException {

//System.out.println("DAO");

//String updateQuery;
	
	LOG.info(new Date()+"  New Fund inserted with fundname "+fundName+ " and fund id "+newFundId);

connnection = DBManager.getConnection();

prepStatement1 = connnection.prepareStatement(DBConstants.INSERT_NEW_FUND);
prepStatement1.setString(1, newFundId);
prepStatement1.setString(2, fundName);
resultSet=prepStatement1.executeQuery();

//System.out.println(fundName+ " added");

// rs1 = st.executeQuery(insertQuery);
for (int i = 0; i < userId.length; i++) {
	
	final PreparedStatement prepStatement2 = connnection.prepareStatement(DBConstants.UPDATE_USER_REG);
	prepStatement2.setString(1, newFundId);
	//System.out.println("for fund " + newFundId);
	prepStatement2.setString(2,userId[i].trim());
	//System.out.println("user " + id[i]);
	//System.out.println(DBConstants.UPDATE_USER_REGISTRATION);
	prepStatement2.executeUpdate();
	
	
	//System.out.println("updated");
	
	prepStatement2.close();
}

//System.out.println(newFundId);

prepStatement1.close();

resultSet.close();


}



//update fund balance
/**
 * Update fund balance.
 *
 * @param fundId the fund id
 * @param amount the amount
 * @throws DBException the dB exception
 * @throws ClassNotFoundException the class not found exception
 * @throws SQLException the sQL exception
 */
public void updateFundBalance(final String fundId,final double amount) throws DBException, ClassNotFoundException, SQLException
{

connnection = DBManager.getConnection();

prepStatement1 = connnection.prepareStatement(DBConstants.UPDATE_FUND_BAL);
prepStatement1.setDouble(1,amount);
prepStatement1.setString(2, fundId);
prepStatement1.executeUpdate();

prepStatement1.close();

}

/**
 * Gets the amount inv indl.
 *
 * @param userId the user id
 * @param stockName the stock name
 * @return the amount inv indl
 * @throws DBException the dB exception
 * @throws ClassNotFoundException the class not found exception
 * @throws SQLException the sQL exception
 */
public int[] getAmountInvIndl(final String userId,final String stockName) throws DBException, ClassNotFoundException, SQLException {
	int[] amountNumber=new int[3];

		connnection = DBManager.getConnection();
		prepStatement1=connnection.prepareStatement(DBConstants.GET_AMT_INDL);
		
		prepStatement1.setString(1, userId);
		prepStatement1.setString(2, stockName);
		resultSet=prepStatement1.executeQuery();
		//System.out.println("userid in dao"+userId);
		//System.out.println("stockname in dao"+stockName);
		
		while (resultSet.next()) {
			amountNumber[0]=resultSet.getInt(3);
			amountNumber[1]=resultSet.getInt(4);
		}// while ends
		//System.out.println("amount in dao"+a[0]);
		//System.out.println("no of stock in dao"+a[1]);
	

		prepStatement1.close();
		resultSet.close();
		
	return amountNumber;
}

/**
 * Gets the buy price from sname.
 *
 * @param stockName the stock name
 * @return the buy price from sname
 * @throws DBException the dB exception
 * @throws ClassNotFoundException the class not found exception
 * @throws SQLException the sQL exception
 */
public double getBuyPriceFromSname(final String stockName) throws DBException, ClassNotFoundException, SQLException {
	double buyPrice = 0;

	
		connnection = DBManager.getConnection();
		prepStatement1 = connnection.prepareStatement(DBConstants.GET_BPRICE_NAME);
		prepStatement1.setString(1, stockName);
		resultSet = prepStatement1.executeQuery();
		while (resultSet.next()) {
			buyPrice = resultSet.getDouble(1);
		}

		prepStatement1.close();
		resultSet.close();
		
	return buyPrice;
}


}

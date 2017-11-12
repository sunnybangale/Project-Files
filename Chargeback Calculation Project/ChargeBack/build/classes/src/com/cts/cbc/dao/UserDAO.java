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
import com.cts.cbc.vo.IndividualUserStockDetailsVo;
import com.cts.cbc.vo.StockDetailsVo;
import com.cts.cbc.vo.UserVo;






/**
 * The Class UserDAO.
 */
public class UserDAO{
	
	private transient Connection connection = null;
	private transient ResultSet resultSet = null;
	private transient Statement statement = null;
	private transient PreparedStatement preparedStatement=null;

	public static final Logger LOG=Logger.getLogger(UserDAO.class);
	private static final long serialVersionUID = 1L;
	
	/**
	 * Gets the user data.
	 *
	 * @return the user data
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public List<UserVo> getUserData()  throws DBException, SQLException, ClassNotFoundException{
		String userId;
		String firstName;
		String lastName;
		
		long mobile;
		double balanceDollar;
		double balanceCurrency;
		
		final List<UserVo> userList= new ArrayList<UserVo>();  
		UserVo uvObject=new UserVo();

		
			connection = DBManager.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(DBConstants.GET_DATA);

			while (resultSet.next()) {
				
				userId=resultSet.getString(1);
				firstName=resultSet.getString(2);
				lastName=resultSet.getString(3);
				
				mobile=resultSet.getLong(4);
				balanceDollar=resultSet.getDouble(5);
				balanceCurrency=resultSet.getDouble(6);
				
				uvObject= new UserVo(userId,firstName,lastName,mobile,balanceDollar,balanceCurrency);
				/*
				uv.setUserId(userId);
				uv.setFirstName(firstName);
				uv.setLastName(lastName);
				uv.setMobile(mobile);
				uv.setBalanceDollar(balanceDollar);
				uv.setBalanceCurrency(balanceCurrency);
				*/
				
				userList.add(uvObject);
				
		
			
			
			}
		
			
				
				statement.close();
				resultSet.close();
			
			
		
		return userList;
	}
	
	
	
	/**
	 * Gets the sell stock data.
	 *
	 * @param selectedUser the selected user
	 * @return the sell stock data
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public List getSellStockData(final String selectedUser) throws DBException, ClassNotFoundException, SQLException {
		
		String userId;
		String firstName;
		String lastName;
		
		long mobile;
		String stockName;
		double sellPrice;
		int sumOfBoughtStocks;
	
		
		final List userList= new ArrayList();
		
		UserVo uvObject=new UserVo();
		StockDetailsVo sdvObject= new StockDetailsVo();		
		
		IndividualUserStockDetailsVo iusdvObject = new IndividualUserStockDetailsVo();
		
	
			connection = DBManager.getConnection();
			preparedStatement=connection.prepareStatement(DBConstants.GET_SELL_STOCK);
			preparedStatement.setString(1,selectedUser);
			preparedStatement.setString(2,selectedUser);
			preparedStatement.setString(3,selectedUser);
			
			
			resultSet=preparedStatement.executeQuery();
				
			while (resultSet.next()) {
				
				stockName=resultSet.getString(1);
				userId=resultSet.getString(2);
				firstName=resultSet.getString(3);
				lastName=resultSet.getString(4);
				
				mobile=resultSet.getLong(5);
				sellPrice=resultSet.getDouble(6);
				sumOfBoughtStocks=resultSet.getInt(7);
				
				uvObject= new UserVo(userId,firstName,lastName,mobile);
				/*
				uv.setUserId(userId);
				uv.setFirstName(firstName);
				uv.setLastName(lastName);
				uv.setMobile(mobile);
				 */
				
				sdvObject=new StockDetailsVo(stockName,sellPrice); 
				/*
				sdv.setStockName(stockName);
				sdv.setSellPrice(sellPrice);
				*/
				
				iusdvObject= new IndividualUserStockDetailsVo(sumOfBoughtStocks);
				/*
				iusdv.setSumOfBoughtStocks(sumOfBoughtStocks);
				iusdv.setTransactionType(transactionType);
				*/
				
				userList.add(uvObject);
				userList.add(sdvObject);
				userList.add(iusdvObject);
				//System.out.println("added!!!");
				
				
				
			}
			

			preparedStatement.close();
			resultSet.close();

		return userList;
	}
	
	
/**
 * Gets the sell stock quantity.
 *
 * @param selectedUser the selected user
 * @param selectedStockName the selected stock name
 * @return the sell stock quantity
 * @throws DBException the dB exception
 * @throws SQLException the sQL exception
 * @throws ClassNotFoundException the class not found exception
 */
public int getSellStockQuantity(final String selectedUser,final String selectedStockName) throws DBException, SQLException, ClassNotFoundException {
		
		int sumOfBoughtStocks=0;
		
		
			connection = DBManager.getConnection();

			preparedStatement=connection.prepareStatement(DBConstants.GET_SELL_SUM);
			preparedStatement.setString(1,selectedUser);
			preparedStatement.setString(2,selectedUser);
			preparedStatement.setString(3,selectedUser);
			preparedStatement.setString(4,selectedStockName) ;

			resultSet=preparedStatement.executeQuery();
				
			while (resultSet.next()) 
			{
				sumOfBoughtStocks=resultSet.getInt(2);
			}
			

		
			preparedStatement.close();
			resultSet.close();
			
		return sumOfBoughtStocks;
	}


////////////
/**
 * Gets the stock id.
 *
 * @param stockName the stock name
 * @return the stock id
 * @throws DBException the dB exception
 * @throws ClassNotFoundException the class not found exception
 * @throws SQLException the sQL exception
 */
public String getStockId(final String stockName) throws DBException, ClassNotFoundException, SQLException
{
	String stockId=null;
	
	
			connection = DBManager.getConnection();
			preparedStatement=connection.prepareStatement(DBConstants.GET_STOCK_ID);
			preparedStatement.setString(1,stockName);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
			stockId = resultSet.getString(1); 
			}

			preparedStatement.close();
			resultSet.close();
			
	return stockId;
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
public double getBuyPrice(final String stockId) throws DBException, ClassNotFoundException, SQLException
{
	double buyPrice=0;
	
	
			connection = DBManager.getConnection();
			preparedStatement=connection.prepareStatement(DBConstants.GET_BUY_PRICE);
			preparedStatement.setString(1,stockId);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
			buyPrice=resultSet.getDouble(1);
			}
	
	
			preparedStatement.close();
			resultSet.close();
			
	return buyPrice;
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
public double getSellPrice(final String stockId) throws DBException, ClassNotFoundException, SQLException
{
	double sellPrice=0;
	
	
			connection = DBManager.getConnection();
			preparedStatement=connection.prepareStatement(DBConstants.GET_SELL_PRICE);
			preparedStatement.setString(1,stockId);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
			sellPrice=resultSet.getDouble(1);
			}
			
			preparedStatement.close();
			resultSet.close();
			
	return sellPrice;
}
//////////////////////

/**
 * Gets the profit range percent.
 *
 * @param profitPercent the profit percent
 * @return the profit range percent
 * @throws DBException the dB exception
 * @throws ClassNotFoundException the class not found exception
 * @throws SQLException the sQL exception
 */
public double getProfitRangePercent( final double profitPercent) throws DBException, ClassNotFoundException, SQLException
{
	double perRangeProfit=0;
	
	
		connection = DBManager.getConnection();
		preparedStatement=connection.prepareStatement(DBConstants.GET_PROFIT_PER);
		
		preparedStatement.setDouble(1,profitPercent);
		preparedStatement.setDouble(2,profitPercent);
		resultSet=preparedStatement.executeQuery();
			
		while(resultSet.next())
		{
			perRangeProfit=resultSet.getDouble(1);
		}
	
	
		preparedStatement.close();
		resultSet.close();
		
	return perRangeProfit;
}
	
////////////////////////

/**
 * Gets the balance.
 *
 * @param userId the user id
 * @return the balance
 * @throws DBException the dB exception
 * @throws ClassNotFoundException the class not found exception
 * @throws SQLException the sQL exception
 */
public double getBalance(final String userId) throws DBException, ClassNotFoundException, SQLException
{
	double balance=0;
	
			connection = DBManager.getConnection();
			preparedStatement=connection.prepareStatement(DBConstants.GET_BALANCE);
			preparedStatement.setString(1,userId);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
			balance = resultSet.getDouble(1); 
			}
			preparedStatement.close();
			resultSet.close();

			return balance;
}


/**
 * Update balance.
 *
 * @param userId the user id
 * @param balance the balance
 * @param currency the currency
 * @throws DBException the dB exception
 * @throws ClassNotFoundException the class not found exception
 * @throws SQLException the sQL exception
 */
public void updateBalance(final String userId,final double balance,final double currency)throws DBException, ClassNotFoundException, SQLException
{
	
		connection = DBManager.getConnection();
		preparedStatement=connection.prepareStatement(DBConstants.UPDATE_BALANCE);
		
		preparedStatement.setDouble(1,balance);
		preparedStatement.setDouble(2,currency);
		
		preparedStatement.setString(3,userId);
		
		preparedStatement.executeUpdate();
		//rs=pst.executeQuery();
		//System.out.println("Updated");
		
	
		preparedStatement.close();
		
		
} 

////////////////
/**
 * Gets the sell stock count.
 *
 * @param userId the user id
 * @return the sell stock count
 * @throws DBException the dB exception
 * @throws ClassNotFoundException the class not found exception
 * @throws SQLException the sQL exception
 */
public int getSellStockCount(final String userId) throws DBException, ClassNotFoundException, SQLException 
{
int countTransactions=0;
	
	
		connection = DBManager.getConnection();
		preparedStatement=connection.prepareStatement(DBConstants.COUNT_SELL_STOCK);
		
		preparedStatement.setString(1,userId);
		
		preparedStatement.setString(1,userId);
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
		countTransactions = resultSet.getInt(1); 
		}
		
	
		preparedStatement.close();
		resultSet.close();
		
return countTransactions;
}


/**
 * Gets the buy stock data.
 *
 * @param selectedUser the selected user
 * @return the buy stock data
 * @throws DBException the dB exception
 * @throws SQLException the sQL exception
 * @throws ClassNotFoundException the class not found exception
 */
public List getBuyStockData(final String selectedUser) throws DBException, SQLException, ClassNotFoundException {
	
	String userId;
	String firstName;
	String lastName;
	
	long mobile;
	String stockName;
	double sellPrice;
	int sumOfBoughtStocks;

	
	final List userList= new ArrayList();
	
	UserVo uvObject=new UserVo();
	StockDetailsVo sdvObject= new StockDetailsVo();		
	
	IndividualUserStockDetailsVo iusdvObject = new IndividualUserStockDetailsVo();
	
	
		connection = DBManager.getConnection();
		preparedStatement=connection.prepareStatement(DBConstants.GET_BUY_DATA);
		preparedStatement.setString(1,selectedUser);
		
		resultSet=preparedStatement.executeQuery();
			
		while (resultSet.next()) {
			
			
			userId=resultSet.getString(1);
			firstName=resultSet.getString(2);
			lastName=resultSet.getString(3);
			
			mobile=resultSet.getLong(4);
			stockName=resultSet.getString(5);
			sellPrice=resultSet.getDouble(6);
			sumOfBoughtStocks=resultSet.getInt(7);
			
			uvObject= new UserVo(userId,firstName,lastName,mobile);
			/*
			uv.setUserId(userId);
			uv.setFirstName(firstName);
			uv.setLastName(lastName);
			uv.setMobile(mobile);
			 */
			
			sdvObject=new StockDetailsVo(stockName,sellPrice); 
			/*
			sdv.setStockName(stockName);
			sdv.setSellPrice(sellPrice);
			*/
			
			iusdvObject= new IndividualUserStockDetailsVo(sumOfBoughtStocks);
			/*
			iusdv.setSumOfBoughtStocks(sumOfBoughtStocks);
			iusdv.setTransactionType(transactionType);
			*/
			
			userList.add(uvObject);
			userList.add(sdvObject);
			userList.add(iusdvObject);
			//System.out.println("added!!!");
			
			
			
		}
		

		preparedStatement.close();
		resultSet.close();

	return userList;
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
public int getBuyStockQuantity(final String selectedUser, final String selectedStockName) throws DBException, SQLException, ClassNotFoundException {
	
	int sumOfBoughtStocks=0;
	
	
		connection = DBManager.getConnection();

		preparedStatement=connection.prepareStatement(DBConstants.GET_BUY_STOCK_SUM);
		preparedStatement.setString(1,selectedUser);
		preparedStatement.setString(2,selectedStockName) ;

		resultSet=preparedStatement.executeQuery();
			
		while (resultSet.next()) 
		{
			sumOfBoughtStocks=resultSet.getInt(1);
		}
		

		preparedStatement.close();
		resultSet.close();

	return sumOfBoughtStocks;
}

///////ash

/**
 * Gets the buy stock details.
 *
 * @return the buy stock details
 * @throws DBException the dB exception
 * @throws SQLException the sQL exception
 * @throws ClassNotFoundException the class not found exception
 */
public List<StockDetailsVo> getBuyStockDetails() throws DBException, SQLException, ClassNotFoundException {

	String stockId;
	String stockName;
	
	double buyPrice;
	
	final List<StockDetailsVo> stockList = new ArrayList<StockDetailsVo>();
	StockDetailsVo sdvObject=new StockDetailsVo();
	
		connection = DBManager.getConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(DBConstants.GET_BUY_STOCK);
		
		while (resultSet.next()) {

			stockId = resultSet.getString(1);
			//System.out.println(stockId);
			stockName = resultSet.getString(2);
			//System.out.println(stockName);
			
			buyPrice = resultSet.getDouble(3);

			sdvObject= new StockDetailsVo(stockId, stockName,buyPrice);
			
			stockList.add(sdvObject);
			
			
		}// while ends
	
		statement.close();
		resultSet.close();
		
	return stockList;

}// func ends




/**
 * Gets the range percent.
 *
 * @param total_Stock_Price the total_ stock_ price
 * @return the range percent
 * @throws DBException the dB exception
 * @throws SQLException the sQL exception
 * @throws ClassNotFoundException the class not found exception
 */
public  double getRangePercent(final double total_Stock_Price) throws DBException, SQLException, ClassNotFoundException
{
	 double percentRange=0;
	
	
		connection = DBManager.getConnection();
		preparedStatement=connection.prepareStatement(DBConstants.GET_PERCENT);
		preparedStatement.setDouble(1,total_Stock_Price);
		preparedStatement.setDouble(2,total_Stock_Price);
		//System.out.println(total_Stock_Price);
		
		resultSet=preparedStatement.executeQuery();
		
			
		while(resultSet.next())
		{
			
			percentRange=resultSet.getDouble(1);
		}
		
		preparedStatement.close();
		resultSet.close();
		
	return percentRange;
}//func ends


	/**
	 * Gets the transaction id.
	 *
	 * @return the transaction id
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public String getTransactionId() throws DBException, ClassNotFoundException, SQLException
	{
		String transactionId="";
		
		
			connection = DBManager.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(DBConstants.GET_TRANS_ID);

			while (resultSet.next()) {
				
				transactionId=resultSet.getString(1);
			}//while ends
			
			statement.close();
			resultSet.close();
			
	return transactionId;
	} 

	 
	/**
	 * Sets the transaction details.
	 *
	 * @param transactionId the transaction id
	 * @param userId the user id
	 * @param stockId the stock id
	 * @param noOfStocks the no of stocks
	 * @param chargeback the chargeback
	 * @param balance the balance
	 * @param transactionType the transaction type
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public void setTransactionDetails(final String transactionId,final String userId,final String stockId,final int noOfStocks,final double chargeback,final double balance,final String transactionType) throws DBException, SQLException, ClassNotFoundException
	{
		Timestamp currentTime;
		LOG.info(new Date()+"transaction details: transactionId- "+transactionId+" userId- "+userId+" Balance- "+balance+" chargeback- "+chargeback);
			connection = DBManager.getConnection();
			preparedStatement=connection.prepareStatement(DBConstants.SET_TRANS_DETAILS);
			preparedStatement.setString(1,transactionId);
			preparedStatement.setString(2,userId);
			preparedStatement.setString(3,stockId);
			preparedStatement.setInt(4,noOfStocks);
			preparedStatement.setDouble(5,chargeback);
			preparedStatement.setDouble(6,balance);
			preparedStatement.setString(7,transactionType);
			
			currentTime = new Timestamp(System.currentTimeMillis());
			preparedStatement.setTimestamp(8, currentTime);
			preparedStatement.executeQuery();
//			System.out.println("Added");	
			
			preparedStatement.close();
		
	}
	

	/**
	 * Gets the only buy stock data.
	 *
	 * @param selectedUser the selected user
	 * @return the only buy stock data
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public List getOnlyBuyStockData(final String selectedUser) throws DBException, SQLException, ClassNotFoundException {
		
		String userId;
		String firstName;
		String lastName;
		
		long mobile;
		String stockName;
		double sellPrice;
		int sumOfBoughtStocks;

		
		final  List userList= new ArrayList();
		
		UserVo uvObject=new UserVo();
		StockDetailsVo sdvObject= new StockDetailsVo();		
		
		IndividualUserStockDetailsVo iusdvObject = new IndividualUserStockDetailsVo();
		
			connection = DBManager.getConnection();
			preparedStatement=connection.prepareStatement(DBConstants.GET_ONLY_BUY);
			preparedStatement.setString(1,selectedUser);
			preparedStatement.setString(2,selectedUser);
			
			resultSet=preparedStatement.executeQuery();
				
			while (resultSet.next()) {
				
				
				stockName=resultSet.getString(1);
				userId=resultSet.getString(2);
				firstName=resultSet.getString(3);
				lastName=resultSet.getString(4);
				
				mobile=resultSet.getLong(5);
				sellPrice=resultSet.getDouble(6);
				sumOfBoughtStocks=resultSet.getInt(7);
				
				uvObject= new UserVo(userId,firstName,lastName,mobile);
				/*
				uv.setUserId(userId);
				uv.setFirstName(firstName);
				uv.setLastName(lastName);
				uv.setMobile(mobile);
				 */
				
				sdvObject=new StockDetailsVo(stockName,sellPrice); 
				/*
				sdv.setStockName(stockName);
				sdv.setSellPrice(sellPrice);
				*/
				
				iusdvObject= new IndividualUserStockDetailsVo(sumOfBoughtStocks);
				/*
				iusdv.setSumOfBoughtStocks(sumOfBoughtStocks);
				iusdv.setTransactionType(transactionType);
				*/
				
				userList.add(uvObject);
				userList.add(sdvObject);
				userList.add(iusdvObject);
				//System.out.println("added!!!");
				
				
				
			}
			

			preparedStatement.close();
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
		
		
			connection = DBManager.getConnection();

			preparedStatement=connection.prepareStatement(DBConstants.GET_ONLY_BUY_SUM);
			preparedStatement.setString(1,selectedUser);
			preparedStatement.setString(2,selectedStockName);
			preparedStatement.setString(3,selectedUser);

			resultSet=preparedStatement.executeQuery();
				
			while (resultSet.next()) 
			{
				sumOfBoughtStocks=resultSet.getInt(1);
			}
			

			preparedStatement.close();
			resultSet.close();

		return sumOfBoughtStocks;
	}
	

}

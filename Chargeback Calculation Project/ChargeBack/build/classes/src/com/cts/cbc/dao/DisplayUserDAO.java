package com.cts.cbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.cts.cbc.exceptions.DBException;
import com.cts.cbc.util.DBConstants;
import com.cts.cbc.util.DBManager;
import com.cts.cbc.vo.TransactiondetailsForFundVo;
import com.cts.cbc.vo.TransactiondetailsForIndividualVo;
import com.cts.cbc.vo.UserVo;

/**
 * The Class DisplayUserDAO.
 */
public class DisplayUserDAO {

	private transient Connection connection = null;
	private transient ResultSet resultSet = null;
	private transient PreparedStatement preparedStatement = null;

	/**
	 * Gets the transactionsdetail for individual user.
	 *
	 * @param voObject the vo object
	 * @return the transactionsdetail for individual user
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public List<TransactiondetailsForIndividualVo> getTransactionsdetailForIndividualUser(final UserVo voObject) throws DBException, SQLException, ClassNotFoundException {
		
		TransactiondetailsForIndividualVo tvo;
		
		final List<TransactiondetailsForIndividualVo> transactionList = new ArrayList<TransactiondetailsForIndividualVo>();
		
		
			connection = DBManager.getConnection();
			preparedStatement = connection
					.prepareStatement(DBConstants.GET_DISPLAY_INDL);
			preparedStatement.setString(1, voObject.getUserId());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				final Timestamp transTimestamp = resultSet.getTimestamp(8);
				final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss",Locale.getDefault());
				final String dateFormat = sdf.format(transTimestamp);
				tvo = new TransactiondetailsForIndividualVo(
						resultSet.getString(1),
						resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4),
						resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getString(7), dateFormat);
				transactionList.add(tvo);

			}

			preparedStatement.close();
			resultSet.close();

		return transactionList;

	}

	/**
	 * Gets the transactionsdetail for fund user.
	 *
	 * @param voObject the vo object
	 * @return the transactionsdetail for fund user
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public List<TransactiondetailsForFundVo> getTransactionsdetailForFundUser(final UserVo voObject) throws DBException, ClassNotFoundException, SQLException 
	{
		TransactiondetailsForFundVo tvo;
	
		final List<TransactiondetailsForFundVo> transactionList = new ArrayList<TransactiondetailsForFundVo>();
		
	
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(DBConstants.GET_DISPLAY_FUND);
			preparedStatement.setString(1, voObject.getUserId());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				final Timestamp transTimestamp = resultSet.getTimestamp(9);
				final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss",Locale.getDefault());
				final String dateFormat = sdf.format(transTimestamp);
				tvo = new TransactiondetailsForFundVo(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getDouble(5),resultSet.getDouble(6),resultSet.getDouble(7),resultSet.getString(8), dateFormat, resultSet.getInt(10), resultSet.getString(11));
				transactionList.add(tvo);

			}

			preparedStatement.close();
			resultSet.close();

		return transactionList;

	}
}

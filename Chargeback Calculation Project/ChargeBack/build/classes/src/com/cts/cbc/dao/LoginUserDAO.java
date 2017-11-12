package com.cts.cbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cts.cbc.bo.UserBO;
import com.cts.cbc.exceptions.DBException;
import com.cts.cbc.util.DBConstants;
import com.cts.cbc.util.DBManager;
import com.cts.cbc.vo.UserVo;

/**
 * The Class LoginUserDAO.
 */
public class LoginUserDAO {
	public static final Logger LOG = Logger.getLogger(LoginUserDAO.class);
	
	private transient Connection connection = null;
	private transient ResultSet resultSet = null;
//	private transient Statement statement = null;
	private transient PreparedStatement preparedStatement = null;
	
	
	/**
	 * Gets the user data.
	 *
	 * @return the user data
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public List<UserVo> getUserData() throws DBException, SQLException, ClassNotFoundException {

		// Map<String, String> userData = new HashMap<String, String>();
		UserVo userData;
		final List<UserVo> userList = new ArrayList<UserVo>();

		
			connection = DBManager.getConnection();
			final Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(DBConstants.GET_LOGIN_INFO);
			while (resultSet.next()) {
				// userData.put(rs.getString(1), rs.getString(2));
				userData = new UserVo();
				userData.setUserId(resultSet.getString(1));
				userData.setPassword(resultSet.getString(2));
				userData.setRoleType(resultSet.getString(3));
				userList.add(userData);
			}

			statement.close();
			resultSet.close();

		return userList;
	}

	/**
	 * Setuser.
	 *
	 * @param voObject the vo object
	 * @return the string
	 * @throws SQLException the sQL exception
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public String setUser(final UserVo voObject) throws SQLException, DBException, ClassNotFoundException {
		String userId = null;
		String fundId= null;
		
	
			connection = DBManager.getConnection();

			preparedStatement=connection.prepareStatement(DBConstants.GET_USERID);
			preparedStatement.setString(1,voObject.getFirstName());
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				
				 userId=resultSet.getString(1);
			}
			
			
			if(voObject.getRoleType().equals("INDL"))
			{
				fundId="0";
			}
			else if(voObject.getRoleType().equals("FUND"))
			{
				fundId="FUND000";
			}
			
			final double balancecurrency = new UserBO().convertCurrencyFromDollarToRupees(voObject.getBalanceDollar());

			preparedStatement=connection.prepareStatement(DBConstants.SET_REGISTRATION);
			preparedStatement.setString(1,userId);
			preparedStatement.setString(2, voObject.getPassword());
			preparedStatement.setString(3, voObject.getFirstName());
			preparedStatement.setString(4, voObject.getLastName());
			preparedStatement.setString(5, voObject.getGender());
			preparedStatement.setLong(6, voObject.getAge());
			preparedStatement.setLong(7, voObject.getMobile());
			preparedStatement.setString(8, voObject.getEmail());
			preparedStatement.setString(9, voObject.getCountry());
			preparedStatement.setString(10, voObject.getCity());
			preparedStatement.setString(11, voObject.getAddress());
			preparedStatement.setInt(12, voObject.getZipCode());
			preparedStatement.setDouble(13,voObject.getBalanceDollar());
			 preparedStatement.setDouble(14,balancecurrency);
			preparedStatement.setString(15, voObject.getRoleType());
		    preparedStatement.setString(16,fundId);
				
			
			
			preparedStatement.executeUpdate();
			
					
			
			//System.out.println("inserted");

			preparedStatement.close();
			resultSet.close();

		
		return userId;
	}
	
	
	/**
	 * Validate password.
	 *
	 * @param userId the user id
	 * @param mobile the mobile
	 * @return the string
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public String validatePassword( final String userId,final  String mobile) throws DBException, ClassNotFoundException, SQLException {
	     String password=null;
	     
	   
				connection = DBManager.getConnection();

	      preparedStatement=connection.prepareStatement(DBConstants.GET_PASSWORD);
				
				preparedStatement.setString(1,userId);
				preparedStatement.setString(2,mobile);
				resultSet=preparedStatement.executeQuery();
				while(resultSet.next())
				{
					password=resultSet.getString(1);
					//System.out.println(password);
				}
	   
				

				preparedStatement.close();
				resultSet.close();

			
			
			return password;
		}

	

}

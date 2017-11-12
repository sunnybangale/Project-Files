package com.cts.cbc.bo;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.cts.cbc.dao.LoginUserDAO;
import com.cts.cbc.exceptions.BusinessException;
import com.cts.cbc.exceptions.DBException;
import com.cts.cbc.util.MyUtil;
import com.cts.cbc.vo.UserVo;

/**
 * The Class UserBO.
 */
public class UserBO {

	/**
	 * Validate user.
	 *
	 * @param voObject the vo object
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public boolean validateUser(final UserVo voObject) throws BusinessException,
			DBException, SQLException, ClassNotFoundException {
		boolean status = false;
		if (userValidationForEmpty(voObject)) {
			status = userValidation(voObject);
		}
		//System.out.println("status");
		return status;

	}

	/**
	 * User validation for empty.
	 *
	 * @param voObject the vo object
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws DBException the dB exception
	 */
	private boolean userValidationForEmpty(final UserVo voObject) throws BusinessException,	DBException {
		boolean status = false;
		if (voObject.getUserId().equals("") || voObject.getPassword().equals("") 
				|| voObject.getRoleType().equals("") || voObject.getUserId()==(null) || voObject.getPassword()==(null) 
				|| voObject.getRoleType()==(null)) {
			//throw new BusinessException(MyUtil.getMes("rule_prob"));
			
		} else {
			status = true;
		}
		//System.out.println(vo.getUserId()+vo.getPassword()+vo.getRoleType());
		//System.out.println("empty" + status);
		return status;

	}

	/**
	 * User validation.
	 *
	 * @param voObject the vo object
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws DBException the dB exception
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	private boolean userValidation(final UserVo voObject) throws BusinessException,
			DBException, SQLException, ClassNotFoundException {
		boolean status = false;
		
		final LoginUserDAO dao = new LoginUserDAO();
		final List<UserVo> userData = dao.getUserData();

		final Iterator<UserVo> iterator = userData.iterator();

		while (iterator.hasNext()) {
			final UserVo uvTemporary = iterator.next();
			//System.out.println(v.getUserId()+v.getPassword()+v.getRoleType());
			//System.out.println(vo.getUserId()+vo.getPassword()+vo.getRoleType());
			if (voObject.getUserId().equals(uvTemporary.getUserId())
					&& voObject.getPassword().equals(uvTemporary.getPassword())
					&& voObject.getRoleType().equals(uvTemporary.getRoleType())) {

				status = true;
			}
		}

		//System.out.println("user" + status);
		return status;

	}

	/**
	 * Validate user for registration.
	 *
	 * @param voObject the vo object
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws DBException the dB exception
	 */
	public boolean validateUserForRegistration(final UserVo voObject)	throws BusinessException, DBException
	{
		boolean status = false;
		if (userRegistrationValidationForEmpty(voObject)) {
			status = userRegistrationValidation(voObject);
		}
		return status;

	}

	/**
	 * User registration validation for empty.
	 *
	 * @param voObject the vo object
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws DBException the dB exception
	 */
	private boolean userRegistrationValidationForEmpty(final UserVo voObject)
			throws BusinessException, DBException {
		boolean status = false;
		if (voObject.getFirstName().equals("") || voObject.getLastName().equals("") || voObject.getPassword().equals("") || voObject.getRoleType().equals("")
				|| voObject.getGender().equals("") || String.valueOf(voObject.getAge()).equals("") || String.valueOf(voObject.getMobile()).equals("") || voObject.getAddress().equals("")
				|| voObject.getEmail().equals("") || String.valueOf(voObject.getBalanceDollar()) .equals("") || voObject.getCountry().equals("") || voObject.getFirstName()==(null) 
				|| voObject.getLastName()==(null) || voObject.getPassword()==(null) || voObject.getRoleType()==(null)
				|| voObject.getGender()==(null) || String.valueOf(voObject.getAge())==(null) || String.valueOf(voObject.getMobile())==(null) || voObject.getAddress()==(null)
				|| voObject.getEmail()==(null) || String.valueOf(voObject.getBalanceDollar()) ==(null) || voObject.getCountry()==(null) ) {
			
			status=false;
			throw new BusinessException(MyUtil.getMes("rule_prob"));
		} else {
			status = true;
		}

		return status;

	}

	/**
	 * User registration validation.
	 *
	 * @param voObject the vo object
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws DBException the dB exception
	 */
	private boolean userRegistrationValidation(final UserVo voObject)
			throws BusinessException, DBException {
		boolean status = false;

		final String testFirstName = voObject.getFirstName();
		final String testLastName = voObject.getLastName();
		final int testAge = voObject.getAge();
		
		final String testEmail = voObject.getEmail();
		final long mobile = voObject.getMobile();
		final String testpassword = voObject.getPassword();
		
		
		int flagPassword=0;
		if(testpassword.length()<8)
		{
			flagPassword=1;
		}
		
		int flagMobile=0;
		final String testMobile = String.valueOf(mobile);
		if(testMobile.length()<10)
		{
			flagMobile=1;
		}

		int flagLastName = 0;
		for (int i = 0; i < testLastName.length(); i++) {
			if (Character.isDigit(testLastName.charAt(i))) {
				flagLastName = 1;
			}

		}
		if (testLastName.length() > 20) {
			flagLastName = 1;
		}

		int flagFirstName = 0;
		for (int i = 0; i < testFirstName.length(); i++) {
			if (Character.isDigit(testFirstName.charAt(i))) {
				flagFirstName = 1;
			}

		}
		if (testFirstName.length() > 20) {
			flagFirstName = 1;
		}

		int flagAge = 0;
		if (testAge < 21) {
			flagAge = 1;
		}

		int flagEmail = 0;
		int flagAt = 0;
		int flagDot = 0;
		for (int i = 0; i < testEmail.length(); i++) {

			if (flagAt == 1 && flagDot == 1) {
				if (testEmail.charAt(i) == '@') {
					flagEmail = 1;
				} else if (testEmail.charAt(i) == '.') {
					flagEmail = 1;
				}
			}
			if (flagAt == 1) {
				if (testEmail.charAt(i) == '@') {
					flagEmail = 1;
				} else if (testEmail.charAt(i) == '.') {
					flagDot = 1;
				}
			}

			if (testEmail.charAt(i) == '@') {
				flagAt = 1;
			}

		}

		if (flagFirstName == 1 || flagLastName == 1 || flagAge == 1	|| flagEmail == 1 || flagMobile ==1 || flagPassword==1)
		{
			status=false;
			throw new BusinessException(MyUtil.getMes("rule_prob"));
		} else {
			status = true;
		}
		return status;

	}

	
	/**
	 * Convert currency from dollar to rupees.
	 *
	 * @param balanceInDollar the balance in dollar
	 * @return the double
	 */
	public double convertCurrencyFromDollarToRupees(final double balanceInDollar){

		
		double balanceInRupees = 0;
		
		balanceInRupees=balanceInDollar*67;
		
		
        return balanceInRupees;

} 
	
	
	/**
	 * Validate user for password.
	 *
	 * @param userId the user id
	 * @param mobile the mobile
	 * @return the string
	 * @throws DBException the dB exception
	 * @throws BusinessException the business exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public String validateUserForPassword(final String userId,final  String mobile) throws DBException,
	BusinessException, ClassNotFoundException, SQLException {

//boolean b =false;
String password = null;
final LoginUserDAO dao = new LoginUserDAO();

if(userId!=null && mobile!=null && !userId.equals("") && !mobile.equals("")){
	
	password = dao.validatePassword(userId, mobile);
	
}

return password;
}
	
}

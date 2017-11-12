package com.cts.cbc.vo;



/**
 * The Class UserVo.
 */
public class UserVo  {
 
	
	private String userId;
	private String password;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private long mobile;
	private String email;
	private String country;
	private String state;
	private String city;
	private String address;
	private int zipCode;
	private double balanceDollar;
	private double balanceCurrency;
	private String roleType;
	private String fundId;


	
	
	/**
	 * Instantiates a new user vo.
	 */
	public UserVo() {
		// TODO Auto-generated constructor stub
	}
	

/**
 * Instantiates a new user vo.
 *
 * @param userId the user id
 * @param firstName the first name
 * @param lastName the last name
 * @param mobile the mobile
 * @param balanceDollar the balance dollar
 * @param balanceCurrency the balance currency
 */
public UserVo(final String userId,final String firstName,final String lastName,final long mobile,final double balanceDollar,final double balanceCurrency) 
{

this.userId=userId;
this.firstName=firstName;
this.lastName=lastName;
this.mobile=mobile;
this.balanceDollar=balanceDollar;
this.balanceCurrency=balanceCurrency;

}


/**
 * Instantiates a new user vo.
 *
 * @param userId the user id
 * @param firstName the first name
 * @param lastName the last name
 * @param mobile the mobile
 */
public UserVo(final String userId,final String firstName,final String lastName,final long mobile) 
{
this.userId=userId;
this.firstName=firstName;
this.lastName=lastName;
this.mobile=mobile;
}
	
	
/**
 * Instantiates a new user vo.
 *
 * @param firstName the first name
 * @param lastName the last name
 * @param password the password
 * @param roleType the role type
 * @param gender the gender
 * @param age the age
 * @param mobile the mobile
 * @param email the email
 * @param address the address
 * @param city the city
 * @param zipCode the zip code
 * @param balanceDollar the balance dollar
 * @param country the country
 */
public UserVo(final String firstName,final  String lastName,final  String password,final 
		String roleType,final  String gender,final  int age,final  long mobile,final  String email,
		final String address,final String city,final int zipCode,final double balanceDollar,final String country) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.password = password;
	this.roleType = roleType;
	this.gender = gender;
	this.age = age;
	this.mobile = mobile;
	this.email = email;
	this.address = address;
	this.city=city;
	this.zipCode=zipCode;
	this.balanceDollar=balanceDollar;
	this.country=country;
	
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
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(final String password) {
		this.password = password;
	}
	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(final String gender) {
		this.gender = gender;
	}
	
	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(final int age) {
		this.age = age;
	}
	
	/**
	 * Gets the mobile.
	 *
	 * @return the mobile
	 */
	public long getMobile() {
		return mobile;
	}
	
	/**
	 * Sets the mobile.
	 *
	 * @param mobile the new mobile
	 */
	public void setMobile(final long mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(final String email) {
		this.email = email;
	}
	
	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(final String country) {
		this.country = country;
	}
	
	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(final String state) {
		this.state = state;
	}
	
	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(final String city) {
		this.city = city;
	}
	
	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(final String address) {
		this.address = address;
	}
	
	/**
	 * Gets the zip code.
	 *
	 * @return the zip code
	 */
	public int getZipCode() {
		return zipCode;
	}
	
	/**
	 * Sets the zip code.
	 *
	 * @param zipCode the new zip code
	 */
	public void setZipCode(final int zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * Gets the balance dollar.
	 *
	 * @return the balance dollar
	 */
	public double getBalanceDollar() {
		return balanceDollar;
	}
	
	/**
	 * Sets the balance dollar.
	 *
	 * @param balanceDollar the new balance dollar
	 */
	public void setBalanceDollar(final double balanceDollar) {
		this.balanceDollar = balanceDollar;
	}
	
	/**
	 * Gets the balance currency.
	 *
	 * @return the balance currency
	 */
	public double getBalanceCurrency() {
		return balanceCurrency;
	}
	
	/**
	 * Sets the balance currency.
	 *
	 * @param balanceCurrency the new balance currency
	 */
	public void setBalanceCurrency(final double balanceCurrency) {
		this.balanceCurrency = balanceCurrency;
	}
	
	/**
	 * Gets the role type.
	 *
	 * @return the role type
	 */
	public String getRoleType() {
		return roleType;
	}
	
	/**
	 * Sets the role type.
	 *
	 * @param roleType the new role type
	 */
	public void setRoleType(final String roleType) {
		this.roleType = roleType;
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
	
	
	/*
	 *  1 approach
	@Override
	public String toString() {
		
		String select="checkbox";
		
		return "<table style='width:100%' border='10'>" +
		"<tr><td>"+userId+"</td><td>"+firstName+"</td><td>"+lastName+"</td><td>"+mobile+"</td>"+
		"<td>"+balanceDollar+"</td><td>"+balanceCurrency+"</td><td>"+select+"</td></tr>" +
		"</table>";
		
		
	}
	*/
	
	
	
	
	
	
}

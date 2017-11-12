package com.cts.cbc.util;


/**
 * The Class DBConstants.
 */
public class DBConstants {
	
	//login
	/** The Constant GET_LOGIN_INFO. */
	public static final String GET_LOGIN_INFO = "select User_id,password,Role_type from User_Registration";
	
	/** The Constant SET_REGISTRATION. */
	public static final String SET_REGISTRATION ="insert into User_Registration values" +
			"(?,?,?,?,?,?,?,?,?,'maharashtra',?,?,?,?," +
			"?,?,?)";
	
	/** The Constant GET_DISPLAY_INDL. */
	public static final String GET_DISPLAY_INDL = "select Transaction_id ,User_id ,Stock_id ,No_of_stock ,Chargeback ,Balance,Transaction_type,Transaction_date from Individual_User_Stock_Details where  User_id=?";

	/** The Constant GET_DISPLAY_FUND. */
	public static final String GET_DISPLAY_FUND = "select Transaction_id,User_id,Stock_id,No_of_stock,Amount_invested,Chargeback,Balance,Transaction_type,Transaction_date,No_of_days_stock_held,Fund_id from Fund_User_Stock_Details where  User_id=?";
	
	
	/** The Constant GET_USERID. */
	public static final String  GET_USERID ="select concat(?,sequenceforuserid.nextval) from dual";
   
	
	/** The Constant GET_PASSWORD. */
	public static final String  GET_PASSWORD ="select password from User_Registration where User_id=? and Mobile=?";

	//for individual users	
	/** The Constant GET_DATA. */
	public static final String GET_DATA ="select User_id,First_name,Last_name,Mobile,Balance_dollar,Balance_currency from User_Registration where role_type='INDL'" ;

	/////
	/** The Constant COUNT_SELL_STOCK. */
	public static final String COUNT_SELL_STOCK="select count(iusd.Transaction_id) from User_Registration ur,Individual_User_Stock_Details iusd where ur.User_id= iusd.User_id and iusd.Transaction_type='sell' and ur.User_id=?";
	/////
	/** The Constant GET_BUY_DATA. */
	public static final String GET_BUY_DATA="select ur.User_id,ur.First_name, ur.Last_name,ur.mobile,sd.Stock_name,sd.Sell_price,sum(iusd.No_of_stock) from User_Registration ur,Individual_User_Stock_Details iusd,Stock_Details sd where ur.User_id= iusd.User_id and iusd.stock_id=sd.stock_id and iusd.Transaction_type='buy' and ur.User_id=? and ur.User_id = any(select ur.User_id from User_Registration ur, Individual_User_Stock_Details iusd, Stock_Details sd where ur.User_id= iusd.User_id and iusd.stock_id=sd.stock_id and iusd.Transaction_type='buy' group by ur.User_id,sd.Stock_id )group by ur.User_id,sd.Stock_id,ur.First_name,ur.Last_name,ur.mobile,sd.Stock_name,sd.Sell_price,iusd.Transaction_type";
	////
	/** The Constant GET_BUY_STOCK_SUM. */
	public static final String GET_BUY_STOCK_SUM="select sum(iusd.No_of_stock) from User_Registration ur,Individual_User_Stock_Details iusd,Stock_Details sd where ur.User_id= iusd.User_id and iusd.stock_id=sd.stock_id and iusd.Transaction_type='buy' and ur.User_id=? and sd.Stock_name=? and ur.User_id = any(select ur.User_id from User_Registration ur, Individual_User_Stock_Details iusd, Stock_Details sd where ur.User_id= iusd.User_id and iusd.stock_id=sd.stock_id and iusd.Transaction_type='buy' group by ur.User_id,sd.Stock_id )group by ur.User_id,sd.Stock_id,ur.First_name,ur.Last_name,ur.mobile,sd.Stock_name,sd.Sell_price,iusd.Transaction_type";
	///
	/** The Constant GET_SELL_STOCK. */
	public static final String GET_SELL_STOCK="select distinct sd.Stock_name,ur.User_id,ur.First_name, ur.Last_name,ur.mobile,sd.Sell_price,(t1.a-t2.b) from User_Registration ur,Individual_User_Stock_Details iusd,Stock_Details sd,(select sd.Stock_name  as snm1,sum(iusd.No_of_stock) as a from User_Registration ur,Individual_User_Stock_Details iusd,Stock_Details sd where ur.User_id= iusd.User_id and iusd.stock_id=sd.stock_id and iusd.Transaction_type='buy' and ur.User_id=? and ur.User_id = any(select ur.User_id from User_Registration ur, Individual_User_Stock_Details iusd, Stock_Details sd where ur.User_id= iusd.User_id and iusd.stock_id=sd.stock_id and iusd.Transaction_type='buy' group by ur.User_id,sd.Stock_id ) group by ur.User_id,sd.Stock_id,ur.First_name,ur.Last_name,ur.mobile,sd.Stock_name,sd.Sell_price,iusd.Transaction_type)t1, (select sd.Stock_name as snm2,sum(iusd.No_of_stock) as b from User_Registration ur,Individual_User_Stock_Details iusd,Stock_Details sd where ur.User_id= iusd.User_id and iusd.stock_id=sd.stock_id and iusd.Transaction_type='sell' and ur.User_id=? and ur.User_id = any(select ur.User_id from User_Registration ur, Individual_User_Stock_Details iusd, Stock_Details sd where ur.User_id= iusd.User_id and iusd.stock_id=sd.stock_id and iusd.Transaction_type='sell' group by ur.User_id,sd.Stock_id) group by ur.User_id,sd.Stock_id,ur.First_name,ur.Last_name,ur.mobile,sd.Stock_name,sd.Sell_price,iusd.Transaction_type)t2 where ur.User_id= iusd.User_id and iusd.stock_id=sd.stock_id and ur.User_id=? and sd.Stock_name=t1.snm1 and sd.Stock_name=t2.snm2";

	/** The Constant GET_SELL_SUM. */
	public static final String GET_SELL_SUM="select distinct sd.Stock_name,(t1.a-t2.b) from User_Registration ur,Individual_User_Stock_Details iusd,Stock_Details sd,(select sd.Stock_name  as snm1,sum(iusd.No_of_stock) as a from User_Registration ur,Individual_User_Stock_Details iusd,Stock_Details sd where ur.User_id= iusd.User_id and iusd.stock_id=sd.stock_id and iusd.Transaction_type='buy' and ur.User_id=? and ur.User_id = any(select ur.User_id from User_Registration ur, Individual_User_Stock_Details iusd, Stock_Details sd where ur.User_id= iusd.User_id and iusd.stock_id=sd.stock_id and iusd.Transaction_type='buy' group by ur.User_id,sd.Stock_id) group by ur.User_id,sd.Stock_id,ur.First_name,ur.Last_name,ur.mobile,sd.Stock_name,sd.Sell_price,iusd.Transaction_type)t1, (select sd.Stock_name as snm2,sum(iusd.No_of_stock) as b from User_Registration ur,Individual_User_Stock_Details iusd,Stock_Details sd where ur.User_id= iusd.User_id and iusd.stock_id=sd.stock_id and iusd.Transaction_type='sell' and ur.User_id=? and ur.User_id = any(select ur.User_id from User_Registration ur, Individual_User_Stock_Details iusd, Stock_Details sd where ur.User_id= iusd.User_id and iusd.stock_id=sd.stock_id and iusd.Transaction_type='sell' group by ur.User_id,sd.Stock_id) group by ur.User_id,sd.Stock_id,ur.First_name,ur.Last_name,ur.mobile,sd.Stock_name,sd.Sell_price,iusd.Transaction_type)t2 where ur.User_id= iusd.User_id and iusd.stock_id=sd.stock_id and ur.User_id=? and sd.Stock_name=? and sd.Stock_name=t1.snm1 and sd.Stock_name=t2.snm2";


	/** The Constant GET_STOCK_ID. */
	public static final String GET_STOCK_ID ="select Stock_id from Stock_Details where Stock_name=?" ;

	/** The Constant GET_BUY_PRICE. */
	public static final String GET_BUY_PRICE ="select Buy_price from Stock_Details where Stock_id=?" ;

	/** The Constant GET_SELL_PRICE. */
	public static final String GET_SELL_PRICE ="select Sell_price from Stock_Details where Stock_id=?" ;

	/** The Constant GET_PERCENT. */
	public static final String GET_PERCENT ="select Chargeback_percent from Charge_Back_Details where Stock_price_lower_limit<=? and Stock_price_upper_limit>=?" ;

	/** The Constant GET_PROFIT_PER. */
	public static final String GET_PROFIT_PER ="select Profit_chargeback from Profit_Charge_Back where Profit_lower_limit<=? and Profit_upper_limit>=?" ;

	/** The Constant GET_BALANCE. */
	public static final String GET_BALANCE = "select Balance_dollar from User_Registration where User_id=?";

	/** The Constant UPDATE_BALANCE. */
	public static final String UPDATE_BALANCE = "update User_Registration set Balance_dollar=?,Balance_currency=? where User_id=?";

	/** The Constant GET_TRANS_ID. */
	public static final String GET_TRANS_ID="select seq.nextval from dual"; 

	/** The Constant SET_TRANS_DETAILS. */
	public static final String SET_TRANS_DETAILS = "insert into Individual_User_Stock_Details values(?,?,?,?,?,?,?,?)";

	/** The Constant GET_ONLY_BUY. */
	public static final String GET_ONLY_BUY = "select sd.Stock_name,iusd.User_id,ur.First_name,ur.Last_name,ur.mobile,sd.Sell_price,sum(iusd.No_of_stock) from Individual_User_Stock_Details iusd,User_Registration ur,Stock_Details sd where ur.User_id= iusd.User_id and iusd.stock_id=sd.stock_id and iusd.User_id=? and iusd.Transaction_type='buy' and iusd.Stock_id not in (select distinct iusd.Stock_id from Individual_User_Stock_Details iusd where iusd.User_id=? and iusd.Transaction_type='sell') group by sd.Stock_name,iusd.User_id,iusd.Stock_id,ur.First_name,ur.Last_name,ur.mobile,sd.Sell_price";

	//////////////ash

	/** The Constant GET_BUY_STOCK. */
	public static final String GET_BUY_STOCK ="select Stock_id,Stock_name,Buy_price,Sell_price from Stock_Details" ;

	/** The Constant GET_BUYPRICE. */
	public static final String GET_BUYPRICE ="select Buy_price from Stock_Details where Stock_id=?" ;

	/** The Constant GET_ONLY_BUY_SUM. */
	public static final String GET_ONLY_BUY_SUM="select sum(iusd.No_of_stock) from Individual_User_Stock_Details iusd,User_Registration ur,Stock_Details sd where ur.User_id= iusd.User_id and iusd.stock_id=sd.stock_id and iusd.User_id=? and sd.Stock_name=? and iusd.Transaction_type='buy' and iusd.Stock_id not in (select distinct iusd.Stock_id from Individual_User_Stock_Details iusd where iusd.User_id=? and iusd.Transaction_type='sell') group by sd.Stock_name,iusd.User_id,iusd.Stock_id,ur.First_name,ur.Last_name,ur.mobile,sd.Sell_price"; 


	
	//fund users

	
	
	// for fund users
	/** The Constant GET_FUND_DATA. */
	public static final String GET_FUND_DATA = "select Fund_id,Fund_name,Amount from Fund_User_Details where Fund_id like 'FUND%' and Amount>0";
	
	//for new fund users
	/** The Constant GET_FUND_REQUEST. */
	public static final String GET_FUND_REQUEST="select User_id,First_name,Last_name,Mobile from User_Registration where Fund_id='FUND000' ";
	
	//for extracting fund id
	/** The Constant GET_LAST_FUNDID. */
	public static final String GET_LAST_FUNDID = "select max(Fund_id) from Fund_User_Details";
	
	//sunny
	/** The Constant GET_SELLSTOCKDATA. */
	public static final String GET_SELLSTOCKDATA="select ur.User_id,ur.First_name, ur.Last_name,ur.mobile,sd.Stock_name,sd.Sell_price,sum(iusd.No_of_stock),iusd.Transaction_type from User_Registration ur,Individual_User_Stock_Details iusd,Stock_Details sd where ur.User_id= iusd.User_id and iusd.stock_id=sd.stock_id and iusd.Transaction_type='buy' and ur.User_id=? and ur.User_id = any (select ur.User_id from User_Registration ur, Individual_User_Stock_Details iusd, Stock_Details sd where ur.User_id= iusd.User_id and iusd.stock_id=sd.stock_id and iusd.Transaction_type='buy' group by ur.User_id,sd.Stock_id) group by ur.User_id,sd.Stock_id,ur.First_name,ur.Last_name,ur.mobile,sd.Stock_name,sd.Sell_price,iusd.Transaction_type";

	//BuyStockForFund
	/** The Constant GET_BUY_FUND. */
	public static final String GET_BUY_FUND ="select Stock_id,Stock_name,Buy_price from Stock_Details" ;

	//SellStockForFund
	/** The Constant GET_SELL_FUND. */
	public static final String GET_SELL_FUND = "select distinct fud.Fund_name,fud.Fund_id,sd.Stock_name,sd.Sell_price,(t1.a-t2.b) from (select count(User_id) as c from User_Registration where Fund_id=?)t,Fund_User_Details fud,Fund_User_Stock_Details fusd,Stock_Details sd,(select distinct fud.Fund_name,fud.Fund_id,sd.Stock_name as snm1,sd.Sell_price,(sum(fusd.No_of_stock)/t.c) as a from (select count(User_id) as c from User_Registration where Fund_id=?)t,Fund_User_Details fud,Fund_User_Stock_Details fusd,Stock_Details sd where fud.Fund_id= fusd.Fund_id and fusd.stock_id=sd.stock_id and fusd.Transaction_type='buy' and fud.Fund_id=? and fud.Fund_id = any (select distinct fud.Fund_id from Fund_User_Details fud, Fund_User_Stock_Details fusd, Stock_Details sd where fud.Fund_id= fusd.Fund_id and fusd.stock_id=sd.stock_id and fusd.Transaction_type='buy' group by fusd.Transaction_id,sd.Stock_id,fud.Fund_id) group by fud.Fund_id,sd.Stock_id,sd.Stock_name,fud.Fund_name,sd.Sell_price,t.c)t1,(select distinct fud.Fund_name,fud.Fund_id,sd.Stock_name as snm2,sd.Sell_price,(sum(fusd.No_of_stock)/t.c) as b from (select count(User_id) as c from User_Registration where Fund_id=?)t,Fund_User_Details fud,Fund_User_Stock_Details fusd,Stock_Details sd where fud.Fund_id= fusd.Fund_id and fusd.stock_id=sd.stock_id and fusd.Transaction_type='sell' and fud.Fund_id=? and fud.Fund_id = any (select distinct fud.Fund_id from Fund_User_Details fud, Fund_User_Stock_Details fusd, Stock_Details sd where fud.Fund_id= fusd.Fund_id and fusd.stock_id=sd.stock_id and fusd.Transaction_type='sell' group by fusd.Transaction_id,sd.Stock_id,fud.Fund_id) group by fud.Fund_id,sd.Stock_id,sd.Stock_name,fud.Fund_name,sd.Sell_price,t.c)t2 where fud.Fund_id= fusd.Fund_id and fusd.stock_id=sd.stock_id and fud.Fund_id=? and sd.Stock_name=t1.snm1 and sd.Stock_name=t2.snm2";
	
	//update user_registration
	/** The Constant UPDATE_USER_REG. */
	public static final String UPDATE_USER_REG="update User_Registration set Role_type='FUND',Fund_id=? where User_id=?";
	
	//get fund name and stock name from their respective id's
	/** The Constant GET_FUND_STOCK. */
	public static final String GET_FUND_STOCK="select f.Fund_name, s.stock_name, s.buy_price " +
			"from stock_details s,Fund_User_Details f where f.fund_id=? and s.stock_id=?";
	
	//for getting users of fund
	/** The Constant GET_COUNT_FUND. */
	public static final String GET_COUNT_FUND="select count(User_id) from User_Registration where Fund_id=?";

	//for getting userId for fund
	/** The Constant GET_FUND_USERS. */
	public static final String GET_FUND_USERS="select User_id from User_Registration where Fund_id=?";
	
	
	//for updating balance
	/** The Constant UPDATE_BAL_USER. */
	public static final String UPDATE_BAL_USER="update User_Registration set Balance_dollar=?,Balance_currency=? where User_id=?" ;
	
	//for getting No-Of-days for fund
	/** The Constant GET_NO_DAYS. */
	public static final String GET_NO_DAYS="select No_of_days_stock_held from Fund_User_Stock_Details where User_id=?";
	
	//for gettingRole type of user in fund
	/** The Constant GET_ROLE_TYPE. */
	public static final String GET_ROLE_TYPE="select Role_type from User_Registration where User_id=?";
	
	/** The Constant COUNT_SELL_FUND. */
	public static final String COUNT_SELL_FUND="select count(fusd.Transaction_id) from Fund_User_Details fud,Fund_User_Stock_Details fusd where fud.Fund_id= fusd.Fund_id and fusd.Transaction_type='sell' and fud.Fund_id=?";
	
	//final working
	/** The Constant GET_BUY_DATA_FUND. */
	public static final String GET_BUY_DATA_FUND="select distinct fud.Fund_name,fud.Fund_id,sd.Stock_name,sd.Sell_price,(sum(fusd.No_of_stock)/t.c) from (select count(User_id) as c from User_Registration where Fund_id=?)t,Fund_User_Details fud,Fund_User_Stock_Details fusd,Stock_Details sd where fud.Fund_id= fusd.Fund_id and fusd.stock_id=sd.stock_id and fusd.Transaction_type='buy' and fud.Fund_id=? and fud.Fund_id = any (select distinct fud.Fund_id from Fund_User_Details fud, Fund_User_Stock_Details fusd, Stock_Details sd where fud.Fund_id= fusd.Fund_id and fusd.stock_id=sd.stock_id and fusd.Transaction_type='buy' group by fusd.Transaction_id,sd.Stock_id,fud.Fund_id) group by fud.Fund_id,sd.Stock_id,sd.Stock_name,fud.Fund_name,sd.Sell_price,t.c";
	
	//final working
	/** The Constant GET_BUY_SUM_FUND. */
	public static final String GET_BUY_SUM_FUND="select distinct (sum(fusd.No_of_stock)/t.c) from (select count(User_id) as c from User_Registration where Fund_id=?)t,Fund_User_Details fud,Fund_User_Stock_Details fusd,Stock_Details sd where fud.Fund_id= fusd.Fund_id and fusd.stock_id=sd.stock_id and fusd.Transaction_type='buy' and fud.Fund_id=? and sd.stock_name=? and fud.Fund_id = any (select distinct fud.Fund_id from Fund_User_Details fud, Fund_User_Stock_Details fusd, Stock_Details sd where fud.Fund_id= fusd.Fund_id and fusd.stock_id=sd.stock_id and fusd.Transaction_type='buy' group by fusd.Transaction_id,sd.Stock_id,fud.Fund_id) group by fud.Fund_id,sd.Stock_id,sd.Stock_name,fud.Fund_name,sd.Sell_price,t.c";
	
	//final working
	/** The Constant GET_SELL_SUM_FUND. */
	public static final String GET_SELL_SUM_FUND = "select (t1.a-t2.b) from (select count(User_id) as c from User_Registration where Fund_id=?)t,Fund_User_Details fud,Fund_User_Stock_Details fusd,Stock_Details sd,(select distinct fud.Fund_name,fud.Fund_id,sd.Stock_name as snm1,sd.Sell_price,(sum(fusd.No_of_stock)/t.c) as a from (select count(User_id) as c from User_Registration where Fund_id=?)t,Fund_User_Details fud,Fund_User_Stock_Details fusd,Stock_Details sd where fud.Fund_id= fusd.Fund_id and fusd.stock_id=sd.stock_id and fusd.Transaction_type='buy' and fud.Fund_id=? and sd.stock_name=? and fud.Fund_id = any (select distinct fud.Fund_id from Fund_User_Details fud, Fund_User_Stock_Details fusd, Stock_Details sd where fud.Fund_id= fusd.Fund_id and fusd.stock_id=sd.stock_id and fusd.Transaction_type='buy' group by fusd.Transaction_id,sd.Stock_id,fud.Fund_id) group by fud.Fund_id,sd.Stock_id,sd.Stock_name,fud.Fund_name,sd.Sell_price,t.c)t1,(select distinct fud.Fund_name,fud.Fund_id,sd.Stock_name snm2,sd.Sell_price,(sum(fusd.No_of_stock)/t.c) as b from (select count(User_id) as c from User_Registration where Fund_id=?)t,Fund_User_Details fud,Fund_User_Stock_Details fusd,Stock_Details sd where fud.Fund_id= fusd.Fund_id and fusd.stock_id=sd.stock_id and fusd.Transaction_type='sell' and fud.Fund_id=? and fud.Fund_id = any (select distinct fud.Fund_id from Fund_User_Details fud, Fund_User_Stock_Details fusd, Stock_Details sd where fud.Fund_id= fusd.Fund_id and fusd.stock_id=sd.stock_id and fusd.Transaction_type='sell' group by fusd.Transaction_id,sd.Stock_id,fud.Fund_id) group by fud.Fund_id,sd.Stock_id,sd.Stock_name,fud.Fund_name,sd.Sell_price,t.c)t2 where fud.Fund_id= fusd.Fund_id and fusd.stock_id=sd.stock_id and fud.Fund_id=? and sd.Stock_name=t1.snm1 and sd.Stock_name=t2.snm2";
	

	
	/** The Constant GET_BALANCE_FUND. */
	public static final String GET_BALANCE_FUND = "select Amount from Fund_User_Details where Fund_id=?";

	/** The Constant UPDATE_BAL_FUND. */
	public static final String UPDATE_BAL_FUND = "update Fund_User_Details set Amount=? where Fund_id=?";
	
	
	
	/** The Constant SET_TRANS_FUND. */
	public static final String SET_TRANS_FUND = "insert into Fund_User_Stock_Details values(?,?,?,?,?,?,?,?,?,?,?,?)";

	
	/** The Constant GET_ONLY_BUY_FUND. */
	public static final String GET_ONLY_BUY_FUND = "select distinct fusd.Fund_id,fud.Fund_name,sd.Stock_name,sd.Sell_price,(sum(fusd.No_of_stock)/t.c) from (select count(User_id) as c from User_Registration where Fund_id=?)t,Fund_User_Stock_Details fusd,Fund_User_Details fud,Stock_Details sd where fud.Fund_id= fusd.Fund_id and fusd.stock_id=sd.stock_id and fusd.Fund_id=? and fusd.Transaction_type='buy' and fusd.Stock_id not in (select distinct fusd.Stock_id from Fund_User_Stock_Details fusd where fusd.Fund_id=? and fusd.Transaction_type='sell') group by fusd.Fund_id,fud.Fund_name,sd.Stock_name,sd.Sell_price,t.c";
	
	/** The Constant GET_ONLY_BUY_SUM_FUND. */
	public static final String GET_ONLY_BS_FUND="select (sum(fusd.No_of_stock)/t.c) from (select count(User_id) as c from User_Registration where Fund_id=?)t,Fund_User_Stock_Details fusd,Fund_User_Details fud,Stock_Details sd where fud.Fund_id= fusd.Fund_id and fusd.stock_id=sd.stock_id and fusd.Fund_id=? and sd.Stock_name=? and fusd.Transaction_type='buy' and fusd.Stock_id not in (select distinct fusd.Stock_id from Fund_User_Stock_Details fusd where fusd.Fund_id=? and fusd.Transaction_type='sell') group by fusd.Fund_id,fud.Fund_name,sd.Stock_name,sd.Sell_price,t.c";
	
	
	//insert new fund
	/** The Constant INSERT_NEW_FUND. */
	public static final String INSERT_NEW_FUND="insert into Fund_User_Details(Fund_id,Fund_name) values(?,?)";
	

	//update fund balance
	/** The Constant UPDATE_FUND_BAL. */
	public static final String UPDATE_FUND_BAL="update Fund_User_Details set Amount=? where Fund_id=?";


	/** The Constant GET_AMT_INDL. */
	public static final String GET_AMT_INDL = "select User_id,Stock_id,sum(Amount_invested),sum(No_Of_stock) from Fund_User_Stock_Details where User_id=? and Stock_id=(select unique Stock_id from Stock_Details where Stock_name=?) and Transaction_type='buy' group by User_id,Stock_id";

	/** The Constant GET_BUY_PRICE_NAME. */
	public static final String GET_BPRICE_NAME = "select Buy_price from Stock_Details where Stock_name=?";

}





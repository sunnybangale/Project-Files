
<%@page import="com.cts.cbc.bo.UserBO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.io.PrintWriter"%>
<%@page import="com.cts.cbc.bo.FundUserSellCalculations"%>
<%@page import="com.cts.cbc.dao.FundDAO"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<%!
HttpSession h;
String loggedIn;
%>
<%
h=request.getSession();
try{
	loggedIn=h.getAttribute("loggedIn").toString();

	}catch(Exception e)
	{	response.sendRedirect("LoggedOut.jsp");}

if(loggedIn.equals("0"))
{
response.sendRedirect("LoggedOut.jsp");
}

%>





<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>ChargeBack Calculation</title>

<!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/freelancer.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" class="index" style="background-image: url(img/Blue.jpg)">

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="RoleSelection.jsp">HOME</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="hidden"><a href="#page-top"></a>
				</li>
				<li class="page-scroll"><a href="LoggedOut.jsp">Logout</a>
				</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

					
	<section id="portfolio">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2>Stock Transaction post selling</h2>
				<hr class="star-primary">
			</div>
		</div>
	</div>
	</section>



	<%
		response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1 
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
		response.setDateHeader("Expires", 0); //prevents caching at the proxy server
	%>

	<%!HttpSession hs;
	String fundId;

	FundDAO da;
	FundUserSellCalculations fuc;

	PrintWriter pw;

	String stockName;
	String stockId;
	int quantity;

	double buyCost;
	double sellCost;
	double profit;
	double profitPerUser;
	double profitPercent;
	double profitChargeback;
	double commission;
	double fees;
	double tax;
	double chargeback;
	double balance;
	double updatedBalance;
	double updatedBalanceUser;
	double amtInvForThisQty;
	double buyPrice;
	double buyPriceTotal;
	double chargebackI;
	double balanceUser;
	
	double currency;
	
	String transactionId;
	String generatedTransactionId;
	String userIds[];
	int countUsers;
	int i = 0;
	int []amt_stock=new int[3];
	int amountInvestedByIdvl;
	int total_stock_bought;
	String tlId;
	
	UserBO ub;
	%>

	<%
		hs = request.getSession();
		fundId = hs.getAttribute("fundId").toString();
		//out.print("Fund is " + fundId);

		pw = response.getWriter();

		stockName = application.getAttribute("stockName").toString();
		//out.print(stockName);

		quantity = Integer.parseInt(application.getAttribute("quantity")
				.toString());
		//out.print(quantity);

		da = new FundDAO();
		fuc = new FundUserSellCalculations();

		stockId = da.getStockId(stockName);
		//System.out.println("stock id is " + stockId);

		sellCost = da.getSellPrice(stockId);
		//System.out.println("sell cost is " + sellCost);

		buyCost = da.getBuyPrice(stockId);
		//System.out.println("buy cost is " + buyCost);

		profit = (sellCost - buyCost) * quantity;
		//System.out.println("profit is " + profit);

		profitPercent = (profit / (buyCost * quantity)) * 100;
		//System.out.println("profit percent is " + profitPercent);
		profitChargeback = da.getProfitRangePercent(profitPercent);
		//System.out.println("profit chargeback is " + profitChargeback);

		commission = fuc.calculateCommission(profitChargeback, profit);
		//System.out.println("commission is " + commission);

		fees = fuc.calculateFees(buyCost, quantity);
		//System.out.println("fees is " + fees);

		tax = fuc.calculateTax(buyCost, quantity);
		//System.out.println("tax is " + tax);

		chargeback = fuc.calculateSellChargeback(commission, fees, tax);
		//System.out.println("chargeback is " + chargeback);
		
		balance = da.getBalance(fundId);
		//System.out.println("balance is " + balance);

		updatedBalance = fuc.subtractChargeback(balance,profit,chargeback,
				sellCost, quantity);
		//System.out.println("subtracted balance is " + updatedBalance);

		da.updateBalanceFund(fundId, updatedBalance);

		transactionId = da.getTransactionId();
		generatedTransactionId = fuc.generateTransactionId(transactionId);
		//System.out.println("trans is " + transactionId);

		userIds = da.getUserFund(fundId);
		countUsers = da.getUserCount(fundId);

		buyPrice=da.getBuyPriceFromSname(stockName);
		buyPriceTotal=quantity*buyPrice;
		
		for (i = 0; i < countUsers; i++) {
			tlId = fuc.generateTlId(transactionId, userIds[i]);
			amt_stock=da.getAmountInvIndl(userIds[i],stockName);
			
			amountInvestedByIdvl=amt_stock[0];
			total_stock_bought=amt_stock[1];
			
			//System.out.println("TOTAL AMOUNT " + amountInvestedByIdvl);
			//System.out.println("TOTAL STOCK BOUGHT " + total_stock_bought);
			
			amtInvForThisQty=(double)((amountInvestedByIdvl*quantity)/total_stock_bought);
			//System.out.println("amt inv for this qty by this indvl " + amtInvForThisQty);
			chargebackI=(chargeback*amtInvForThisQty)/buyPriceTotal;
			
			profitPerUser=profit*(amtInvForThisQty/buyPriceTotal);
			
			//System.out.println("chargeback of indv is " + chargebackI);
			
			balanceUser=da.getBalanceUser(userIds[i]);
			//System.out.println("balance user " + balanceUser+" profit "+profitPerUser+" chargeback "+chargebackI+" sellcost "+sellCost+" quantity "+quantity);
		updatedBalanceUser = fuc.subtractChargeback(balanceUser, profitPerUser,chargebackI,sellCost, quantity);
			
			//System.out.println("subtracted balance of user is " + updatedBalanceUser);
			
			ub= new UserBO();
			currency=ub.convertCurrencyFromDollarToRupees(updatedBalance);
			da.updateBalanceUser(updatedBalanceUser,currency, userIds[i]);
			da.setTransactionDetails(tlId, generatedTransactionId,userIds[i], stockId, quantity, 1000, chargebackI,	updatedBalance, "sell", fundId);
		}
	%>
	<form>

		<!-- <table style='width: 100%' border='10'>
			<col width='130'>
			<col width='130'>
			<col width='130'>
			<col width='130'>
			<col width='130'>
			<col width='130'>
			<col width='130'>
			<col width='130'>
			<col width='130'>
			<col width='130'> -->
<h5>			
<div class="container">
<table class="table table-hover">
<thead>
			
			<tr class="success">
				<td>Transaction Id</td>
				<td>User Id</td>
				<td>Stock Name</td>
				<td>Number Of Stock</td>
				<td>Charge Back</td>
				<td>Balance</td>
				<td>Transaction Type</td>
			</tr>
</thead>

<tbody>				
			<tr>
				<td><%=generatedTransactionId%></td>
				<td><%=fundId%></td>
				<td><%=stockName%></td>
				<td><%=quantity%></td>
				<td><%=chargeback%></td>
				<td><%=updatedBalance%></td>
				<td>sell</td>
			</tr>

			<br>

		<!-- </table> -->
</tbody>
</table>
</div>
</h5>
	</form>


	<br>
	<br>
<center>

	<form action='DisplayFundUsers.jsp' method='post'>
	
	<div class="container">
		<input type='submit' name='sellAnother' value='Sell For Another User' class="btn btn-info"></input>
	</div>
	
	</form>

</center>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
</body>

<!-- Footer -->
    <footer class="text-center">
        <div class="footer-above">
            <div class="container">
                <div class="row">
                    <div class="footer-col col-md-4">
                        <h3>Location</h3>
                        <p>Cognizant - Ph3, Phase 3, Hinjewadi Rajiv Gandhi Infotech Park, Hinjawadi, Pimpri-Chinchwad, Maharashtra 411057</p>
                    </div>
                    <div class="footer-col col-md-4">
                        <h3>Follow us on</h3>
                        <ul class="list-inline">
                            <li>
                                <a href="https://www.facebook.com/" class="btn-social btn-outline"><i class="fa fa-fw fa-facebook"></i></a>
                            </li>
                            <li>
                                <a href="https://plus.google.com/collections/featured" class="btn-social btn-outline"><i class="fa fa-fw fa-google-plus"></i></a>
                            </li>
                            <li>
                                <a href="https://twitter.com/" class="btn-social btn-outline"><i class="fa fa-fw fa-twitter"></i></a>
                            </li>
                            <li>
                                <a href="https://www.linkedin.com/" class="btn-social btn-outline"><i class="fa fa-fw fa-linkedin"></i></a>
                            </li>
                            
                        </ul>
                    </div>
                    <div class="footer-col col-md-4">
                        <h3>Cognizant Technology Solutions</h3>
                        <p>Chargeback is a free to use,created by <a href="http://www.cognizant.com/">Visit Us</a>.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer-below">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        Copyright &copy; Chargeback 2015
                    </div>
                </div>
            </div>
        </div>
    </footer>


</html>
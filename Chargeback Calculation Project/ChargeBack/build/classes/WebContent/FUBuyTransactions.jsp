<%@page import="com.cts.cbc.bo.UserBO"%>
<%@page import="com.cts.cbc.bo.FundUserBuyCalculations"%>

<%@page import="com.cts.cbc.dao.FundDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<li class="hidden"><a href="#page-top"></a></li>
				<li class="page-scroll"><a href="LoggedOut.jsp">Logout</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

				
	<section id="portfolio">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2>Stock Transaction post buying</h2>
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



	<!-- <table style='width: 100%' border='10'>
		<col width='130'>
		<col width='130'>
		<col width='130'>
		<col width='130'>
		<col width='130'>
		<col width='130'>
		<col width='80'> -->

<h5>
<div class="container">
<table class="table table-hover">
<thead>	
		<tr class="success">
			<td>User Id</td>
			<td>Stock Name</td>
			<td>No.of Units</td>
			<td>Stock Price</td>
			<td>ChargeBack</td>
			<td>Amount Invested</td>
			<td>Balance Amount(Dollar)</td>
			<td>Role</td>
			<td>Number Of Days</td>
		</tr>
</thead>

<%!
	int quantityOfStocks;
	int countUser;
	int j;
	int i;
	String fid;
	String userId[];
	String stockName;
	String stockId;
	double buyPrice;
	double totalStockPrice;
	double percentRange;
	double chargebackF;
	double chargeback[];
	double amountInvested[];
	String amountInvestedUser[];
	double obtainedBalance[];
	String roleType[];
	double subtractedBalance[];
	double fundsubtractedBalance;
	double currency[];
	String tlId;
	String transactionId;
	String generatedTransactionId;
	HttpSession hs;
	//FundUserBuyCalculations ibc;
	FundUserBuyCalculations fub;
	FundDAO d;
	UserBO ub;

%>

		<%
			ub=new UserBO();
			hs = request.getSession();
			stockName = application.getAttribute("stockName").toString();
			//out.println();
			//out.println("Welcome user:- ");
			countUser = Integer.parseInt(application.getAttribute("UserCount")
					.toString());
			//for(int c=0;c<countUser;c++)
			userId = new String[countUser];
			chargeback = new double[countUser];
			amountInvested = new double[countUser];
			obtainedBalance = new double[countUser];
			subtractedBalance = new double[countUser];
			roleType = new String[countUser];
			currency=new double[countUser];
			amountInvestedUser=new String[countUser];
			userId = (String[]) application.getAttribute("UserId");
			stockId = application.getAttribute("stockID").toString();
			quantityOfStocks = Integer.parseInt(application.getAttribute(
					"quantityOfStocks").toString());
			buyPrice = Double.parseDouble(application.getAttribute("stockPrice")
					.toString());
			totalStockPrice = Double.parseDouble(application.getAttribute(
					"totalStockPrie").toString());
			//out.print(userId[0]);
			//fid = hs.getAttribute("fundId").toString();
			fid=application.getAttribute("fundId").toString();
			
			//out.print(fid);
			d = new FundDAO();
			fub = new FundUserBuyCalculations();
			//buyPrice = d.getBuyPrice(stock_Id);
			//out.println("Buy Price is " + buyPrice);

			//totalStockPrice = (quantity_Bought) * (buyPrice);
			//out.println("Total stock price is " + totalStockPrice);

			percentRange = d.getRangePercent(totalStockPrice);
			//out.println("Percent Range is " + percentRange);
			chargebackF = fub.calculateTotalChargeback(percentRange,
					totalStockPrice);
			amountInvestedUser=(String [])application.getAttribute("users");
			//System.out.println("tt "+amountInvestedUser[0]);
			for (j = 0; j < countUser; j++) {
				//amountInvested[j]=Double.parseDouble(hs.getAttribute(userId[j]).toString());
				//amountInvested[j] = Double.parseDouble(request.getParameter(userId[j]));
				amountInvested[j] = Double.parseDouble(amountInvestedUser[j]);
				chargeback[j] = fub.calculateIndividualChargeback(percentRange,
						totalStockPrice, amountInvested[j]);
				obtainedBalance[j] = d.getBalanceUser(userId[j]);
				subtractedBalance[j] = fub.subtractChargeback(
						obtainedBalance[j], chargeback[j]);
				roleType[j] = d.getRoleType(userId[j]);
			}

			//out.println("Chargeback calculated is " + chargeback);

			//out.println(obtainedBalance);

			//out.println("The subtracted balance is " + subtractedBalance);
		%>
		<%
			transactionId = d.getTransactionId();
			//System.out.println("TRAS " + transactionId);

			fub = new FundUserBuyCalculations();

			generatedTransactionId = fub.generateTransactionId(transactionId);
			//System.out.println(generatedTransactionId);

			for (i = 0; i < countUser; i++) {

				amountInvested[i] = Double.parseDouble(amountInvestedUser[i]);
				currency[i]=ub.convertCurrencyFromDollarToRupees(subtractedBalance[i]);
				d.updateBalanceUser(subtractedBalance[i],currency[i], userId[i]);
				fundsubtractedBalance += subtractedBalance[i];

				tlId = fub.generateTlId(transactionId, userId[i]);
				//System.out.println("TLID" + tlId + " ussss " + userId[i]+ " FUND " + fid + " USERID " + userId[i] + " STOck "	+ stockId);
				d.setTransactionDetails(tlId, generatedTransactionId,
						userId[i], stockId, quantityOfStocks, amountInvested[i],
						chargeback[i], subtractedBalance[i], "buy", fid);
		%>
		
<tbody>
		<tr>
			<td><%=userId[i]%></td>
			<td><%=stockName%></td>
			<td><%=quantityOfStocks%></td>
			<td><%=buyPrice%></td>
			<td><%=chargeback[i]%></td>
			<td><%=amountInvested[i]%></td>
			<td><%=subtractedBalance[i]%></td>
			<td><%=roleType[i]%></td>
			<td><%=d.getNoOfDaysStockHeld(userId[i])%></td>
		</tr>
		<%
						}
			d.updateBalanceFund(fid, fundsubtractedBalance);
		%>
	<!-- </table> -->

</tbody>
</table>
</div>
</h5>
	
	
	<br><br>

<form action="DisplayFundUsers.jsp" method="post">

<center>
<div class="container">
<input type='submit' name='buyAnother' value='Buy For Another Fund User' class="btn btn-info"></input>
</div>
</center>

</form>

<br><br><br>

	
	
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

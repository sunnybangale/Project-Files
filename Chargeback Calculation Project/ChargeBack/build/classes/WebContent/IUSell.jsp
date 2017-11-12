
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  
    import="java.util.ArrayList"
    import="java.util.List"
    import="com.cts.cbc.dao.UserDAO"
    import="com.cts.cbc.vo.IndividualUserStockDetailsVo"
    import="javax.servlet.RequestDispatcher"
%>

<%@page import="com.cts.cbc.bo.IndividualUserSellCalculations"%>
<%@page import="com.cts.cbc.vo.StockDetailsVo"%>
<%@page import="com.cts.cbc.vo.UserVo"%>
<%@page import="javax.xml.ws.Response"%>
<%@page import="com.cts.cbc.exceptions.DBException"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


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
				<h2>Sell Stocks</h2>
				<hr class="star-primary">
			</div>
		</div>
	</div>
	</section>



<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP 1.0 
 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%>


<%!//String user;

List l = new ArrayList();
List l1 = new ArrayList();


Iterator it;
Iterator it1;

UserDAO da = new UserDAO();

String userId;
String firstName;
String lastName;
long mobile;
String stockName;
double sellPrice;
int sumOfBoughtStocks;
String transactionType;

UserVo uv;
StockDetailsVo sdv;
IndividualUserStockDetailsVo iusdv;

RequestDispatcher rd;

String selectedStockName;
String stock;
int stockCount;

//Map<String,Integer> m;
//Map<String,Integer> m1;

HttpSession hs;
//String u;

IndividualUserSellCalculations iuc;

String stockId;
int quantity;

double buyCost;
double sellCost;
double profit;
double profitPercent;
double profitChargeback;
double commission;
double fees;
double tax;
double chargeback;
double balance;
double updatedBalance;


int countBuyTransactions;
int flag;

String transactionId;
String generatedTransactionId;

%>

<%


userId=application.getAttribute("selectUser").toString();


hs=request.getSession();
hs.setAttribute("userId",userId);
//System.out.println("he wala "+userId);


//out.print("User is "+userId);

//////////////


//m= new HashMap<String,Integer>();

uv = new UserVo();
sdv = new StockDetailsVo();
iusdv= new IndividualUserStockDetailsVo();			
iuc = new IndividualUserSellCalculations();
%>
		
		


<%
		try {

	countBuyTransactions=da.getSellStockCount(userId);		
	
	if(countBuyTransactions==0)
	{
		l=da.getBuyStockData(userId);
		flag=0;	
		//System.out.println("flag 0");
	
	}
	else
	if(countBuyTransactions>0)
	{	
		l=da.getSellStockData(userId);
		l1=da.getOnlyBuyStockData(userId);
		flag=1;

		if(l1.size()!=0)
		{
			flag=2;
		}	
		//System.out.println("flag "+flag);

	}
	
	
	if(l.size()!=0 || l1.size()!=0)
	{
%>		
		
	<form >
		
<!-- <table style='width:100%' border='10'>
<col width='130'><col width='130'><col width='130'><col width='130'>
<col width='130'><col width='130'><col width='130'><col width='130'>
<col width='130'><col width='130'> -->

<h5>
<div class="container">
<table class="table table-hover">
<thead>

<tr class="success"><td>User_id</td><td>First Name</td><td>Last Name</td><td>Mobile Number</td>
<td>Stock Name</td><td>Sell Price</td><td>Number of Stocks</td>
<td>Select Stock to Sell</td></tr>	
		
</thead>
		
<% 		
	it = l.iterator();

	
	while (it.hasNext()) 
	{
		uv = (UserVo) it.next();
		sdv= (StockDetailsVo)it.next();
		iusdv = (IndividualUserStockDetailsVo)it.next();
		
		userId = uv.getUserId();
		firstName = uv.getFirstName();
		lastName = uv.getLastName();
		mobile = uv.getMobile();
		
		stockName = sdv.getStockName();
		sellPrice= sdv.getSellPrice();
		
		sumOfBoughtStocks = iusdv.getSumOfBoughtStocks();
		//transactionType= iusdv.getTransactionType();
%>

		
		<!-- <col width='130'><col width='130'><col width='130'><col width='130'>
		<col width='130'><col width='130'><col width='130'><col width='130'>
		<col width='130'><col width='130'> -->
		
		<tbody>	
		
		<tr><td><%=userId%></td><td><%=firstName%></td><td><%=lastName%></td><td><%=mobile%></td>
		<td><%=stockName%></td><td><%=sellPrice%></td><td><%=sumOfBoughtStocks%></td>
		<td><input type='radio' name='selectStock' value='<%=stockName%>'></input></td></tr>
		

<%
	}
	
////////////////////
	
 it1 = l1.iterator();

	
	while (it1.hasNext()) 
	{
		uv = (UserVo) it1.next();
		sdv= (StockDetailsVo)it1.next();
		iusdv = (IndividualUserStockDetailsVo)it1.next();
		
		userId = uv.getUserId();
		firstName = uv.getFirstName();
		lastName = uv.getLastName();
		mobile = uv.getMobile();
		
		stockName = sdv.getStockName();
		sellPrice= sdv.getSellPrice();
		
		sumOfBoughtStocks = iusdv.getSumOfBoughtStocks();
		
		//System.out.println(userId + stockName + sumOfBoughtStocks+" "+sellPrice+ mobile);
%>		
		<!-- <col width='130'><col width='130'><col width='130'><col width='130'>
		<col width='130'><col width='130'><col width='130'><col width='130'>
		<col width='130'><col width='130'> -->
		
		<tr><td><%=userId%></td><td><%=firstName%></td><td><%=lastName%></td><td><%=mobile%></td>
		<td><%=stockName%></td><td><%=sellPrice%></td><td><%=sumOfBoughtStocks%></td>
		<td><input type='radio' name='selectStock' value='<%=stockName%>'></input></td></tr>
<%
}
	 
%>	 
	<!-- </table> -->
	</tbody>
</table>
</div>
</h5>
	
	<br>
	<br>

<center>			
	<h3>Number of Stocks to Sell</h3>
	
	<br>
	<input type='text' name='quantity' value='0' onkeypress='return event.charCode >= 48 && event.charCode <= 57'></input>
	
	<br>
	<br>
	
	<div class="container">
	<input type='submit' name='sellStock' value='Sell' class="btn btn-info"></input>
	</div>
</center>

<br>
	<br>	
<% 	

	if(request.getParameter("sellStock")!=null )
	{
		selectedStockName = request.getParameter("selectStock");
		//System.out.println("stock name is "+selectedStockName);
		
		if(selectedStockName==null)
		{
		//System.out.println("NOT ALLOWED !!!!");
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Please select a stock to sell!!');");
		out.println("location='IUSell.jsp';");
		out.println("</script>");
		}
		
		else
		{
		//System.out.println("user id is "+userId);
		
		
		if(flag==0)
		{
		stockCount= da.getBuyStockQuantity(userId,selectedStockName);
		//System.out.println("stock count is "+ stockCount);
		}
		else if(flag==1)
		{
		stockCount= da.getSellStockQuantity(userId,selectedStockName);
		//System.out.println("stock count is "+ stockCount);
		}
		else if(flag==2)
		{
			stockCount= da.getOnlyBuyStockQuantity(userId,selectedStockName);
			
			if(stockCount==0)
			{
				stockCount= da.getSellStockQuantity(userId,selectedStockName);
			}
				
			//System.out.println("this stock count is "+ stockCount);
		}
		
		quantity=Integer.parseInt(request.getParameter("quantity"));
		
		if(quantity<=stockCount && quantity!=0)
		{
	
	application.setAttribute("stockName",selectedStockName);
	application.setAttribute("quantity",quantity);
	 
	
	
		//System.out.println("chalaaa !!!!");
		response.sendRedirect("IUSellTransactions.jsp");
	
		}
		else
		{
	//System.out.println("NOT ALLOWED !!!!");
	out.println("<script type=\"text/javascript\">");
	out.println("alert('Please enter valid quantity!!');");
	out.println("location='IUSell.jsp';");
	out.println("</script>");
		}

	}
	}

	}//if ends
	else	{
%>
	<center><h2>Currently, there are no stocks bought by <%=userId %></h2></center>
<br><br><br><br><br><br><br><br><br><br><br>
<%		
	}
%>

</form>

<% 		
	} catch (DBException e) {
		// TODO Auto-generated catch block
		//System.out.println("Sell problem");
	}
%>



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
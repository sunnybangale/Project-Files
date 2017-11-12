<%@page import="com.cts.cbc.vo.StockDetailsVo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.io.PrintWriter"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cts.cbc.dao.*"%>

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
				<h2>Buy Stocks</h2>
				<hr class="star-primary">
			</div>
		</div>
	</div>
</section>



<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP 1.0 
 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%>


<form action="IUBuy.jsp">
	<%!String user;
	PrintWriter pw;
	String temp;
	String stockId;
	int quantity;
	double buyPrice;
	double obtainedBalance;
	double checkBalance;
	int flag=0;
	int count = 0;
	%>
	
	<%
			pw = response.getWriter();
				user=application.getAttribute("selectUser").toString(); 
				pw.print("User is " + user);
			
			
				UserDAO d = new UserDAO();
				StockDetailsVo sdv=new StockDetailsVo();
			    List<StockDetailsVo> l = new ArrayList<StockDetailsVo>();
				
			    try {

			l = d.getBuyStockDetails();

			if(l.size()!=0)
			{
			
			Iterator<StockDetailsVo> i = l.iterator();
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
			<td>Stock Id</td>
			<td>Stock Name</td>
			<td>Buy Price</td>
			<td>Select Stock to Buy</td>
		</tr>

</thead>
			<%
				while (i.hasNext()) 
				{
				sdv = i.next();
			%>

<tbody>			
			<tr><td><%=sdv.getStockId()%></td>
			
			<td><%=sdv.getStockName() %></td>
			
			<td><%=sdv.getBuyPrice()%></td>
			
			<td><input type='radio' value="<%=sdv.getStockId()%>" name='selectUser'></td>
			</tr>
			<%
			stockId=request.getParameter("selectUser");
			//System.out.println("Stock Id is : "+stockId);

			count++;
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
	<h3>Enter quantity</h3>
	
	<br>
	<input type="text" name="getquant" value="0" onkeypress='return event.charCode >= 48 && event.charCode <= 57'> 
	
	<br>
	<br>
	
	<div class="container">
	<input type="submit" name="submit" value="Buy" class="btn btn-info">
	</div>
	
</center>	
	<%
	quantity=Integer.parseInt(request.getParameter("getquant"));
	
	application.setAttribute("getquant",quantity);
	
	buyPrice=d.getBuyPrice(stockId);
	obtainedBalance=quantity*buyPrice;
	
	checkBalance=d.getBalance(user);
	
	if(checkBalance>=obtainedBalance && request.getParameter("submit")!=null && quantity!=0 )
	{
			
		if(stockId==null)
		{
		//System.out.println("NOT ALLOWED !!!!");
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Please select a stock to sell!!');");
		out.println("location='IUBuy.jsp';");
		out.println("</script>");
		}		
		else
		{
		//System.out.println("ALLOWED !!!!");
		response.sendRedirect("IUBuyTransactions.jsp");
		}
	}
	else
	{
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Please enter valid quantity/ Low on Balance!!');");
		out.println("location='IUBuy.jsp';");
		out.println("</script>");
	}
	
}//if ends
else
{
	%>
	
	<h2>Sorry, there are no stocks to buy for <%=user%></h2>
		
	<%
}	
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("Exception!");
		}
		
		HttpSession hs=request.getSession();
	
		hs.setAttribute("user",user);
		hs.setAttribute("stockId",stockId);
		
	%>
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
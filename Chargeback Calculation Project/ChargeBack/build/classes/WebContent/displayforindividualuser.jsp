<%@page import="java.util.Iterator"%>
<%@page import="com.cts.cbc.vo.TransactiondetailsForIndividualVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.cts.cbc.dao.DisplayUserDAO"%>
<%@page import="com.cts.cbc.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<a class="navbar-brand" href="Chargeback.jsp">HOME</a>
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
				<h2>Stock Transactions</h2>
				<hr class="star-primary">
			</div>
		</div>
	</div>
</section>



<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP 1.0 
 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%> 

	<%
		HttpSession hs = request.getSession();
		UserVo vo = (UserVo) hs.getAttribute("user");
		TransactiondetailsForIndividualVo user;
		String userId = vo.getUserId();
		String roleType = vo.getRoleType();

		DisplayUserDAO d = new DisplayUserDAO();
		List<TransactiondetailsForIndividualVo> l = new ArrayList<TransactiondetailsForIndividualVo>();
		l = d.getTransactionsdetailForIndividualUser(vo);
		Iterator<TransactiondetailsForIndividualVo> i = l.iterator();

		if (i.hasNext()) {

	%>
<!-- 	
	<table style='width:100%' border='10'>
	<col width='130'><col width='130'><col width='130'><col width='130'>
	<col width='130'><col width='130'><col width='130'><col width='130'> -->
<h5>
<div class="container">
<table class="table table-hover">
<thead>	
			<tr class="success">
			<td>Transaction_id</td>
			<td>User_id</td>
			<td>Stock_id</td>
			<td>No_of_stock</td>
			<td>Chargeback</td>
			<td>Balance</td>
			<td>Transaction_type</td>
			<td>Transaction_date</td>
		</tr>
</thead>

		<%
			while (i.hasNext()) {
					user = (TransactiondetailsForIndividualVo) i.next();
		%>

<tbody>
		<tr>
			<td><%=user.getTransactionId()%></td>
			<td><%=user.getUserId()%></td>
			<td><%=user.getStockId()%></td>
			<td><%=user.getNoOfStock()%></td>
			<td><%=user.getChargeBack()%></td>
			<td><%=user.getBalance()%></td>
			<td><%=user.getTransactionType()%></td>
			<td><%=user.getTransactionDate()%></td>
		</tr>
		

		<%
			}
		%>

	<!-- </table> -->
</tbody>
</table>
</div>
</h5>	

	<%
		}
		else
		{

	%>
		<center><h2>Sorry, you have made no transactions!</h2></center>
		<br><br>
	<% 
			
		}
	%>

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
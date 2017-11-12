
<%@page import="com.cts.cbc.exceptions.DBException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.cts.cbc.dao.FundDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cts.cbc.vo.FundVo"%>
<%@page import="java.util.List"%>
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
				<h2>Buy/Sell Stocks</h2>
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




	<%!
	List<FundVo> l;
	FundDAO da = new FundDAO();
	Iterator<FundVo> it;
	FundVo uv = new FundVo();

	String fundId;
	String fundName;
	HttpSession hs;
	int amountDollar;
	
	
	%>
	<%
	if (request.getParameter("buy") != null) {

		if (request.getParameter("SelectFund") != null) {
			//hs=request.getSession();
			application.setAttribute("fundId", request.getParameter("SelectFund"));
			/* RequestDispatcher rd = request
					.getRequestDispatcher("FUBuy.jsp");
			rd.forward(request, response); */
			response.sendRedirect("FUBuy.jsp");
		}

		else {
			out.print("<script type=\"text/javascript\">");
			out.print("alert('Please select a Fund!!!');");
			out.print("location='DisplayFundUsers.jsp';");
			out.print("</script>");

		}

	} else if (request.getParameter("sell") != null) {

		if (request.getParameter("SelectFund") != null) {
			application.setAttribute("SelectFund",request.getParameter("SelectFund"));

			response.sendRedirect("FUSell.jsp");
		} else {
			out.print("<script type=\"text/javascript\">");
			out.print("alert('Please select a Fund!!!');");
			out.print("location='DisplayFundUsers.jsp';");
			out.print("</script>");

		}

	} else if (request.getParameter("addFund") != null) {

		
			/* RequestDispatcher rd = request
					.getRequestDispatcher("AddFundUsers.jsp");

			rd.forward(request, response); */
		//application.setAttribute("fundId", request.getParameter("SelectFund"));
		/* RequestDispatcher rd = request
				.getRequestDispatcher("FUBuy.jsp");
		rd.forward(request, response); */
		response.sendRedirect("AddFundUsers.jsp");
		

	}
	
	
	%>
	

	<form action="DisplayFundUsers.jsp">
	
		

			<%
				l = new ArrayList<FundVo>();
				try {
					l = da.getFundData();
					it = l.iterator();

					
			if(l.size()!=0 )
			{
%>					
			<!-- <table style='width: 100%' border='10'>
			<col width='130'>
			<col width='130'>
			<col width='130'>
			<col width='80'> -->

<h5>			
<div class="container">
<table class="table table-hover">
<thead>				
			<tr class="success">
				<td>Fund Id</td>
				<td>Fund Name</td>
				<td>Amount (in dollars)</td>
				<td>Select Fund</td>
			</tr>
</thead>				
				
				
				
				
<% 					
					while (it.hasNext()) {
						uv = (FundVo) it.next();

						fundId = uv.getFundId();
						fundName = uv.getFundName();
						amountDollar = uv.getAmountDollar();
			%>
			<!-- <col width='130'>
			<col width='130'>
			<col width='130'>
			<col width='80'> -->
			
<tbody>				
			<tr>
				<td><%=fundId%></td>
				<td><%=fundName%></td>
				<td><%=amountDollar%></td>
				<td><input type='radio' name='SelectFund' value='<%=fundId%>'>
				</td>
			</tr>

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
		
		<div class="container">
		<input type='submit' name='buy' value='Buy' class="btn btn-info"> 
		</div>
		
		<br>
	
		
		<div class="container">
		<input type='submit' name='sell' value='Sell' class="btn btn-info"> 
		</div>
		
		<br>
		
		</center>
		
	
	<%
		
			}//if ends
			else	{
		%>
		<center><h2>Currently, there are no Fund Users. Please add one.</h2></center>
<br><br><br>
		<%	
			}
		%>
		
		
		
		<center>
		<div class="container">
		<input type='submit' name='addFund' value='AddFund' class="btn btn-info">
		</div>

		</center>
		
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		
		
		
		
		
		
	</form>
	<%
	
	
		} catch (DBException e) {

			//System.out.println("Nahi hotey");
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
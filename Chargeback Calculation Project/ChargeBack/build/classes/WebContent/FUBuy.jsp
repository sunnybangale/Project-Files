
<%@page import="com.cts.cbc.util.MyUtil"%>
<%@page import="com.cts.cbc.exceptions.BusinessException"%>
<%@page import="com.cts.cbc.vo.StockDetailsVo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1" import="java.io.PrintWriter"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cts.cbc.dao.*"%>
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
	{response.sendRedirect("LoggedOut.jsp");
		}

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




	<%!String user;
	int count;
	FundDAO d ;
	StockDetailsVo sdv;
	List<StockDetailsVo> l;
	HttpSession s;
	Iterator<StockDetailsVo> i;
	String fundId;
	String id;
	HttpSession hs;
	%>
	<%
	//hs=request.getSession();
	//fundId=hs.getAttribute("fundId").toString();
	fundId=application.getAttribute("fundId").toString();
	
	d= new FundDAO();
		sdv=new StockDetailsVo();
	     l = new ArrayList<StockDetailsVo>();
		try {

			l = d.getBuyStockData();
			i= l.iterator();

			
			%>


<%-- FUND_ID <%=fundId %>
 --%>
 
 <form action="FUBuy.jsp" method="post" name="frm">

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
			<%-- <td>Enter Quantity</td>--%>
</thead>

			<%
				while (i.hasNext()) {
				sdv = i.next();
				id=sdv.getStockId();
				%>
					
	<tbody>		
		<tr>
		
			<td><%=sdv.getStockId()%></td>
			<td><%=sdv.getStockName() %></td>
			<td><%=sdv.getBuyPrice()%></td>
			<td><input type='radio' name='selectStock'
				value='<%=id %>'></input></td>
			<%--  <td><input type="text" name='quantity'></td> --%>
			</tr>
			
			<%
			
				count++;
					}
			%>

	<!-- </table> -->
	</tbody>
	</table>
	</div>
	</h5>
	
	<br><br><br><br>
	
	<center>
	
	<h3>Enter Quantity</h3> 
	
	<input type="text" name="quantity" value="0" onkeypress='return event.charCode >= 48 && event.charCode <= 57'></input>
	
	<br><br>
	
	<div class="container">
	<input type="submit" name="sub" value="BuyStock" class="btn btn-info">
	</div>
	
	</center>
	
	<br>
	<br>
	
	<%  
	if (request.getParameter("sub") != null) {
			HttpSession htp;
			if(request.getParameter("selectStock")==null && Integer.parseInt(request.getParameter("quantity").toString())==0)
			{
				//System.out.println("NOT ALLOWED !!!!");
			out.print("<script type=\"text/javascript\">");
			out.print("alert('Please select a stock to sell!!');");
			out.print("location='FUBuy.jsp';");
			out.print("</script>"); 
						}
			else {
			//System.out.println(request.getParameter("quantity").toString());
			application.setAttribute("stockID",request.getParameter("selectStock"));
			application.setAttribute("quantity",request.getParameter("quantity"));
			//application.setAttribute("quantity",request.getParameter("quantity"));
				/* RequestDispatcher rd = request.getRequestDispatcher("ConfirmBuyForFund.jsp");
				rd.forward(request, response); */
				response.sendRedirect("ConfirmBuyForFund.jsp");
			}
	}

	%>
</form>
	<%
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("Exception!");
			throw new BusinessException(MyUtil.getMes("rule_prob"));
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
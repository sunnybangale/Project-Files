<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.ArrayList"
	import="java.util.List" import="com.cts.cbc.dao.FundDAO"
	import="com.cts.cbc.vo.FundUserStockDetailsVo"
	import="javax.servlet.RequestDispatcher"%>
<%@page import="com.cts.cbc.vo.StockDetailsVo"%>
<%@page import="com.cts.cbc.vo.FundVo"%>
<%@page import="com.cts.cbc.vo.StockDetailsVo"%>
<%@page import="javax.xml.ws.Response"%>
<%@page import="com.cts.cbc.exceptions.DBException"%>
<%@page import="java.util.Iterator"%>
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
				<h2>Confirm Buy</h2>
				<hr class="star-primary">
			</div>
		</div>
	</div>
	</section>





<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP 1.0 
 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%>

<%!FundDAO d;
	FundVo fv;
	String fname = "";
	String sname = "";
	double sprice = 0.0;
	StockDetailsVo sdv;
	String user[];
	String userAmount[];
	int quantity;
	double sumBalance;
	int countUser;
	double enterBalance;
	String id;
	String fid;
	double balance;
	double tot_stock_price;
	String member;
	int count;
	String ans;
	List l;
	Iterator it;
	int i;
	int j;
	HttpSession hs;
	
	%>
	<%
	d = new FundDAO();
	userAmount=new String[10];
		if (request.getParameter("confirm") != null) {
			countUser = 0;
			sumBalance = 0.0;
			//System.out.println(user[0] + "fgfdgfdgfdg" + user.length);
			for (int i = 0; i < count; i++) {
				//System.out.println(user[i]);
				balance = d.getBalanceUser(user[i]);
				//System.out.println(balance);
				enterBalance = Double.parseDouble(request
						.getParameter(user[i]));
				//System.out.println(enterBalance);
				if (enterBalance <= balance) {
					++countUser;
					sumBalance += enterBalance;
				}
			}
			if (countUser == d.getUserCount(fid)
					&& sumBalance == tot_stock_price) {
								
				hs=request.getSession();
				/* hs.setAttribute("stockName",fname);
				hs.setAttribute("UserCount",countUser);
				hs.setAttribute("StockId",id);
				//hs.setAttribute("fundId",fid);
				//for(int c=0;c<countUser;c++)
				hs.setAttribute("UserId",user);
				hs.setAttribute("quantityOfStocks",quantity);
				hs.setAttribute("stockPrice",sprice);
				hs.setAttribute("totalStockPrie",tot_stock_price);
				RequestDispatcher rd1 = request
						.getRequestDispatcher("FUBuyTransactions.jsp");
				rd1.forward(request, response); */
				for(int c=0;c<countUser;c++)
				userAmount[c]=request.getParameter(user[c]);
				application.setAttribute("stockName",fname);
				application.setAttribute("UserCount",countUser);
				application.setAttribute("stockID",id);
				//hs.setAttribute("fundId",fid);
				//for(int c=0;c<countUser;c++)
				application.setAttribute("UserId",user);
				application.setAttribute("quantityOfStocks",quantity);
				application.setAttribute("stockPrice",sprice);
				application.setAttribute("totalStockPrie",tot_stock_price);
				application.setAttribute("users",userAmount);
				response.sendRedirect("FUBuyTransactions.jsp");
						
			}
			else
			{
				//System.out.println("NOT ALLOWED !!!!");
				out.print("<script type=\"text/javascript\">");
				out.print("alert('Please enter valid amounts!!');");
				out.print("location='ConfirmBuyForFund.jsp';");
				out.print("</script>"); 
			}
		
		}
	%>

	<form action="ConfirmBuyForFund.jsp" name="frm" method="post">
		<%
			//HttpSession s = request.getSession();
			//fid = s.getAttribute("fundId").toString();
			fid = application.getAttribute("fundId").toString();
			
			
			//out.print(s.getAttribute("fundId"));
			id = application.getAttribute("stockID").toString();
			//out.print(id); 

			//System.out.println("asdf565656");
			l = new ArrayList();

			l = d.getFundStockNames(fid, id);
			it = l.iterator();
			while (it.hasNext()) {
				fv = (FundVo) it.next();
				sdv = (StockDetailsVo) it.next();
				fname = fv.getFundName();
				sname = sdv.getStockName();
				sprice = sdv.getBuyPrice();
				//System.out.println(sprice+" bbbbb");
			}                                                                     
			
			try {
				//ans= request.getParameter("quantity");
				ans=application.getAttribute("quantity").toString();
				//application.getAttribute("quantity").toString();
				
			//System.out.println("quantity "+ans);
				quantity = Integer.parseInt(ans.trim());
			tot_stock_price = quantity * sprice;
			}
			catch (Exception e){
				System.out.println(e.getMessage());}
		%>
		
<h5>
<div class="container">
<table class="table table-hover">

<thead>
		<tr class="success"> 
		  <td>Fund Name</td>  
		 <td>Stock Name</td>
		 <td>Stock Price</td>
		 <td>Total Stock Price</td>
		</tr>
</thead>		

<tbody>	
	
		<tr> 
		<td> <%=fname%></td>
		<td> <%=sname%></td>
		<td> <%=sprice%></td>
		<td> <%=tot_stock_price%></td>
		</tr>


</tbody>		
</table>
</div>		
</h5>
<center>		
		<%
			count = d.getUserCount(fid);
			//out.print(count);

			user = d.getUserFund(fid);

			for (i = 0; i < count; i++)
			{
				j=i+1;
		%>		
	
		<h5> Member <%=j%>  Contribution * </h5>
		
		<% member = "Member" + (i + 1); %>

		<input type="text" name="<%=user[i]%>" value="0" onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
		
		<%
		//System.out.println(" Member " + (i + 1) + " Contribution *"+request.getParameter(user[i]));
		}
		%>
	</center>	
		<br>
		<br>
		
		<center>
		<div class="container">
		<input type="submit" name="confirm" value="Confirm" class="btn btn-info">
		</div>

		</center>
<br>
<br>
<br>

	</form>
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
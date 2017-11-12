<%@page import="com.cts.cbc.bo.FundUserBuyCalculations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.io.PrintWriter"
	import="java.util.ArrayList" import="java.util.Iterator"
	import="java.util.List" import="com.cts.cbc.vo.UserVo"
	import="com.cts.cbc.dao.FundDAO"
	import="com.cts.cbc.exceptions.DBException"%>
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
				<h2>Create new fund</h2>
				<hr class="star-primary">
			</div>
		</div>
	</div>
	</section>





<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP 1.0 
 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%>




<script type="text/javascript">

/***********************************************
* Limit number of checked checkboxes script- by JavaScript Kit (www.javascriptkit.com)
* This notice must stay intact for usage
* Visit JavaScript Kit at http://www.javascriptkit.com/ for this script and 100s more
***********************************************/

function checkboxlimit(checkgroup, limit){
	var checkgroup=checkgroup
	var limit=limit
	for (var i=0; i<checkgroup.length; i++){
		checkgroup[i].onclick=function(){
		var checkedcount=0
		for (var i=0; i<checkgroup.length; i++)
			checkedcount+=(checkgroup[i].checked)? 1 : 0
		if (checkedcount>limit){
			alert("You can only select a maximum of "+limit+" checkboxes")
			this.checked=false
			}
		}
	}
}

</script>


<%!
List<UserVo> l;
FundDAO da;
Iterator<UserVo> it;
UserVo uv;
FundUserBuyCalculations fuc;


String userId[];
String firstName;
String lastName;
long mobile;
String newFundId;
String newGeneratedsFundId;
int i;
double amount;

String id[];

%>

	<%
	
	l = new ArrayList<UserVo>();
	fuc = new FundUserBuyCalculations();
	da = new FundDAO();
	
	uv = new UserVo();
	userId=new String[100];
	
	
	
	
	
	
	
	if(request.getParameter("addNewFund")!=null)
	{
		if(request.getParameter("newFundID")!=null && request.getParameter("fundId")!=null && !request.getParameter("fundId").equals("") )
		{
			//System.out.println("in jsp fundId");
			newGeneratedsFundId=da.getLastFundID();
			newFundId=fuc.getGenerateFundId(newGeneratedsFundId);
			
		
			id=request.getParameterValues("newFundID");
		da.insertNewFund(newFundId,request.getParameter("fundId"),id);
		
		amount=fuc.getTotalFundBalance(id);
		
		da.updateBalanceFund(newFundId,amount);
		//System.out.println("balance updated");

		/* RequestDispatcher rd1 = request
				.getRequestDispatcher("DisplayFundUsers.jsp");
		rd1.forward(request, response); */
	
		response.sendRedirect("RoleSelection.jsp");
		}
		}
		
	
	
	
	%>
	
		
		
		<form action='AddFundUsers.jsp' method='post' id='frm' name='frm'>
		
		
				
<% 

		try {

			l = da.getNewUserData();
			it = l.iterator();

			
			if (l.size() != 0)
			{
			
%>	
	
		<!-- FUND ID: <%= newFundId%><br><br><br> -->
		<center><h5>Enter Fund Name * </h5><input type='text' name='fundId' value="New Fund"></input>
		</center>
		<br><br><br>
		
		<!-- <table style='width:100%' border='10'>
				<col width='80'><col width='80'><col width='80'>
				<col width='80'><col width='80'> -->
				
<h5>			
<div class="container">
<table class="table table-hover">
<thead>	
				
				<tr class="success">
				<td>User Id</td><td>First Name</td><td>Last Name</td>
				<td>Mobile Number</td><td>Select User</td>
				</tr>
</thead>
	
				
				
				
<%				
			while (it.hasNext()) {
				uv = (UserVo) it.next();

				userId[i] = uv.getUserId();
				firstName = uv.getFirstName();
				lastName = uv.getLastName();
				mobile = uv.getMobile();
				%>
				
				<tbody>
				
				<tr>
				<td><%= userId[i]%></td>
				<td><%= firstName%></td>
				<td><%= lastName%></td>
				<td><%= mobile%></td>
				<td><input type='checkbox' name='newFundID' value='<%=userId[i]%>'></input></td>
				</tr>
			
			
			
			<% i=i+1;}%>
			
			</tbody>
		</table>
		</div>
		</h5>
			
			<br>
			<center>
			<div class="container">
			<input type='submit' name='addNewFund' value='Add New Fund' class="btn btn-info">
			</div>
			</center>
			
		<%
		/* if( request.getParameter("newFundID")==null )
		{
			out.print("<script type=\"text/javascript\">");
			out.print("alert('Please select min two users for Fund!!!');");
			out.print("location='AddFundUsers.jsp';");
			out.print("</script>");
		}
		if(request.getParameter("fundId")==null || request.getParameter("fundId")=="" )
		{
			out.print("<script type=\"text/javascript\">");
			out.print("alert('Please enter name for Fund!!!');");
			out.print("location='AddFundUsers.jsp';");
			out.print("</script>");
			
		}
		else */
		

		%>
			</form>
			<script type="text/javascript">
			checkboxlimit(document.forms.frm.newFundID, 5);
			</script>
			
			<%
			
			}//if ends
			else {
	%>
	<center><h2>Currently, there are no users who have registered to join a fund.</h2></center>
	
	<%		}
			
			}
		 catch (DBException e) {
			// TODO Auto-generated catch block
			//System.out.println("Nahi hotey");
		}
		 
	%>




</body>

<br><br><br><br><br>
<br><br><br><br><br>
<br><br>

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
	
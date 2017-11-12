
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>

<script>
function validateForm() {
    var userId = document.forms["LoginForm"]["userId"].value;
    var password = document.forms["LoginForm"]["password"].value;
    var roleType = document.forms["LoginForm"]["roleType"].value;
    
if (userId == null || userId == "") {
        alert("User ID must be filled out");
        return false;
    }
   
    if (password == null || password == "") {
        alert("password must be filled out");
        return false;
    }
  
    if (roleType == null || roleType == "") {
        alert("Role Type must be filled out");
        return false;
    }

    
}
</script>




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
<!-- 
 --><body id="page-top" class="index" style="background-image: url(img/bnew.jpg)">

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
			<a class="navbar-brand" href="#page-top">HOME</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="hidden"><a href="#page-top"></a></li>
				<li class="page-scroll"><a href="#login">Login</a></li>
				<li class="page-scroll"><a href="#about">About Us</a></li>
				<li class="page-scroll"><a href="#contact">Contact Us</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<!-- Header -->
	<header>
	<div class="container" >
		<div class="row">
			<div class="col-lg-12">
				<img class="img-circle" src="img/Preview.jpg" alt="">
				<div class="intro-text">
					<span class="name">Welcome to ChargeBack Calculation system</span>
					<hr class="star-light">
					<span class="skills">Individual User - Fund User</span>
					<br>
					<span class="skills">CBC is a system used for determining portfolio transaction costs driven by client cash flows,
				 and to charge those costs back to the appropriate clients.</span>
				</div>
			</div>
		</div>
	</div>
	</header>

	<!-- Login Grid Section -->
	<section id="login">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2>LOGIN</h2>
				<hr class="star-primary">
			</div>
			<form action="ValidationServlet" method="post" name="LoginForm"
				onsubmit="return validateForm()">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label>UserId</label>
								<p>USER-ID</p>
								<input
									style="background-color: #FCF5D8; color: #AD8C08; border: 3px solid #AD8C08;"
									text" name="userId" class="form-control" placeholder="User ID"
									id="name" required
									data-validation-required-message="Please enter your user Id.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div></div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label>Password</label>
								<p>PASSWORD</p>
								<input type="password" name="password" class="form-control"
									placeholder="Password" id="password" required
									data-validation-required-message="Please enter your password."
									style="background-color: #FCF5D8; color: #AD8C08; border: 3px solid #AD8C08;"help-blocktext-danger">
								</p>
							</div>
						</div>

						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label>Role</label>
								<p>SELECT ROLE</p>
								<select name="roleType" name="roleType" class="form-control"><option
										value="BR">Bank Representative</option>
									<option value="INDL">Individual User</option>
									<option value="FUND">Fund User</option>
								</select>
							</div>
						</div>


						<div class="row control-group">
							<div class="col-lg-4 col-lg-offset-2">
								<!-- <input type="button" value="Register for free" onclick="document.forms[0].action = 'registration.jsp'; return true;""> -->
								<h4><p><a href="registration.jsp">REGISTER FOR FREE</a></p></h4>
							</div>
							
							<div class="row control-group">
								<div class="col-lg-4 col-lg-offset-2">
									<!-- <input type="button" value="Register for free" onclick="document.forms[0].action = 'registration.jsp'; return true;""> -->
									<h4><p>
										<a href="forgetpassword.jsp">FORGOT PASSWORD?</a>
									</p></h4>
								</div>
								<br><br>
							<div>
								<center><input type="submit" name="Login" value="submit" class="btn btn-info"></center>
							</div>
						</div>
			</form>
	</section>

	<!-- About Section -->
	<section class="success" id="about">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2>About Us</h2>
				<hr class="star-light">
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4 col-lg-offset-2">
				<p>We are a banking firm responsible for calculating the
					chargeback for individual clients or fund users after buying and
					selling of respective stocks.</p>
			</div>
			<div class="col-lg-4">
				<p>	Charge back is calculated by the Bank Representative at the time of buying or selling a stock
				 for a client or for a fund (fund is a group of clients, they can be from different countries) irrespective of profit or loss.	
				</p>
			</div>

		</div>
		
		<div class="row">
			<div class="col-lg-4 col-lg-offset-2">
		<p>
		</p>
		</div>
		</div>
		
		<div class="row">
			<div class="col-lg-4 col-lg-offset-2">
				<p>Chargebacks also occur in the distribution industry.
				 This type of chargeback occurs when the supplier sells a product at a higher price to the distributor
				  than the price they have set with the end user. </p>
			</div>
			<div class="col-lg-4">
				<p>CBC is a system used for determining portfolio transaction costs driven by client cash flows,
				 and to charge those costs back to the appropriate clients.
				</p>
			</div>

		</div>
	</div>
	</section>

	<!-- Contact Section -->
	<section id="contact">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2>Contact Us</h2>
				<hr class="star-primary">
			</div>
			<h4><p>Office Telephone: 020-252513</p>
			<p>Fax: 1-877-899-1234</p>
			<p>Email: abc@chargeback.com</p></h4>
			<div class="row"></div>
		</div>
	</div>

	</section>



	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="js/classie.js"></script>
	<script src="js/cbpAnimatedHeader.js"></script>

	<!-- Contact Form JavaScript -->
	<script src="js/jqBootstrapValidation.js"></script>
	<script src="js/contact_me.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/freelancer.js"></script>

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
                        <p>Chargeback is free to use, created by <a href="http://www.cognizant.com/">Visit Us</a>.</p>
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

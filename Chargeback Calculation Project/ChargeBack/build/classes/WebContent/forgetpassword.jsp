<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<script src="http://code.jquery.com/jquery-2.0.3.min.js"
	data-semver="2.0.3" data-require="jquery"></script>
<script src="script.js"></script>

<script type="text/javascript">
	function validateForm() {
		var userId = document.forms["PasswordForm"]["userId"].value;
		var mobile = document.forms["PasswordForm"]["mobile"].value;
		var flag=0;
		var boolean = true;
		
		if (userId == null || userId == "") {
			//alert("Contact no. must be filled out");
			//return false;
			document.getElementById("errorforuserid").innerHTML = "*This field cannot be left empty";
			flag = 1;
		}else {
			document.getElementById("errorforuserid").innerHTML = "";
		}
		
		
		
		if (mobile == null || mobile == "") {
			//alert("Contact no. must be filled out");
			//return false;
			document.getElementById("errorformobile").innerHTML = "*This field cannot be left empty";
			flag = 1;
		}

		else if (isNaN(mobile) || mobile.length != 10) {
			//alert("Mobile number is invalid");
			//return false;
			document.getElementById("errorformobile").innerHTML = "*Enter valid contact no.";
			flag = 1;
		} else {
			document.getElementById("errorformobile").innerHTML = "";
		}
		
		if (flag == 1) {
			boolean = false;
		}

		return boolean;
	}
</script>
<!-- starting css code -->

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
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

				
	<section id="portfolio">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2>Helping you retrieve your password..</h2>
				<hr class="star-primary">
			</div>
		</div>
	</div>
	</section>







	<div class="container">
		<form  method="post" name="PasswordForm"
			action="ForgetPasswordServlet" onsubmit="return validateForm()">



			<h4>UserId:</h4>

			<div  class="col-xs-3">
				<div class="input-group form-group">
					<div class="input-group-addon">
						<i class="fa fa-user"></i>
					</div>


					<input type="text" class="form-control" name="userId" id="userId" />
				</div>
			</div>
			
			<div>
				<p style="font-size: 15px; color: red" id="errorforuserid"></p>

			</div>
	


<br><br><br>

	<h4>Contact No.:</h4>
	<div class="col-xs-3">
		<div class="input-group form-group">
			<div class="input-group-addon">
				<i class="fa fa-mobile"></i>
			</div>


			<input type="text" class="form-control" name="mobile" id="mobile"  onkeypress='return event.charCode >= 48 && event.charCode <= 57' />
		</div>
	</div>
	<div>
		<p style="font-size: 15px; color: red" id="errorformobile"></p>

	</div>


<br><br><br>


			<div>
				<center>
					<input class="btn btn-info" type="submit" value="Submit">
					 <input	class="btn btn-info" type="reset" value="reset">
				</center>
			</div>
			

	</form>



</div>


<br><br><br><br>




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
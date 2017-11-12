<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>


<script src="http://code.jquery.com/jquery-2.0.3.min.js"
	data-semver="2.0.3" data-require="jquery"></script>
<script src="script.js"></script>
<script type="text/javascript">
	function validateForm() {

		var firstName = document.forms["RegistrationForm"]["firstName"].value;
		var lastName = document.forms["RegistrationForm"]["lastName"].value;
		var age = document.forms["RegistrationForm"]["age"].value;
		var email = document.forms["RegistrationForm"]["email"].value;
		var emailRegex = /^[A-Za-z0-9._]*\@[A-Za-z]*\.[A-Za-z]{2,5}$/;
		//var emailRegex = /^[A-Za-z0-9._]*\@[A-Za-z]*\.[A-Za-z]{2,5}*\.[A-Za-z]{2,5}$/;
		var password = document.forms["RegistrationForm"]["password"].value;
		var repassword = document.forms["RegistrationForm"]["repassword"].value;
		var mobile = document.forms["RegistrationForm"]["mobile"].value;
		var balance = document.forms["RegistrationForm"]["balance"].value;
		var city = document.forms["RegistrationForm"]["city"].value;
		var zipCode = document.forms["RegistrationForm"]["zipCode"].value;
		var address = document.forms["RegistrationForm"]["address"].value;
		var country = document.forms["RegistrationForm"]["country"].value;
		var decimal=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/; 

		//var letters = /^[a-zA-Z]+$/;
		var flag = 0;
		var gender = document.forms["RegistrationForm"]["gender"].value;
		var boolean = true;

		if (city == null || city == "") {
			//alert("Age must be filled out");
			//return false;
			document.getElementById("errorforcity").innerHTML = "*City must be selected";
			flag = 1;
		} else {
			document.getElementById("errorforcity").innerHTML = "";
		}

		if (zipCode == null || zipCode == "") {
			//alert("Age must be filled out");
			//return false;
			document.getElementById("errorforzipcode").innerHTML = "*zip Code must be selected";
			flag = 1;
		} else {
			document.getElementById("errorforzipcode").innerHTML = "";
		}

		if (address == null || address == "") {
			//alert("Age must be filled out");
			//return false;
			document.getElementById("errorforaddress").innerHTML = "*This field cannot be left empty";
			flag = 1;
		} else {
			document.getElementById("errorforaddress").innerHTML = "";
		}

		if (gender == null || gender == "") {
			//alert("Age must be filled out");
			//return false;
			document.getElementById("errorforgender").innerHTML = "*Gender must be selected";
			flag = 1;
		} else {
			document.getElementById("errorforgender").innerHTML = "";
		}

		if (balance == null || balance == "") {
			//alert("Age must be filled out");
			//return false;
			document.getElementById("errorforbalance").innerHTML = "*This field cannot be left empty";
			flag = 1;
		} else if (isNaN(balance) || balance.length>7 ) {
			document.getElementById("errorforbalance").innerHTML = "*Balance must be number and should be less than  $ 9 millions ";
			flag = 1;
		} else {
			document.getElementById("errorforbalance").innerHTML = "";
		}

		if (firstName == null || firstName == "") {
			//alert("First Name must be filled out");
			document.getElementById("errorforfirstname").innerHTML = "*This field cannot be left empty";
			//return false;
			flag = 1;
		} else if (firstName.length > 20 || !(/^[a-zA-Z]*$/.test(firstName))) {
			//alert("Last Name length must be less than 20");
			//return false;
			document.getElementById("errorforfirstname").innerHTML = "*First Name length must be less than 20 and must contain only alphabets";
			flag = 1;
		} else {
			document.getElementById("errorforfirstname").innerHTML = "";
		}

		if (lastName == null || lastName == "") {
			//alert("Last Name must be filled out");
			document.getElementById("errorforlastname").innerHTML = "*This field cannot be left empty";
			//return false;
			flag = 1;
		} else if (lastName.length > 20 || !(/^[a-zA-Z]*$/.test(lastName))) {
			//alert("Last Name length must be less than 20");
			//return false;
			document.getElementById("errorforlastname").innerHTML = "*Last Name length must be less than 20 and must contain only alphabets";
			flag = 1;
		} else {
			document.getElementById("errorforlastname").innerHTML = "";
		}

		if (password == null || password == "") {
			//alert("password must be filled out");
			document.getElementById("errorforpassword").innerHTML = "*This field cannot be left empty";
			//return false;
			flag = 1;
		} else if (password.length < 8 || !password.match(decimal)) {
			//alert("password must be greater than 8 digits");
			//return false;
			document.getElementById("errorforpassword").innerHTML = "*Password must be greater than 8 digits and should contain atleast one lowercase letter, one uppercase letter, one numeric digit, and one special character";
			flag = 1;
		} else {
			document.getElementById("errorforpassword").innerHTML = "";
		}

		if (repassword == null || repassword == "") {
			//alert("password must be filled out");
			document.getElementById("errorforrepassword").innerHTML = "*This field cannot be left empty";
			//return false;
			flag = 1;
		} else if (repassword != password) {
			//alert("password must be greater than 8 digits");
			//return false;
			document.getElementById("errorforrepassword").innerHTML = "*Password must be same";
			flag = 1;
		} else {
			document.getElementById("errorforrepassword").innerHTML = "";
		}

		if (age == null || age == "") {
			//alert("Age must be filled out");
			document.getElementById("errorforage").innerHTML = "*This field cannot be left empty";
			//return false;
			flag = 1;
		}

		else if (isNaN(age) || (age<21) || age>100) {
			//alert("Age must be a number");
			//return false;
			document.getElementById("errorforage").innerHTML = "*Age must be a number and must be greater than 21 and less than 100";
			flag = 1;
		} else {
			document.getElementById("errorforage").innerHTML = "";
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

		if (email == null || email == "") {
			//alert("Email must be filled out");
			//return false;
			document.getElementById("errorforemail").innerHTML = "*This field cannot be left empty";
			flag = 1;
		} else if (!emailRegex.test(email)) {
			//alert("Enter valid email");
			//return false;
			document.getElementById("errorforemail").innerHTML = "*Enter valid email";
			flag = 1;
		} else {
			document.getElementById("errorforemail").innerHTML = "";
		}
		if (country == null || country == "") {
			//alert("Email must be filled out");
			//return false;
			document.getElementById("errorforcountry").innerHTML = "*This field cannot be left empty";
			flag = 1;
		}else {
			document.getElementById("errorforcountry").innerHTML = "";
		}

		if (flag == 1) {
			boolean = false;
		}

		return boolean;
	}
</script>

<script
	src="http://maps.googleapis.com/maps/api/js?sensor=false&amp;libraries=places"
	type="text/javascript"></script>
<script type="text/javascript">
	function initialize() {
		var options = {
			types : [ '(regions)' ]
		};
		var input = document.getElementById('searchTextField');
		var autocomplete = new google.maps.places.Autocomplete(input, options);
	}
	google.maps.event.addDomListener(window, 'load', initialize);
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

<body id="page-top" class="index" >

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
				<h2>Registration</h2>
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


	<div class="container">
		<form method="post" name="RegistrationForm"
			action="RegistrationServlet" onsubmit="return validateForm()">

			<h4>First Name:</h4>

			<div class="col-xs-3">
				<div class="input-group form-group">
					<div class="input-group-addon">
						<i class="fa fa-user fa-fw"></i>
					</div>


					<input type="text" class="form-control" name="firstName" id="fname" />
				</div>
			</div>
			<div>
				<p style="font-size: 15px; color: red" id="errorforfirstname"></p>

			</div>


			
<br><br><br>

			<h4>Last Name:</h4>



			<div class="col-xs-3">
				<div class="input-group form-group">
					<div class="input-group-addon">
						<i class="fa fa-user fa-fw"></i>
					</div>



					<input type="text" class="form-control" name="lastName"
						onblur="validateLastname()" />

				</div>
			</div>


			<div>
				<p style="font-size: 15px; color: red" id="errorforlastname"></p>
			</div>


<br><br><br>

			<h4>Password:</h4>


			<div class="col-xs-3">
				<div class="input-group form-group">
					<div class="input-group-addon">
						<i class="fa fa-key"></i>
					</div>


					<input type="password" class="form-control" name="password">
				</div>
			</div>

			<div>
				<p style="font-size: 15px; color: red" id="errorforpassword"></p>
			</div>



<br><br><br>
			<h4>Confirm Password:</h4>


			<div class="col-xs-3">
				<div class="input-group form-group">
					<div class="input-group-addon">
						<i class="fa fa-key"></i>
					</div>


					<input type="password" class="form-control" name="repassword">
				</div>
			</div>
			<div>
				<p style="font-size: 15px; color: red" id="errorforrepassword"></p>
			</div>



<br><br><br>
			
				<h4>Role:</h4>

<div class="col-xs-3">
				<div class="input-group form-group">
					<div class="input-group-addon">
						<i class="fa fa-user fa-fw"></i>
					</div>

				<select name="roleType" class="form-control">
					<option value="INDL">Individual User</option>
					<option value="FUND">Fund User</option>
				</select>
			</div>
</div>





<br><br><br>

			<h4>Age:</h4>

			<div class="col-xs-3">
				<div class="input-group form-group">
					<div class="input-group-addon">
						<i class="fa fa-user fa-fw"></i>
					</div>


					<input type="text" name="age" class="form-control"
						onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
				</div>
			</div>
			<div>
				<p style="font-size: 15px; color: red" id="errorforage"></p>
			</div>


<br><br>
			<br>
<div>
				<h4>Gender:</h4>
			
			<h5>	<input type="radio" name="gender" value='Male'> Male &nbsp
			<br><br><input
					type="radio" name="gender" value='Female'>Female</h5>
			</div>


			<div>
				<p style="font-size: 15px; color: red" id="errorforgender"></p>
			</div>






<br><br>
			<h4>Contact no.:</h4>

			<div class="col-xs-3">
				<div class="input-group form-group">
					<div class="input-group-addon">
						<i class="fa fa-phone"></i>
					</div>


					<input type="text" name="mobile" class="form-control"
						onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
				</div>
			</div>
			<div>
				<p style="font-size: 15px; color: red" id="errorformobile"></p>
			</div>


<br><br><br><br>

			<h4>Email Id:</h4>


			<div class="col-xs-3">
				<div class="input-group form-group">
					<div class="input-group-addon">
						<i class="fa fa-envelope-o fa-fw"></i>
					</div>


					<input type="email" name="email" class="form-control">
				</div>
			</div>
			<div>
				<p style="font-size: 15px; color: red" id="errorforemail"></p>

			</div>


<br><br><br><br>
			<h4>Balance in dollars:</h4>

			<div class="col-xs-3">
				<div class="input-group form-group">
					<div class="input-group-addon">
						<i class="fa fa-dollar"></i>
					</div>


					<input type="text" name="balance" id="balance" class="form-control"
						onkeypress='return event.charCode >= 46 && event.charCode <= 57' />
				</div>
			</div>
			<div>
				<p style="font-size: 15px; color: red" id="errorforbalance"></p>

			</div>

<br><br><br><br>
			
						

			<h4>Country:</h4>

			<div class="col-xs-3">
				<div class="input-group form-group">
					<div class="input-group-addon">
						<i class="fa fa-home"></i>
					</div>



					<input type="text" class="form-control"  id="country"    name="country" />

				</div>
			</div>


			<div>
				<p style="font-size: 15px; color: red" id="errorforcountry"></p>
			</div>
<br><br><br>

				<h4>City:</h4>
				
				
				<div class="col-xs-3">
				<div class="input-group form-group">
					<div class="input-group-addon">
						<i class="fa fa-home"></i>
					</div>
					
					
				<select id="ddl" class="form-control"
					onchange="configureDropDownLists(this,document.getElementById('ddl2'))"
					name="city">
					<option value=""></option>
					<option value="Mumbai">Mumbai</option>
					<option value="Delhi">Delhi</option>
					<option value="Pune">Pune</option>
					<option value="Chennai">Chennai</option>
					<option value="Nagpur">Nagpur</option>
					<option value="Nashik">Nashik</option>
					<option value="Kolkata">Kolkata</option>
					<option value="Aurangabad">Aurangabad</option>
					<option value="Surat">Surat</option>

				</select>
			</div>
			</div>
			<div>
				<p style="font-size: 15px; color: red" id="errorforcity"></p>

			</div>


<br><br><br>
			
				<h4>Zip Code:</h4>
				<div class="col-xs-3">
				<div class="input-group form-group">
					<div class="input-group-addon">
						<i class="fa fa-home"></i>
					</div>
					
				<select id="ddl2" name="zipCode" class="form-control">
				</select>
			</div>
			</div>
			<div>
				<p style="font-size: 15px; color: red" id="errorforzipcode"></p>

			</div>


<br><br><br>

			<h4>Address:</h4>

			<div class="col-xs-3">
				<div class="input-group form-group">
					<div class="input-group-addon">
						<i class="fa fa-home"></i>
					</div>


					<input type="text" name="address" class="form-control">
				</div>
			</div>
			<div>
				<p style="font-size: 15px; color: red" id="errorforaddress"></p>

			</div>

<br><br><br>


			<div>
				<center>
					<input class="btn btn-info" type="submit" value="Register"> <input
						class="btn btn-info" type="reset" value="reset">
				</center>
			</div>
		</form>

<br><br><br>

		<script type="text/javascript">
			function configureDropDownLists(ddl1, ddl2) {
				var Mumbai = [ '400008' ];
				var Delhi = [ '110054' ];
				var Chennai = [ '600101' ];
				var Nagpur = [ '440001' ];
				var Kolkata = [ '741255' ];
				var Nashik = [ '422012' ];
				var Pune = [ '411038' ];
				var Aurangabad = [ '413515' ];
				var Surat = [ '395008' ];

				switch (ddl1.value) {
				case 'Mumbai':
					ddl2.options.length = 0;
					for (i = 0; i < Mumbai.length; i++) {
						createOption(ddl2, Mumbai[i], Mumbai[i]);
					}
					break;
				case 'Delhi':
					ddl2.options.length = 0;
					for (i = 0; i < Delhi.length; i++) {
						createOption(ddl2, Delhi[i], Delhi[i]);
					}
					break;

				case 'Chennai':
					ddl2.options.length = 0;
					for (i = 0; i < Chennai.length; i++) {
						createOption(ddl2, Chennai[i], Chennai[i]);
					}
					break;
				case 'Nagpur':
					ddl2.options.length = 0;
					for (i = 0; i < Nagpur.length; i++) {
						createOption(ddl2, Nagpur[i], Nagpur[i]);
					}
					break;
				case 'Kolkata':
					ddl2.options.length = 0;
					for (i = 0; i < Kolkata.length; i++) {
						createOption(ddl2, Kolkata[i], Kolkata[i]);
					}
					break;
				case 'Nashik':
					ddl2.options.length = 0;
					for (i = 0; i < Nashik.length; i++) {
						createOption(ddl2, Nashik[i], Nashik[i]);
					}
					break;
				case 'Pune':
					ddl2.options.length = 0;
					for (i = 0; i < Pune.length; i++) {
						createOption(ddl2, Pune[i], Pune[i]);
					}
					break;
				case 'Aurangabad':
					ddl2.options.length = 0;
					for (i = 0; i < Aurangabad.length; i++) {
						createOption(ddl2, Aurangabad[i], Aurangabad[i]);
					}
					break;
				case 'Surat':
					ddl2.options.length = 0;
					for (i = 0; i < Surat.length; i++) {
						createOption(ddl2, Surat[i], Surat[i]);
					}
					break;
				default:
					ddl2.options.length = 0;
					break;
				}

			}

			function createOption(ddl, text, value) {
				var opt = document.createElement('option');
				opt.value = value;
				opt.text = text;
				ddl.options.add(opt);
			}
		</script>

	</div>


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









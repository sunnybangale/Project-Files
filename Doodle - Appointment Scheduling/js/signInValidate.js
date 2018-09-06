$(document).ready(function() {
	
    
var okEmail = "";
var okPassword = "";
var okUsernameSignUp = "";
var okEmailSignUp = "";
var okPasswordSignUp = "";

 var useridResponse = "";
 var emailResponse = "";
 var passwordResponse = "";
 
 var usernameSignUpResponse = "";
 var passwordSignUpResponse = "";
 var emailSignUpResponse = "";
     
        
	//Validation for username text field
    $("#usernameSignUp").focus(function () {
        //Remove all the post-validation messages before on focus of the username
        $("#username_okay, #username_error").remove();
        $("#usernameSignUp").after("<span id='username_info' class='info'>Must contain only alphabetical/numeric characters!</span>");
    });

	
    $("#usernameSignUp").blur(function () {
    
		//Remove the info message in span tag
        $("#username_info").remove();

        //validate username
        if ($("#usernameSignUp").val() == "")
        {
            $("#username_okay, #username_error", "#username_info").remove();
        }
        else
        {
            var regexForUsername = /^[0-9a-zA-Z]+$/;
            if ($("#usernameSignUp").val().match(regexForUsername))
            {
                //$("#username").after("<span id='username_okay' class='ok'>OK</span>");
                okUsernameSignUp = "done";
            }
            else
            {
                $("#usernameSignUp").after("<span id='username_error' class='error'>Error</span>");
            }
        }
    });


    //Validation for password field
    $("#passwordSignUp").focus(function () {
        //Remove all the post-validation notifications before on focus of the password
        $("#password_okay, #password_error").remove();
        $("#passwordSignUp").after("<span id='password_info' class='info'>Must be at least 8 characters long! </span>");
    });

    $("#passwordSignUp").blur(function () {
        //Remove the info message in span tag
        $("#password_info").remove();
        
		//validate password
		if ($("#passwordSignUp").val() == "")
        {
            $("#password_okay, #password_error", "#password_info").remove();
        }
        else
        {        
			if ($("#passwordSignUp").val().length >= 8) 
            {
                //$("#password").after("<span id='password_okay' class='ok'>OK</span>");
                okPasswordSignUp = "done"; 
            }
            else
            {
                $("#passwordSignUp").after("<span id='password_error' class='error'>Error</span>");
            }
        }
    });


   	//Validation for email text field
	$("#emailSignUp").focus(function () {
		//Remove all the post-validation messages before on focus of the email
        $("#email_okay, #email_error").remove();
        $("#emailSignUp").after("<span id='email_info' class='info'>Must be a valid email (abc@def.xyz)! </span>");
    });

    $("#emailSignUp").blur(function () {
        //Remove the info message in span tag
        $("#email_info").remove();
		//validate email
        if ($("#emailSignUp").val() == "") {
            $("#email_okay, #email_error, #email_info").remove();
        }
        else {
            var regexForEmail = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,3})$/;
			
            if ($("#emailSignUp").val().match(regexForEmail)) {
                //$("#email").after("<span id='email_okay' class='ok'>OK</span>");
                okEmailSignUp = "done";
            }
            else {
                $("#emailSignUp").after("<span id='email_error' class='error'>Error</span>");
            }
        }
    });
	
    
    
   
    
if( $("#registerbtn").click(function()
{
    console.log("Inside the register button")
    
    	//Retriving values from form
        var usernameSignUp=$("#usernameSignUp").val();
        var emailSignUp=$("#emailSignUp").val();
        var passwordSignUp=$("#passwordSignUp").val();
   
     if(okUsernameSignUp == "done" && okEmailSignUp == "done" && okPasswordSignUp == "done")
     {
        var values = 
            {
                "usernameSignUp":usernameSignUp,
                "emailSignUp":emailSignUp,
                "passwordSignUp":passwordSignUp
            }
                
         //console.log(values);
         //window.alert(values);
         $.ajax({
                    url:"register.php",
                    type:"POST",
                    dataType: "json",
                    data: values,
                    success: function (credentials) 
                    { 
                        //alert('blank '+credentials.email);
                        //alert('form was submitted');
                        if(credentials)
                        {    
                            usernameSignUpResponse = credentials.usernameSignUp;
                            emailSignUpResponse = credentials.emailSignUp;
                            passwordSignUpResponse = credentials.passwordSignUp;
                            
                            //alert('assign '+emailSignUpResponse);

                            if(usernameSignUpResponse == "success" && emailSignUpResponse == "success" && passwordSignUpResponse == "success")
                            {
                                //alert("User Authenticated");
                                
                                /*
                                console.log('User Authenticated');
                                setTimeout(function () {
                                window.location.href = "userhomepage.php";
                                },500);
                                */
                                
                                window.location.href = "homepage.html";
                                
                            }
                            else
                            if(usernameSignUpResponse == "already exists" && emailSignUpResponse == "already exists" && passwordSignUpResponse == "already exists")
                            {
                                //alert('Already exists');
                                console.log('Already exists');
                                window.location.href = "homepage.html";
                            }
                            else 
                            if(usernameSignUpResponse == "error registering" && emailSignUpResponse == "error registering" && passwordSignUpResponse == "error registering")
                            {
                                //alert('Error Registering');
                                console.log('error registering');
                                window.location.href = "homepage.html";
                            }
                            
                        }
                    },
                    error:function(response)
                    {
                          console.log(response);
                          alert('Sorry! Currently the Server is down.. ');
                    }
             
                });
         window.alert("Registering you to the Doodle family....");

    }
    
}));
    
 

    ////////////////////////////////////////////////////////////////////////////////////////

   
  
   
    	//Validation for email text field
	$("#email").focus(function () {
		//Remove all the post-validation messages before on focus of the email
        $("#email_okay, #email_error").remove();
        $("#email").after("<span id='email_info' class='info'>Must be a valid email (abc@def.xyz)! </span>");
    });

    $("#email").blur(function () {
        //Remove the info message in span tag
        $("#email_info").remove();
		//validate email
        if ($("#email").val() == "") {
            $("#email_okay, #email_error, #email_info").remove();
        }
        else {
            var regexForEmail = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,3})$/;
			
            if ($("#email").val().match(regexForEmail)) {
               //$("#emailSignIn").after("<span id='email_okay' class='ok'>OK</span>");
                okEmail= "done";
            }
            else {
                $("#email").after("<span id='email_error' class='error'>Error</span>");
            }
        }
    });
    
    
	
    //Validation for password field
    $("#password").focus(function () {
        //Remove all the post-validation notifications before on focus of the password
        $("#password_okay, #password_error").remove();
        $("#password").after("<span id='password_info' class='info'>Must be at least 8 characters long!</span>");
    });

    $("#password").blur(function () {
        //Remove the info message in span tag
        $("#password_info").remove();
        
		//validate password
		if ($("#password").val() == "")
        {
            $("#password_okay, #password_error", "#password_info").remove();
        }
        else
        {        
			if ($("#password").val().length >= 8) 
            {
                //$("#passwordSignIn").after("<span id='password_okay' class='ok'>OK</span>");
                okPassword = "done"
                
            }
            else
            {
                $("#password").after("<span id='password_error' class='error'>Error</span>");
            }
        }
    });
    

if( $("#loginbtn").click(function(){   
    
    console.log("Inside the login button")
    
    var email=$("#email").val();
    var password=$("#password").val();
    var userid="";
          
    if( okEmail == "done" && okPassword == "done")
     {    
         var values = 
            {
                "userid":userid,
                "email":email,
                "password":password
                
            }
            
         //window.alert(values);
         $.ajax({
                    url:"login.php",
                    type:"POST",
                    dataType: "json",
                    data: values,
                    success: function (credentials) 
                    { 
                        //alert('blank '+credentials.userid);
                        //alert('form was submitted');
                        if(credentials)
                        {    
                            useridResponse= credentials.userid;
                            emailResponse = credentials.email;
                            passwordResponse = credentials.password;
                            //alert('assign '+emailResponse);

                            if(emailResponse == email && passwordResponse == "valid" )
                            {
                               //password
                                //alert("User Authenticated");
                                
                                /*
                                console.log('User Authenticated');
                                setTimeout(function () {
                                window.location.href = "userhomepage.php";
                                },500);
                                */
                               
                         //sessionStorage.setItem("userid",useridResponse);
                         //alert(sessionStorage.getItem("userid"));    
                         
                                
                            document.cookie='id = '+useridResponse;    
                            window.location.href = "userhomepage.php";
                        //      window.location = "userhomepage.php?s="
                        //    + encodeURIComponent(useridResponse)
                        //    + "&=delete=true&id=" + useridResponse;
                                
                            }
                            else
                            if(emailResponse == "invalid" && passwordResponse == "invalid")
                            {
                                //alert('Wrong Credentials');
                                console.log('Wrong Credentials');
                                window.location.href = "homepage.html";
                            }
                            
                        }
                    },
                    error:function(response)
                    {
                          console.log(response);
                          alert('Sorry! Currently the Server is down.. ');
                    }
             
         });
        //setTimeout(console.log,1000); 
         
        alert('Verifying Credentials....');
        // window.location.href = "userhomepage.php";
        //console.log("jhala");    
                        
     }
                
}));

   
  
    
    
    
});

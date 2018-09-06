<?php
session_start();
if(isset($_SESSION["creatorid"]))
{    
?>

<!DOCTYPE html>
 <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/style3.css" />
		<link href="css/homepage.css" type="text/css" rel="stylesheet"/>
        
        
<title>
    Doodle
</title>

</head>


<body>

<header>
    
<img src="css/images/DoodleLogo.png" alt="Doodle Icon"  class="logoimage"/>

    <table >

    <tr>
    <td>
    <a href="logout.php">Logout</a>
    <?php    
        $_SESSION["logout"]="set";    
    ?>     
    </td>
    <td>
    &nbsp;&nbsp;     
    </td>
       
    <td>
    <a href="#contact">Contact</a>
    </td>
    </tr>
        
    </table>

</header>    


    
    
<div class="container">
            <!-- Codrops top bar -->
            
            
            <section>				
                <div id="container_demo" >
                   
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form id="regForm" method="post" action="create_doodle.php">
                                <h1>Create Doodle!</h1> 
                                <p> 
                                    <label for="pollname" > What's the meeting for? </label>
                                    <input id="pollname" name="pollname" required="required" type="text"/>
                                </p>
                                <p> 
                                    <label for="location" > Where is this meeeting? </label>
                                    <input id="location" name="location" required="required" type="text"/> 
                                </p>
                               <p> 
                                    <label for="note" > Additional details for the meeting. </label>
                                    <input id="note" name="note" type="text"/> 
                                </p>
                                <p class="login button"> 
                                    <input type="submit" value="Create" class="loginbutton"/> 
								</p>
                            </form>
                        </div>						
                    </div>
                </div>  
            </section>
        </div>
    
    
    
    <div id="contact" >
<h1 id="h1contact">Contact us</h1>    


<table >
    
<tr> 
<td><img src="css/images/phone.png" alt="Phone Icon"  class="icon"/>
</td>
<td>
    +1 (469)-959-1111
</td>
</tr>    
   
<tr> 
<td><img src="css/images/location.png" alt="Address Icon"  class="icon"/>
</td>
<td>
   The University of Texas at Dallas, Richardson, Texas
</td>
</tr>    

<tr> 
<td><img src="css/images/mail.png" alt="Email Icon"  class="icon"/>
</td>
<td>
    contactdoodle@gmail.com
</td>
</tr>    
        
</table>
    
</div>        
    

    
    
    
<div id="follow"> 
<h1 id="h1follow">Follow us</h1>    

<table>    
<tr> 
<td><a href="https://www.linkedin.com" >
    <img src="css/images/linkedin.png" alt="LinkedIn Icon"  class="icon"/>
    </a>
</td>
<td>
    <a href="https://www.linkedin.com" >
    LinkedIn
    </a>    
</td>

    
<td><a href="https://www.facebook.com" >
    <img src="css/images/facebook.png" alt="Facebook Icon"  class="icon"/>
    </a>
</td>
<td>
    <a href="https://www.facebook.com" >
    Facebook
    </a>    
</td>

<td><a href="https://www.youtube.com">
    <img src="css/images/youtube.png" alt="Youtube Icon"  class="icon"/>
    </a>
</td>
<td>
    <a href="https://www.youtube.com" >
    YouTube
    </a>    
</td>    
    

</tr>
</table>    
    
    
</div>    
    
    
    

<footer>
This Doodle is made with  &#10084; in Dallas @2018 CS 6314.001 Final Project
</footer>

</body>
</html>

<?php

}
else
{
    header("Location: homepage.html");
}
?>




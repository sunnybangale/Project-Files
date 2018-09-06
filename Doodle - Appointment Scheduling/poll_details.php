<?php
session_start();
if(isset($_SESSION["creatorid"]))
{    
?>

<!DOCTYPE html>
 <html lang="en" class="no-js"> <!--<![endif]-->
    <head>

        
        <title>Calendar</title>
        
        <link href="css/homepage.css" type="text/css" rel="stylesheet"/>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="http://yui.yahooapis.com/3.18.1/build/yui/yui-min.js"></script>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        
        <link rel="stylesheet" type="text/css" href="css/style3.css" />
        <link rel="stylesheet" type="text/css" href="css/poll_details.css" />
        
        
         <script type="text/javascript" src="js/poll_details.js">
            
        </script>
    </head>
    <body>
        
        
        <header>
            <img src="css/images/DoodleLogo.png" alt="Doodle Icon"  class="logoimage"/>
            <table>
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
        
        
        
        
        <?php
        
        
    $servername = "localhost";
	$username = "root";
	$password = "1234";
	$dbname = "doodle";
	// Create connection 
	$conn = new mysqli($servername, $username, $password, $dbname); // Checkconnection 
	if ($conn -> connect_error)  
	{      
	    die("Connection failed: " . $conn->connect_error);
	}    

        
        //session_start();
        //echo $_SESSION["pollid"];
        $pollid = $_SESSION["pollid"];
        $pollname="";
        
        $query="select poll_name from poll where poll_id='$pollid'"; 
                
                
        $result = mysqli_query ($conn,$query);
              
              
        if (mysqli_num_rows($result) > 0) 
        {
                while($row = mysqli_fetch_assoc($result)) 
                {
                      $pollname = $row["poll_name"];
                }
        }
        
        ?>
        
        
        
        
            
            <section style="overflow: auto;">               
                <div id="container_demo" >
                                                            
                    <div id="wrapper">

                        <div id="login" class="animate form">
                            <h1>
                            <?php    
                                echo $pollname;
                            ?>
                            </h1>
                            <div id="demo" class="yui3-skin-sam yui3-g"> 
                                <div id="leftcolumn" class="yui3-u">
                                    
                                    <div id="mycalendar">

                                    </div><br>
                                </div>
                            </div>
                        <div class="intervs"> 
                            <form method="POST" name="ofrm">
                                <input type="hidden" value="" name="date" id="date" />
                                <fieldset id="interval">
                                   <h2 class="selectdate">Selected date: <span id="selecteddate"></span></h2>
                                </fieldset>
                                <input type="button" value="Add an interval" class="pollbutton" id="add" />
                                <input type="submit" value="Save" class="pollbutton">
                            </form>
                            
                            <?php 
                            
                            $query="select * from doodle.interval where poll_id='$pollid'"; 
                
                
        $result = mysqli_query ($conn,$query);
              
              
       if (mysqli_num_rows($result) > 0) 
        {
                echo "<input type='button' class = 'pollbutton' onclick='location.href=\"userhomepage.php\";' value='Submit' />";
        }
                            
                            ?>
                           
                            
                            <?php 
                            if(isset($_POST)){
                        $array = array_values($_POST);
    //session_start();

	$i = 1;
	$j = 2;
	//$date = ;
    //$pollid = $_SESSION["pollid"];

	while($j < sizeof($array)){

		$sint = $array[$i];
		$eint = $array[$j];

		if($sint < $eint && $array[0] != NULL){
			$insertQuery = "insert into doodle.interval(poll_id, interval_date, interval_start_time, interval_end_time,count_votes) VALUES ( '$pollid', '$array[0]', '$sint', '$eint',0)";
			//$insertQuery = "insert into doodle.interval(poll_id, interval_date, interval_start_time, interval_end_time) VALUES ( 1, 'abc', 'def', 'ghi')";
            
			if(!$conn->query($insertQuery)){
				//echo $sint;
				echo "Please choose other Intervals!";}//header('location: 
			else
				header('location: poll_details.php');				
		}else{
			//echo "Please select the intervals again!";
            //print_r($array);
			echo "Invalid Intervals!";//header('location: poll_details.php');
		}
		$i = $i + 2;
		$j = $j + 2;
        
	}
                                }
                    ?>
                        </div>
                        </div>                      
                        
                    </div>
                    
                </div>  
            </section>
        
        
        
        
        <div id="contact" >
            <h1 id="h1contact">Contact us</h1>    
            <table >
                <tr>
                    <td>
                        <img src="css/images/phone.png" alt="Phone Icon"  class="icon"/>
                    </td>
                    <td>
                        +1 (469)-959-1111
                    </td>
                </tr>
                <tr>
                    <td>
                        <img src="css/images/location.png" alt="Address Icon"  class="icon"/>
                    </td>
                    <td>
                        The University of Texas at Dallas, Richardson, Texas
                    </td>
                </tr>
                <tr> 
                    <td>
                        <img src="css/images/mail.png" alt="Email Icon"  class="icon"/>
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
                    <td>
                        <a href="https://www.linkedin.com" >
                            <img src="css/images/linkedin.png" alt="LinkedIn Icon"  class="icon"/>
                        </a>
                    </td>
                    <td>
                        <a href="https://www.linkedin.com" >
                            LinkedIn
                        </a>    
                    </td>
                    <td>
                        <a href="https://www.facebook.com" >
                            <img src="css/images/facebook.png" alt="Facebook Icon"  class="icon"/>
                        </a>
                    </td>
                    <td>
                        <a href="https://www.facebook.com" >
                            Facebook
                        </a>    
                    </td>
                    <td>
                        <a href="https://www.youtube.com">
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
            This Doodle is made with &#10084; in Dallas @2018 CS 6314.001 Final Project
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

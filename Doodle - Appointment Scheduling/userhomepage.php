

<?php
session_start();
if(isset($_SESSION["creatorid"]))
{    
?>

<!DOCTYPE html>
<html>

<head>

    
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

    
    
<div id="createpoll">  
    
<h1 id='h1createdoodle'>Create a Doodle Poll</h1>    
<form action="CreateDoodle.php" method="post">
 <input type='submit' name='submit' value='Create Doodle' class='createdoodlebutton'/>
<br>
<br>    
</form>        
</div>    
    
  
<form action="SelectedPollDetail.php" method="post">
    <input type="hidden" name="poll_id" id="poll_id" value=""/>
            
            <script>
	           function myFun(element) {
				document.getElementById("poll_id").setAttribute("value",element);
				}
			</script>
	    	
            <div id="creatorselection">  
	    		<?php
                    
                    //echo $_SESSION["creatorid"];
	    			$creator_id=$_SESSION["creatorid"];
		    		include("Connection.php");
		            $sql="select * from poll where creator_id=".$creator_id;
		            $result = mysqli_query($conn, $sql);
		           	if (mysqli_num_rows($result) > 0){
	            ?>
	            <table>
	            <?php
                        
                        echo "<br>";
                        echo "<br>";
                        echo "<br>";
                        echo "<br>";
                        echo "<br>";
                        echo "<br>";
                        echo "<br>";
                        echo "<br>";
                        
                        echo "<h2 id='h1creatorselection'>Polls you have created so far....</h2>";
                        
		            	for ( $i = 0 ; $i < mysqli_num_rows($result) ; $i++ )
                        {
                    		$row = mysqli_fetch_assoc($result);
                            
                            
                    		echo "<tr>";
                            
                            echo "<td>";                            
                            echo "<img src='css/images/polling.png' alt='Poll Icon' />";
                            echo "</td>";
                            
                            echo "<td><h2>";                            
                    		echo $row['poll_name'];
                    		echo "</h2></td>";
                            
                            echo "<td><h3>";
                            echo "localhost/polls/".$row['poll_id'];
                    		echo "</h3></td>";
                            
                    		
                            echo "<td>";
                            if($row['poll_closed']==0){
                            echo "<input type='submit' name='submit' id='".$row['poll_id']."' value='View Poll Details' onclick='myFun(this.id)' class='viewdetailbutton'/>";}
                            else{
                                $sql2="SELECT interval_date, interval_start_time, interval_end_time from doodle.interval where count_votes=(select MIN(count_votes) from doodle.interval where poll_id=".$row['poll_id'].") and poll_id=".$row['poll_id']." limit 1;";
                                $result2 = mysqli_query($conn, $sql2);
		           	              if (mysqli_num_rows($result2) > 0){
                                      $row2=mysqli_fetch_assoc($result2);
                                      echo $row2['interval_date']."<br>".$row2['interval_start_time']."-".$row2['interval_end_time'];
                                  }
                                
                            }
                    		echo "</td>";
                            
                    		echo "</tr>";
                            
                            
                            
	                    }
                ?>
                
	            </table>
	            
                <?php
	        		}
                    else
                    {
                        echo "<br>";
                        echo "<br>";
                        echo "<br>";
                        echo "<br>";
                        echo "<br>";
                        echo "<br>";
                        echo "<br>";
                        echo "<br>";
                        echo "<h2 id='h1creatorselection'>You have created no Polls so far....</h2>";
                    }
	        	?>
	        </div>
</form>    
    
  
    
    
    
    
    
    
    
    
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



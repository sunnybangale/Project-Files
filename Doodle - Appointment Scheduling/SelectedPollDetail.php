<?php
session_start();
if(isset($_SESSION["creatorid"]))
{    
?>

<!DOCTYPE html>


<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="css/homepage.css" type="text/css" rel="stylesheet"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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


	
	
        
      	<div id="polldetail">
            <h1 id='h1polldetail'>Poll Statistics</h1> 
    
                <?php
		    		include("Connection.php");
		    		$poll_id= $_POST['poll_id'];
                    $selectedInterval=-1;
                    $sql="SELECT Min(myvote) as min,interval_id FROM (SELECT COUNT(interval_id) AS myvote,interval_id FROM vote GROUP BY interval_id) as abc";
		            $result = mysqli_query($conn, $sql);            
                    if (mysqli_num_rows($result) > 0)
                    {
                        $row = mysqli_fetch_assoc($result);
                    		
                        $selectedInterval=$row['interval_id'];
                    }
		    		$sql="select distinct(interval_date) as dates from doodle.interval where poll_id= ".$poll_id;
		            $result = mysqli_query($conn, $sql);
		        
            
                    if (mysqli_num_rows($result) > 0)
                    {
	            ?>
            
	            <table>
	            	<tr>
	                <th>Dates </th>
                    <th>Time Intervals </th>
                    <th>Number of Votes </th>
                        
	            	</tr>
	            	<?php
	            		for ( $i = 0 ; $i < mysqli_num_rows($result) ; $i++ )
                		{
                    		$row = mysqli_fetch_assoc($result);
                    		echo "<tr>";
                    		echo "<td>".$row['dates'];
                    		echo "</td>";
                    		$sql1="select interval_id,interval_start_time, interval_end_time from doodle.interval where interval_date like '".$row['dates']."' and poll_id=".$poll_id;
                    		//echo $sql1;
		           			$result1 = mysqli_query($conn, $sql1);
		           			for ($j = 0 ; $j < mysqli_num_rows($result1) ; $j++ )
                			{
                    			$row1 = mysqli_fetch_assoc($result1);
                                if($j==0){
                    			echo "<td>";                    			
                    			echo $row1['interval_start_time']."-".$row1['interval_end_time'];
                    			$sql2="select count(vote_id) as countIds from doodle.vote where interval_id=".$row1['interval_id'];
                    		    //echo $sql1;
                                echo "</td>";                    		
                                echo "<td>";                    		
			           			$result2 = mysqli_query($conn, $sql2);
			           			if (mysqli_num_rows($result2) > 0)
                                {
			           				$row2=mysqli_fetch_assoc($result2);
			 
                                    echo $row2['countIds'];
			           			}
                    			echo "</td>";
                                }
                                else{
                                    echo"<tr><td></td>";
                                    echo "<td>";                    		echo $row1['interval_start_time']."-".$row1['interval_end_time'];
                                    echo "</td>";                    		
                                echo "<td>";
                    			$sql2="select count(vote_id) as countIds from doodle.vote where interval_id=".$row1['interval_id'];
                                $result2 = mysqli_query($conn, $sql2);
			           			if (mysqli_num_rows($result2) > 0)
                                {
			           				$row2=mysqli_fetch_assoc($result2);
			 
                                    echo $row2['countIds'];
			           			}
                    		    //echo $sql1;
                                echo "</td>";                    	
                                    
                                }
                    		}
                    		
                    		echo "</tr>";
                    	}
	            	?>
	            </table>
	           
            
                <br><br>
                
                <table>
                    <tr>
                    <td>

                <form action="CloseDeletePoll.php" method="post">
                    <?php
               echo " <input type='hidden' id='selectedInterval' name='selectedInterval' value=".$selectedInterval." />";?>
	            <input type="submit" name="closepoll" Value="Close Poll" class="closepollbutton" id="closepoll"/>
                 
                <?php
                echo "<input type='hidden' name='poll_id1' id='poll_id1' value='".$poll_id."'/>";
                ?>    
                    
                </form>    
                        </td>
                        <td>
                <form action="CloseDeletePoll.php" method="post">
	            <input type="submit" name="deletepoll" Value="Delete Poll" class="deletepollbutton" id="deletepoll"/>
            
                <?php
                echo "<input type='hidden' name='poll_id2' id='poll_id2' value='".$poll_id."'/>";
                        
                ?>    
                
                </form>
                    </td>
                    </tr>
                </table>    
                    
            
             <?php
	        		}
                    else
                    {
                        echo "<br>";
                        echo "<br>";
                        
                        echo "<h3 id='h1pollmissingdetail'>No poll details available..</h3>";
                        
                        echo "<br>";
                        echo "<br>";
                        echo "<form action='userhomepage.php' method='post'>
                        <input type='submit' name='goback' Value='Go Back' class='gobackbutton' id='goback'/>
                        </form>";
                    
                    
                    }
	            ?>
            
            
            
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
		
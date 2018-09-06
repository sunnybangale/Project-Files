<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
		<script src="/dashboard/doodle/js/jquery.min.js" type="text/javascript"></script>
		<link href="/dashboard/doodle/css/homepage.css" type="text/css" rel="stylesheet"/>
<title>
    Doodle
</title>

</head>


<body>

<header>

<img src="/dashboard/doodle/css/images/DoodleLogo.png" alt="Doodle Icon"  class="logoimage"/>

    <table >

    <tr>         
    <td>
    <a href="#contact">Contact</a>
    </td>
    </tr>
        
    </table>

</header>    

    	<?php
    		include("Connection.php");
    		$url=$_SERVER['REQUEST_URI'];
    		$poll_id=0;
		    		
		    		$id=pathinfo($url,PATHINFO_BASENAME);
		    		if(is_numeric($id))
					{
						$poll_id=$id;
					}
        $sqlMain="Select  * from poll where poll_closed=0 and poll_id=".$poll_id;
    $resultMain = mysqli_query($conn, $sqlMain);
		            if (mysqli_num_rows($resultMain) > 0){

				if(isset($_POST['submit'])){
					$emailId= $_POST['email'];
					if(!empty($_POST['dates'])) {
						foreach($_POST['dates'] as $selected) {
							$sql4="insert into vote(email_id,interval_id,poll_id) values('".$emailId."',".$selected.",".$poll_id.")";
                            
                                $query="select count_votes from doodle.interval"; 
                
                
        $result = mysqli_query ($conn,$query);
              
              
        if (mysqli_num_rows($result) > 0) 
        {
            $sql5="UPDATE doodle.interval SET count_votes = count_votes + 1 WHERE interval_id = ". $selected ." AND poll_id = ". $poll_id ." ";
                          	$conn->query($sql5);
        }
							$conn->query($sql4);
						}
					}
				}
				echo "<form action='".$url."' method='post'>";
 		    	?>
    <div id="menu">
    <table>
    
    <tr>
    <td>
	<input type="text" name="name" placeholder ="Participant Name" class="time"/>
    </td>
    
    <td>
	<input type="text" name="email" placeholder ="Email ID" class="time"/>
	</td>
    
    <td>
	<input type="submit" name="Go" value="Go" class="gobutton"/>
    </td>
    
    </table>    
				 </form>
 		    	<?php
		    if(isset($_POST['Go']))		{
		    	$emailId=$_POST['email'];
		    	echo "<form action='".$url."' method='post'>";
		?>
	    	
	    		<?php
	    			echo "<input type='hidden' name='email' value='".$emailId."'/>";
		    		echo "";
		            $sql="select distinct(interval_date) as dates from doodle.interval where poll_id= ".$poll_id;
		            $result = mysqli_query($conn, $sql);
		           	if (mysqli_num_rows($result) > 0){

	            ?>
	            <table>
	            	<tr>
	            		<th>Dates </th>
                        <th> Intervals </th>
	            	</tr>
	            	<?php
	            		for ( $i = 0 ; $i < mysqli_num_rows($result) ; $i++ )
                		{
                    		$row = mysqli_fetch_assoc($result);
                    		echo "<tr>";
                    		echo "<td>".$row['dates'];
                    		echo "</td>";
                    		$sql1="select interval_id,interval_start_time, interval_end_time from doodle.interval where interval_date like '".$row['dates']."' and poll_id= ".$poll_id;
                    		//echo $sql1;
		           			$result1 = mysqli_query($conn, $sql1);
		           			for ( $j = 0 ; $j < mysqli_num_rows($result1) ; $j++ )
                			{
                    			$row1 = mysqli_fetch_assoc($result1);
                    			echo "<td>";         
                    			//echo $row1['interval_id'];
                    			$sql2="select * from vote where email_id like '".$emailId."' and interval_id=".$row1['interval_id'];
                    			 $result2 = mysqli_query($conn, $sql2);
		           					if (mysqli_num_rows($result2) > 0){
		           						//echo "yes";
		           						echo "<input type='checkbox' name='dates[]' value='".$row1['interval_id']."' checked>";
		           						$sql4="delete from vote where email_id like '".$emailId."' and interval_id=".$row1['interval_id'];
                                        echo "&nbsp;&nbsp;";
                                        
										$conn->query($sql4);
		           					}
		           					else{
                    					echo "<input type='checkbox' name='dates[]' value='".$row1['interval_id']."'>";
                                        echo "&nbsp;&nbsp;";
                    				}
                    			echo $row1['interval_start_time']."-".$row1['interval_end_time'];
                    			echo "</td>";
                    		}
                    		echo "</tr>";
                    	}
	            	?>
	            </table>
	            <?php
	        		}
	            ?>
	        
	        <input type="submit" name="submit" Value="Submit" class="submitbutton"/>
	        <br>
            <br>
            <br>
	        
		</form>
		
	    		<?php
	    	
		    		$sql="select distinct(interval_date) as dates from doodle.interval where poll_id= ".$poll_id;
		            $result = mysqli_query($conn, $sql);
		            if (mysqli_num_rows($result) > 0){

	            ?>
	        <!--<div id="menu">-->
	            <table>
	            	<?php
	            		for ( $i = 0 ; $i < mysqli_num_rows($result) ; $i++ )
                		{
                			//$labels=array();
                			// $conuts=array();
                    		$row = mysqli_fetch_assoc($result);
                    		$sql1="select interval_id,interval_start_time, interval_end_time from doodle.interval where interval_date like '".$row['dates']."' and poll_id= ".$poll_id;
                    		$result1 = mysqli_query($conn, $sql1);

		           			for ( $j = 0 ; $j < mysqli_num_rows($result1) ; $j++ )
                			{
                				$row1 = mysqli_fetch_assoc($result1);

                    			$row1['interval_start_time']."-".$row1['interval_end_time'];
                    			$sql2="select count(vote_id) as countIds from doodle.vote where interval_id=".$row1['interval_id'];
                    			$result2 = mysqli_query($conn, $sql2);
			           			if (mysqli_num_rows($result2) > 0){
			           				$row2=mysqli_fetch_assoc($result2);
			           				$label=$row['dates']."\n".$row1['interval_start_time']."-".$row1['interval_end_time'];
			           				//$temp=array($label,$countIds);
			           				if ($i==0 and $j==0) {
			           					$labels=array($label);
			           					$counts=array($row2['countIds']);
			           				}
			           				else{
				           				array_push($labels, $label);
				           				array_push($counts,$row2['countIds']);
			           				}	
                    			}
                    		
                    		}
                    	}
	            	?>
	            </table>
	            <script type="text/javascript">
	            	var col1=<?php echo json_encode($labels);?>;
	            	var col2=<?php echo json_encode($counts);?>;
	            </script>
	            <?php
	        		}
	            ?>
	       <!-- </div>-->
        </div >
	    
        <div id="chart"> 
	        <div id="barchart_material" style="height: 300px; width: 50%;">
	        <script type="text/javascript">
	        	google.charts.load('current', {'packages':['bar']});
				google.charts.setOnLoadCallback(drawChart);
	        	function drawChart() {
	        		var final=[["Intervals","Counts"]];
		        	for (var i = 0; i < col1.length; i++) {
						var temp2=[col1[i]];
						temp2=temp2.concat(parseInt(col2[i]));
						var temp=[temp2];
						final=final.concat(temp);
					}	
					
					google.charts.load('current', {'packages':['bar']});
					var data = google.visualization.arrayToDataTable(final);

			      var options = {
                chart: {
                        title: 'Voting Statistics'
                }
        };
			      var chart = new google.charts.Bar(document.getElementById('barchart_material'));
			      chart.draw(data, google.charts.Bar.convertOptions(options));
	        	}
	        </script>
	        </div>

    </div>


    
<div id="contact" >
<h1 id="h1contact">Contact us</h1>    


<table >
    
<tr> 
<td><img src="/dashboard/doodle/css/images/phone.png" alt="Phone Icon"  class="icon"/>
</td>
<td>
    +1 (469)-959-1111
</td>
</tr>    
   
<tr> 
<td><img src="/dashboard/doodle/css/images/location.png" alt="Address Icon"  class="icon"/>
</td>
<td>
   The University of Texas at Dallas, Richardson, Texas
</td>
</tr>    

<tr> 
<td><img src="/dashboard/doodle/css/images/mail.png" alt="Email Icon"  class="icon"/>
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
    <img src="/dashboard/doodle/css/images/linkedin.png" alt="LinkedIn Icon"  class="icon"/>
    </a>
</td>
<td>
    <a href="https://www.linkedin.com" >
    LinkedIn
    </a>    
</td>

    
<td><a href="https://www.facebook.com" >
    <img src="/dashboard/doodle/css/images/facebook.png" alt="Facebook Icon"  class="icon"/>
    </a>
</td>
<td>
    <a href="https://www.facebook.com" >
    Facebook
    </a>    
</td>

<td><a href="https://www.youtube.com">
    <img src="/dashboard/doodle/css/images/youtube.png" alt="Youtube Icon"  class="icon"/>
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





	        <?php
	    }
	echo "</body>";
                    }
else{
echo "<center><h1>The poll is  closed</h1></center>";}?>

</html>
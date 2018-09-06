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

	$pollname =  $_POST['pollname'];
	$location =  $_POST['location'];
	$note =  $_POST['note'];
    session_start();

	echo $pollname, $location, $note;

	//$date =  "20180406";
	//$sint =  "110000";
	//$eint =  "120000";

	//echo $_POST['sInt2'];
	//echo $_POST['eInt2'];

	//insert into doodle.interval(poll_id, interval_date, interval_start_time, interval_end_time) VALUES ( 1, '$date', '$sint', '$eint')
    $creatorid= $_SESSION["creatorid"];
    echo $creatorid;

	$insertQuery = "insert into doodle.poll(creator_id, poll_name, poll_location, poll_note) VALUES ('$creatorid', '$pollname', '$location', '$note')"; 

	if($conn->query($insertQuery)){
		
        
        $query="select max(poll_id) as poll_id from poll"; 
                
                
        $result = mysqli_query ($conn,$query);
              
              
        if (mysqli_num_rows($result) > 0) 
        {
                while($row = mysqli_fetch_assoc($result)) 
                {
                      $_SESSION["pollid"]=$row["poll_id"];
                }
        }
          
        header('location: poll_details.php');
        
        
	}
	else{
		echo "Error inserting intervals. Server is down!";
	}
?>
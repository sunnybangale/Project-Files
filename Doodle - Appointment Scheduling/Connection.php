<html>
 <body>
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
?>
</body>
</html>
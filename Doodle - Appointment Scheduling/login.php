<?php

    //echo "Login page!!";

    $userDB = 'root';
    $passwordDB = '1234';
    $db = 'doodle';
    $host = 'localhost';

    $conn = mysqli_connect($host,$userDB,$passwordDB,$db);

    if(!$conn)
    {
        exit("<script language='javascript'>alert('Unable to connect to database')</script>");
    }
    
    $email = $password = "";

    session_start();
    

    if ($_SERVER["REQUEST_METHOD"] == "POST") 
    {
          $email = test_input($_POST["email"]);
          $password = test_input($_POST["password"]);
        
        
          if(empty($email) || empty($password))
          {
              header('Location:homepage.html');
          }
          else 
              //if(!empty($name) && !empty($username) && !empty($password))
          {
            //header('Location:welcome.php');
             //exit("<script language='javascript'>alert('okay till here')</script>");
                $query="select user.user_id,user.user_email, user.user_password from user where user.user_email = '$email'"; 
                
                
                $result = mysqli_query ($conn,$query);
              
              //and user.user_password='$password'
              
              
              if (mysqli_num_rows($result) > 0) 
              {
                    while($row = mysqli_fetch_assoc($result)) 
                    {
                        //echo "id: ".$row["user_email"]." " ;
                    
                        $hashedPassword = $row["user_password"];
                        
                        if(sha1($password)==$hashedPassword) 
                        {
                            
                            $_SESSION["creatorid"] = $row["user_id"];
                            
                            $output = array(
                            "userid"=>
                            $row["user_id"],
                            "email" => $row["user_email"],
                            "password" => "valid"
                            );
                            echo json_encode($output);        
                        } 
                        
                        
                        /*
                        $output = array(
                            "userid"=>
                            $row["user_id"],
                            "email" => $row["user_email"],
                            "password" => $row["user_password"]
                            );
                        echo json_encode($output);
                        */
                    }
              }
              else if (mysqli_num_rows($result) == 0) 
              {
                  $output = array(
                            "email" => "invalid",
                            "password" => "invalid"
                            );
                  echo json_encode($output);
              }
              
          }

    }

/*    if(isset($_SESSION["email"]) && isset($_SESSION["password"]))
      {
          //header('Location:welcome.php');
      }
      else
      {
            //header('Location:homepage.html');
      }
*/
      function test_input($data) 
      {
      $data = trim($data);
      $data = stripslashes($data);
      $data = htmlspecialchars($data);
      return $data;
      }

 
?>
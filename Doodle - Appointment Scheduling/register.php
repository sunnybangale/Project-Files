<?php

//echo "registered";
 
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
    
    $usernameSignUp = $emailSignUp = $passwordSignUp = "";

    session_start();

    if ($_SERVER["REQUEST_METHOD"] == "POST") 
    {
          $usernameSignUp = test_input($_POST["usernameSignUp"]);  
          $emailSignUp = test_input($_POST["emailSignUp"]);
          $passwordSignUp = test_input($_POST["passwordSignUp"]);
        
        
          if(empty($usernameSignUp) ||empty($emailSignUp) || empty($passwordSignUp))
          {
              header('Location:homepage.html');
          }
          else 
              //if(!empty($name) && !empty($username) && !empty($password))
          {
            //header('Location:welcome.php');
             //exit("<script language='javascript'>alert('okay till here')</script>");
              $query="select user.user_email from user where 
              user.user_name = '$usernameSignUp' and user.user_email = '$emailSignUp' and user.user_password='$passwordSignUp'";
              
              $result = mysqli_query ($conn,$query);
                
              if (mysqli_num_rows($result) > 0) 
              {
                    //echo "id: ".$row["user_email"]." " ;
                    $output = array(
                    "usernameSignUp" => "already exists",
                    "emailSignUp" => "already exists",
                    "passwordSignUp" => "already exists"
                    );
                    echo json_encode($output);    
              }
              else if (mysqli_num_rows($result) == 0) 
              {
                  
                  $hashedPassword = sha1($passwordSignUp);
                  
                    
                  $insertQuery="insert into user(user.user_name, user.user_email, user.user_password) values ('$usernameSignUp','$emailSignUp','$hashedPassword')";
              
                  if($conn->query($insertQuery))
                  {
                        $output = array(
                        "usernameSignUp" => "success",
                        "emailSignUp" => "success",
                        "passwordSignUp" => "success"
                        );
                        echo json_encode($output);    
                  }
                  else
                  {
                        $output = array(
                        "usernameSignUp" => "error registering",
                        "emailSignUp" => "error registering",
                        "passwordSignUp" => "error registering"
                        );
                        echo json_encode($output);
                  }
                  
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
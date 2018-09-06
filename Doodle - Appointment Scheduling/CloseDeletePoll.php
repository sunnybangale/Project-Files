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
    
    $close = $delete =  $poll_id = "empty";
    

    if ($_SERVER["REQUEST_METHOD"] == "POST") 
    {
        
        //$delete = $_POST["deletepoll"];
        
        if(isset($_POST["closepoll"]))
        {    
            $close = $_POST["closepoll"];
            echo $close;
            $poll_id = $_POST["poll_id1"];
            $selectedInterval=$_POST["selectedInterval"];
            //echo $poll_id;
            
            if($close=="Close Poll")
            { 
                $query=" update doodle.poll set poll_closed=1,finalInterval=".$selectedInterval." where poll_id = ".$poll_id; 
                if($conn->query($query))
                {
                    //echo "done";
                    header("Location: userhomepage.php");
                }
                else
                {
                    echo "Couldn't close the poll. Server is down!";
                }
                       
            }
            
        }   
        
        
        if(isset($_POST["deletepoll"]))
        {    
            $delete = $_POST["deletepoll"];
            $poll_id = $_POST["poll_id2"];
            //echo $poll_id;
            
            if($delete=="Delete Poll")
            { 
                
                $q1="delete from doodle.vote where poll_id = ".$poll_id;
                if($conn->query($q1)){
                $q2="delete from doodle.interval where poll_id = ".$poll_id;
                    if($conn->query($q2)){
            
                $query="delete from doodle.poll where poll_id = ".$poll_id; 
                if($conn->query($query))
                {
                    //echo "done";
                    header("Location: userhomepage.php");
                }}}
                else
                {
                    echo "Couldn't delete the poll. Server is down!";
                }
                       
            }
            
        }   
        
        
        
        
        
        
    }



?>
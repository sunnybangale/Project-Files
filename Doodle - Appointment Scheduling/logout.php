<?php


session_start();
if(isset($_SESSION["creatorid"]))
{
    $_SESSION["creatorid"]=null;
    session_destroy();
    header("Location: homepage.html");
}



?>
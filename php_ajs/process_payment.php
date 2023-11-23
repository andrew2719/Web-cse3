<?php
session_start();

$time_duration = 10*60;

if(isset($_SESSION['start_time'])){
    $elapsed_time = time()-$_SESSION['start_time'];
    if ($elapsed_time>$time_duration){
        session_unset();
        session_destroy();
        echo "session expired";
        exit;
    }

}
else{
    $_SESSION['start_time'] = time();

}
if ($_SERVER["REQUEST_METHOD"]=="POST"){
    $amount = $_POST['amount'];
    echo "processing bro".$amount;
}



?>
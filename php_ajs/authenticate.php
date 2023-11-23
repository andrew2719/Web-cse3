<?php
$servername  = "localhost";
$username = "root";
$password = "";
$dbname = "lab";

$conn  = new mysqli($servername,$username,$password,$dbname);

if ($conn->conn_error){
    die("connection failed:". $conn->conn_error);
}

$usr = $conn->real_escape_string($_POST['username']);
$pwd = $conn->real_escape_string($_POST['password']);

$sql = "SELECT * FROM user where email = '$usr' and pwd = '$pwd'";

$result = $conn->query($sql);

if($result->num_rows>0){
    $_SESSION['loggedin'] = true;
    $_SESSION['username'] = $usr;
    header("Location: welcome.php");
    }
else{

    echo "invalidbro";
}

$conn->close();

?>
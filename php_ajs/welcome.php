<?php
session_start();

if (!isset($_SESSION['loggedin']) || $_SESSION['loggedin'] !== true) {
    header("Location: login.php");
    exit;
}

echo "Welcome " . $_SESSION['username'] . "! <br>";
echo "<a href='logout.php'>Logout</a>";
?>

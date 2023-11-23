<!DOCTYPE html>
<html>
<body>

<form action="welcome_post.php" method="post">
Name: <input type="text" name="name">
Age: <input type="text" name="age">
<input type="submit">
</form>

</body>
</html>

<!-- <!DOCTYPE html>
<html>
<body>

Welcome <?php echo $_POST["name"]; ?><br>
Your age: <?php echo $_POST["age"]; ?>


</body>
</html> -->

simiarly 

method = 'get'
Welcome <?php echo $_GET["name"]; ?><br>
Your age: <?php echo $_GET["age"]; ?>

welcome <?php echo $_REQUEST["name"];?>
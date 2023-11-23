<!DOCTYPE html>
<html>
<body>

<h2>Simple Image Display</h2>

<form action="" method="post" enctype="multipart/form-data">
    Select image to upload:
    <input type="file" name="image" id="image">
    <input type="submit" value="Display Image" name="submit">
</form>

<?php
if(isset($_POST["submit"])) {
    if(getimagesize($_FILES['image']['tmp_name']) == false) {
        echo "Please select an image.";
    } else {
        $imageData = base64_encode(file_get_contents($_FILES['image']['tmp_name']));
        $src = 'data: '.mime_content_type($_FILES['image']['tmp_name']).';base64,'.$imageData;
        echo "<img src='".$src."' style='max-width:300px;'/>";
    }
}
?>

</body>
</html>

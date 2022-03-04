<?php
session_start();
include("function.php");

$connect = new mysqli('localhost', 'root', '', 'userInfo');
//print_r(mysqli_connect_error());
if (mysqli_connect_error() != null) {
    die("connection failed" . $connect->connect_errno);
} else {
    //echo "connected successfully";
    //print_r($_SERVER['REQUEST_METHOD']);
    if ($_SERVER['REQUEST_METHOD'] == 'POST') {
        $username = $_POST['username'];
        //print_r($username."       aaaaaaaaaaaaa");
        $password = $_POST['password'];
        //print_r($password."        bbbbbbbbbbb");

        //To check if he has filled in the username and password
        if (!empty($username) && !empty($password)) {
            $query = "SELECT id, username, password 
            FROM `userInfo` 
            WHERE username = '$username' ";

            $result = mysqli_query($connect, $query);

            //
            if ($result->num_rows == 1) {
                $user_information = mysqli_fetch_assoc($result);

                //To check if the password is correct or not
                if ($user_information['password'] === $password) {

                    $_SESSION['id'];
                    header("location: home.php");
                    die();
                } else {
                    echo "incorrect password";
                }
            } else {
                echo "invalid username";
            }
        }
        else{
            echo "It's empty";
        }
    }
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register/Create account/</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Be+Vietnam+Pro:ital,wght@1,200&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <link rel="stylesheet" href="./Style/RegisterStyle.css">
</head>

<body>
    <div class="container">
        <!-- Create login box -->
        <form class="form" id="login" action="#" method="POST">
            <h1 class="title">Login</h1>

            <!-- Create a box to fill in your name or username -->
            <div class="form__input-group">
                <input type="text" class="input" autofocus placeholder="Username" name="username" require>
            </div>

            <!-- Create a box to fill in your password -->
            <div class="form__input-group">
                <input type="password" class="input" autofocus placeholder="Password" name="password" require>
            </div>

            <input type="hidden" name="userId" value="">

            <!-- Create a submit button -->
            <button class="button" type="submit">Login</button>

            <p class="form__text">
                <a class="form__link" href="./create account.php" id="linkCreateAccount">Don't have an account? Create an account</a>
            </p>
        </form>
    </div>
</body>

</html>
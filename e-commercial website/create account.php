<?php
$connect = new mysqli('localhost', 'root', '', 'userInfo');
//print_r(mysqli_connect_error());
if (mysqli_connect_error() != null) {
    die("connection failed" . $connect->connect_errno);
} else {
    if ($_SERVER['REQUEST_METHOD'] == 'POST') {
        $username = $_POST['username'];
        //print($username."   uuuuuuuuuuuu");
        $email = $_POST['email'];
        //print($email."    eeeeeeeeeeeeeee");
        $phone = $_POST['phone'];
        //print($phone."     phphphphphphphph");
        $gender = $_POST['gender'];
        //print($gender."        gggggggggggggggggggg");
        $password = $_POST['password'];
        //print($password."       ppppppppppppppp");
        $confirmPassword = $_POST['confirmPassword'];
        //print($confirmPassword."       cpcpcpccpcpcpcp")

        if (!empty($username) && !empty($email) && !empty($phone) && !empty($password) && !empty($confirmPassword) && $confirmPassword == $password) {
            $sql = "INSERT INTO `userinfo` (`username`, `password`, `email`, `phone`, `gender`) 
            VALUES ('$username','$password','$email','$phone','$gender')";
            header('Login.php');
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
    <title>Document</title>

    <link rel="stylesheet" href="./Style/RegisterStyle.css">
</head>

<body>
    <div class="container">
        <!-- Create login box -->
        <form class="form" id="login" action="#" method="POST">
            <h1 class="title">Create an account</h1>

            <!-- Create a box to fill in your name -->
            <div class="form__input-group">
                <input type="text" class="input" autofocus placeholder="Username" name="username" require>
            </div>

            <!-- Create a box to fill in your email -->
            <div class="form__input-group">
                <input type="email" class="input" autofocus placeholder="email" name="email" require>
            </div>
                        
            <!-- Create a box to fill in your Phone number -->
            <div class="form__input-group">
                <input type="number" class="input" autofocus placeholder="Phone number" name="phone" require>
            </div>

            <!-- Create a box to fill in your Phone number -->
            <div class="form__input-group">
                <input type="radio" class="input" name="gender" value="male">
                <label for="male">Male</label><br>
                <input type="radio" class="input" name="gender" value="female">
                <label for="male">Female</label><br>
            </div>

            <!-- Create a box to fill in your password -->
            <div class="form__input-group">
                <input type="password" class="input" autofocus placeholder="Password" name="password" require>
            </div>
            
            <!-- Create a box to fill in your password -->
            <div class="form__input-group">
                <input type="password" class="input" autofocus placeholder="Confirm Password" name="confirmPassword" require>
            </div>

            <input type="hidden" name="userId" value="">

            <!-- Create a submit button -->
            <button class="button" type="submit">Create an account</button>

            <p class="form__text">
                <a class="form__link" href="./Login.php" id="linkCreateAccount">Agree have an account? Login</a>
            </p>
        </form>
    </div>

</body>

</html>
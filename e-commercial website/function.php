<?php

function checkLogin($connect){
    if(isset($_SESSION['username'])){
        $username= $_SESSION['username'];
        $query="select * from user where username = '$username'";
        $result=$connect->query($query);
        $result= mysqli_query($connect,$query);
        if($result->num_rows>0){
        $user_information= mysqli_fetch_assoc($result);

        return $user_information;
   }

       header("location:login.php");
       die();
  }
}

?>
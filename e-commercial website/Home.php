<?php
session_start();

$connect = new mysqli('localhost', 'root', '', 'userInfo');
if (mysqli_connect_error() != null) {
    die("connection failed" . $connect->connect_errno);
} else {
    //echo "connected successfully";

    if (isset($_GET['action'])) {
        if ($_GET['action'] == 'add') {
            $id = $_GET['id'];
            print($id);
            $sql = "SELECT * FROM `items` where `id`='$id'";
            $result = $connect->query($sql);

            if ($result->num_rows == 1) {
                $row = $result->fetch_assoc();

                // we store the retrieved values from the database to show them in input tags below
                $itemId = $row["id"];
                $itemName = $row["name"];
                $price = $row["price"];
                $description = $row["description"];
                $img1 = $row["img1"];
                $img2 = $row["img2"];
                $img3 = $row["img3"];
                $img4 = $row["img4"];

                $cartSql = "INSERT INTO useritems( `userid`, `itemsid`) VALUES (1,$itemId)";

                if ($connect->query($cartSql) === TRUE) {
                    echo '<script>alert("The item is added")</script>';
                    //echo '<script>window.location="Add to cart.php"</script>';
                } else echo "Error: " . $cartSql . "<br>" . $connect->error;
            } else echo "0 results";
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
    <title>Home</title>

    <link rel="stylesheet" href="./Style/nav.css">
    <link rel="stylesheet" href="./Style/Home.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
    <!-- Create navigation bar -->
    <nav>
        <input type="checkbox" id="check">

        <label for="check" class="checkbtn">
            <i class="fas fa-bars"></i>
        </label>

        <label class="logo">MobileShop</label>

        <ul>
            <li><a href="./Logout.php"><i class="fa-solid fa-arrow-right-from-bracket"></i> Logout</a></li>
        </ul>
    </nav>

    <!-- Create a slideshow -->
    <div class="slideshow">
        <div class="Slide">
            <img src="./Slideshow/iPhone.jpg" class="img1">
        </div>
        <div class="Slide">
            <img src="./Slideshow/Samsung announces Galaxy Z Fold3 5G and Galaxy Z Flip3 5G.png" class="img1">
        </div>
        <div class="Slide">
            <img src="./Slideshow/S21_Mockup_8_.jpg" class="img1">
        </div>
        <div class="Slide">
            <img src="./Slideshow/hawaii nova.jpg" class="img1">
        </div>
        <div class="Slide">
            <img src="./Slideshow/OPPO-Find-X3-5G.jpg" class="img1">
        </div>
        <div class="Slide">
            <img src="./Slideshow/LG WING, Official Site, LMF100N.jpg" class="img1">
        </div>
    </div>

    <h1 class="title">Mobile Phones</h1>
    <p class="firstP">Our everyday lives have become more reliant on mobile phones. In today's technologically driven world, it has become a need. Mobile phones were first introduced in 1973 as a means of communication, but they may now be used for a variety of tasks ranging from calling to shopping. Mobile phones include advanced cameras, super AMOLED displays, fast CPUs, large RAMs, and other features, and if you're looking for one, you've come to the correct spot. At myG, we provide a wide range of smartphones at competitive prices, and we send them to your home the same day.</p>

    <div class="container d-flex justify-content-center mt-50">
        <div class="row">
            <?php
            $selectItems = "SELECT * FROM `items`";
            $result = $connect->query($selectItems);
            if ($result->num_rows > 0) {
                while ($row = $result->fetch_assoc()) {
            ?>
                    <div class="col-md-4 mt-2">
                        <div class="card">
                            <div class="card-body">
                                <div class="card-img-actions">
                                    <img src="./items/<?php echo $row['img1']; ?>" class="card-img img-fluid" width="96" height="350" alt="">
                                </div>
                            </div>

                            <div class="card-body bg-light text-center">
                                <div class="mb-2">
                                    <h6 class="font-weight-semibold mb-2">
                                        <p href="#" class="text-default mb-2" data-abc="true" style="color: #019ef8;"><?php echo $row['name']; ?></p>
                                    </h6>
                                </div>

                                <h3 class="text-default mb-2"><?php echo $row['price'] . "JD"; ?></h3>

                                <div>
                                    <i class="fa fa-star star"></i>
                                    <i class="fa fa-star star"></i>
                                    <i class="fa fa-star star"></i>
                                    <i class="fa fa-star star"></i>
                                    <i class="fa fa-star star"></i>
                                </div>

                                <button type="button" class="btn bg-cart">
                                    <i class="fa fa-cart-plus mr-2"></i> Add to cart
                                </button>
                            </div>
                        </div>
                    </div>
            <?php
                }
            } else echo "There isn't any item";
            ?>
        </div>
    </div>

    <footer class="text-center text-white" style="background-color: #00143B;">

        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            <p>
                And you can follow us on social media to get all new through the following links:

                <a href="#" class="text-white">
                    <i class="fa-brands fa-facebook"></i>
                </a>
                <a href="#" class="text-white">
                    <i class="fa-brands fa-instagram"></i>
                </a>
                <a href="#" class="text-white">
                    <i class="fa-brands fa-snapchat"></i>
                </a>
                <a href="#" class="text-white">
                    <i class="fa-brands fa-twitter"></i>
                </a>
                <a href="#" class="text-white">
                    <i class="fa-brands fa-linkedin"></i>
                </a>
                <a href="#" class="text-white">
                    <i class="fa-brands fa-github"></i>
                </a>
            </p>
        </div>

    </footer>



    <script src="./JS/Home.js"></script>
</body>

</html>
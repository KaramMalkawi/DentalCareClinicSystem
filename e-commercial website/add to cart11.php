<?php
session_start();

$connect = new mysqli('localhost', 'root', '', 'userInfo');
if (mysqli_connect_error() != null) {
    die("connection failed" . $connect->connect_errno);
} else {
    echo "connected successfully";
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
    <main class="page">
        <section class="shopping-cart dark">
            <div class="container">
                <div class="block-heading">
                    <h2>Shopping Cart</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna, dignissim nec auctor in, mattis vitae leo.</p>
                </div>
                <div class="content">
                    <div class="row">
                        <div class="col-md-12 col-lg-8">
                            <?php
                            $selectUserItems = "SELECT * FROM `useritems` where `itemId`='1'";
                            //print($sql);
                            $result = $connect->query($selectUserItems);
                            print($result);

                            if ($result->num_rows > 0) {
                                while ($row = $result->fetch_assoc()) {

                                    $itemId = $row['itemId'];
                                    // echo $itemId;
                                    $getItem = "SELECT * FROM courses where Id=$itemId";
                                    $itemInfo = $connect->query($getItem);

                                    if ($itemInfo->num_rows > 0) {
                                        while ($items = $itemInfo->fetch_assoc()) {
                            ?>
                                            <div class="items">
                                                <div class="product">
                                                    <div class="row">
                                                        <div class="col-md-3">
                                                            <img class="img-fluid mx-auto d-block image" src="assets/img/image.jpg">
                                                        </div>
                                                        <div class="col-md-8">
                                                            <div class="info">
                                                                <div class="row">
                                                                    <div class="col-md-5 product-name">
                                                                        <div class="product-name">
                                                                            <a href="#">Lorem Ipsum dolor</a>
                                                                            <div class="product-info">
                                                                                <div>Display: <span class="value">5 inch</span></div>
                                                                                <div>RAM: <span class="value">4GB</span></div>
                                                                                <div>Memory: <span class="value">32GB</span></div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-4 quantity">
                                                                        <label for="quantity">Quantity:</label>
                                                                        <input id="quantity" type="number" value="1" class="form-control quantity-input">
                                                                    </div>
                                                                    <div class="col-md-3 price">
                                                                        <span>$120</span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                            <?php
                                        }
                                    }
                                }
                            }
                            ?>
                        </div>
                        <div class="col-md-12 col-lg-4">
                            <div class="summary">
                                <h3>Summary</h3>
                                <div class="summary-item"><span class="text">Subtotal</span><span class="price">$360</span></div>
                                <div class="summary-item"><span class="text">Discount</span><span class="price">$0</span></div>
                                <div class="summary-item"><span class="text">Total</span><span class="price">$360</span></div>
                                <button type="button" class="btn btn-primary btn-lg btn-block">Checkout</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
</body>

</html>
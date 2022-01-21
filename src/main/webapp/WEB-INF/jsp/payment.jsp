<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Paypal Payment</title>

    <link rel="stylesheet" href="css/stylePayment.css">
</head>
<body>
    <main id="cart-main">
        <div class="site-title text-center">
            <h1 class="font-title">Carrello</h1>
        </div>

        <div class="container">
            <div class="grid">
                <div class="col-1">
                    <div class="flex item justify-content-between">
                        <div class="flex">
                            <div class="img text-center">
                                <img src="../immagini/camionUnicalTracciabile.png" alt=""> <!--immagine spedizione-->
                            </div>
                            <div class="title">
                                <h3>Canon EOS 1500D</h3> <!--qui inserire il nome del acquisto-->
                                <span>Electronics</span> <!--qui mettere la sottolabel-->

                                <div class="buttons">
                                    <input type="text" class="font-title" value="1"> <!--qui inserire i dettgli della spedizione-->
                                </div>
                            </div>
                        </div>
                        <div class="price">
                            <h4 class="text-red">$349</h4> <!--qui mettere il prezzo-->
                        </div>
                    </div>
                </div>
                <div class="col-2">
                    <div class="subtotal text-center">
                        <h3>Resoconto</h3>

                        <ul>
                            <li class="flex justify-content-between">
                                <label for="price">Products ( 3 items ) : </label> 
                                <span>$399</span>   <!--riprendere il prezzo dell'item-->
                            </li>
                            <li class="flex justify-content-between">
                                <label for="price">IVA : </label> 
                                <span>22%</span>
                            </li>
                            <hr>
                            <li class="flex justify-content-between">
                                <label for="price">Costo totale : </label>
                                <span class="text-red font-title">$399</span> <!--inserire prezzo+iva-->
                            </li>
                        </ul>
                        <div id="paypal-payment-button">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>


    <script src="https://www.paypal.com/sdk/js?client-id=AQ2WqHwi0ANjtRSJbuTR_Q5kFXHFCtUexGeviXlYOZuseBFzZIFssrFaOD-Bi_p3XSRs1-6EIfgk1gP6&disable-funding=credit,card"></script>
    <script src="https://www.paypal.com/sdk/js?client-id=AQ2WqHwi0ANjtRSJbuTR_Q5kFXHFCtUexGeviXlYOZuseBFzZIFssrFaOD-Bi_p3XSRs1-6EIfgk1gP6&currency=EUR"></script>
    <script src="js/payment.js"></script>
</body>
</html>

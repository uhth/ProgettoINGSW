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
            <h1 class="font-title">Carrello &#128722;</h1>
        </div>

        <div class="container">
            <div class="grid">
                <div class="col-1">
                    <div class="flex item justify-content-between">
                        <div class="flex">
                            <div class="img text-center">
                                <img src="" id="img" alt=""> <!--immagine spedizione-->
                                <script>
                                    var img= sessionStorage.getItem("third");
                                    document.getElementById("img").src=img;
                                    //sessionStorage.clear();
                                </script>
                            </div>
                            <div class="title">
                                <h3 id="Spedizione"></h3>
                                <script>
                                    var spedizione= sessionStorage.getItem("second");
                                    document.getElementById("Spedizione").innerHTML= spedizione;
                                    //sessionStorage.clear();
                                </script>
                                <span>Qui inserire i dettagli della spedizione(via ritiro,ecc)</span> <!--qui mettere la sottolabel-->
                            </div>
                        </div>
                        <div class="price">
                            <p id="costo"></p>
                            <script>
                                var costo= sessionStorage.getItem("first");
                                document.getElementById("costo").innerHTML= costo+" "+ "&euro;";
                                //sessionStorage.clear();
                            </script>
                            <!--<h4 class="text-red"></h4>-->
                        </div>
                    </div>
                </div>
                <div class="col-2">
                    <div class="subtotal text-center">
                        <h3>Resoconto</h3>

                        <ul>
                            <li class="flex justify-content-between">
                                <label for="price">Spedizione : </label> 
                                <span id="costo2"></span><!--riprendere il prezzo dell'item-->
                                <script>
                                    var costo= sessionStorage.getItem("first");
                                    document.getElementById("costo2").innerHTML= costo+" "+ "&euro;";
                                </script>   
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

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <link rel="stylesheet" href="css/index.css">
    <script src="https://kit.fontawesome.com/eb3e5ce09e.js" crossorigin="anonymous"></script>
    <title>UniTransport</title>
</head>

<body>
    <header class="showcase">
        <div class="showcase-top">
            <img src="/immagini/b1.png" alt="">
            <c:if test="${ email == null }">
            	<a href="login" id="prova" onclick="btnAccedi()" class="btn btn-rounded">Accedi</a>
            </c:if>
        </div>
        <div class="showcase-content">
            <h1>Hai creato con successo l'account</p>
                <a href="/" class="btn btn-xl">
                    TORNA ALLA HOME <i class="fas fa-chevron-right btn-icon"></i>
                </a>
        </div>
    </header>




            <footer class="footer">
                <div class="footer-cols">
                    <ul>
                        <li><a href="faq">FAQ</a></li>
                    </ul>
                    <ul>
                        <li><a href="chi_siamo">Chi siamo</a></li>
                    </ul>
                    <ul>
                        <li><a href="http://www.unical.it">Sito Unical</a></li>
                    </ul>
                    <ul>
                        <c:if test="${email == null}">
                            <li><a id="prova" onclick="document.getElementById('divLogin').style.display='block'">Account</a></li>
                        </c:if>  
                    </ul>
                </div>
            </footer>
</body>

</html>
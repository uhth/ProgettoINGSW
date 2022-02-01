<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
	<!--<link href="https://chatcompose.azureedge.net/static/all/global/export/css/main.5b1bd1fd.css"
        rel="stylesheet">
    <script async type="text/javascript"
        src="https://chatcompose.azureedge.net/static/all/global/export/js/main.a7059cb5.js?user=unitransport&lang=IT"
        user="unitransport" lang="IT"></script>-->
    <link href="https://chatcompose.azureedge.net/static/all/global/export/css/main.5b1bd1fd.css" rel="stylesheet">    <script async type="text/javascript" src="https://chatcompose.azureedge.net/static/all/global/export/js/main.a7059cb5.js?user=UnicalTransport&lang=IT" user="UnicalTransport" lang="IT"></script>  
    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <link rel="stylesheet" href="css/index.css">
    <script src="https://kit.fontawesome.com/eb3e5ce09e.js" crossorigin="anonymous"></script>
    <title>Pagamento fallito</title>
</head>

<body>
    <header class="showcase">
        <div class="showcase-top">
            <a id="posLogo" href="/"><img id="posLogo" src="/immagini/b1.png"></a>
        </div>
        
       <div class="showcase-content">
        <h1>ACCESSO NEGATO
            <br>
        </h1>
            <p>Qualcosa è andato storto durante il pagamento, ti preghiamo di ritornare alla home page e riprovare</p>
        <h2>
            <a href="/" class="btn btn-xl">
                TORNA ALLA HOME <i class="fas fa-chevron-right btn-icon"></i>
            </a>
        </h2>
        <br><br>   
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
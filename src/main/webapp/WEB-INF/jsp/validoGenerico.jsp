<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1>${validoGenerico}</h1>
            <p>${validoGenerico_p}</p>
                <a href="/" class="btn btn-xl">
                    TORNA ALLA HOME <i class="fas fa-chevron-right btn-icon"></i>
                </a>
        </div>
        <br><br>
    </header>




    <footer class="footer">
        <p>Problemi? Contatta l'assistenza</p>
        <div class="footer-cols">
            <ul>
                <li><a href="">FAQ</a></li>
                <li><a href="">Burocrazia</a></li>
            </ul>
            <ul>
                <li><a href="">Lavora con noi</a></li>
                <li><a href="">Chi siamo</a></li>
            </ul>
            <ul>
                <li><a href="">Sito Unical</a></li>
                <li><a href="">Dove siamo</a></li>
            </ul>
            <ul>
                <li><a href="">Account</a></li>
                <li><a href="">Privacy</a></li>
            </ul>
        </div>
    </footer>
    <script src="js/main.js"></script>
</body>

</html>
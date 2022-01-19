<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <link rel="stylesheet" href="css/gmaps.css">
    <script src="js/gmaps.js"></script>
    <script src="https://kit.fontawesome.com/eb3e5ce09e.js" crossorigin="anonymous"></script>
    <title>UniTransport</title>
</head>

<body>
    <header class="showcase">
        <div class="showcase-top">
                <div class="showcase-top">
                   <a id="posLogo" href="/"><img id="posLogo" src="/immagini/b1.png"></a>


                    <c:if test="${email == null}">
                        <p class="intro_benvenuto">Benvenuto utente</p>
                        <a href="login" id="prova" onclick="btnAccedi()" class="btn btn-rounded">Accedi</a>
                    </c:if>

                    <c:if test="${email != null}">
                        <p class="intro_benvenuto">Benvenuto ${email}</p>
                        <a href="profilo_utente" id="profilo_utente" onclick="btnAccedi()" class="btn btn-rounded">Profilo utente</a>
                        <a href="logout" id="prova" onclick="btnAccedi()" class="btn btn-rounded">Logout</a>
                    </c:if>
                </div>  

            </div>


        <div class="showcase-content">
            <h1>Il codice inserito non appartiene a nessuna spedizione</h1>
            <h2>Inserisci un codice valido</h2></p>
                <form method="post" action="trackingService">
                    <input type="text" id="tracking_box" name="tracking_box" placeholder="Inserisci numero di tracking" name="track_box">
                    <input type="submit" class="btn btn-xl" id="button_procedi" value="Procedi" />
                <!-- <a href="/" class="btn btn-xl" id="button_procedi"> PROCEDI <i class="fas fa-chevron-right btn-icon"></i>        </a> -->
                </form>
          </div>
    </header>


</body>

</html>
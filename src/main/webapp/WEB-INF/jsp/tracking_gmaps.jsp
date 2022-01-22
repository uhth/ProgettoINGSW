<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <link rel="stylesheet" href="css/gmaps.css">
    <link rel="stylesheet" href="css/login.css">
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
                        <a id="prova" onclick="document.getElementById('divLogin').style.display='block'" class="btn btn-rounded">Accedi</a>
                    </c:if>

                    <c:if test="${email != null}">
                        <p class="intro_benvenuto">Benvenuto ${email}</p>
                        <a href="profilo_utente" id="profilo_utente" onclick="btnAccedi()" class="btn btn-rounded">Profilo utente</a>
                        <a href="logout" id="prova" onclick="btnAccedi()" class="btn btn-rounded">Logout</a>
                    </c:if>
                </div>  
                     
            </div>
            
            
        <div class="showcase-content">
            <h1>Inserisci il codice della tua spedizione</h1>
            <form method="post" action="trackingService">
                <input type="text" id="tracking_box" name="tracking_box" placeholder="Inserisci numero di tracking" name="track_box" value="${trackingRichiesto}">
                <input type="submit" class="btn btn-xl" id="button_procedi" value="Procedi" />
            </form>

            <!-- LOGIN -->
            <div id="divLogin" class="modal">
                <form class="modal-content animate" action="/loginService" method="post">
                    <div class="imgcontainer">
                        <span onclick="document.getElementById('divLogin').style.display='none'" class="close"
                            title="Close Modal">&times;</span>
                        <img src="img/b1.png" alt="Avatar" class="avatar">
                    </div>
                    <div class="container">
                        <label for="uname"><b>Email</b></label>
                        <input type="text" placeholder="Inserisci Email" name="email" required>
                        <label for="psw"><b>Password</b></label>
                        <input type="password" placeholder="Inserisci Password" name="password" required>
                        <button type="submit" id="button">Login</button>
                    </div>
                    <div class="container" style="background-color:#f1f1f1">
                        <button type="button"
                            onclick="document.getElementById('divLogin').style.display='none'; document.getElementById('divRegister').style.display='block' "
                            class="cancelbtn">Registrati</button>
                        <span class="psw"><a href="#" id="forgotPassw">Password dimenticata?</a></span>
                    </div>
                </form>
            </div>
            <!-- FINE LOGIN -->
            <!-- REGISTER -->
            <div id="divRegister" class="modal">
                <form class="modal-content animate" action="/iscrizioneService" method="post">
                    <div class="imgcontainer">
                        <span onclick="document.getElementById('divRegister').style.display='none'"
                            class="close" title="Close Modal">&times;</span>
                        <img src="img/b1.png" alt="Avatar" class="avatar">
                    </div>
                    <div class="container">
                        <label for="email"><b>Email</b></label>
                        <input type="email" placeholder="Inserisci Email" name="email" required>
                        <label for="password"><b>Password</b></label>
                        <input type="password" placeholder="Inserisci Password" name="password" required>
                        <label for="password_ripetuta"><b>Conferma Password</b></label>
                        <input type="password" placeholder="Inserisci Password" name="password_ripetuta"
                            required>
                        <button type="submit" id="button">Registrati</button>
                    </div>
                    <div class="container" style="background-color:#f1f1f1">
                        <button type="button"
                            onclick="document.getElementById('divRegister').style.display='none'; document.getElementById('divLogin').style.display='block';"
                            class="cancelbtn">Login</button>
                    </div>
                </form>
            </div>
            <!-- FINE REGISTER -->
        </div>

         

    </header>
    <script src="js/login.js"></script>
    <footer class="footer">
        <div class="footer-cols">
            <ul>
                <li><a href="">FAQ</a></li>
            </ul>
            <ul>
                <li><a href="">Chi siamo</a></li>
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
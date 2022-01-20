<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
	<link href="https://chatcompose.azureedge.net/static/all/global/export/css/main.5b1bd1fd.css"
        rel="stylesheet">
    <script async type="text/javascript"
        src="https://chatcompose.azureedge.net/static/all/global/export/js/main.a7059cb5.js?user=unitransport&lang=IT"
        user="unitransport" lang="IT"></script>
    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/login.css">
    <script src="https://kit.fontawesome.com/eb3e5ce09e.js" crossorigin="anonymous"></script>
    <title>UniTransport</title>
</head>

<body>
    <header class="showcase">
        <div class="showcase-top">
            <a id="posLogo" href="/"><img id="posLogo" src="/immagini/b1.png"></a>
        </div>
        
       <div class="showcase-content">
       <h1>ACCESSO NEGATO</p>
               <a id="prova" onclick="document.getElementById('divLogin').style.display='block'" class="btn btn-xl">Accedi <i class="fas fa-chevron-right btn-icon"></i></a>
           <br>
           <br>
           <a href="/" class="btn btn-xl">
               TORNA ALLA HOME <i class="fas fa-chevron-right btn-icon"></i>
           </a>

			<!-- LOGIN -->
               <div id="divLogin" class="modal">
                   <form class="modal-content animate" action="/loginService" method="post">
                       <div class="imgcontainer">
                           <span onclick="document.getElementById('divLogin').style.display='none'" class="close"
                               title="Close Modal">&times;</span>
                           <img src="img/b1.png" alt="Avatar" class="avatar">
                       </div>
                       <div class="container">
                           <label for="uname" class="text-dark"><b>Email</b></label>
                           <input type="text" placeholder="Inserisci Email" name="email" required>
                           <label for="psw" class="text-dark"><b>Password</b></label>
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
                           <input type="email" placeholder="Inserisci Email" name="email" required>
                           <label for="password" class="text-dark" ><b>Password</b></label>
                           <input type="password" placeholder="Inserisci Password" name="password" required>
                           <label for="password_ripetuta" class="text-dark" ><b>Conferma Password</b></label>
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
         </div>
    </header>
                    <!-- FINE REGISTER -->

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
    <script src="login.js"></script>
</body>

</html>
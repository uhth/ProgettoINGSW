<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <link rel="stylesheet" href="css/tracking_page.css">
    <script src="https://kit.fontawesome.com/eb3e5ce09e.js" crossorigin="anonymous"></script>
    <title>UniTransport</title>
</head>

<body>
    <header class="showcase">
        <div class="showcase-top">
            <img src="/immagini/b1.png" alt="">
                <div class="showcase-top">
                    <img src="/immagini/b1.png" alt="">


                    <c:if test="${username == null}">
                        <p class="intro_benvenuto">Benvenuto utente</p>
                        <a href="login" id="prova" onclick="btnAccedi()" class="btn btn-rounded">Accedi</a>
                    </c:if>

                    <c:if test="${username != null}">
                        <p class="intro_benvenuto">Benvenuto ${username}</p>
                        <a href="profilo_utente" id="profilo_utente" onclick="btnAccedi()" class="btn btn-rounded">Profilo utente</a>
                        <a href="logout" id="prova" onclick="btnAccedi()" class="btn btn-rounded">Logout</a>
                    </c:if>
                </div>  
                     
            </div>
            
            
        <div class="showcase-content">
            <h1>Inserisci il codice della tua spedizione</p>

                
                <form method="post" action="trackingService">
                <input type="text" id="tracking_box" placeholder="Inserisci numero di tracking" name="codice_inserito" action="trackingService"><br>

		            <input  class="btn btn-xl" d= "button_procedi" type="submit" value="Cerca" />
		
	     	   </form>
        
                
          </div>
    </header>


</body>

</html>


<!-- 

        <div class="showcase-content">
            <h1>Inserisci il codice della tua spedizione</p>
                <input type="text" id="tracking_box" placeholder="Inserisci numero di tracking" name="codice_inserito" action="trackingService"><br>
                <a href="tracking_information" class="btn btn-xl" id="button_procedi" name="truck_code" method="post" type="button" >
                    PROCEDI <i class="fas fa-chevron-right btn-icon"></i>
                </a>
                
                <form method="post" action="trackingService">
		            <p>Username:</p>
		            <input type="text" name="username" placeholder="Inserisci nome utente"/>
		            <p>Password:</p>
		            <input type="password" name="pass" placeholder="Inserisci password"/>
		
		            <input type="submit" value="Accedi" />
		
	     	   </form>
        
                
          </div>
 -->
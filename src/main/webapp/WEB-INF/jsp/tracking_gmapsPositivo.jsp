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
            <h1>Spedizione trovata!</h1>
            <h3>Cerca una nuova spedizione</h3>
            <form method="post" action="trackingService">
                <input type="text" id="tracking_box" name="tracking_box" placeholder="Inserisci numero di tracking" name="track_box">
                <input type="submit" class="btn btn-xl" id="button_procedi" value="Procedi" />
            </form>
            <div id="map"></div>
        

            <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD35CvNGS9oIaIaa-MSQsKf1i4JxrInTf4&callback=initMap&libraries=&v=weekly" async></script>

            <table class="table">
                <thead class="thead-light">
                  <tr>                      
                    <th scope="col">Data e ora</th>
                    <th scope="col">Stato</th>
                    <th scope="col">Luogo</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th scope="row">..</th>
                    <td>..</td>
                    <td>..</td>
                  </tr>
                </tbody>
              </table>
          </div>
    </header>


</body>

</html>
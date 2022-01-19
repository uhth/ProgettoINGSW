<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <link rel="stylesheet" href="css/gmaps.css">
  
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
            <script th:inline="javascript">
            function initMap() {
            const roma = { lat: 41.77, lng: 12.94 }; 
            const map = new google.maps.Map(document.getElementById("map"), {
                zoom: 4,
                center: roma,
            });
                
            const icons = {
                mittente: {
                icon: "immagini/gmaps_mittente.png",
                },
                destinatario: {
                icon: "immagini/gmaps_destinatario.png",
                },
                corriere: {
                icon: "immagini/gmaps_corriere.png",
                },
            };
            
            /*<![CDATA[*/
                const features = [
                {
                position: new google.maps.LatLng([[${corrierelat}]],  [[${corrierelong}]]),
                type: "corriere",
                },
                {
                position: new google.maps.LatLng([[${mittentelat}]],  [[${mittentelong}]]),
                type: "mittente",
                },
                {
                position: new google.maps.LatLng([[${destinatariolat}]],  [[${destinatariolong}]]),
                type: "destinatario",
                },
                ];
                /*]]>*/
                
            // Create markers.
            for (let i = 0; i < features.length; i++) {
                const marker = new google.maps.Marker({
                position: features[i].position,
                icon: icons[features[i].type].icon,
                map: map,
                });
            }
            
            map.addListener("click", (mapsMouseEvent) => {    
                console.log(mapsMouseEvent.latLng.toJSON()) /* posizione  */
            /*  infoWindow.open(map); infowindow */ 
            });
            }
            </script>

            
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
                    <th scope="row">${dataeora}</th>
                    <td>${statosped}</td>
                    <td>${luogosped}</td>
                  </tr>
                </tbody>
              </table>
          </div>
    </header>


</body>

</html> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Aggiorna Stato</title>
  </head>
  <body>
  <div class="background">
  <nav class="navbar navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src="../immagini/logoBianco.jpeg" alt="" width="30" height="24" class="d-inline-block align-text-top">
      UniTransport
    </a>
  </div>
</nav>




<div class="container my-5 text-center" style="max-width: 580px;">
    <img src="../immagini/logoNome.png" alt="" style="width:30%;">
    <p class="lead">Aggiorna lo stato di una spedizione </p>
    <button type="button" class="btn btn-primary"><a href="/" class="text-decoration-none" style="color: white;">Home Page</a></button>
	<button type="button" class="btn btn-success"><a href="profilo_utente" class="text-decoration-none" style="color: white;">Profilo</a></button>
	<button type="button" class="btn btn-secondary"><a href="tracking_gmaps" class="text-decoration-none" style="color: white;">Traccia spedizione</a></button>
</div>



      <div class="container">
        <div class="row">
				    <div class="col">
				      

							      <p style="color: blue; border-style: outset; border-color: lightblue; text-align: center; font-size: 28px; font-family: Courier, monospace;">SPEDIZIONE N.</p>
  										<form  method="post" action="corriereServiceCode">
										  <div class="form-group">
										    <label for="formCodice">Inserisci il Codice Tracking</label>
										    <input type="text" class="form-control" id="codice" placeholder="Codice Tracking" name="codice" value="${codiceRichiestoCorriere}">
											
										  </div>
										  <br>
										  <input  class="btn btn-success" type="submit" value="Cerca" />	<br><br>										 							  
										</form>


				    </div>
					<div class="col">
				      
						<p style="color: blue; border-style: outset; border-color: lightblue; text-align: center; font-size: 28px; font-family: Courier, monospace;">POSIZIONE ATTUALE</p>
							<!--<label for="formLuogo" >${luogoAttuale}</label>-->
							<div id="map"></div>

							<!--<img src="http://mt1.google.com/vt/lyrs=m@113&hl=it&x=17509&s=&y=12191&z=15&s=Galile" class="center">-->
			


		 			 </div>
				    <div class="col">
							      <p style="color: blue; border-style: outset; border-color: lightblue; text-align: center; font-size: 28px; font-family: Courier, monospace;">MODIFICHE</p>				      
										<form  method="post" action="corriereService">
										  <div class="form-group">
										    <label for="formLuogo">Località Aggiornata</label>
										    <input type="text" class="form-control" id="luogoAggiornato" placeholder="es. Roma (RM)" name="luogoAggiornato">
										  </div>
										  <div class="form-group">
										    <label for="formStato">Stato</label>
										    <select multiple class="form-control" id="" name="scelta">
													<c:choose>
													    <c:when test="${statoPacco == 0}">
													        <option value="1">SPEDIZIONE AVVIATA</option>
													        <option value="5">SPEDIZIONE SMARRITA</option>
													    </c:when>
													    <c:when test="${statoPacco == 1}">
													        <option value="2">SPEDIZIONE PRONTA PER LA CONSEGNA</option>
													        <option value="5">SPEDIZIONE SMARRITA</option>
													    </c:when>
													    <c:when test="${statoPacco == 2}">
													        <option value="3">SPEDIZIONE IN CONSEGNA</option>
													        <option value="5">SPEDIZIONE SMARRITA</option>
													    </c:when>
													    <c:when test="${statoPacco == 3}">
													        <option value="4">SPEZIONE COMPLETATA</option>
													        <option value="5">SPEDIZIONE SMARRITA</option>
													    </c:when>
													    <c:otherwise>
													        <option value="-1">STATO SCONOSCIUTO</option>
													    </c:otherwise>
													</c:choose>

										    </select>
										  </div>
										  <br>
										  <input  class="btn btn-primary" type="submit" value="Aggiorna" />
										</form>


				    </div>
				    
				     

     	 </div>
      
      </div>
      
      
    </div>  

  </body>
  
      <style>

      .background {
        background-image: url("../immagini/mappa_sfocata.png")  ;
 		background-size: contain;
        background-repeat: no-repeat;
      }

     .center {
	  display: block;
	  margin-left: auto;
	  margin-right: auto;
	  width: 50%;
	}
	#map {
		height: 200px;
		width: 100%;
		}
	</style>

	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD35CvNGS9oIaIaa-MSQsKf1i4JxrInTf4&callback=initMap&libraries=&v=weekly" async></script>
	<script th:inline="javascript">

		function initMap() {
			const roma = { lat: 41.77, lng: 12.94 }; 
			const map = new google.maps.Map(document.getElementById("map"), {
				zoom: 5.5,
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
				},];                  
					
				const mittenteCorriere = [
					new google.maps.LatLng([[${corrierelat}]],  [[${corrierelong}]]),
					new google.maps.LatLng([[${mittentelat}]],  [[${mittentelong}]])
				];
				const mitCor = new google.maps.Polyline({
					path: mittenteCorriere,
					geodesic: true,
					strokeColor: "#FF0000",
					strokeOpacity: 0.5,
					strokeWeight: 2,
				});
				const corDestinatario = [
					new google.maps.LatLng([[${corrierelat}]],  [[${corrierelong}]]),
					new google.maps.LatLng([[${destinatariolat}]],  [[${destinatariolong}]])
				];
				const corDest = new google.maps.Polyline({
					path: corDestinatario,
					geodesic: true,
					strokeColor: "#12d400",
					strokeOpacity: 0.5,
					strokeWeight: 2,
				});

				mitCor.setMap(map); 
				corDest.setMap(map); 
			/*]]>*/
			
	
			// Creazione markers.
			for (let i = 0; i < features.length; i++) {
				const marker = new google.maps.Marker({
					position: features[i].position,
					icon: icons[features[i].type].icon,
					map: map,					
				});
				if (features[i].type == "corriere"){
					addInfoWindow(marker, "Corriere");
					map.setZoom(15);
            		map.panTo(marker.position);
				}
				if (features[i].type == "mittente")
					addInfoWindow(marker, "Mittente");
				if (features[i].type == "destinatario")
					addInfoWindow(marker, "Destinatario");
			}
		/*          
		map.addListener("click", (mapsMouseEvent) => {    
			console.log(mapsMouseEvent.latLng.toJSON()) // print posizione              
		});
		*/                
		}

		function addInfoWindow(marker, message) {
			var infoWindow = new google.maps.InfoWindow({
				content: message
			});

			google.maps.event.addListener(marker, 'click', function () {
				infoWindow.open(map, marker);
			});
		}
	</script>
</html>
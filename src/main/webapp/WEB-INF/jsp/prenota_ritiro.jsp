<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Prenota ritiro</title>
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
    <p class="lead">Prenota un ritito ${email}</p>
    <button type="button" class="btn btn-primary"><a href="/" class="text-decoration-none" style="color: white;">Home Page</a></button>
	  <button type="button" class="btn btn-success"><a href="profilo_utente" class="text-decoration-none" style="color: white;">Profilo</a></button>
	  <button type="button" class="btn btn-secondary"><a href="tracking_gmaps" class="text-decoration-none" style="color: white;">Traccia spedizione</a></button>
</div>


      <div class="container">
        <div class="row">

				    <div class="col">
										<form  method="post" action="/prenotaService" id="form">
										  <div class="form-group">
										    <label for="formLuogo">Ritiro presso:</label>
										    <input type="text" class="form-control" id="ViaRitiro" placeholder="es. Via Roma n.31 Milano (MI)" name="luogoRitiro">
										  </div>
										  <br>
										  <div class="form-group">
										    <label for="formLuogo">Consegna presso:</label>
										    <input type="text" class="form-control" id="ViaConsegna" placeholder="es. Via Riccardo Misasi n.31 Cosenza (CS)" name="luogoConsegna">
										  </div>
										  <br>	
										  <div class="form-group">
										    <label for="formLuogo">Email destinatario:</label>
										    <input type="text" class="form-control" id="EmailDest" placeholder="es. email@address.com" name="emailDestinatario">
										  </div>
										  <br>
                      <p>Seleziona il tuo metodo di pagamento:</p>
                      <input type="radio" id="Online" name="Online" value="Online">
                      <label for="Online">Online</label>
                      <br>
                      <input type="radio" id="Contrassegno" name="Contrassegno" value="Contrassegno">
                      <label for="Contrassegno">Contrassegno</label>
                      <br>
                      <button type="button" class="btn btn-primary" onclick="prosegui()">Procedi</button>
                      <!--<button type="button" class="btn btn-primary"><a href="/payment" class="text-decoration-none" style="color: white;">Prosegui</a></button>-->								  										  
                      <!--<input class="btn btn-primary" type="submit" value="Prenota"/>-->
										</form>


				    </div>
				    


     	 </div>
      
      </div>
      
      
    </div>  
    <script src="js/prenota_ritiro.js"></script>
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
     
	</style>
</html>
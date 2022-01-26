<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Gestisci spedizione</title>
  </head>
  <body>
  <div class="background">
  <nav class="navbar navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src="../immagini/b1.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
      UniTransport
    </a>
  </div>
</nav>




<div class="container my-5 text-center" style="max-width: 580px;">
    <img src="../immagini/logoNome.png" alt="" style="width:30%;">
    <p class="lead" style="font-size: 32px;">Hai bisogno di modificare una spedizione?</p>
    <p class="lead">Inserisci il codice della spedizione che ti interessa e procedi inserendo i nuovi dati.</p>
    <button type="button" class="btn btn-primary"><a href="/" class="text-decoration-none" style="color: white;">Home Page</a></button>
	<button type="button" class="btn btn-success"><a href="profilo_utente" class="text-decoration-none" style="color: white;">Profilo</a></button>
	<button type="button" class="btn btn-secondary"><a href="tracking_page" class="text-decoration-none" style="color: white;">Traccia spedizione</a></button>
	<button type="button" class="btn btn-danger"><a href="profilo_utente" class="text-decoration-none" style="color: white;">Torna Indietro</a></button>
	
</div>


      <div class="container">
        <div class="row">
        
            	 <div class="col text-center">
						<div class="info">


						<table>
						  <tr>
						    <th> ~CODICI SPEDIZIONI DISPONIBILI~ </th>
						  </tr>
							<c:forEach items="${listaSpedizioni}" var="singolaSpedizione">
								<th></th>
								  <tr>
								    <td>${singolaSpedizione}</td>
								  </tr>								
							</c:forEach>
						</table>

						</div>	

											
				  </div>
        

				    <div class="col">
										<form  method="post" action="cercaTrackingModificaSpedizione">
										  <div class="form-group">
										    <label for="formLuogo">SPEDIZIONE DA MODIFICARE:</label>
										    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="es. un1tr4$p0rt" name="trackingModifica">
										  </div>
										  <br>			  
										    <input  class="btn btn-primary" type="submit" value="CERCA"/>
										</form>

										<br><br>


										<form  method="post" action="aggiornaSpedizioneUtente">
										  <div class="form-group">
										    <label for="formLuogo">Consegna presso:</label>
										    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="es. Via Roma n.31 Milano (MI)" name="luogoConsegnaNuovo">
										  </div>
										  <br>								  										  
										    <input  class="btn btn-success" type="submit" value="MODIFICA"/>
										</form>
										<br><br>




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
	
	table, th, td {
	  border:2px dotted rgba(0,90,255,255);
	}
     
     
	</style>
</html>
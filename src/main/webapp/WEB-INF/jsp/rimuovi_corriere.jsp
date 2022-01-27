<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>ZONA AMMINISTRATORE</title>
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
    <p class="lead">In questa sezione puoi gestire il tuo profilo </p>
    <button type="button" class="btn btn-primary"><a href="/" class="text-decoration-none" style="color: white;">Home Page</a></button>
	<button type="button" class="btn btn-success"><a href="spedisci" class="text-decoration-none" style="color: white;">Prenota un ritiro</a></button>
	<button type="button" class="btn btn-secondary"><a href="tracking_page" class="text-decoration-none" style="color: white;">Traccia un'altra spedizione</a></button>
</div>



      <div class="container">
        <div class="row">
				   

				  
				   <div class="col">
				      <p class="p">Email corrieri attivi</p>
						<div class="info">
							<ul>
							<c:forEach items="${listaUtentiConvertibili}" var="singoliUtenti">
								<li>${singoliUtenti}</li>
							</c:forEach>
							</ul>
						</div>	

											
				  </div>
				  	
				  	
				  					  
				   <div class="col text-center">
				      <p class="p">Rimuovi corriere</p>
						<div class="richiesta">
							<form  method="post" action="rimozioneCorriere">
									  <div class="form-group">
									    <label for="formCorriere"></label>
									    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="es. mario_rossi@gmail.com" name="richiestaRimozioneCorriere">
								 	 </div>
								  <br>								  										  
							    <input  class="btn btn-success" type="submit" value="CONFERMA"/>
							</form>
						</div>	

											
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
      
      .p{
      	color: blue; border-style: outset; border: 2px solid; border-radius: 15px; border-color: rgba(12, 19, 216, 0.8); text-align: center; font-size: 32px; font-family: Copperplate, Papyrus, fantasy;
      }
      
      .info {
      	text-align: center; font-family: monospace; border-style: inset;  font-size: 16px;
      }

     
	</style>
  
</html>
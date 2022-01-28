<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>ZONA CORRIERE</title>
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
    <p class="lead">In questa sezione puoi gestire il tuo lavoro </p>
    <button type="button" class="btn btn-primary"><a href="/" class="text-decoration-none" style="color: white;">Home Page</a></button>
	<button type="button" class="btn btn-secondary"><a href="tracking_gmaps" class="text-decoration-none" style="color: white;">Aggiorna stato spedizione</a></button>
</div>



      <div class="container">
        <div class="row">
				   

				    

				    <div class="col">
				      <p class="p">EMAIL</p>
				
						<p class="info">${email}</p><br>
						

				  </div>
				  
				  
				   <div class="col text-center">
				      <p class="p">PASSWORD</p>
				 	
						<button type="button" class="btn btn-success"><a href="spedisci" class="text-decoration-none" style="color: white;">Modifica password</a></button>
				 
				  </div>
				  
				   <div class="col">
				      <p class="p">SPEDIZIONI DISPONIBILI</p>
						<div class="info">
							<ul>
							<c:forEach items="${listaSpedizioniTotale}" var="spedizioneDisponibile">
								<li>${spedizioneDisponibile}</li>
							</c:forEach>
							</ul>
						</div>	

											
				  </div>
				  	
				  		  					  
				   <div class="col">
				      <p class="p">SPEDIZIONI ATTIVE</p>
						<div class="info">
							<ul>
							<c:forEach items="${listaSpedizioni}" var="singolaSpedizione">
								<li>${singolaSpedizione}</li>
							</c:forEach>
							</ul>
						</div>	

											
				  </div>
				  	
				  		  					  
				   <div class="col">
				      <p class="p">PRENDI IN CARICO</p>
						<div class="richiesta">
							<form  method="post" action="richiestaCorriere">
									  <div class="form-group">
									    <label for="formLuogo"></label>
									    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="es. un1tr4$p0rT" name="richiestaSpedizione">
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
      
       .richiesta {
      	text-align: center; font-family: monospace;   font-size: 16px;
      }

     
	</style>
  
</html>
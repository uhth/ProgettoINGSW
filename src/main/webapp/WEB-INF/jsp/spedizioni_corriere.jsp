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
      <img src="../immagini/b1.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
      UniTransport
    </a>
  </div>
</nav>

<div class="container my-5 text-center" style="max-width: 580px;">
    <img src="../immagini/logoNome.png" alt="" style="width:30%;">
    <p class="lead">SPEDIZIONI ATTIVE DI ${email} </p>
    <button type="button" class="btn btn-primary"><a href="/" class="text-decoration-none" style="color: white;">Home Page</a></button>
	<button type="button" class="btn btn-secondary"><a href="tracking_page" class="text-decoration-none" style="color: white;">Aggiorna stato spedizione</a></button>
</div>



      <div class="container">
        <div class="row">
				   

				  
				   <div class="col text-center">
				      <p class="p">SPEDIZIONI IN CARICO</p>
						<div class="info">
						<br>
							<ol>
							<c:forEach items="${listaSpedizioni}" var="singolaSpedizione">
								<li>
									<form  method="post" action="richiestaTrackingCorriere">
									<input  name="trackingRichiesto" type="submit" value="${singolaSpedizione}"/>
									</form>
								 </li>
								 <br>
							
							</c:forEach>
							</ol>
						</div>	
						<p ><strong>Clicca sulla spedizione che ti interessa per i dettagli del tracking</strong></p>

											
				  </div>
				  	
				  		  				
				  	
				  		  					  
				   <div class="col text-center">
				      <p class="p">Anteprima Stato</p>
							<div class="info">
							<br>
								<ol>
								<c:forEach items="${listaSpedizioniAnteprima}" var="singolaSpedizioneAnteprima">
									<li>
									<input style="text-align: center;" type="text" id="field" size="35" readonly value="${singolaSpedizioneAnteprima} "/> 
									</li>
									<br>
								</c:forEach>
								</ol>
						</div>	
				
						<p ><strong>Nell'anteprima viene mostrata solo la posizione attuale</strong></p>
						

											
				  </div>
				  	
				  	
				  					  		  					  
				   <div class="col text-center">
				      <p class="p">Modifica stato</p>
							<div class="info">
							<br>
								<ol>
							<c:forEach items="${listaSpedizioni}" var="singolaSpedizione">
									<li>
									<form  method="post" action="richiestaTrackingCorriereModifica">
   									 <input  name="modificaCodiceTracking" type="submit" class="btn btn-primary btn-sm" value="${singolaSpedizione}" />
   									 </form>
									</li>
									<br>
								</c:forEach>
								</ol>
						</div>	
						<p ><strong>Per modificare rapidamente una spedizione seleziona quella interessata</strong></p>
				
						

											
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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="js/load.js"></script>
    <script type="text/javascript"> const emails = ${listaUtentiConvertibili}; </script>
    <script type="text/javascript" src="js/rmCorriere.js" defer></script>
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
	<button type="button" class="btn btn-secondary"><a href="tracking_gmaps" class="text-decoration-none" style="color: white;">Traccia un'altra spedizione</a></button>
</div>



      <div class="container">
        <div class="row">			  
		   <div class="col text-center">
		      <p class="p">Rimuovi Corriere</p>
		      
		      <!-- MENU A TENDINA SCELTA UTENTE -->
		      <div class="menu"></div>
									
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
	   	color: blue; border-style: outset; border: 2px solid; border-radius: 15px; border-color: rgba(12, 19, 216, 0.8); text-align: center; font-size: 32px; font-family: Courier, monospace;
	   }
	   
	   .info {
	   	text-align: center; font-family: monospace; border-style: inset;  font-size: 16px;
	   }
	   
	   
	.selLabel {
		  font-size: 24px;
		  font-family: sans-serif;
		  font-weight: 700;
		  color: #444;
		  line-height: 1.3;
		  padding: .6em 1.4em .5em .8em;
	  }   
      
	select {
	  display: block;
	  font-size: 16px;
	  font-family: sans-serif;
	  font-weight: 700;
	  color: #444;
	  line-height: 1.3;
	  padding: .6em 1.4em .5em .8em;
	  width: 100%;
	  max-width: 100%; /* useful when width is set to anything other than 100% */
	  box-sizing: border-box;
	  margin: 0;
	  border: 1px solid #aaa;
	  box-shadow: 0 1px 0 1px rgba(0,0,0,.04);
	  border-radius: .5em;
	  -moz-appearance: none;
	  -webkit-appearance: none;
	  appearance: none;
	  background-color: #fff;
	  background-size: .65em auto, 100%;
}
	
	:root {
  --select-border: #777;
  --select-focus: blue;
  --select-arrow: var(--select-border);
}
     
	</style>
  
</html>
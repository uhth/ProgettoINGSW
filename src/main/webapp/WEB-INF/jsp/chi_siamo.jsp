<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="js/load.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>ZONA UTENTE</title>
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
    <p class="lead">In questa sezione puoi trovare una nostra breve descrizione </p>
    <button type="button" class="btn btn-primary"><a href="/" class="text-decoration-none" style="color: white;">Home Page</a></button>
	<button type="button" class="btn btn-danger"><a href="/" class="text-decoration-none" style="color: white;">Torna Indietro</a></button>
	
</div>



	<div class="container">		  
	    <div class="row">  
			<div class="col">
				<h1 class="p">CHI SIAMO?</h1>
				<h5 align = center>Siamo degli studenti di informatica presso l'università della Calabria.</h5>
				<h5 align = center>Questo sito è la nostra realizzazione del progetto per il corso di Ingegneria del softwer e Web computing</h5>
				<br>
				<br>
				<br>
				<br>
				<br>
				<h5 align = center>A cura di:</h5>
				<h5 align = center>Pierpaolo Lopez</h5>	
				<h5 align = center>Luca Ruffolo</h5>
				<h5 align = center>Vincenzo Rizzo</h5>	
				<h5 align = center>Vittorio Matranga</h5>			
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
			</div>	  				  
      	</div>
 	</div>

  </body>
  
  
      <style>

      .background {
        background-image: url("../gif/chisiamo.gif")  ;
 		background-size: cover;
        background-repeat: no-repeat;
      }
      
      .p{
      	color: rgb(255, 145, 0); border-style: outset; border: 2px solid; border-radius: 15px; border-color: rgba(255, 145, 0, 0.8); text-align: center; font-size: 32px; font-family: Copperplate, Papyrus, fantasy;
      }
      
      .info {
      	text-align: center; font-family: monospace; border-style: inset;  font-size: 16px;
      }

		h5 {
		margin-top: 0;
		margin-bottom: 0.5rem;
		font-weight: 500;
		line-height: 1.2;
		color: orange;
	    }

		.row{
			COLOR: orange;
			text-shadow: -1px 0 #FF0000, 0 1px #FF0000, 1px 0 #FF0000, 0 -1px #FF0000;
		}
     
	</style>
  
</html>
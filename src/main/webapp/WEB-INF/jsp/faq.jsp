<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <meta name="viewport" content="width=device-width, initial-scale=1">

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
    <p class="lead">In questa sezione puoi trovare le risposte alle domande più frequenti </p>
    <button type="button" class="btn btn-primary"><a href="/" class="text-decoration-none" style="color: white;">Home Page</a></button>
	<button type="button" class="btn btn-danger"><a href="/" class="text-decoration-none" style="color: white;">Torna Indietro</a></button>
	
</div>



	<div class="container">		  
	    <div class="row">  
			<div class="col">
				<h1 class="p">Domande frequenti</h1>
				<ul>
					<li>
						<h5>Come faccio a controllare lo stato della mia spedizione (tracking)?</h5>
					</li>
							<ul>
								<li>
									E' fondamentale avere il numero di spedizione. Nel caso in cui tu non ne sia in possesso, devi chiederlo al mittente.
									Nel caso tu sia già in possesso del numero di spedizione basta inserirlo nella sezione "Traccia un pacco".
								</li>
							</ul>
						<br>
					<li>
						<h5>Lo stato della spedizione che trovo è quello più aggiornato?</h5>
							<ul>
								<li>
									Sì, la sezione ricerca spedizione fornisce le informazioni più aggiornate sullo stato della spedizione. Le informazioni sul percorso vengono registrate ogni qualvolta un nostro corriere aggiorna lo stato della spedizione stessa.
								</li>
							</ul>
							<br>
					<li>
						<h5>La mia spedizione non è ancora arrivata. Cosa devo fare?</h5>
							<ul>
								<li>
									E' consigliabile monitorare lo stato della spedizione. Se la spedizione risulta consegnata potete contattare l'assistenza tramite il chatbot per chiedere informazioni.
								</li>
							</ul>
					</li>
						<br>
					<li>
						<h5>Ho ricevuto una spedizione danneggiata/manomessa. Cosa devo fare?</h5>
							<ul>
								<li>
									Nel caso tu abbia selezionato un ritiro assicurato, fornendo delle prove tramite assistenza è possibile procedere ad un rimborso.
								</li>
							</ul>
					</li>
						<br>
					<li>
						<h5>Come faccio a richiedere un ritiro?</h5>
							<ul>
								<li>
									Dalla home page basta essere autenticato/registrato per poter accere alla sezione "Prenota un ritiro".
								</li>
							</ul>
					</li>
				</ul>						
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
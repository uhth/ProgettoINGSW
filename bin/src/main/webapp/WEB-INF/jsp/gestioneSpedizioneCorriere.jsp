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
      <img src="../immagini/b1.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
      UniTransport
    </a>
  </div>
</nav>




<div class="container my-5 text-center" style="max-width: 580px;">
    <img src="../immagini/logoNome.png" alt="" style="width:30%;">
    <p class="lead">Aggiorna lo stato di una spedizione </p>
    <button type="button" class="btn btn-primary"><a href="/" class="text-decoration-none" style="color: white;">Home Page</a></button>
	<button type="button" class="btn btn-success"><a href="profilo_utente" class="text-decoration-none" style="color: white;">Profilo</a></button>
	<button type="button" class="btn btn-secondary"><a href="tracking_page" class="text-decoration-none" style="color: white;">Traccia spedizione</a></button>
</div>



      <div class="container">
        <div class="row">
				    <div class="col">
				      

							      <p style="color: blue; border-style: outset; border-color: lightblue; text-align: center; font-size: 32px; font-family: Copperplate, Papyrus, fantasy;">SPEDIZIONE N.</p>
  										<form  method="post" action="corriereServiceCode">
										  <div class="form-group">
										    <label for="formCodice">Codice</label>
										    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Codice Tracking" name="codice" value="${last_code}">
										  </div>
										  <br>
										  <input  class="btn btn-success" type="submit" value="Cerca" />										  
										</form>


				    </div>
				    <div class="col">
							      <p style="color: blue; border-style: outset; border-color: lightblue; text-align: center; font-size: 32px; font-family: Copperplate, Papyrus, fantasy;">MODIFICHE</p>				      
										<form  method="post" action="corriereService">
										  <div class="form-group">
										    <label for="formLuogo">Località</label>
										    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="es. Roma" name="luogo" value="${luogoAttuale}">
										  </div>
										  <div class="form-group">
										    <label for="formStato">Stato</label>
										    <select multiple class="form-control" id="" name="scelta">
										      <option value="0">SPEDIZIONE CREATA</option>
										      <option value="1">SPEDIZIONE AVVIATA</option>
										      <option value="2">SPEDIZIONE PRONTA PER LA CONSEGNA</option>
										      <option value="3">SEDIZIONE IN CONSEGNA</option>
										      <option value="4">SPEZIONE COMPLETATA</option>
										    </select>
										  </div>
										  <br>
										  <input  class="btn btn-primary" type="submit" value="Aggiorna" />
										</form>


				    </div>
				    
				     <div class="col">
				      

							      <p style="color: blue; border-style: outset; border-color: lightblue; text-align: center; font-size: 32px; font-family: Copperplate, Papyrus, fantasy;">POSIZIONE</p>
  											<img src="http://mt1.google.com/vt/lyrs=m@113&hl=it&x=17509&s=&y=12191&z=15&s=Galile" class="center">



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
     
	</style>
</html>
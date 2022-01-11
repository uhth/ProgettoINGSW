<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <link rel="stylesheet" href="css/effettua_spedizione.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Acquista spedizione</title>
  </head>
  <body>
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
    <p class="lead">In questa sezione puoi scegliere il tipo di spedizione che più si adatta alle tue esigenze </p>
    <button type="button" class="btn btn-primary"><a href="/" class="text-decoration-none" style="color: white;">Home Page</a></button>
	<button type="button" class="btn btn-success"><a href="profilo_utente" class="text-decoration-none" style="color: white;">Profilo</a></button>
	<button type="button" class="btn btn-secondary"><a href="tracking_page" class="text-decoration-none" style="color: white;">Traccia spedizione</a></button>
</div>



      <div class="container">
        <div class="row">
				    <div class="col">
				      

				         <div class="card" style="width: 18rem;">
							  <img src="../immagini/camionUnical.png" class="card-img-top" alt="...">
							  <div class="card-body">
							    <h5 class="card-title">SPEDIZIONE NON TRACCIABILE</h5>
							    <p class="card-text" style="color: black;" style="font-size: 10px;"> Soluzione più economica.</p>
							    <a href="#" class="btn btn-primary">Acquista</a>
							  </div>
						</div>     


				    </div>
				    <div class="col">
				      

				         <div class="card" style="width: 18rem;">
							  <img src="../immagini/camionUnicalTracciabile.png" class="card-img-top" alt="...">
							  <div class="card-body">
							    <h5 class="card-title">SPEDIZIONE TRACCIABILE</h5>
							    <p class="card-text" style="color: black;"> Soluzione per seguire sua spedizione.</p>
							    <a href="#" class="btn btn-primary">Acquista</a>
							  </div>
						</div>     


				    </div>
				    <div class="col">
				      

				         <div class="card" style="width: 18rem;">
							  <img src="../immagini/camionUnicalAssicurato.png" class="card-img-top" alt="...">
							  <div class="card-body">
							    <h5 class="card-title">SPEDIZIONE TRACCIABILE ASSICURATA</h5>
							    <p class="card-text" style="color: black;"> Soluzione per trasporti di valore.</p>
							    <a href="#" class="btn btn-primary">Acquista</a>
							  </div>
						</div>     



				  </div>
      </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

  </body>
</html>
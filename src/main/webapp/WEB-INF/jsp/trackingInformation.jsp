<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Sezione tracking</title>
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
    <p class="lead">In questa sezione puoi scegliere il tipo di spedizione che più si adatta alle tue esigenze </p>
    <button type="button" class="btn btn-primary"><a href="/" class="text-decoration-none" style="color: white;">Home Page</a></button>
	<button type="button" class="btn btn-success"><a href="profilo_utente" class="text-decoration-none" style="color: white;">Profilo</a></button>
	<button type="button" class="btn btn-secondary"><a href="tracking_gmaps" class="text-decoration-none" style="color: white;">Traccia un'altra spedizione</a></button>
</div>



      <div class="container">
        <div class="row">
				   

				    

				    <div class="col">
				      <p style="color: blue; border-style: outset; border-color: lightblue; text-align: center; font-size: 32px; font-family: Copperplate, Papyrus, fantasy;">SPEDIZIONE N.</p>
						
					 <c:if test="${codice != null}">
						<p style="text-align: center; font-family: monospace; border-style: double;">${codice}</p><br>
                    </c:if>

					 <c:if test="${codice == null}">
						<p style="text-align: center; font-family: monospace; border-style: double;">NESSUN CODICE</p><br>
                    </c:if>

				  </div>
				  
				  
				   <div class="col">
				      <p style="color: blue; border-style: outset; border-color: lightblue; text-align: center; font-size: 32px; font-family: Copperplate, Papyrus, fantasy;">STATO</p>
				 	
						<p style="text-align: center; font-family: monospace; border-style: double;  font-size: 16px;">${stato}</p><br>
				 
				  </div>
				  
				   <div class="col">
				      <p style="color: blue; border-style: outset; border-color: lightblue; text-align: center; font-size: 32px; font-family: Copperplate, Papyrus, fantasy;">LOCALIZZAZIONE</p>
						<p style="text-align: center; font-family: monospace; border-style: double;">${luogo}</p><br>
						
						
				  </div>
				  	
				  		  	
				  	
				  	
				  				  
     	 </div>
      </div>
  </div>

<!-- 						<p style="text-align: center;"></p><br>
 -->

  </body>
  
  
      <style>

      .background {
        background-image: url("../immagini/mappa_sfocata.png")  ;
 		background-size: contain;
        background-repeat: no-repeat;
      }

     
	</style>
  
</html>
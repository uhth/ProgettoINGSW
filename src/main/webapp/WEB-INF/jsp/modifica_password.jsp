<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>CAMBIO PASSWORD</title>
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
    <p class="lead">Ricorda di utilizzare una password lunga e sicura </p>
    <button type="button" class="btn btn-primary"><a href="/" class="text-decoration-none" style="color: white;">Home Page</a></button>
	<button type="button" class="btn btn-danger"><a href="profilo_utente" class="text-decoration-none" style="color: white;">Indietro</a></button>
</div>



      <div class="container">
        <div class="row">
				   
			 <div class="col"> </div>

		            <c:if test="${passwordInseritaValida == null}">				  		  					  
						   <div class="col">
						      <p class="p">Inserisci vecchia password</p>
								<div class="richiesta">
									<form  method="post" action="cambioPassword">
											  <div class="form-group">
											    <label for="formPass">Vecchia password:</label>
											    <input type="password" class="form-control" id="exampleFormControlInput1" placeholder="es. 65iZQHTSf6" name="richiediCambioPassword">
										 	 </div>
										  <br>								  										  
									    <input  class="btn btn-success" type="submit" value="CONFERMA"/>
									</form>
								</div>	
		
													
						  </div>
						  	  			
					</c:if>	  	  			
						  	  			
						  	  			
		            <c:if test="${passwordInseritaValida != null}">						  	  					  
						   <div class="col">
						      <p class="p">Inserisci Nuova password</p>
								<div class="richiesta">
									<form  method="post" action="cambioPasswordNuova">
											  <div class="form-group">
											    <label for="formPass"> Nuova password:</label>
											    <input type="password" class="form-control" id="exampleFormControlInput1" placeholder="es. 65iZQHTSf6" name="passwordNuova">
											    <label for="formPass"> Ripeti password:</label>
											    <input type="password" class="form-control" id="exampleFormControlInput1" placeholder="es. 65iZQHTSf6" name="passwordNuovaRipeti">
		
										 	 </div>
										  <br>								  										  
									    <input  class="btn btn-success" type="submit" value="CONFERMA"/>
									</form>
								</div>	
		
													
						  </div>
					</c:if>	  
				  
				  	
				  		
				  		
				   <div class="col"> </div>
				  		
				  		
				  		
				  		  	
				  	
				  	
				  				  
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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/login.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Acquista spedizione</title>
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
    <p class="lead">Scegli, in base al peso, la spedizione tracciabile che si adatta alle tue esigenze. </p>
    <button type="button" class="btn btn-primary"><a href="/" class="text-decoration-none" style="color: white;">Home Page</a></button>
	<button type="button" class="btn btn-success"><a href="profilo_utente" class="text-decoration-none" style="color: white;">Profilo</a></button>
	<button type="button" class="btn btn-secondary"><a href="tracking_gmaps" class="text-decoration-none" style="color: white;">Traccia spedizione</a></button>
	<button type="button" class="btn btn-danger"><a href="spedisci" class="text-decoration-none" style="color: white;">Torna indietro</a></button>
</div>



      <div class="container">
        <div class="row">
				    <div class="col">
				      

				         <div class="card" style="width: 18rem;">
							  <img src="../immagini/camionUnicalTracciabile.png" class="card-img-top" alt="...">
							  <div class="card-body">
							    <h5 class="card-title">FINO A 10Kg</h5>
							    <p class="card-text" style="color: black;">5.99€</p>
			                    <c:if test="${email != null}">
			                	    <!--<a href="prenotaRitiro" class="btn btn-primary">Acquista</a>-->
                            <script>
                              function store(){
                                var costo=5.99;
                                var spedizione="Spedizione tracciabile fino a 10kg.";
                                var img="../immagini/camionUnicalTracciabile.png";
                                sessionStorage.setItem("first",costo);
                                sessionStorage.setItem("second",spedizione);
                                sessionStorage.setItem("third",img);
                                location.href = "payment.jsp";
                              }
                            </script>
                            <a href="prenotaRitiro" class="btn btn-primary" onclick="store()">Acquista</a>
			                    </c:if>
			                    <c:if test="${email == null}">
			                	    <a onclick="document.getElementById('divLogin').style.display='block'" class="btn btn-primary">Accedi e acquista</a>
			                    </c:if>
							  </div>
						</div>     


				    </div>
				    <div class="col">
				      

				         <div class="card" style="width: 18rem;">
							  <img src="../immagini/camionUnicalTracciabile.png" class="card-img-top" alt="...">
							  <div class="card-body">
							    <h5 class="card-title">FINO A 15Kg</h5>
							    <p class="card-text" style="color: black;">7.99€</p>
			                    <c:if test="${email != null}">
                            <script>
                              function store2(){
                                var costo=7.99;
                                var spedizione="Spedizione tracciabile fino a 15kg.";
                                var img="../immagini/camionUnicalTracciabile.png";
                                sessionStorage.setItem("first",costo);
                                sessionStorage.setItem("second",spedizione);
                                sessionStorage.setItem("third",img);
                                location.href = "payment.jsp";
                              }
                            </script>
			                	    <a href="prenotaRitiro" class="btn btn-primary" onclick="store2()">Acquista</a>
			                    </c:if>
			                    <c:if test="${email == null}">
			                	    <a onclick="document.getElementById('divLogin').style.display='block'" class="btn btn-primary">Accedi e acquista</a>
			                    </c:if>
							  </div>
						</div>     


				    </div>
				    <div class="col">
				      

				         <div class="card" style="width: 18rem;">
							  <img src="../immagini/camionUnicalTracciabile.png" class="card-img-top" alt="...">
							  <div class="card-body">
							    <h5 class="card-title">OLTRE 25Kg</h5>
							    <p class="card-text" style="color: black;">15.99€</p>
			                    <c:if test="${email != null}">
                            <script>
                              function store3(){
                                var costo=15.99;
                                var spedizione="Spedizione tracciabile oltre i 25kg.";
                                var img="../immagini/camionUnicalTracciabile.png";
                                sessionStorage.setItem("first",costo);
                                sessionStorage.setItem("second",spedizione);
                                sessionStorage.setItem("third",img);
                                location.href = "payment.jsp";
                              }
                            </script>
			                	    <a href="prenotaRitiro" class="btn btn-primary" onclick="store3()">Acquista</a>
			                    </c:if>
			                    <c:if test="${email == null}">
			                	    <a onclick="document.getElementById('divLogin').style.display='block'" class="btn btn-primary">Accedi e acquista</a>
			                    </c:if>
							  </div>
						</div>     



				  </div>
  		   </div>
      
      </div>
      
   </div>
   
                       <!-- LOGIN -->
                    <div id="divLogin" class="modal">
                        <form class="modal-content animate" action="/loginServiceTracciabile" method="post">
                            <div class="imgcontainer">
                                <span onclick="document.getElementById('divLogin').style.display='none'" class="close"
                                    title="Close Modal">&times;</span>
                                <img src="img/b1.png" alt="Avatar" class="avatar">
                            </div>
                            <div class="container">
                                <label for="uname"><b>Email</b></label>
                                <input type="text" placeholder="Inserisci Email" name="email" required>
                                <label for="psw"><b>Password</b></label>
                                <input type="password" placeholder="Inserisci Password" name="password" required>
                                <button type="submit" id="button">Login</button>
                            </div>
                            <div class="container" style="background-color:#f1f1f1">
                                <button type="button"
                                    onclick="document.getElementById('divLogin').style.display='none'; document.getElementById('divRegister').style.display='block' "
                                    class="cancelbtn">Registrati</button>
                                <span class="psw"><a href="#" id="forgotPassw">Password dimenticata?</a></span>
                            </div>
                        </form>
                    </div>
                    <!-- FINE LOGIN -->
                    <!-- REGISTER -->
                    <div id="divRegister" class="modal">
                        <form class="modal-content animate" action="/iscrizioneServiceTracciabile" method="post">
                            <div class="imgcontainer">
                                <span onclick="document.getElementById('divRegister').style.display='none'"
                                    class="close" title="Close Modal">&times;</span>
                                <img src="img/b1.png" alt="Avatar" class="avatar">
                            </div>
                            <div class="container">
                                <label for="email"><b>Email</b></label>
                                <input type="email" placeholder="Inserisci Email" name="email" required>
                                <label for="password"><b>Password</b></label>
                                <input type="password" placeholder="Inserisci Password" name="password" required>
                                <label for="password_ripetuta"><b>Conferma Password</b></label>
                                <input type="password" placeholder="Inserisci Password" name="password_ripetuta"
                                    required>
                                <button type="submit" id="button">Registrati</button>
                            </div>
                            <div class="container" style="background-color:#f1f1f1">
                                <button type="button"
                                    onclick="document.getElementById('divRegister').style.display='none'; document.getElementById('divLogin').style.display='block';"
                                    class="cancelbtn">Login</button>
                            </div>
                        </form>
                    </div>
                    <!-- FINE REGISTER -->
   
   
   
   <script src="js/login.js"></script>

  </body>
  
        <style>

      .background {
        background-image: url("../immagini/mappa_sfocata.png")  ;
 		background-size: contain;
        background-repeat: no-repeat;
      }

     
	</style>
  
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en" dir="ltr">

    <head>
      <meta charset="utf-8">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
      <link rel="icon" href="../immagini/b1.png">
      <link rel="stylesheet" href="css/profilo_utente.css">
      <script src="https://kit.fontawesome.com/eb3e5ce09e.js" crossorigin="anonymous"></script>
      <title>UniTransport</title>
    </head>

    <body>

      <header class="showcase">
        <div class="showcase-top">
          <img src="/immagini/b1.png" alt="">


          <c:if test="${email == null}">
            <p class="intro_benvenuto">Benvenuto utente</p>
            <a href="login" id="prova" onclick="btnAccedi()" class="btn btn-rounded">Accedi</a>

          </c:if>

          <c:if test="${email != null}">
            <p class="intro_benvenuto">Benvenuto ${email}</p>
            <a href="/" id="home" onclick="btnAccedi()" class="btn btn-rounded">HomePage</a>
            <a href="logout" id="prova" onclick="btnAccedi()" class="btn btn-rounded">Logout</a>
          </c:if>

        </div>


        <c:if test="${email == null}">
          <div class="showcase-content">
            <h1>Non dovresti essere qui!</h1>
            <p>Devi prima autenticarti.</p>
            <a href="login" class="btn btn-xl">
              Autenticati <i class="fas fa-chevron-right btn-icon"></i>
            </a>
            <br>
          </div>
        </c:if>

        <c:if test="${email != null}">
          <div class="showcase-content">

            <!-- Zona menù -->

                  	<nav class=”barra_navigazione”>
					  <ul class="menu">
					    <li><a href="/" class="active">Profilo<span class="fa fa-angle-down"></span></a>
					      <ul class="submenu">
					        <li><a href="/">Visualizza informazioni </a>
					        </li>
					        <li><a href="/">Cambia informazioni<span class="fa fa-angle-down"></span></a>
					          <ul class="submenu">
					        <li><a href="/">Cambia email</a></li>
					        <li><a href="/">Cambia password</a></li>
					      </ul>
					        </li>
					      </ul>
					    </li>
					    <li><a href="/">Visualizza spedizioni</a></li>
					    <li><a href="/">Modifica spedizioni</a></li>
					  </ul>
					</nav>

            	<div class="d-flex align-items-start">
					  <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
					    <button class="nav-link active" id="v-pills-home-tab" data-bs-toggle="pill" data-bs-target="#v-pills-home" type="button" role="tab" aria-controls="v-pills-home" aria-selected="true">PROFILO</button>
					    <button class="nav-link" id="v-pills-messages-tab" data-bs-toggle="pill" data-bs-target="#v-pills-messages" type="button" role="tab" aria-controls="v-pills-messages" aria-selected="false">MODIFICA PROFILO</button>
					    <button class="nav-link" id="v-pills-settings-tab" data-bs-toggle="pill" data-bs-target="#v-pills-settings" type="button" role="tab" aria-controls="v-pills-settings" aria-selected="false">VISUALIZZA SPEDIZIONI</button>
					  </div>
					  <div class="tab-content" id="v-pills-tabContent">
					    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">...</div>
					    <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">...</div>
					    <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">...</div>
					    <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab">...</div>
					  </div>
					</div>


		<section class="tabs">
            <div class="barra">
              <ul>
           	<div id="tab-1" class="tab-item tab-border">
                <li>Profilo</li>
			</div>
		  	<div id="tab-2" class="tab-item tab-border">
	            <li>Modifica email</li>
	        </div>
		  	<div id="tab-3" class="tab-item tab-border">
	            <li>Modifica password</li>
	        </div>
		  	<div id="tab-4" class="tab-item tab-border">
                <li>Visualizza spedizioni</li>
	        </div>
              </ul>
            </div>
		</section>
		
		<section class="tab-content">
            <div id="tab-1-content" class="tab-content-item">
			    <p class="textllg">Profilo</p>
			</div>
            <div id="tab-2-content" class="tab-content-item">
			    <p class="textllg">Modifica la tua email</p>
			</div>
            <div id="tab-3-content" class="tab-content-item">
			    <p class="textllg">Modifica la tua password</p>
			</div>
            <div id="tab-4-content" class="tab-content-item">
			    <p class="textllg">Visualizza le spedizioni attive </p>
			</div>			
		</section>

            <!-- Fine zona menu -->




          </div>
        </c:if>



      </header>


      <script src="js/profilo_page.js"></script>
    </body>

    </html>
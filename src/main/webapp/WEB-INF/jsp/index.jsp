<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en" dir="ltr">

        <head>
			<link href="https://chatcompose.azureedge.net/static/all/global/export/css/main.5b1bd1fd.css" rel="stylesheet">    <script async type="text/javascript" src="https://chatcompose.azureedge.net/static/all/global/export/js/main.a7059cb5.js?user=UnicalTransport&lang=IT" user="UnicalTransport" lang="IT"></script>  
			<!--<link href="https://chatcompose.azureedge.net/static/all/global/export/css/main.5b1bd1fd.css" rel="stylesheet">    <script async type="text/javascript" src="https://chatcompose.azureedge.net/static/all/global/export/js/main.a7059cb5.js?user=UnicalTransport&lang=IT" user="UnicalTransport" lang="IT"></script>-->
            <meta charset="utf-8">
            <link rel="icon" href="../immagini/b1.png">
            <link rel="stylesheet" href="css/index.css">
            <link rel="stylesheet" href="css/login.css">
            <script src="https://kit.fontawesome.com/eb3e5ce09e.js" crossorigin="anonymous"></script>
            <title>UniTransport</title>
        </head>

        <body>

            <header class="showcase">
                <div class="showcase-top">
                    <a id="posLogo" href="/"><img id="posLogo" src="/immagini/b1.png"></a>

                    
					<c:if test="${email == null}">
                        <p class="intro_benvenuto">Benvenuto utente</p>
                        <a id="prova" onclick="document.getElementById('divLogin').style.display='block'" class="btn btn-rounded" >Accedi <i class="fas fa-sign-in-alt"></i></a>
                    </c:if>

                    <c:if test="${email != null}">
		                        <p class="intro_benvenuto">Benvenuto ${email}</p>
              		      <c:if test="${role == 'user'}">

		                        <a href="profilo_utente" id="profilo_utente" onclick="btnAccedi()"
		                            class="btn btn-rounded">Profilo utente <i class="far fa-user"></i></a>
	                       </c:if>
              		      <c:if test="${role == 'corriere'}">

                    		    <a id="corriereZone" href="areaCorriere"
                            class="btn btn-rounded">Area Corriere <i class="fas fa-people-carry"></i></a>
	                       </c:if>
              		      <c:if test="${role == 'admin'}">

		                        <a href="profiloAmministratore" id="adminZone" onclick="btnAccedi()"
		                            class="btn btn-rounded">Amministratore  <i class="fas fa-user-lock"></i></a>	                      
                             </c:if>
	                       	                       		                            
		                        <a href="logout" id="prova" onclick="btnAccedi()" class="btn btn-rounded">Logout <i class="fas fa-sign-out-alt"></i></a>
                    </c:if>
                </div>

                <div class="showcase-content">

                           <c:choose>
				            <c:when test="${role == 'corriere'}">
				                 <h1>Il lavoro che hai sempre desiderato.<br>Reso più semplice.</h1>
				                    <p>Assistenza h24</p>
				                    <a href="aggiornaStato" class="btn btn-xl">
				                       Aggiorna stato spedizione <i class="fas fa-sync"></i>
				                    </a>
				                    <br>
				                    <a href="spedizioniCorriere" class="btn btn-xl">
				                        Visualizza spedizioni <i class="fas fa-history"></i>
				                    </a><br>
				                    <a id="tutorial1" href="tutorial" class="btn btn-xl">
				                       Tutorial <i class="fas fa-graduation-cap"></i>
				                    </a>				                    
				                <br />
								<br><br>
				            </c:when>    
				            <c:when test="${role == 'admin'}">
				                 <h1>Pannello Amministratore<br></h1>
				                    <a href="aggiungiCorriere" class="btn btn-xl">
				                        Aggiungi corriere <i class="fas fa-user-plus"></i>
				                    </a>                            	
				                    <br>
				                    <a href="rimuoviCorriere" class="btn btn-xl">
				                        Rimuovi corriere <i class="fas fa-user-slash"></i>
				                    </a>
				                    <br>
				                <br />
				            </c:when>    	
				            <c:when test="${email != null}">
				                 <h1>Consegne Al Miglior Prezzo.<br>Nazionali e Internazionali.</h1>
				                    <p>Paga direttamente alla consegna.</p>
				                    <a href="spedisci" class="btn btn-xl">
				                        Effettua una spedizione <i class="fas fa-truck"></i>
				                    </a>
				                    <br>
				                    <a href="tracking_gmaps" class="btn btn-xl">
				                        Traccia una spedizione <i class="fas fa-map-marker-alt"></i>
				                    </a><br>
				                    <a id="tutorial2" href="tutorial" class="btn btn-xl">
				                       Tutorial <i class="fas fa-graduation-cap"></i>
				                    </a>
				                    <br>				                    
				                    <br><br>
				            </c:when>    				            			           
				             <c:otherwise>
				                 <h1>Consegne Al Miglior Prezzo.<br>Nazionali e Internazionali.</h1>
				                    <p>Paga direttamente alla consegna.</p>
				                    <a href="spedisci" class="btn btn-xl">
				                        Effettua una spedizione <i class="fas fa-truck"></i>
				                    </a>
				                    <br>
				                    <a href="tracking_gmaps" class="btn btn-xl">
				                        Traccia una spedizione <i class="fas fa-map-pin"></i>
				                    </a><br>
				                    <a id="tutorial3" href="tutorial" class="btn btn-xl">
				                       Tutorial <i class="fas fa-graduation-cap"></i>
				                    </a>
				                    <br>
				                    <br><br>
				            </c:otherwise>
				        </c:choose>
                   
                   <!-- add Corriere -->
                   <div id="divRegisterCorr" class="modal">
                        <form class="modal-content animate" action="/iscrizioneCorriereService" method="post">
                            <div class="imgcontainer">
                                <span onclick="document.getElementById('divRegisterCorr').style.display='none'"
                                    class="close" title="Close Modal">&times;</span>
                                <img src="img/b1.png" alt="Avatar" class="avatar">
                            </div>
                            <div class="container">
                                <label for="email"><b>Email corriere</b></label>
                                <input type="email" placeholder="Inserisci Email" name="email" required>
                                <label for="password"><b>Password</b></label>
                                <input type="password" placeholder="Inserisci Password" name="password" required>
                                <label for="password_ripetuta"><b>Conferma Password</b></label>
                                <input type="password" placeholder="Inserisci Password" name="password_ripetuta"
                                    required>
                                <button type="submit" id="button">Registra</button>
                            </div>
                        </form>
                    </div>
                   

                    <!-- LOGIN -->
                    <div id="divLogin" class="modal">
                        <form class="modal-content animate" action="/loginService" method="post">
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
                            </div>
                        </form>
                    </div>
                    <!-- FINE LOGIN -->
                    <!-- REGISTER -->
                    <div id="divRegister" class="modal">
                        <form class="modal-content animate" action="/iscrizioneService" method="post">
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
                </div>
            </header>
            
            
            
            
            
            
            
            			            <section class="tabs">
						                <div class="container">
						                    <div id="tab-1" class="tab-item tab-border">
						                        <i class="fas fa-tags fa-3x">
						                            <p class="hide-sm  fa-1x">Confronta prezzi</p>
						                        </i>
						                    </div>
						                    <div id="tab-2" class="tab-item">
						                        <i class="fas fa-truck-loading fa-3x">
						                            <p class="hide-sm fa-1x">Modifica spedizione</p>
						                        </i>
						                    </div>
						                    <div id="tab-3" class="tab-item">
						                        <i class="fas fa-search-location fa-3x">
						                            <p class="hide-sm fa-1x">Rintraccia pacco</p>
						                        </i>
						                    </div>
						                </div>
						            </section>
						
						            <section class="tab-content">
						                <div class="container">
						                    <!-- Contenuto Tab 1 -->
						
						                    <div id="tab-1-content" class="tab-content-item">
						                        <div class="text-center">
						                            <p class="textllg">Valuta il tipo di servizio che cerchi e procedi</p>
						                            <c:if test="${ email == null || role == 'user' }">
						                            	<a href="spedisci" class="btn btn-lg">Effettua una spedizione</a>
						                            </c:if>
						                        </div>
						
						                        <table class="table">
						                            <thead>
						                                <tr>
						                                    <th></th>
						                                    <th>TRACCIABILE</th>
						                                    <th>TRACCIABILE EXPRESS</th>
						                                    <th>TRACCIABILE ASSICURATA</th>
						                                </tr>
						                            </thead>
						                            <tbody>
						                                <tr>
						                                    <td>Fino a 10Kg</td>
						                                    <td>5.99€</td>
						                                    <td>9.99€</td>
						                                    <td>15.99€</td>
						                                </tr>
						                                <tr>
						                                    <td>Fino a 15Kg</td>
						                                    <td>7.99€</td>
						                                    <td>11.99€</td>
						                                    <td>17.99€</td>
						                                </tr>
						                                <tr>
						                                    <td>Fino a 25Kg</td>
						                                    <td>9.99€</td>
						                                    <td>12.99€</td>
						                                    <td>19.99€</td>
						                                </tr>
						                                <tr>
						                                    <td>Oltre 20Kg</td>
						                                    <td>15.99€</td>
						                                    <td>19.99€</td>
						                                    <td>26.99€</td>
						                                </tr>
						                                <tr>
						                                    <td>Assistenza</td>
						                                    <td><i class="fas fa-check"></i></td>
						                                    <td><i class="fas fa-check"></i></td>
						                                    <td><i class="fas fa-check"></i></td>
						                                </tr>
						                                <tr>
						                                    <td>Tracciamento pacco</td>
						                                    <td><i class="fas fa-check"></i></td>
						                                    <td><i class="fas fa-check"></i></td>
						                                    <td><i class="fas fa-check"></i></td>
						                                </tr>
						                                <tr>
						                                    <td>Modifica dati spedizione gratuita</td>
						                                    <td><i class="fas fa-check"></i></td>
						                                    <td><i class="fas fa-check"></i></td>
						                                    <td><i class="fas fa-check"></i></td>
						                                </tr>
						                                <tr>
						                                    <td>Rimborso smarrimento</td>
						                                    <td><i class="fas fa-times"></i></td>
						                                    <td><i class="fas fa-times"></i></td>
						                                    <td><i class="fas fa-check"></i></td>
						                                </tr>
						                            </tbody>
						                        </table>
						                    </div>
						
						                    <div id="tab-2-content" class="tab-content-item">
						                    	<c:choose> 
						                            	<c:when test="${email == null}">
						                            		<div class="text-center">
						                            			<p class="textllg">Se vuoi modificare una spedizione come cliente passa alla sezione</p>
						                            			<a onclick="document.getElementById('divLogin').style.display='block'" class="btn btn-lg" >Effettua una modifica</a><br><br>
						                            		</div>
						                            		<div class="text-center">
						                            			<p class="textllg">Se vuoi modificare lo stato di una spedizione come corriere passa alla sezione</p>
                							       				 <a onclick="document.getElementById('divLogin').style.display='block'" class="btn btn-lg" >Aggiorna stato</a>
						                        			</div>
						                            	</c:when>
					                        			<c:when test="${role == 'corriere'}">
						                            		<div class="text-center">
						                            			<p class="textllg">Se vuoi modificare lo stato di una spedizione </p>
                							       				 <a href="/gestioneSpedizioneCorriere" class="btn btn-lg" >Aggiorna stato</a>
						                        			</div>
					                        			</c:when>
					                        			<c:when test="${role == 'user'}">
						                            		<div class="text-center">
						                            			<p class="textllg">Se vuoi modificare lo stato di un ritiro </p>
                							       				 <a href="/gestisciRitiro" class="btn btn-lg" >Effettua una modifica</a>
						                        			</div>
					                        			</c:when>
						                            </c:choose>	
											
						                    </div>
						
						                    <div id="tab-3-content" class="tab-content-item">
						                        <div class="text-center">
						                            <p class="textllg">Esegui la ricerca manuale della spedizione</p>
						                            <a href="tracking_gmaps" class="btn btn-lg">Cerca tramite codice</a>
						
						                            <c:if test="${email == null}">
						                                <br><br><br>
						                                <p class="textllg">OPPURE</p><br><br>
						                                <p class="textllg">Esegui la ricerca da profilo utente</p>
						                                <a id="prova" onclick="document.getElementById('divLogin').style.display='block'"
						                                    class="btn btn-lg">Accedi</a>
						                            </c:if>
						                        </div>
						
						                    </div>
						
						                </div>
						            </section>          
            
            
            
            
            
            
            
            
            


            <footer class="footer">
                <div class="footer-cols">
                    <ul>
                        <li><a href="faq">FAQ</a></li>
                    </ul>
                    <ul>
                        <li><a href="tutorial">Tutorial</a></li>
                    </ul>                    
                    <ul>
                        <li><a href="chi_siamo">Chi siamo</a></li>
                    </ul>
                    <ul>
                        <li><a href="http://www.unical.it">Sito Unical</a></li>
                    </ul>
                </div>
            </footer>
            <script src="js/main.js"></script>
            <script src="js/login.js"></script>
        </body>

        </html>
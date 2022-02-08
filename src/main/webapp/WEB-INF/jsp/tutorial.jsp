<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en" dir="ltr">

        <head>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
			<link href="https://chatcompose.azureedge.net/static/all/global/export/css/main.5b1bd1fd.css" rel="stylesheet">    <script async type="text/javascript" src="https://chatcompose.azureedge.net/static/all/global/export/js/main.a7059cb5.js?user=UnicalTransport&lang=IT" user="UnicalTransport" lang="IT"></script>  
			<!--<link href="https://chatcompose.azureedge.net/static/all/global/export/css/main.5b1bd1fd.css" rel="stylesheet">    <script async type="text/javascript" src="https://chatcompose.azureedge.net/static/all/global/export/js/main.a7059cb5.js?user=UnicalTransport&lang=IT" user="UnicalTransport" lang="IT"></script>-->
            <meta charset="utf-8">
            <link rel="icon" href="../immagini/b1.png">
            <link rel="stylesheet" href="css/tutorial.css">
            <link rel="stylesheet" href="css/login.css">
            <script src="js/menu.js"></script>
            <title>UniTransport</title>
        </head>

        <body>

            <header class="showcase">
                <div class="showcase-top">
                    <a id="posLogo" href="/"><img id="posLogo" src="/immagini/b1.png"></a>
                    
					<c:if test="${email == null}">
                        <p class="intro_benvenuto">Benvenuto utente</p>                  
                    </c:if>
                    <c:if test="${email != null}">
		            	<p class="intro_benvenuto">Benvenuto ${email}</p>           
                    </c:if>
                    
                    
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
                    
                </div>

                <div class="showcase-content">

                       <c:choose>
				            <c:when test="${role == 'corriere'}">
                             <h1>Hai dubbi su come effettuare qualche operazione?</h1>
                            <p>Nessun problema, grazie ai nostri tutorial tutto sarà più chiaro! </p>
                            
                                <a href="/" class="btn btn-xl">
                                        Home Page <i class="fas fa-laptop-house"></i>
                                </a>
                                <br>
                                <a href="https://www.youtube.com/playlist?list=PLxoUfL2w8MJ_DXEtPg7f7mElUGaGcN_ul" class="btn btn-xl">
                                        PlayList Tutorial <i class="fab fa-youtube"></i>
                                </a><br><br>

				            </c:when> 		           
				             <c:otherwise>
                             <h1>Hai dubbi su come effettuare qualche operazione?</h1>
                            <p>Nessun problema, grazie ai nostri tutorial tutto sarà più chiaro! </p>
                            <p id="tutorialCorriere" style="font-size: 18px;">Se necessiti di una guida per corrieri accedi come corriere o consulta la playlist youtube. </p><br>
                            
                                <a href="/" class="btn btn-xl">
                                        Home Page <i class="fas fa-laptop-house"></i>
                                </a>
                                <br>
                                <a href="https://www.youtube.com/playlist?list=PLxoUfL2w8MJ_DXEtPg7f7mElUGaGcN_ul" class="btn btn-xl">
                                        PlayList Tutorial <i class="fab fa-youtube"></i>
                                </a><br><br>
				            </c:otherwise>
				        </c:choose>

                   </div>
           
                    
                   
                  
                </div>
            </header>
            
            
            
            
            
            
            

                        <c:choose>
				            <c:when test="${role == 'corriere'}">

					            <section class="tabs">
					                <div class="container">
					                    <div id="tab-1" class="tab-item tab-border">
					                        <i class="fas fa-people-carry fa-2x">
					                            <p class="hide-sm fa-1x">Prendi in carico spedizione</p>
					                        </i>
					                    </div>
					                    
					                                                            
					                    <div id="tab-2" class="tab-item">
					                        <i class="fas fa-retweet fa-2x">
					                            <p class="hide-sm fa-1x">Aggiorna stato spedizione</p>
					                        </i>
					                    </div>
					                    
					                    
					                    <div id="tab-3" class="tab-item">
					                        <i class="fas fa-search-location fa-2x">
					                            <p class="hide-sm fa-1x">Effettua tracciamento</p>
					                        </i>
					                    </div>	
					                    
					                                                                
					                </div>
					            </section>
					
					            <section class="tab-content">
					                <div class="container">
					                    
					                    <div id="tab-1-content" class="tab-content-item">
					                              <iframe width="1000" height="520" src="https://www.youtube.com/embed/Sfkjs8Evtg0" title="YouTube video player" frameborder="2" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
					                    </div>
					    
					                    <div id="tab-2-content" class="tab-content-item">
					                              <iframe width="1000" height="520" src="https://www.youtube.com/embed/9jHQhW3Fgso" title="YouTube video player" frameborder="2" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
					                    </div>						                    						                    					
					                </div>      
					                    <div id="tab-3-content" class="tab-content-item">
					                            <iframe width="1000" height="520" src="https://www.youtube.com/embed/EzMuosdvHUU" title="YouTube video player" frameborder="2" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
					                    </div>	
					
					
					            </section>  
					
					
									            </c:when> 		           
									             <c:otherwise>
					            <section class="tabs">
					                <div class="container">
					                    <div id="tab-1" class="tab-item tab-border">
					                        <i class="fas fa-tags fa-2x">
					                            <p class="hide-sm  fa-1x">Acquisto spedizione</p>
					                        </i>
					                    </div>
					                    
					                    <div id="tab-2" class="tab-item">
					                        <i class="fas fa-backspace fa-2x">
					                            <p class="hide-sm fa-1x">Annulla spedizione</p>
					                        </i>
					                    </div>
					                    <div id="tab-3" class="tab-item">
					                        <i class="fas fa-dolly fa-2x">
					                            <p class="hide-sm fa-1x">Modifica luogo ritiro/consegna</p>
					                        </i>
					                    </div>
					                                                 
					                </div>
					            </section>
					
					            <section class="tab-content">
					                <div class="container">
					                    <!-- Contenuto Tab 1 -->
					
					                    <div id="tab-1-content" class="tab-content-item">
					                        <iframe width="1000" height="520" src="https://www.youtube.com/embed/mv7SOnelVkw" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>						                        
					
					                    </div>
					
					                    <div id="tab-2-content" class="tab-content-item">
					                             <iframe width="1000" height="520" src="https://www.youtube.com/embed/RjpevSjjK6U" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
					
					                    </div>
					
					                    <div id="tab-3-content" class="tab-content-item">
					                            <iframe width="1000" height="520" src="https://www.youtube.com/embed/Z5szmVsV9Qk" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
					                        
					
					
					                    </div>
					            </section>       
				            </c:otherwise>
				        </c:choose>


            
            
            
            
            
            
            
            


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
            <script src="js/tutorial.js"></script>
        </body>

        </html>
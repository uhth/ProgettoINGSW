<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en" dir="ltr">

        <head>
            <meta charset="utf-8">
            <link rel="icon" href="../immagini/b1.png">
            <link rel="stylesheet" href="css/style.css">
            <script src="https://kit.fontawesome.com/eb3e5ce09e.js" crossorigin="anonymous"></script>
            <title>UniTransport</title>
        </head>

        <body>

            <header class="showcase">
                <div class="showcase-top">
                    <img src="/immagini/b1.png" alt="">


                    <c:if test="${username == null}">
                        <p class="intro_benvenuto">Benvenuto utente</p>
                        <a href="login" id="prova" onclick="btnAccedi()" class="btn btn-rounded">Accedi</a>
                    </c:if>

                    <c:if test="${username != null}">
                        <p class="intro_benvenuto">Benvenuto ${username}</p>
                        <a href="logout" id="prova" onclick="btnAccedi()" class="btn btn-rounded">Logout</a>
                    </c:if>




                </div>
                <div class="showcase-content">
                    <h1>Consegne Al Miglior Prezzo.<br>Nazionali e Internazionali.</h1>
                    <p>Paga direttamente alla consegna.</p>
                    <a href="#" class="btn btn-xl">
                        Effettua una spedizione <i class="fas fa-chevron-right btn-icon"></i>
                    </a>
                    <br>
                    <a href="#" class="btn btn-xl">
                        Traccia una spedizione <i class="fas fa-chevron-right btn-icon"></i>
                    </a>
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
                            <a href="" class="btn btn-lg">Effettua una spedizione</a>
                        </div>

                        <table class="table">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th>NON TRACCIABILE</th>
                                    <th>TRACCIABILE</th>
                                    <th>TRACCIABILE ASSICURATA</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Fino a 10Kg</td>
                                    <td>5.99€</td>
                                    <td>9.99€</td>
                                    <td>15.99€ + 2% Valore Assicurato</td>
                                </tr>
                                <tr>
                                    <td>Fino a 15Kg</td>
                                    <td>7.99€</td>
                                    <td>11.99€</td>
                                    <td>17.99€ + 2% Valore Assicurato</td>
                                </tr>
                                <tr>
                                    <td>Fino a 25Kg</td>
                                    <td>9.99€</td>
                                    <td>12.99€</td>
                                    <td>19.99€ + 2% Valore Assicurato</td>
                                </tr>
                                <tr>
                                    <td>Oltre 20Kg</td>
                                    <td>15.99€</td>
                                    <td>19.99€</td>
                                    <td>26.99€ + 2% Valore Assicurato</td>
                                </tr>
                                <tr>
                                    <td>Assistenza</td>
                                    <td><i class="fas fa-check"></i></td>
                                    <td><i class="fas fa-check"></i></td>
                                    <td><i class="fas fa-check"></i></td>
                                </tr>
                                <tr>
                                    <td>Tracciamento pacco</td>
                                    <td><i class="fas fa-times"></i></td>
                                    <td><i class="fas fa-check"></i></td>
                                    <td><i class="fas fa-check"></i></td>
                                </tr>
                                <tr>
                                    <td>Modifica dati spedizione gratuita</td>
                                    <td><i class="fas fa-times"></i></td>
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
                        <div class="text-center">
                            <p class="textllg">Valuta il tipo di servizio che cerchi e procedi</p>
                            <a href="" class="btn btn-lg">Effettua una spedizione</a>
                        </div>

                        <table class="table">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th>NON TRACCIABILE</th>
                                    <th>TRACCIABILE</th>
                                    <th>TRACCIABILE ASSICURATA</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Fino a 10Kg</td>
                                    <td>5.99€</td>
                                    <td>9.99€</td>
                                    <td>15.99€ + 2% Valore Assicurato</td>
                                </tr>
                                <tr>
                                    <td>Fino a 15Kg</td>
                                    <td>7.99€</td>
                                    <td>11.99€</td>
                                    <td>17.99€ + 2% Valore Assicurato</td>
                                </tr>
                                <tr>
                                    <td>Fino a 25Kg</td>
                                    <td>9.99€</td>
                                    <td>12.99€</td>
                                    <td>19.99€ + 2% Valore Assicurato</td>
                                </tr>
                                <tr>
                                    <td>Oltre 20Kg</td>
                                    <td>15.99€</td>
                                    <td>19.99€</td>
                                    <td>26.99€ + 2% Valore Assicurato</td>
                                </tr>

                            </tbody>
                        </table>
                    </div>

                </div>
            </section>

            <footer class="footer">
                <p>Problemi? Contatta l'assistenza</p>
                <div class="footer-cols">
                    <ul>
                        <li><a href="">FAQ</a></li>
                        <li><a href="">Burocrazia</a></li>
                    </ul>
                    <ul>
                        <li><a href="">Lavora con noi</a></li>
                        <li><a href="">Chi siamo</a></li>
                    </ul>
                    <ul>
                        <li><a href="">Sito Unical</a></li>
                        <li><a href="">Dove siamo</a></li>
                    </ul>
                    <ul>
                        <li><a href="">Account</a></li>
                        <li><a href="">Privacy</a></li>
                    </ul>
                </div>
            </footer>
            <script src="js/main.js"></script>
        </body>

        </html>
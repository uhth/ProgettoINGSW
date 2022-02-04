<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <link rel="stylesheet" href="css/iscrizione_page.css">
    <script src="js/iscrizione.js"></script>

    <title>Iscriviti</title>
</head>

<body>
    <img src="/immagini/b1.png" alt="" class="img_logo">
    <a href="/" id="btn1" class="btn btn-rounded">Home Page</a>

    <div class="iscrizioneForm">
        <img src="/immagini/avatarPrimary.png" class="avatar">
        <h1>Effettua l'iscrizione</h1>
        <div id="errorMessage"></div>


        <form method="post" action="iscrizioneService" id="form" onSubmit="return validate();">          


            <div class="form-group">
                <label for="email">Email:</label>
                <input type="text" class="form-control" name="email" id="mail" placeholder="Inserisci mail" />
            </div>

            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" name="password" id="pass"
                    placeholder="Inserisci mail" />
            </div>

            <div class="form-group">
                <label for="password">Conferma password:</label>
                <input type="password" class="form-control" name="password_ripetuta" id="passConf"
                    placeholder="Inserisci mail" />
            </div>

            <button type="submit" class="btn btn-success">Iscriviti </button>

        </form>




    </div>

    </div>


</body>

</html>


<!--     <div class="iscrizioneForm">
        <img src="/immagini/avatarPrimary.png" class="avatar">
        <h1>Effettua l'iscrizione</h1>
        <form method="post" action="iscrizioneService" id="formIscrizione">
            <p>Username:</p>
            <input type="text" name="username_new" id="username_new" placeholder="Inserisci nome utente"/>
            <p>E-mail:</p>
            <input type="text" name="email_new" id="email_new" placeholder="Inserisci mail"/>
            <p>Password:</p>
            <input type="password" name="pass_new" id="pass_new" placeholder="Inserisci password"/>
            <p>Ripeti password:</p>
            <input type="password" name="passRipetuta_new" id="passRipetuta_new" placeholder="Inserisci password"/>

            <input type="submit" value="Iscriviti" />
            <br><br>
            <a href="login" id="a_iscriviti">Hai gi� un account? Entra</a>

        </form>
    </div> 
    
    
    
    
    
    
    
            <form method="post" action="iscrizioneService" name="formIscrizione">
            <p>Username:</p>
            <input type="text" name="username_new" placeholder="Inserisci nome utente"/>
            <p>E-mail:</p>
            <input type="text" name="email_new" placeholder="Inserisci mail"/>
            <p>Password:</p>
            <input type="password" name="pass_new" placeholder="Inserisci password"/>
            <p>Ripeti password:</p>
            <input type="password" name="passRipetuta_new" placeholder="Inserisci password"/>

            <input type="submit" value="Iscriviti" />
            <br><br>
            <a href="login" id="a_iscriviti">Hai gi� un account? Entra</a>

        </form>
    
    
    -->



<!-- 
     tutto
    
    
    
    
    
    
    
    
    
    
    
    
    
    <!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <link rel="stylesheet" href="css/iscrizione_page.css">
    <script src="js/iscrizione.js"></script>
    
    <title>Iscriviti</title>
</head>

<body>
    <img src="/immagini/b1.png" alt="" class="img_logo">
    <a href="/" id="btn1" class="btn btn-rounded">Home Page</a>

    <div class="iscrizioneForm">
        <img src="/immagini/avatarPrimary.png" class="avatar">
        <h1>Effettua l'iscrizione</h1>
        <form method="post" action="iscrizioneService" id="formIscrizione" onSubmit="return validate();">
            <p>Username:</p>
            <input type="text" name="username_new" id="username_new" placeholder="Inserisci nome utente"/>
            <p>E-mail:</p>
            <input type="text" name="email_new" id="email_new" placeholder="Inserisci mail"/>
            <p>Password:</p>
            <input type="password" name="pass_new" id="pass_new" placeholder="Inserisci password"/>
            <p>Ripeti password:</p>
            <input type="password" name="passRipetuta_new" id="passRipetuta_new" placeholder="Inserisci password"/>

            <input type="submit" value="Iscriviti" />
            <br><br>
            <a href="login" id="a_iscriviti">Hai gi� un account? Entra</a>

        </form>
    </div> 
    
    </div>


</body>

</html>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     -->
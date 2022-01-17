<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <link rel="stylesheet" href="css/iscrizione_page.css">
    <title>Iscriviti</title>
</head>

<body>
    <img src="/immagini/b1.png" alt="" class="img_logo">
    <a href="/" id="btn1" class="btn btn-rounded">Home Page</a>

    <div class="iscrizioneForm">
        <img src="/immagini/avatarPrimary.png" class="avatar">
        <h1>Effettua l'iscrizione</h1>
        <form method="post" action="iscrizioneService">
            <p>Username:</p>
            <p>E-mail:</p>
            <input type="text" name="email" placeholder="Inserisci mail"/>
            <p>Password:</p>
            <input type="password" name="password" placeholder="Inserisci password"/>
            <p>Ripeti password:</p>
            <input type="password" name="password_ripetuta" placeholder="Inserisci password"/>

            <input type="submit" value="Iscriviti" />
            <br><br>
            <a href="login" id="a_iscriviti">Hai gi� un account? Entra</a>

        </form>
    </div>



    <script src="js/main.js"></script>
</body>

</html>


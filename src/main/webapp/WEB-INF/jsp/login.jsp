<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <link rel="icon" href="../immagini/b1.png">
    <link rel="stylesheet" href="css/login_page.css">
    <title>Login</title>
</head>

<body>
    <img src="/immagini/b1.png" alt="" class="img_logo">
    <a href="/" id="btn1" class="btn btn-rounded">Home Page</a>

    <div class="loginForm">
        <img src="/immagini/avatarPrimary.png" class="avatar">
        <h1>Effettua il login</h1>
        <form method="post" action="loginService">
            <p>Email:</p>
            <input type="text" name="email" placeholder="Inserisci email"/>
            <p>Password:</p>
            <input type="password" name="password" value="" placeholder="Inserisci password"/>
            <input type="submit" value="Accedi" />
            <br><br>
            <a href="iscrizione" id="a_iscriviti">Non hai un account? Iscriviti!</a>

        </form>
    </div>



    <script src="js/main.js"></script>
</body>

</html>
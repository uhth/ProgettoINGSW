



    const inputs = document.getElementById("form").elements;
	const username = inputs[0];
	const mail = inputs[1];
	const password = inputs[2];
	const passConf = inputs[3];
    
    
    alert("nome utente " + username);
    alert("mail utente " + mail);
    alert("passowrd utente " + password);
    alert("password ripetuta "+ passwordRipetuta);
    

/*

function validate() {



    var inputs = document.getElementById("mform").elements;
	var username = inputs[0];
	var mail = inputs[1];
	var password = inputs[2];
	var passConf = inputs[3];
    
    
    alert("nome utente " + username);
    alert("mail utente " + mail);
    alert("passowrd utente " + password);
    alert("password ripetuta "+ passwordRipetuta);
    



    var alertDiv = '<div class="alert alert-danger alert-dismissible" role="alert">';
    var alertBtn = '<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="=true">&times;</span></button>';

    if (mail.value == "") {
        errorBox.innerHTML = alertDiv + alertBtn + 'attento alla amil';
        mail.focus();
        return false;
    }

    return true;


}
*/

/*

    var username = document.querySelector("#user").value;
    var mail = document.querySelector("#email").value;
    var password = document.querySelector("#pass").value;
    var passwordRipetuta = document.querySelector("#passConf").value;
    

function validate() {
    var nome = document.getElementById("username_new");
    var mail = document.getElementById("email_new");
    var password = document.getElementById("pass_new");
    var passwordRipetuta = document.getElementById("passRipetuta_new");


    var email_reg_exp = /^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-]{2,})+.)+([a-zA-Z0-9]{2,})+$/;

    alert("CIAO2");

    if ((nome == "") || (nome == "undefined")) {
        alert("Il campo Nome è obbligatorio.");
        document.formIscrizione.nome.focus();
        return false;
    } else if (password != passwordRipetuta) {
        alert("Le password non coincidono");
        document.formIscrizione.passwordRipetuta.value = "";
        document.formIscrizione.passwordRipetuta.focus();
        return false;
    } else if (!email_reg_exp.test(email) || (email == "") || (email == "undefined")) {
        alert("Inserire un indirizzo email corretto.");
        document.formIscrizione.email.select();
        return false;
    } else {
        document.formIscrizione.action = "";
        document.formIscrizione.submit();
    }
}
*/
/*
var nome = document.formIscrizione.username_new.value;
var mail = document.formIscrizione.email_new.value;
var password = document.formIscrizione.pass_new.value;
var passwordRipetuta = document.formIscrizione.passRipetuta_new.value;

if ((nome == "") || (nome == "undefined")) {
    alert("Il campo Nome è obbligatorio.");
    document.modulo.nome.focus();
    return false;
} else if (password != passwordRipetuta) {
    alert("Le password non coincidono");
    document.modulo.conferma.value = "";
    document.modulo.conferma.focus();
    return false;
} else if (!email_reg_exp.test(email) || (email == "") || (email == "undefined")) {
    alert("Inserire un indirizzo email corretto.");
    document.modulo.email.select();
    return false;
} else {
    document.modulo.action = "elabora_dati.asp";
    document.modulo.submit();
}










alert("CIAO1");


var nome = document.getElementById("username_new");
var mail = document.getElementById("email_new");
var password = document.getElementById("pass_new");
var passwordRipetuta = document.getElementById("passRipetuta_new");


var email_reg_exp = /^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-]{2,})+.)+([a-zA-Z0-9]{2,})+$/;

alert("CIAO2");

if ((nome == "")) {
    alert("Il campo Nome è obbligatorio.");
    document.formIscrizione.nome.focus();
    return false;
} else if (password != passwordRipetuta) {
    alert("Le password non coincidono");
    document.formIscrizione.passwordRipetuta.value = "";
    document.formIscrizione.passwordRipetuta.focus();
    return false;
} else if (!email_reg_exp.test(email) || (email == "") || (email == "undefined")) {
    alert("Inserire un indirizzo email corretto.");
    document.formIscrizione.email.select();
    return false;
} else {
    document.formIscrizione.action = "";
    document.formIscrizione.submit();
}





*/
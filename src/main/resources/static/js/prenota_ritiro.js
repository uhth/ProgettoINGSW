function prosegui() {
	if (document.getElementById("Online").checked == true){
		sessionStorage.setItem("luogoRitiro", document.getElementById("ViaRitiro").value);
		sessionStorage.setItem("luogoConsegna", document.getElementById("ViaConsegna").value);
		sessionStorage.setItem("emailDestinatario", document.getElementById("EmailDest").value);
		//sessionStorage.setItem("emailMittente");	
  		window.location.href = "/payment";
	}
 	else if(document.getElementById("Contrassegno").checked == true){
		document.getElementById('form').submit();
	}
}

function prosegui() {
	if (document.getElementById("Online").checked == true){
		sessionStorage.setItem("luogoRitiro", document.getElementById("ViaRitiro").value);
		sessionStorage.setItem("luogoConsegna", document.getElementById("ViaConsegna").value);
		sessionStorage.setItem("emailDestinatario", document.getElementById("EmailDest").value);
		//sessionStorage.setItem("emailMittente");	
  		window.location.href = "/payment";
	}
 	else if(document.getElementById("Contrassegno").checked == true){
		var element4 = document.createElement("input");
		element4.value=sessionStorage.getItem("costoIva");
		element4.name="costoIva";
		form.appendChild(element4);
		
		document.body.appendChild(form);
		form.submit();
		//document.getElementById('form').submit();
	}
}

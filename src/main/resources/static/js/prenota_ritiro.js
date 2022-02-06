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
		
		var element5 = document.createElement("input");
		element5.value=document.getElementById("Contrassegno").checked;
		element5.name="Contrassegno";
		form.appendChild(element5);
		
		var element6 = document.createElement("input");
		element6.value=document.getElementById("EmailDest");
		element6.name="EmailDest";
		form.appendChild(element6);
		
		document.body.appendChild(form);
		form.submit();
		//document.getElementById('form').submit();
	}
}

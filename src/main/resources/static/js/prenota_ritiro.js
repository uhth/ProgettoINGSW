function prosegui() {
	if (document.getElementById("Online").checked == true){
  		window.location.href = "/payment";
	}
 	else if(document.getElementById("Contrassegno").checked == true){
		window.location.href = "";
	}
}

function prosegui() {
		var element5 = document.createElement("input");
		element5.value=sessionStorage.getItem("valore");
		element5.name="valore";
		form.appendChild(element5);
		
		document.body.appendChild(form);
		form.submit();
		//document.getElementById('form').submit();
}
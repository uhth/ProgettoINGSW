var FUNDING_SOURCES = [
	paypal.FUNDING.PAYPAL
];


$(document).ready(function() {
	var costo = sessionStorage.getItem("first");
	document.getElementById("costo").innerHTML = costo + " " + "&euro;";

	var costo2 = parseFloat(sessionStorage.getItem("first"));
	document.getElementById("costo2").innerHTML = costo2 + " " + "&euro;";

	var iva = ((costo2 * 22) / 100);
	var costoIva = iva + costo2;
	document.getElementById("costoIva").innerHTML = costoIva.toFixed(2) + " " + "&euro;";
	sessionStorage.setItem("costoIva", costoIva);

	// Loop over each funding source/payment method
	FUNDING_SOURCES.forEach(function(fundingSource) {

		// Initialize the buttons
		var button = paypal.Buttons({
			fundingSource: fundingSource,
			createOrder: function(data, actions) {
				return actions.order.create({
					purchase_units: [{
						amount: {
							value: costoIva.toFixed(2)
						}
					}]
				});
			},
			onApprove: function(data, actions) {
				return actions.order.capture().then(function(details) {
					console.log(details)
					    var form = document.createElement("form");
						var element1 = document.createElement("input"); 
						var element2 = document.createElement("input");  
						var element3 = document.createElement("input");
						var element4 = document.createElement("input");
						
						form.method = "POST";
						form.action = "/prenotaService";   
						
						element1.value=sessionStorage.getItem("luogoRitiro");
						element1.name="luogoRitiro";
						form.appendChild(element1);  
						
						element2.value=sessionStorage.getItem("luogoConsegna");
						element2.name="luogoConsegna";
						form.appendChild(element2);
						
						element3.value=sessionStorage.getItem("emailDestinatario");
						element3.name="emailDestinatario";
						form.appendChild(element3);
						
						element4.value=sessionStorage.getItem("costoIva");
						element4.name="costoIva";
						form.appendChild(element4);
						
						document.body.appendChild(form);

						form.submit();	
				})
			},
			onCancel: function(data) {
				window.location.replace("http://localhost:8080/payment_error")
			}
		});

		// Check if the button is eligible
		if (button.isEligible()) {

			// Render the standalone button for that funding source
			button.render('#paypal-payment-button');
		}
	});

});






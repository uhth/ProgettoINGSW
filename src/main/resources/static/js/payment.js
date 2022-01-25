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
					window.location.replace("http://localhost:8080/payment/success.php")
				})
			},
			onCancel: function(data) {
				window.location.replace("http://localhost:8080/payment/Oncancel.php")
			}
		});

		// Check if the button is eligible
		if (button.isEligible()) {

			// Render the standalone button for that funding source
			button.render('#paypal-payment-button');
		}
	});

});






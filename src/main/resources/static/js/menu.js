
		
$( function() {
	//get session
	var email = "";
	var role = "";
	
	$("head").append( "<script src=\"https://kit.fontawesome.com/eb3e5ce09e.js\" crossorigin=\"anonymous\"></script>" );
	
	//ottengo gli attributi facendo una request dopo genero il menu di conseguenza
	$.when( 
		$.get(   "/session",
		 function( data ) {
			email = data['email'];
			role = data['role']; },
		"json" ) 
		).always( function() {		
		$("head").append( "<link rel=\"stylesheet\" href=\"css/menu.css\">" );
		
		$("body").prepend( "<div class=\"topnav\" id=\"myTopnav\"> <a href=\"/\" class=\"active\">Home</a> </div>" );
		
		
		switch( role ) {
			case "admin" :
				$(".topnav").append( "<a href=\"profiloAmministratore\">Area Admin  <i class=\"fas fa-user-lock\"></i></a>" );
			break;
			case "corriere" :
				$(".topnav").append( "<a href=\"areaCorriere\">Area Corriere  <i class=\"fas fa-people-carry\"></i></a>" );
			break;
			case "user" :
				$(".topnav").append( "<a href=\"profilo_utente\">Profilo utente  <i class=\"far fa-user\"></i></a>" );
			break;
		}
		if( email != "" )
			$(".topnav").append( "<a href=\"logout\">Logout  <i class=\"fas fa-sign-out-alt\"></i></a>" );	
		else
			$(".topnav").append( "<a onclick=\"document.getElementById('divLogin').style.display='block'\">Accedi  <i class=\"fas fa-sign-in-alt\"></i></a>" );
		
		$(".topnav").append( "<a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\"><i class=\"fa fa-bars\"></i></a>" );
				
	});
});


/* Toggle between adding and removing the "responsive" class to topnav when the user clicks on the icon */
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}


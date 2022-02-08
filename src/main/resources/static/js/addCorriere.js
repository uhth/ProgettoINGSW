
var selectedMail = "";
	
function ValidateCorriere() {
	if( selectedMail === "" ) return;
	$.post( "aggiuntaCorriere", { email : selectedMail }, location.reload(true) )
	  .done( function() {
	    alert( selectedMail + " è ora un corriere!" );
	  }).fail(function( xhr, status, error ) {
		alert( selectedMail + "OPERAZIONE FALLITA, RIPROVARE" );
    });
	
}
	
function Menu(emailList) { 
	selectedMail = emailList[emailList.selectedIndex].value;
}
	
function LoadEmails() {
	let emails_l = emails.length;
   	
	if( emails_l > 0 ) selectedMail = emails[0];
	else $(".richiesta" ).hide; 	
	
	$(".menu").append( "<div class=\"selLabel\">SELEZIONA EMAIL DA AGGIUNGERE</div>" );
	$(".menu").append( "<br><select class=\"menu_sel\" onChange=\"Menu(this)\">" );
	for( i=0; i<emails_l; i++ ) { $(".menu_sel").append( "<option value=\"" + emails[i] + "\">" + emails[i] + "</option>"); }
	$(".menu").append( "<br><input class=\"btn btn-success\" onClick=ValidateCorriere() value=\"CONFERMA\"/>" );
	$(".menu").append( "</select>" );
}
	
WaitJQ2();

function WaitJQ2() {
	if ( typeof jQuery != "undefined" ) { LoadEmails(); }
	else {
		setTimeout( function() { WaitJQ2() }, 50 ); 
	}
}
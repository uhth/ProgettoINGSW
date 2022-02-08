
window.onload = function LoadJQ() {
	if(typeof jQuery === "undefined") {
	    var script = document.createElement('script');
	    script.src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js';
	    script.type = 'text/javascript';
	    document.getElementsByTagName('head')[0].appendChild(script);
    }
};

WaitJQ();

function LoadMenu() {
	var menu = document.createElement('script');
	menu.src = 'js/menu.js';
	menu.type = 'text/javascript';
	document.getElementsByTagName('head')[0].appendChild(menu);    
}

function WaitJQ() {
    if ( typeof jQuery != "undefined" ) {
        LoadMenu();
    } else {
        setTimeout( function() { WaitJQ() }, 50);
    }
}
function initMap() {
  const roma = { lat: 41.77, lng: 12.94 }; 
  const map = new google.maps.Map(document.getElementById("map"), {
    zoom: 4,
    center: roma,
  });
  
  /*
  const marker = new google.maps.Marker({
    position: x,
    map: map,
  });
	*/
	
  const icons = {
    mittente: {
      icon: "immagini/gmaps_mittente.png",
    },
    destinatario: {
      icon: "immagini/gmaps_destinatario.png",
    },
    corriere: {
      icon: "immagini/gmaps_corriere.png",
    },
  };
  
  
	 const features = [
	{
	  position: new google.maps.LatLng(40.614924258302516,  15.745457455158864),
	  type: "corriere",
	},
	 {
      position: new google.maps.LatLng(42.26991050314891, 13.115952911376953),
      type: "mittente",
    },
	 {
      position: new google.maps.LatLng(39.272193757920505, 16.18770288032943),
      type: "destinatario",
    },
    ];
    
    
// Create markers.
  for (let i = 0; i < features.length; i++) {
    const marker = new google.maps.Marker({
      position: features[i].position,
      icon: icons[features[i].type].icon,
      map: map,
    });
  }
  
  map.addListener("click", (mapsMouseEvent) => {    
    console.log(mapsMouseEvent.latLng.toJSON()) /* posizione  */
  /*  infoWindow.open(map); infowindow */ 
  });
}


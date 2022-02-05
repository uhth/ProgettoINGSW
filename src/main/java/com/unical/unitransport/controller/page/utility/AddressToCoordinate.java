package com.unical.unitransport.controller.page.utility;

import java.util.List;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class AddressToCoordinate { // API opencagedata

	private String address;
	private String key = "&key=3f829b18d2d24a10b0e20c68a7a437fd";
	private String URL = "https://api.opencagedata.com/geocode/v1/json?q=";
	private String latitude = "39.3336225";
	private String longitude = "16.324287";

	public AddressToCoordinate(String address) {
		super();
		this.address = address;
		init();
	}

	public AddressToCoordinate() {}

	public void init() {
		if (address == null || address.isEmpty())
			return;
		String theUrl = URL + address.replaceAll("\\s", "") + key;

		try {
			RestTemplate restTemplate = new RestTemplate(); 
			String rtResult = restTemplate.getForObject(theUrl, String.class);
			GsonController risultato = new Gson().fromJson(rtResult.toString(), GsonController.class);
			List<Result> list = risultato.getResults();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getFormatted().contains("Italia") || list.get(i).getFormatted().contains("Italy")) {
					latitude = list.get(i).getGeometry().getLat().toString();
					longitude = list.get(i).getGeometry().getLng().toString();
			//		System.out.println(list.get(i).getFormatted());
					break;
				}
			}
		} catch (RestClientException e) {
			System.out.println("Errore in AddressToCoordinate");
		} catch (JsonSyntaxException e) {
			System.out.println("Errore in AddressToCoordinate");
		}
	}

	public String getLatitude() {
		if (address == null || address.isEmpty())
			return "";
		return latitude;
	}

	public String getLongitude() {
		if (address == null || address.isEmpty())
			return "";
		return longitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
/*	OLD SYSTEM API positionstack
 * 
 * package com.unical.unitransport.controller.page.utility;
 * 
 * import java.io.BufferedReader; import java.io.InputStreamReader; import
 * java.net.URL; import java.net.URLConnection; import java.util.regex.Pattern;
 * 
 * public class AddressToCoordinate {
 * 
 * private String address; private String URL =
 * "http://api.positionstack.com/v1/forward?access_key=3a0f0a316dd93089d6bdfbf66e4a95d4&query=";
 * private String latitude; private String longitude;
 * 
 * public AddressToCoordinate(String address) { super(); this.address = address;
 * init(); }
 * 
 * public AddressToCoordinate() { }
 * 
 * public void init() { if (address == null || address.isEmpty()) return ;
 * String theUrl = URL + address; StringBuilder content = new StringBuilder();
 * 
 * try { URL url = new URL(theUrl); URLConnection urlConnection =
 * url.openConnection(); BufferedReader bufferedReader = new BufferedReader(new
 * InputStreamReader(urlConnection.getInputStream())); String line; while ((line
 * = bufferedReader.readLine()) != null) { content.append(line + "\n"); }
 * bufferedReader.close(); } catch (Exception e) { e.printStackTrace(); } try {
 * String c = content.toString(); String[] parts = c.split(Pattern.quote(":"));
 * 
 * String lat = parts[2]; String lng = parts[3]; String[] splitlat =
 * lat.split(Pattern.quote(",")); String[] splitlong =
 * lng.split(Pattern.quote(","));
 * 
 * String finalLat = splitlat[0]; String finalLong = splitlong[0];
 * 
 * setLatitude(finalLat); setLongitude(finalLong); } catch (Exception e) {
 * System.out.println("Errore nell'indirizzo"); return; } }
 * 
 * public String getLatitude() { if (address == null || address.isEmpty())
 * return ""; return latitude; }
 * 
 * public String getLongitude() { if (address == null || address.isEmpty())
 * return ""; return longitude; }
 * 
 * public void setLatitude(String latitude) { this.latitude = latitude; }
 * 
 * public void setLongitude(String longitude) { this.longitude = longitude; }
 * 
 * }
 */
package com.unical.unitransport.controller.page;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;

public class AddressToCoordinate {

	private String address;
	private String URL = "http://api.positionstack.com/v1/forward?access_key=3a0f0a316dd93089d6bdfbf66e4a95d4&query=";
	private String latitude;
	private String longitude;
	
	public AddressToCoordinate(String address) {
		super();
		this.address = address;
		init();
	}

	public AddressToCoordinate() {	}
	
	public void init() {
		if (address == null || address.isEmpty())
			return ;
		String theUrl = URL + address;
		StringBuilder content = new StringBuilder();

		try {
			URL url = new URL(theUrl);
			URLConnection urlConnection = url.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				content.append(line + "\n");
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String c = content.toString();
		String[] parts = c.split(Pattern.quote(":"));

		String lat = parts[2];
		String lng = parts[3];
		String[] splitlat = lat.split(Pattern.quote(","));
		String[] splitlong = lng.split(Pattern.quote(","));

		String finalLat = splitlat[0];
		String finalLong = splitlong[0];
		
		setLatitude(finalLat);
		setLongitude(finalLong);
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

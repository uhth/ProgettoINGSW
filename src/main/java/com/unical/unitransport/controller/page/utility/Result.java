
package com.unical.unitransport.controller.page.utility;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Result {

	@SerializedName("confidence")
	@Expose
	private Integer confidence;
	@SerializedName("formatted")
	@Expose
	private String formatted;
	@SerializedName("geometry")
	@Expose
	private Geometry geometry;


	public Integer getConfidence() {
		return confidence;
	}

	public void setConfidence(Integer confidence) {
		this.confidence = confidence;
	}

	public String getFormatted() {
		return formatted;
	}

	public void setFormatted(String formatted) {
		this.formatted = formatted;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

}
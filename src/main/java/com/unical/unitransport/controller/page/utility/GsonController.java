
package com.unical.unitransport.controller.page.utility;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class GsonController {

	@SerializedName("documentation")
	@Expose
	private String documentation;
	@SerializedName("results")
	@Expose
	private List<Result> results = null;
	@SerializedName("thanks")
	@Expose
	private String thanks;
	@SerializedName("total_results")
	@Expose
	private Integer totalResults;

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public String getThanks() {
		return thanks;
	}

	public void setThanks(String thanks) {
		this.thanks = thanks;
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}

}
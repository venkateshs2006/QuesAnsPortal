package com.phd.quesans.entity.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="searchengine")
public class SearchEnginePojo {
	@Id
	@GeneratedValue
 	private int searchEngineId;
	private String searchEngineName;
	private String searchEngineURL;
	private String resultTag;
	private String resultTagID;
	private int TagPosition;
	private String regexDetails;
	public int getSearchEngineId() {
		return searchEngineId;
	}
	public void setSearchEngineId(int searchEngineId) {
		this.searchEngineId = searchEngineId;
	}
	public String getSearchEngineName() {
		return searchEngineName;
	}
	public void setSearchEngineName(String searchEngineName) {
		this.searchEngineName = searchEngineName;
	}
	public String getSearchEngineURL() {
		return searchEngineURL;
	}
	public void setSearchEngineURL(String searchEngineURL) {
		this.searchEngineURL = searchEngineURL;
	}
	public String getResultTag() {
		return resultTag;
	}
	public void setResultTag(String resultTag) {
		this.resultTag = resultTag;
	}
	public String getResultTagID() {
		return resultTagID;
	}
	public void setResultTagID(String resultTagID) {
		this.resultTagID = resultTagID;
	}
	public int getTagPosition() {
		return TagPosition;
	}
	public void setTagPosition(int tagPosition) {
		TagPosition = tagPosition;
	}
	public String getRegexDetails() {
		return regexDetails;
	}
	public void setRegexDetails(String regexDetails) {
		this.regexDetails = regexDetails;
	} 
}

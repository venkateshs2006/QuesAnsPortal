package com.phd.quesans.entity.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class searchEngine {
 @Id
 private String SearchEngineId;
 private String SearchEngineName;
 private String contentTag;
 private String contentTagId;
 private String regex;
public String getSearchEngineId() {
	return SearchEngineId;
}
public void setSearchEngineId(String searchEngineId) {
	SearchEngineId = searchEngineId;
}
public String getSearchEngineName() {
	return SearchEngineName;
}
public void setSearchEngineName(String searchEngineName) {
	SearchEngineName = searchEngineName;
}
public String getContentTag() {
	return contentTag;
}
public void setContentTag(String contentTag) {
	this.contentTag = contentTag;
}
public String getContentTagId() {
	return contentTagId;
}
public void setContentTagId(String contentTagId) {
	this.contentTagId = contentTagId;
}
public String getRegex() {
	return regex;
}
public void setRegex(String regex) {
	this.regex = regex;
}
 
}

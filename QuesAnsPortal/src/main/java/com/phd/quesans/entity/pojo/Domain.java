package com.phd.quesans.entity.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Domain {
	@Id
private int domainId;
private String name;
private int parentdomainId;
public int getDomainId() {
	return domainId;
}
public void setDomainId(int domainId) {
	this.domainId = domainId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getParentdomainId() {
	return parentdomainId;
}
public void setParentdomainId(int parentdomainId) {
	this.parentdomainId = parentdomainId;
}
}

package com.phd.quesans.hibernate.pojo;

public class QuestionPojo {
	
	private int quesid;
	private String question;
	private String answer;
	private String domainid;
	private String keywords;
	public int getQuesid() {
		return quesid;
	}
	public void setQuesid(int quesid) {
		this.quesid = quesid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getDomainid() {
		return domainid;
	}
	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

}

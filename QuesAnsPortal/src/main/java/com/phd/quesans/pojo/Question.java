package com.phd.quesans.pojo;

public class Question {
private int id;
private String ques;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getQues() {
	return ques;
}
public void setQues(String ques) {
	this.ques = ques;
}
@Override
public String toString() {
	return "Question [id=" + id + ", ques=" + ques + "]";
}


}

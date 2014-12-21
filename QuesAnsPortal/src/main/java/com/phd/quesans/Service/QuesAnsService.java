package com.phd.quesans.Service;

import java.util.List;

import com.phd.quesans.entity.pojo.QuestionPojo;
import com.phd.quesans.pojo.Question;

public interface QuesAnsService {
	public List<String> listQuestion(String term);
	public QuestionPojo getQuestionPojo(String question);
}

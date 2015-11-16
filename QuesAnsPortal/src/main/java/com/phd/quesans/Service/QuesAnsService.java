package com.phd.quesans.Service;

import java.util.List;

import com.phd.quesans.entity.pojo.QuestionPojo;
import com.phd.quesans.entity.pojo.SearchEnginePojo;
import com.phd.quesans.entity.pojo.SearchKeyword;
import com.phd.quesans.pojo.Question;

public interface QuesAnsService {
	public List<String> listQuestion(String term);
	public QuestionPojo getQuestionPojo(String question);
	public List<SearchEnginePojo> listSearchEngine();
	public List<SearchKeyword> listKeyword(int quesid);
}

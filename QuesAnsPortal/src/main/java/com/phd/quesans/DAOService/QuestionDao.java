package com.phd.quesans.DAOService;

import java.util.List;

import com.phd.quesans.entity.pojo.QuestionPojo;
import com.phd.quesans.entity.pojo.SearchEnginePojo;
import com.phd.quesans.entity.pojo.SearchKeyword;


public interface QuestionDao {
	public List<String> listQuestion(String term);
	public QuestionPojo getQuestionPojo(String question);
	public List<SearchEnginePojo> listSearchEngine();
	public List<SearchKeyword> listKeyword(int quesid);
	
}

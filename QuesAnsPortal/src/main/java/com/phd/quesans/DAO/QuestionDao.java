package com.phd.quesans.DAO;

import java.util.List;

import com.phd.quesans.entity.DTO.QuestionDTO;
import com.phd.quesans.entity.DTO.SearchEngineDTO;
import com.phd.quesans.entity.DTO.SearchKeywordDTO;


public interface QuestionDao {
	public List<String> listQuestion(String term);
	public QuestionDTO getQuestionPojo(String question);
	public List<SearchEngineDTO> listSearchEngine();
	public List<SearchKeywordDTO> listKeyword(int quesid);
	
}

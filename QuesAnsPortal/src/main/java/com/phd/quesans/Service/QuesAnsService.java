package com.phd.quesans.Service;

import java.util.List;

import com.phd.quesans.entity.DTO.QuestionDTO;
import com.phd.quesans.entity.DTO.SearchEngineDTO;
import com.phd.quesans.entity.DTO.SearchKeywordDTO;
import com.phd.quesans.pojo.Question;

public interface QuesAnsService {
	public List<String> listQuestion(String term);
	public QuestionDTO getQuestionPojo(String question);
	public List<SearchEngineDTO> listSearchEngine();
	public List<SearchKeywordDTO> listKeyword(int quesid);
	
}

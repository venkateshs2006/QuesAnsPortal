package com.phd.quesans.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phd.quesans.DAOService.QuestionDao;
import com.phd.quesans.entity.DTO.QuestionDTO;
import com.phd.quesans.entity.DTO.SearchEngineDTO;
import com.phd.quesans.entity.DTO.SearchKeywordDTO;
@Service
public class QuesAnsServiceImpl implements QuesAnsService {
	 @Autowired
	 private QuestionDao questionDao;
	@Transactional
    public List<String> listQuestion(String term) {
		List<String> listQuestions=new ArrayList<String>();
		listQuestions=questionDao.listQuestion(term);
		return listQuestions;
    }
	@Transactional
	public QuestionDTO getQuestionPojo(String question) {
		return questionDao.getQuestionPojo(question);
	}
	@Transactional
	public List<SearchEngineDTO> listSearchEngine() {
		// TODO Auto-generated method stub
		
		List<SearchEngineDTO> listSearchEngine=new ArrayList<SearchEngineDTO>();
		listSearchEngine=questionDao.listSearchEngine();
		//List<SearchEngine> searchEngines=new ArrayList<SearchEngine>();
		return listSearchEngine;
	}
	@Transactional
	public List<SearchKeywordDTO> listKeyword(int quesid) {
		// TODO Auto-generated method stub
		
		List<SearchKeywordDTO> listSearchKeyword=new ArrayList<SearchKeywordDTO>();
		listSearchKeyword=questionDao.listKeyword(quesid);
		//List<SearchEngine> searchEngines=new ArrayList<SearchEngine>();
		return listSearchKeyword;
	}
}

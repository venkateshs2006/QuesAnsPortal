package com.phd.quesans.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phd.quesans.DAOService.QuestionDao;
import com.phd.quesans.entity.pojo.QuestionPojo;
import com.phd.quesans.entity.pojo.SearchEnginePojo;
import com.phd.quesans.entity.pojo.SearchKeyword;
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
	public QuestionPojo getQuestionPojo(String question) {
		return questionDao.getQuestionPojo(question);
	}
	@Transactional
	public List<SearchEnginePojo> listSearchEngine() {
		// TODO Auto-generated method stub
		
		List<SearchEnginePojo> listSearchEngine=new ArrayList<SearchEnginePojo>();
		listSearchEngine=questionDao.listSearchEngine();
		//List<SearchEngine> searchEngines=new ArrayList<SearchEngine>();
		return listSearchEngine;
	}
	@Transactional
	public List<SearchKeyword> listKeyword(int quesid) {
		// TODO Auto-generated method stub
		
		List<SearchKeyword> listSearchKeyword=new ArrayList<SearchKeyword>();
		listSearchKeyword=questionDao.listKeyword(quesid);
		//List<SearchEngine> searchEngines=new ArrayList<SearchEngine>();
		return listSearchKeyword;
	}
}

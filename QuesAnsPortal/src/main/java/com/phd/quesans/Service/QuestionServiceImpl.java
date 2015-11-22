package com.phd.quesans.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phd.quesans.DAO.AdminQuestionDAO;
import com.phd.quesans.DAO.SearchEngineDAO;
import com.phd.quesans.entity.DTO.QuestionDTO;
import com.phd.quesans.entity.DTO.SearchEngineDTO;


@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	 private AdminQuestionDAO adminQuestionDAO;

	@Override
	@Transactional
	public QuestionDTO getQuestion(int id) {
		// TODO Auto-generated method stub
		return adminQuestionDAO.getQuestion(id);
	}
	

	@Override
	@Transactional
	public List<QuestionDTO> getQuestionList() {
		// TODO Auto-generated method stub
		return adminQuestionDAO.getQuestionList();
	}

	@Override
	@Transactional
	public int addQuestion(QuestionDTO question) {
		// TODO Auto-generated method stub
		return adminQuestionDAO.addQuestion(question);
	}

	@Override
	@Transactional
	public int deleteQuestion(QuestionDTO question) {
		// TODO Auto-generated method stub
		return adminQuestionDAO.addQuestion(question);
	}



}

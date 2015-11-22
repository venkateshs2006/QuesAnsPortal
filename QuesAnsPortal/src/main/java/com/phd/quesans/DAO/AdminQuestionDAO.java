package com.phd.quesans.DAO;

import java.util.List;

import com.phd.quesans.entity.DTO.QuestionDTO;

public interface AdminQuestionDAO {
	public QuestionDTO getQuestion(int id);
	public List<QuestionDTO> getQuestionList();
	public int addQuestion(QuestionDTO question);
	public int deleteQuestion(QuestionDTO question);
}

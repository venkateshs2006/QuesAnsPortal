package com.phd.quesans.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.phd.quesans.DAOService.QuestionDao;
import com.phd.quesans.pojo.Question;

public class QuesAnsServiceImpl implements QuesAnsService {
	@Transactional
    public List<Question> listQuestion() {
		QuestionDao questionDao=(QuestionDao) new QuesAnsServiceImpl();
		List<Question> listQuestions=new ArrayList<Question>();
		listQuestions=questionDao.listQuestion();
		return listQuestions;
    }
 
}

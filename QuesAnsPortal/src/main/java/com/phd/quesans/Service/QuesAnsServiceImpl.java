package com.phd.quesans.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.phd.quesans.DAOService.QuestionDao;
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
 
}

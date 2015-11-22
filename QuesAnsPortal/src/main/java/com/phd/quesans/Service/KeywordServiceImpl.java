package com.phd.quesans.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phd.quesans.DAO.AdminKeywordDAO;
import com.phd.quesans.DAO.AdminQuestionDAO;
import com.phd.quesans.DAO.QuestionDao;
import com.phd.quesans.entity.DTO.QuestionDTO;
import com.phd.quesans.entity.DTO.SearchEngineDTO;
import com.phd.quesans.entity.DTO.SearchKeywordDTO;
@Service
public class KeywordServiceImpl implements KeywordService {
	@Autowired
	 private AdminKeywordDAO adminKeywordDAO;

	@Override
	@Transactional
	public SearchKeywordDTO getSearchKeyword(int id) {
		// TODO Auto-generated method stub
		return adminKeywordDAO.getSearchKeyword(id);
	}
	

	@Override
	@Transactional
	public List<SearchKeywordDTO> getSearchKeywordList() {
		// TODO Auto-generated method stub
		return adminKeywordDAO.getSearchKeywordList();
	}

	@Override
	@Transactional
	public int addSearchKeyword(SearchKeywordDTO searchKeywordDTO){
		// TODO Auto-generated method stub
		return adminKeywordDAO.addSearchKeyword(searchKeywordDTO);
	}

	@Override
	@Transactional
	public int deleteSearchKeyword(SearchKeywordDTO searchKeywordDTO) {
		// TODO Auto-generated method stub
		return adminKeywordDAO.deleteSearchKeyword(searchKeywordDTO);
	}


}

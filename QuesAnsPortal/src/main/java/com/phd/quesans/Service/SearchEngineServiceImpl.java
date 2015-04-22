package com.phd.quesans.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.phd.quesans.DAOService.QuestionDao;
import com.phd.quesans.entity.pojo.SearchEnginePojo;



public class SearchEngineServiceImpl implements SearchEngineService {
	@Autowired
	 private QuestionDao questionDao;
	@Override
	public List<SearchEnginePojo> listSearchEngine() {
		// TODO Auto-generated method stub
		
		List<SearchEnginePojo> listSearchEngine=new ArrayList<SearchEnginePojo>();
		listSearchEngine=questionDao.listSearchEngine();
		//List<SearchEngine> searchEngines=new ArrayList<SearchEngine>();
		return listSearchEngine;
	}	

}

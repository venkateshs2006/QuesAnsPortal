package com.phd.quesans.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phd.quesans.DAO.SearchEngineDAO;
import com.phd.quesans.entity.DTO.SearchEngineDTO;


@Service
public class SearchEngineServiceImpl implements SearchEngineService {
	@Autowired
	 private SearchEngineDAO searchEngineDAO;

	@Override
	@Transactional
	public SearchEngineDTO getSearchEngine(int id) {
		// TODO Auto-generated method stub
		return searchEngineDAO.getSearchEngine(id);
	}
	

	@Override
	@Transactional
	public List<SearchEngineDTO> getSearchEngineList() {
		// TODO Auto-generated method stub
		return searchEngineDAO.getSearchEngineList();
	}

	@Override
	@Transactional
	public int addSearchEngine(SearchEngineDTO searchEngine) {
		// TODO Auto-generated method stub
		return searchEngineDAO.addSearchEngine(searchEngine);
	}

	@Override
	@Transactional
	public int deleteSearchEngine(SearchEngineDTO searchEngine) {
		// TODO Auto-generated method stub
		return searchEngineDAO.deleteSearchEngine(searchEngine);
	}
		

}

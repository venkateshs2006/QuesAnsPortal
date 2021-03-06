package com.phd.quesans.Service;

import java.util.List;

import com.phd.quesans.entity.DTO.SearchEngineDTO;


public interface SearchEngineService {
	public SearchEngineDTO getSearchEngine(int id);
	public List<SearchEngineDTO> getSearchEngineList();
	public int addSearchEngine(SearchEngineDTO searchEngine);
	public int deleteSearchEngine(SearchEngineDTO searchEngine);	
}

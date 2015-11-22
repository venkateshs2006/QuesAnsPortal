package com.phd.quesans.DAO;

import java.util.List;

import com.phd.quesans.entity.DTO.SearchEngineDTO;

public interface SearchEngineDAO {
	public SearchEngineDTO getSearchEngine(int id);
	public List<SearchEngineDTO> getSearchEngineList();
	public int addSearchEngine(SearchEngineDTO searchEngine);
	public int deleteSearchEngine(SearchEngineDTO searchEngine);
}

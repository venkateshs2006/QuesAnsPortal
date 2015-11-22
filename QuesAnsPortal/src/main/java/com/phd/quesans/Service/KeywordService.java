package com.phd.quesans.Service;

import java.util.List;

import com.phd.quesans.entity.DTO.SearchKeywordDTO;

public interface KeywordService {
	public SearchKeywordDTO getSearchKeyword(int id);
	public List<SearchKeywordDTO> getSearchKeywordList();
	public int addSearchKeyword(SearchKeywordDTO searchKeywordDTO);
	public int deleteSearchKeyword(SearchKeywordDTO searchKeywordDTO);
	
}

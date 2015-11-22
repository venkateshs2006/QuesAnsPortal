package com.phd.quesans.DAO;

import java.util.List;

import com.phd.quesans.entity.DTO.SearchKeywordDTO;

public interface AdminKeywordDAO {
	public SearchKeywordDTO getSearchKeyword(int id);
	public List<SearchKeywordDTO> getSearchKeywordList();
	public int addSearchKeyword(SearchKeywordDTO searchKeyword);
	public int deleteSearchKeyword(SearchKeywordDTO searchKeyword);
}

package com.phd.quesans.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.phd.quesans.DAOService.QuestionDao;
import com.phd.quesans.entity.pojo.SearchEnginePojo;



public class SearchEngineServiceImpl implements SearchEngineService {
	@Autowired
	 private QuestionDao questionDao;
		

}

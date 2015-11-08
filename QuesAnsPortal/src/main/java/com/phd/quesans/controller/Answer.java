package com.phd.quesans.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.phd.quesans.Crawler.WebpageCrawer;
import com.phd.quesans.Service.QuesAnsService;
import com.phd.quesans.Service.SearchEngineService;
import com.phd.quesans.entity.pojo.QuestionPojo;
import com.phd.quesans.entity.pojo.SearchEnginePojo;
import com.phd.quesans.pojo.Question;
import com.phd.quesans.pojo.SearchEngine;

@Controller

public class Answer {
	@Autowired
	QuesAnsService quesAnsService;

	@RequestMapping(value = "/RequestQuestion", method = RequestMethod.POST)
	public String processQuestionRequest(@RequestParam("ques") String name, Map<String, Object> model) {
		// implement your own registration logic here...
		// for testing purpose:
		QuestionPojo questionPojo = getQuestionPojo(name);
		model.put("ques", questionPojo.getQuestion());
		model.put("answer", questionPojo.getAnswer());
		List<String> resultWebContent = getWikiContent(questionPojo.getQuestion(), questionPojo.getKeywords());
		model.put("wiki", resultWebContent.get(0));
		model.put("google", resultWebContent.get(1));
		return "QuestionSuccess";
	}

	@RequestMapping(value = "/RequestQuestion", method = RequestMethod.GET)
	public String processQuestionGetRequest(@RequestParam("ques") String name, Map<String, Object> model) {
		// implement your own registration logic here...
		// for testing purpose:

		QuestionPojo questionPojo = getQuestionPojo(name);
		model.put("ques", questionPojo.getQuestion());
		model.put("answer", questionPojo.getAnswer());
		List<String> resultWebContent = getWikiContent(questionPojo.getQuestion(), questionPojo.getKeywords());
		model.put("wiki", resultWebContent.get(0));
		model.put("google", resultWebContent.get(1));
		return "QuestionSuccess";
	}

	public QuestionPojo getQuestionPojo(String question) {
		return quesAnsService.getQuestionPojo(question);
	}

	public List<SearchEnginePojo> getSearchEnginePojo() {
		return quesAnsService.listSearchEngine();
	}

	public List<String> getWikiContent(String question, String keyword) {
		List<String> result = new ArrayList<String>();
		WebpageCrawer webpageCrawer = new WebpageCrawer();
		List<SearchEnginePojo> searchEnginePojos = getSearchEnginePojo();
		for (SearchEnginePojo searchEnginePojo : searchEnginePojos) {
			//System.out.println(https://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=founder%20of%20whatsup&userip=117.202.151.21);
			if(searchEnginePojo.getSearchEngineName()=="Wikipedia"){
				
			}
			if(searchEnginePojo.equals("Google")){
				Gson gson=new Gson();
			}
		}
		System.out.println("Result ::" + result.toString());
		return result;
	}
}
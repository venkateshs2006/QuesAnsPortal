package com.phd.quesans.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@Autowired
	SearchEngineService searchEngineService;
	@RequestMapping(value = "/RequestQuestion", method = RequestMethod.POST)
    public String processQuestionRequest(@ModelAttribute("question") Question question,
            Map<String, Object> model) {         
        // implement your own registration logic here...         
        // for testing purpose:
		QuestionPojo questionPojo=getQuestionPojo(question.getQues());
		model.put("ques", question.getQues());
        model.put("answer", questionPojo.getAnswer());
        model.put("wiki", getWikiContent(questionPojo.getKeywords()));
        return "QuestionSuccess";
    }
	public QuestionPojo getQuestionPojo(String question) {
		return quesAnsService.getQuestionPojo(question);
	}
	public List<SearchEnginePojo> getSearchEnginePojo() {
		return searchEngineService.listSearchEngine();
	}
   public String getWikiContent(String keyword) {
	   String result=new String();
	   WebpageCrawer webpageCrawer=new WebpageCrawer();
	   List<SearchEnginePojo> searchEnginePojos=getSearchEnginePojo();
	   for(SearchEnginePojo searchEnginePojo: searchEnginePojos){
	   webpageCrawer.getSelectedContent(searchEnginePojo.getSearchEngineURL()+keyword, "div", "bodycontent");
	   }
	return result;  
}
}
package com.phd.quesans.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phd.quesans.Crawler.WebpageCrawer;
import com.phd.quesans.Service.QuesAnsService;
import com.phd.quesans.entity.pojo.QuestionPojo;
import com.phd.quesans.pojo.Question;

@Controller

public class Answer {
	@Autowired
	QuesAnsService quesAnsService;
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
   public String getWikiContent(String keyword) {
	   WebpageCrawer webpageCrawer=new WebpageCrawer();
	   return webpageCrawer.getSelectedContent("http://en.wikipedia.org/w/index.php?search="+keyword+"&title=Special%3ASearch&go=Go", "div", "bodycontent");
   }
}

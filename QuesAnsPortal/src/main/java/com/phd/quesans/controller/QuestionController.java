package com.phd.quesans.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phd.quesans.pojo.Question;


@Controller
public class QuestionController {
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	@RequestMapping(value = "/RequestQuestion", method = RequestMethod.GET)
	public String requestQues(Locale locale, Model model) {
		//Question question = new Question();
		//modelMap.put("question", question);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		//model.addAttribute(question);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("question", new Question()); 
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome QuesAns! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("question", new Question()); 
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/RequestQuestion", method = RequestMethod.POST)
    public String processQuestionRequest(@ModelAttribute("question") Question question,
            Map<String, Object> model) {
         
        // implement your own registration logic here...
         
        // for testing purpose:
        System.out.println("Question: " + question.getQues());
        System.out.println("QuestionID: " + question.getId());
        model.put("ques", question.getQues());
        model.put("id",question.getId());
        return "QuestionSuccess";
    }
}

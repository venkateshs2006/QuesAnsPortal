package com.phd.quesans.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phd.quesans.pojo.Question;

@Controller

public class Answer {
	@RequestMapping(value = "/RequestQuestion", method = RequestMethod.POST)
    public String processQuestionRequest(@ModelAttribute("question") Question question,
            Map<String, Object> model) {
         
        // implement your own registration logic here...
         
        // for testing purpose:
        model.put("ques", question.getQues());
        return "QuestionSuccess";
    }
}

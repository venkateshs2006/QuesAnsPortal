package com.phd.quesans.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.phd.quesans.Crawler.WebpageCrawer;
import com.phd.quesans.Service.QuesAnsService;
import com.phd.quesans.entity.DTO.QuestionDTO;
import com.phd.quesans.entity.DTO.SearchEngineDTO;
import com.phd.quesans.entity.DTO.SearchKeywordDTO;

@Controller

public class Answer {
	@Autowired
	QuesAnsService quesAnsService;

	@RequestMapping(value = "/RequestQuestion", method = RequestMethod.POST)
	public String processQuestionRequest(@RequestParam("ques") String name, Map<String, Object> model) {
		// implement your own registration logic here...
		// for testing purpose:
		QuestionDTO questionPojo = getQuestionPojo(name);
		model.put("ques", questionPojo.getQuestion());
		model.put("answer", questionPojo.getAnswer());
		List<String> resultWebContent = getWikiContent(questionPojo.getQuestion(), questionPojo.getQuesid());
		model.put("wiki", resultWebContent.get(0));
		model.put("google", resultWebContent.get(1));
		return "QuestionSuccess";
	}

	@RequestMapping(value = "/RequestQuestion", method = RequestMethod.GET)
	public String processQuestionGetRequest(@RequestParam("ques") String name, Map<String, Object> model) {
		// implement your own registration logic here...
		// for testing purpose:

		QuestionDTO questionPojo = getQuestionPojo(name);
		model.put("ques", questionPojo.getQuestion());
		model.put("answer", questionPojo.getAnswer());
		List<String> resultWebContent = getWikiContent(questionPojo.getQuestion(), questionPojo.getQuesid());
		model.put("wiki", resultWebContent.get(0));
		model.put("google", resultWebContent.get(1));
		return "QuestionSuccess";
	}

	public QuestionDTO getQuestionPojo(String question) {
		return quesAnsService.getQuestionPojo(question);
	}

	public List<SearchEngineDTO> getSearchEnginePojo() {
		return quesAnsService.listSearchEngine();
	}

	public List<String> getWikiContent(String question, int quesid) {
		List<String> result = new ArrayList<String>();
		WebpageCrawer webpageCrawer = new WebpageCrawer();
		List<SearchEngineDTO> searchEnginePojos = quesAnsService.listSearchEngine();
		//System.out.println("search engine name :" + searchEnginePojos.toString());
		String keyword=null;
		List<SearchKeywordDTO> keywords=quesAnsService.listKeyword(quesid);
		//System.out.println("Keywords :"+keywords.toString());
		for (SearchEngineDTO searchEnginePojo : searchEnginePojos) {
			for(SearchKeywordDTO keys:keywords){
				if(keys.getSearchengineid()==searchEnginePojo.getSearchEngineId()){
					keyword=keys.getKeyword();
				}
			}
			//System.out.println("Search engine :" + searchEnginePojo.getSearchEngineName());
			if (searchEnginePojo.getSearchEngineName().equals("Wikipedia")) {
				String output = webpageCrawer.getSelectedContent(searchEnginePojo.getSearchEngineURL() +keyword,
						searchEnginePojo.getResultTag(), searchEnginePojo.getTagPosition());
				//System.out.println("Wiki output :" + output);
				result.add(output);
			}
			if (searchEnginePojo.getSearchEngineName().equals("Google")) {

				Gson gson = new Gson();
				List<LinkedHashMap<String,String>> map=null;
				Type collectionType = new TypeToken<Collection<LinkedHashMap<String,String>>>(){}.getType();
				// InetAddress IP = null;
				String IP = null;
				StringBuilder out=new StringBuilder();
				try {
					IP = new BufferedReader(
							new InputStreamReader(new URL("http://agentgatech.appspot.com").openStream())).readLine();
					// IP = InetAddress.getLocalHost();
					//System.out.println("My system IP :" + IP);
					String googleOutput = webpageCrawer.getDocument(
							"https://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=" + keyword + "&userip=" + IP)
							.html();
					//System.out.println("google URL :" + "https://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=" + question + "&userip=" + IP);
					//System.out.println("Google output:"+googleOutput);
					String googleresult=googleOutput.substring(googleOutput.indexOf("{\"results\":")+11, googleOutput.indexOf(",\"cursor\""));
					//System.out.println("After substring :"+googleresult);
					try{
						
						map = gson.fromJson(googleresult, collectionType);
					Iterator<LinkedHashMap<String, String>> mapIterator = map.iterator();
					
					while(mapIterator.hasNext()){
						LinkedHashMap<String,String> temp=mapIterator.next();
						String title=temp.get("title");
						String url=temp.get("url");
						String content=temp.get("content");
						out.append(title+"<br>"+content+" <a href="+url+" value=\"more\" alt=\"More\"><b>more Info</b></a><br><br>");
						//googleOutput+=title+"<br>"+content+"<a href="+url+">More>></a><br><br>";								
					}
					}
					catch(Exception e){
						System.out.println(e.getMessage());
					}
					//System.out.println("Output String :"+out.toString());
					result.add(out.toString());
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
		//System.out.println("Result ::" + result.toString());
		return result;
	}
}
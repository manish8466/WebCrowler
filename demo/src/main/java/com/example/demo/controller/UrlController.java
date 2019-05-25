package com.example.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.WebCrowlerService;

@RestController
public class UrlController {

@Autowired
private RestTemplate restTemplate;

@Autowired
private WebCrowlerService webCrowlerService;

private static final String  URL = "https://in.yahoo.com";

	
@GetMapping("/getUrlData") 	 
	public Set<String> getdata() {
	
		String result = restTemplate.getForObject(URL, String.class);
		return	webCrowlerService.getAllUrls(result);
//		int index = result.indexOf("href=");
//		result = result.substring(index);
//		String str = result.substring(0,result.indexOf("/>"));
//		if(str.contains(YAHOO))
//		set.add(str);
//		index= result.indexOf("/>");
//		while(index >= 0) {
//		    index = result.indexOf("href=", index+1);
//		    if(index >=0 && result.indexOf("/>",index) >=0) {
//		    str = result.substring(index,result.indexOf("/>",index));
//		    if(str.length()<50 && str.contains(YAHOO))
//		    set.add(str);
//		    index = result.indexOf("/>",index);
//		    }
//		}
//		return set;
		
	
		
	}
}

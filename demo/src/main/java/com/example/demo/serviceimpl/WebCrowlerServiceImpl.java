package com.example.demo.serviceimpl;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.example.demo.service.WebCrowlerService;

@Service
public class WebCrowlerServiceImpl implements WebCrowlerService {

	private static final String YAHOO = "yahoo";

	@Override
	public Set<String> getAllUrls(String result) {
		String urlStrTemp = null;
		Set<String> set = new HashSet<String>();
         set.add("https://in.yahoo.com");
		String regex = "href=\\\"(.*?)\\\"\"";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(result);
		while (m.find()) {
			String urlStr = m.group(1);
			urlStrTemp = urlStr.substring(0, urlStr.indexOf("\""));
			if (urlStrTemp.contains(YAHOO))
				set.add(urlStrTemp);
		}
		return set;
	}

}

package com.bashfan.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class OrganizationTurnover {
	
	
	@Value("#{fielddata}")
	private Map<String,String> fielddata;
	
	public Map<String, String> organizationTurnover() {
		Map<String, String> turnover = new LinkedHashMap<>();
		turnover.put("none", "-----Select-----");
		turnover.put("1000",	 "0-1000");
		turnover.put("10000", "1001-10000");
		return turnover;
	}
	
	public Map<String, String> fields(){
		return new TreeMap<String, String>(fielddata);
	}
}

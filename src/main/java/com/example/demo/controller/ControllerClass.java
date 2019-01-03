package com.example.demo.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerClass {


	

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public void addValues(@RequestBody HashMap<String,Object> hm) {
		//extract wR type from hash map received.
		String value = null;
		System.out.println(hm.toString());
		if(hm.containsKey("WorkRequestType"))
		{
			value=(String)hm.get("WorkRequestType");
			System.out.println("WorkRequestType: "+value);
		}
		
//		List<WorkRequestTypeMetaData> list=vr.findByWorkRequestType((String) value);
//		System.out.println(list);
		
		//get all the common format attr for that work req type
		
		//validate for :
		//1. mandatory fields (required or not)
		
	}
}

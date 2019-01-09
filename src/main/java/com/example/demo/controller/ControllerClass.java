package com.example.demo.controller;

import java.util.*;

import com.example.demo.exceptions.ValidationException;
import com.example.demo.model.Issue_Intake;
import com.example.demo.repos.IssueIntakeRepo;
import com.example.demo.service.CommonFormatAttributeValidationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass {
	
	@Autowired
	private CommonFormatAttributeValidationService validationService;

	@Autowired
	private IssueIntakeRepo issueIntakeRepo;

	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public IssueIntakeResponse processIssueIntake(@RequestBody HashMap<String,Object> hm) {

		//TODO: Generate better unique id
		String referenceId = String.valueOf(System.currentTimeMillis());
		//extract wR type from hash map received.
		String value = null;
		if(hm.containsKey("WorkRequestType"))
		{
			value=(String)hm.get("WorkRequestType");
		}


		try {
			HashMap validatedHashMap=validationService.validate(hm, value);
					////json
					String mapAsJson = null;
					try {
						mapAsJson = new ObjectMapper().writeValueAsString(validatedHashMap);
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        System.out.println(mapAsJson+"!!!!!!!!!!!!!!!!!!!");
			        //TODO:persist to DB here!!
			        issueIntakeRepo.save(new Issue_Intake(referenceId,mapAsJson));
			        //below code to convert from json to map.
			        JSONParser parser = new JSONParser();
			        try {

			        	System.out.println(issueIntakeRepo.findAllById(referenceId));

						JSONObject json = (JSONObject) parser.parse(issueIntakeRepo.findAllById(referenceId).getMappedJson());
						HashMap<String,Object> result =json;
						        
						System.out.println(result+"!!!!!!!!!!!!!!!!!!!");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					////endjson

		} catch (ValidationException e) {
			Errors[] err = new Errors[1];
			err[0] = new Errors(e.getMessage(),e.getAttributeName());
			return new IssueIntakeResponse(referenceId,err);
		}

		//TODO: Insert into DB
		System.out.println(referenceId+" is the reference ID. Validation successful.");
		return new IssueIntakeResponse(referenceId);
	}
}

package com.example.demo.controller;

import java.util.*;

import com.example.demo.exceptions.ValidationException;
import com.example.demo.model.Issue_Intake;
import com.example.demo.repos.IssueIntakeRepo;
import com.example.demo.service.CommonFormatAttributeValidationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONArray;
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

	@RequestMapping(value = "/processList", method = RequestMethod.POST)
	public List<IssueIntakeResponse> processIssueIntakeList(@RequestBody List<HashMap<String,Object>> hmlist) {
		List<IssueIntakeResponse> iirList=new ArrayList<>();
		for (HashMap<String,Object> hm:hmlist) {
			IssueIntakeResponse iir1=processIssueIntake(hm);
			iirList.add(iir1);
		}
		return iirList;
	}
	@RequestMapping(value = "/processAndSaveList", method = RequestMethod.POST)
	public List<IssueIntakeResponse> processIssueIntakeListPersist(@RequestBody List<HashMap<String,Object>> hmlist) {
		List<IssueIntakeResponse> iirList=new ArrayList<>();
		List<Issue_Intake> listallForSaving=new ArrayList<>();
		for (HashMap<String,Object> hm:hmlist) {
			IssueIntakeResponse iir1=processIssueIntake(hm);
			iirList.add(iir1);//for responce to postman

			listallForSaving.add(new Issue_Intake(iir1.getReferenceId(),toJson(hm)));
		}
		//save and return
		issueIntakeRepo.saveAll(listallForSaving);
		return iirList;
	}
	@RequestMapping(value = "/processAndSave", method = RequestMethod.POST)
	public IssueIntakeResponse processIssueIntakePersist(@RequestBody HashMap<String,Object> hm) {
		IssueIntakeResponse iir=processIssueIntake(hm);
//		saveIt(validatedHashMap,referenceId);
		saveIt(hm,iir.getReferenceId());
		return iir;
	}
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
		} catch (ValidationException e) {
			Errors[] err = new Errors[1];
			err[0] = new Errors(e.getMessage(),e.getAttributeName());
			return new IssueIntakeResponse(referenceId,err);
		}

		//TODO:DONE! Insert into DB
		System.out.println(referenceId+" is the reference ID. Validation successful.");
		return new IssueIntakeResponse(referenceId);
	}






	public void saveIt(HashMap validatedHashMap,String referenceId){
		//// mapped json persist
		String mapAsJson=toJson(validatedHashMap);
		//TODO:DONE!! persist to DB here!! SENDER who will persist in DB
		issueIntakeRepo.save(new Issue_Intake(referenceId,mapAsJson));
		//below code to convert from json to map.RECEIVER SIDE
		/*JSONParser parser = new JSONParser();
		try {
			System.out.println(issueIntakeRepo.findAllById(referenceId));
			JSONObject json = (JSONObject) parser.parse(issueIntakeRepo.findAllById(referenceId).getMappedJson());
			HashMap<String,Object> result =json;
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		////endjson
	}
	public String toJson(HashMap<String,Object> valiHashMap){
		String mapAsJson = null;
		try {
			mapAsJson = new ObjectMapper().writeValueAsString(valiHashMap);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return mapAsJson;
	}
}

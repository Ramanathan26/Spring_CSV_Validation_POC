package com.example.demo.controller;

import java.util.*;

import com.example.demo.exceptions.ValidationException;
import com.example.demo.service.CommonFormatAttributeValidationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass {
	
	@Autowired
	private CommonFormatAttributeValidationService validationService;

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

		//TODO: Insert into DB
		return new IssueIntakeResponse(referenceId);
	}
}

package com.example.demo.controller;

import java.util.*;


import com.example.demo.service.PopulatePojos;
import com.example.demo.service.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Standard_Object_Attributes;
import com.example.demo.model.Validation_Master;
import com.example.demo.model.Work_Request_Type_Master;
import com.example.demo.pojos.CommonFormatAttributeMetaData;
import com.example.demo.pojos.WorkRequestTypeMetaData;
import com.example.demo.repos.StandardObjAttrRepo;
import com.example.demo.repos.ValidationMasterRepo;
import com.example.demo.repos.WorkReqTypeMasterRepo;





@RestController
public class ControllerClass {
	
	@Autowired
	private WorkReqTypeMasterRepo workReqTypeMasterRepo;
	@Autowired
	private StandardObjAttrRepo standardObjAttrRepo;
	@Autowired
	private ValidationMasterRepo validationMasterRepo;
	
	@Autowired
	private PopulatePojos pojo;
	@Autowired
	private Validation validation;
	
	

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public void addValues(@RequestBody HashMap<String,Object> hm) {
		//extract wR type from hash map received.
		String value = null;
		System.out.println("hashmap received: "+hm.toString());
		if(hm.containsKey("WorkRequestType"))
		{
			value=(String)hm.get("WorkRequestType");
			//now wr type is received.
			System.out.println("WorkRequestType: "+value);
		}
		
		//
		
		WorkRequestTypeMetaData wrtypemetadata=pojo.getAttributesForWorkRequestType(value);
		System.out.println("pojos populated now.");
		//
		
		
		//
//		Validation validation=new Validation();
		HashMap validatedHashMap=validation.validate(hm, wrtypemetadata);
//		System.out.println(validatedHashMap.toString());
		//

	}
}

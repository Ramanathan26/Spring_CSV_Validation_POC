package com.example.demo.controller;

import java.util.*;


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
	
	

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public void addValues(@RequestBody HashMap<String,Object> hm) {
		//extract wR type from hash map received.
		String value = null;
		System.out.println(hm.toString());
		if(hm.containsKey("WorkRequestType"))
		{
			value=(String)hm.get("WorkRequestType");
			//now wr type is received.
			System.out.println("WorkRequestType: "+value);
		}
		
		//get all the common format attr for that work req type
		
		//first find out wr ID using the known wr type.
		Work_Request_Type_Master workReqTypeobj=workReqTypeMasterRepo.findByWork_Request_Type(value);
		int wid=workReqTypeobj.getId();
		boolean ignoreOtherAttr=workReqTypeobj.isIgnoreAditionalAttributes();
		//now we have wr id.
		
		
		List<CommonFormatAttributeMetaData> cfam=new ArrayList<CommonFormatAttributeMetaData>();
		List<Validation_Master> validationMasterlist=validationMasterRepo.findAllByWork_Request_Type_Id(wid);
		for (Validation_Master validation_Master : validationMasterlist) {
			Standard_Object_Attributes soa=validation_Master.getcF_Field();
			boolean isreq=validation_Master.getIs_Required();

			//construct CommonFormatAttributeMetaData object and add it to list cfam.
			cfam.add(new CommonFormatAttributeMetaData(soa.getCommon_Format_Field_Name(),isreq,null));

		}//now we have a list containing objects of CommonFormatAttributeMetaData type.
		
		
		
		//get values to populate WorkRequestTypeMetaData
		Object[] o=new Object[cfam.size()];//conversion form list to array
		CommonFormatAttributeMetaData[] wrtm= (CommonFormatAttributeMetaData[]) cfam.toArray();
		
		WorkRequestTypeMetaData wrtypemetadata = new WorkRequestTypeMetaData(value,wid,workReqTypeobj.isIgnoreAditionalAttributes(),wrtm);
		//using "wrtypemetadata" object created.. validate for mandatory fields.
		
		
		//validate for :
		//1. mandatory fields (required or not)
		//first we shall clone the map.
		HashMap hm2=(HashMap)hm.clone();
		hm2.remove(value);//remove the workreqtype key in the cloned one.
		//check if all the mandatory fields are present or not.
		for (CommonFormatAttributeMetaData commonFormatAttributeMetaData : wrtypemetadata.getAttributes()) {
			if (commonFormatAttributeMetaData.isRequired()) {
				boolean flag = hm2.containsKey(commonFormatAttributeMetaData.getAttributeName());
				if (flag == false) {
					System.out.println("mandatory field not present. throw error here");
					break;
				}
				hm2.remove(commonFormatAttributeMetaData.getAttributeName());
			}
			else{
				hm2.remove(commonFormatAttributeMetaData.getAttributeName());
			}


		}
		
		//2. check for ignore other fields (clone the akar map and use hashmap to find out left over ones and to do this we need all the entries in common attr table)
		//now we have leftover fields in cloned map.
		if(!ignoreOtherAttr&&hm2.size()>0){
			System.out.println("throwing exception");
			//throw new exception
		}
		else{
			System.out.println("nothing will be done as of now with the addln attr.");
		}
	}
}

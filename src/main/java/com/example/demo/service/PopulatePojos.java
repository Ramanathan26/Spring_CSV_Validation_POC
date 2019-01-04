package com.example.demo.service;

import com.example.demo.model.Standard_Object_Attributes;
import com.example.demo.model.Validation_Master;
import com.example.demo.model.Work_Request_Type_Master;
import com.example.demo.pojos.CommonFormatAttributeMetaData;
import com.example.demo.pojos.WorkRequestTypeMetaData;
import com.example.demo.repos.StandardObjAttrRepo;
import com.example.demo.repos.ValidationMasterRepo;
import com.example.demo.repos.WorkReqTypeMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PopulatePojos {

    @Autowired
    private WorkReqTypeMasterRepo workReqTypeMasterRepo;
    @Autowired
    private StandardObjAttrRepo standardObjAttrRepo;
    @Autowired
    private ValidationMasterRepo validationMasterRepo;

    public WorkRequestTypeMetaData getAttributesForWorkRequestType(String workRequestType) {
    //
    	//get all the common format attr for that work req type
		
    			//first find out wr ID using the known wr type.
    			Work_Request_Type_Master workReqTypeobj=workReqTypeMasterRepo.findByWork_Request_Type(workRequestType);
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

    WorkRequestTypeMetaData wrtypemetadata = new WorkRequestTypeMetaData(workRequestType,wid,workReqTypeobj.isIgnoreAditionalAttributes(),wrtm);
    //using "wrtypemetadata" object created.. validate for mandatory fields.
    //
    return wrtypemetadata;
	}
}

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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PopulatePojos {

    @Autowired
    private WorkReqTypeMasterRepo workReqTypeMasterRepo;
    @Autowired
    private StandardObjAttrRepo standardObjAttrRepo;
    @Autowired
    private ValidationMasterRepo validationMasterRepo;

    public WorkRequestTypeMetaData getAttributesForWorkRequestType(String workRequestType) {
    //
        // get all the common format attr for that work req type
        //first find out wr ID using the known wr type.
    	System.out.println(workRequestType);
        Work_Request_Type_Master workReqTypeobj=workReqTypeMasterRepo.findByWorkRequestType(workRequestType);
        int wid=workReqTypeobj.getwId();
        System.out.println("workreq id: "+wid);
        boolean ignoreOtherAttr=workReqTypeobj.getIgnoreAditionalAttributes();
        //now we have wr id.
    			
    	
        List<CommonFormatAttributeMetaData> cfam=new ArrayList<CommonFormatAttributeMetaData>();
        List<Validation_Master> validationMasterlist=validationMasterRepo.findAllByWorkRequestTypeId_wId(wid);//
		for (Validation_Master validation_Master : validationMasterlist) {
            Standard_Object_Attributes soa=validation_Master.getcFField();
            boolean isreq=validation_Master.isRequired();

            //construct CommonFormatAttributeMetaData object and add it to list cfam.
            cfam.add(new CommonFormatAttributeMetaData(soa.getCommonFormatFieldName(),isreq,null));

		}//now we have a list containing objects of CommonFormatAttributeMetaData type.
        System.out.println("list conatining the common format attr relating to that particular wr type"+cfam);


		//get values to populate WorkRequestTypeMetaData
//      Object[] o=new Object[cfam.size()];//conversion form list to array
        CommonFormatAttributeMetaData[] wrtm = cfam.toArray(new CommonFormatAttributeMetaData[cfam.size()]);
//        CommonFormatAttributeMetaData[] wrtm=(CommonFormatAttributeMetaData[]) cfam.toArray();

        WorkRequestTypeMetaData wrtypemetadata = new WorkRequestTypeMetaData(workRequestType,wid,workReqTypeobj.getIgnoreAditionalAttributes(),wrtm);
        //using "wrtypemetadata" object created.. validate for mandatory fields.
        //
        return wrtypemetadata;
	}
}

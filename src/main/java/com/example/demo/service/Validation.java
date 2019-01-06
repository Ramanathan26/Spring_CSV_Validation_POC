package com.example.demo.service;

import com.example.demo.model.Standard_Object_Attributes;
import com.example.demo.pojos.CommonFormatAttributeMetaData;
import com.example.demo.pojos.WorkRequestTypeMetaData;
import com.example.demo.repos.StandardObjAttrRepo;
import com.example.demo.repos.ValidationMasterRepo;
import com.example.demo.repos.WorkReqTypeMasterRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
@Service
public class Validation {
    @Autowired
    private WorkReqTypeMasterRepo workReqTypeMasterRepo;
    @Autowired
    private StandardObjAttrRepo standardObjAttrRepo;
    @Autowired
    private ValidationMasterRepo validationMasterRepo;



    private boolean flag;
    private boolean flag2;

    public HashMap validate(HashMap<String,Object> hm,WorkRequestTypeMetaData wrtypemetadata) {
        //
        //validate for :
        //1. mandatory fields (required or not)
        //first we shall clone the map.
        HashMap hm2 = (HashMap) hm.clone();
        //check if all the mandatory fields are present or not.


        ////////---------------experiment
        Set<String> keyset=hm2.keySet();
        ////////--------
        


        for (CommonFormatAttributeMetaData commonFormatAttributeMetaData : wrtypemetadata.getAttributes()) {
            if (commonFormatAttributeMetaData.isRequired()) {
            	////////--------
                for (String key : keyset) {
                    flag=key.startsWith(commonFormatAttributeMetaData.getAttributeName());
                    System.out.println(flag+" "+key);
                    if(flag==true){
                    	hm2.remove(key);//review
                    	keyset.remove(key);
                    	break;
                    }
                    
                }
                ////////---------------
//                flag = hm2.containsKey(commonFormatAttributeMetaData.getAttributeName());//uncomment
                if (flag == false) {
                    System.out.println("mandatory field not present. throw error here");
                    break;
                }
//                hm2.remove(commonFormatAttributeMetaData.getAttributeName());//uncomment
            }
            else {
                if (hm2.containsKey(commonFormatAttributeMetaData.getAttributeName())) {
                    hm2.remove(commonFormatAttributeMetaData.getAttributeName());
                }
            }


        }
        if (flag == true) {
            System.out.println("first validation done.");
        }
        boolean ignoreOtherAttr = wrtypemetadata.isIgnoreAdditionalAttributes();
        //2. check for ignore other fields (clone the akar map and use hashmap to find out left over ones and to do this we need all the entries in common attr table)
        //now we have leftover fields in cloned map.
        //see if known fields are there in these leftover fields.


        if (!ignoreOtherAttr) {
            //check for known attr.
            List<Standard_Object_Attributes> allAttrList = standardObjAttrRepo.findAll();
            //now we have all std attr list.
            String attrname;
            for (Standard_Object_Attributes standard_Object_Attributes : allAttrList) {
                attrname = standard_Object_Attributes.getCommonFormatFieldName();
                ////////--------
                for (String key : keyset) {
                    flag2= key.startsWith(attrname);
                    if (flag2 == true) {
                        hm2.remove(key);//review
                        keyset.remove(key);
                        break;
                    }
                }
                ////////---------------
//                flag2 = hm2.containsKey(attrname);
//                if (flag2 == true) {
//                    System.out.println("known field present.");
//                    hm2.remove(attrname);
//                }

            }

            System.out.println(hm2.size());
            //now we have unknown attr. what to do with it?
            if (!ignoreOtherAttr && hm2.size() > 0) {
                System.out.println("throwing exception");
                //throw new exception
            } else {
                System.out.println("nothing will be done as of now with the addln attr if present.");
            }
            //
            System.out.println(hm2.toString());//print the attributes which are unknown
            return hm;//return validated hash map.
        }
        else {
            System.out.println(hm2.toString());//
        	return hm;//return validated hashmap.
        }
    }
}

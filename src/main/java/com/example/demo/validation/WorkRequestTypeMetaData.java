package com.example.demo.validation;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WorkRequestTypeMetaData {

	@Id
	String workRequestType;
	int WorkRequestTypeId;
	boolean ignoreAdditionalAttributes;
	CommonFormatAttributeMetaData[] attributes;
	public WorkRequestTypeMetaData(String workRequestType, int workRequestTypeId, boolean ignoreAdditionalAttributes,
			CommonFormatAttributeMetaData[] attributes) {
		super();
		this.workRequestType = workRequestType;
		WorkRequestTypeId = workRequestTypeId;
		this.ignoreAdditionalAttributes = ignoreAdditionalAttributes;
		this.attributes = attributes;
	}
	public WorkRequestTypeMetaData()
	{
		
	}
	public String getWorkRequestType() {
		return workRequestType;
	}
	public void setWorkRequestType(String workRequestType) {
		this.workRequestType = workRequestType;
	}
	public int getWorkRequestTypeId() {
		return WorkRequestTypeId;
	}
	public void setWorkRequestTypeId(int workRequestTypeId) {
		WorkRequestTypeId = workRequestTypeId;
	}
	public boolean isIgnoreAdditionalAttributes() {
		return ignoreAdditionalAttributes;
	}
	public void setIgnoreAdditionalAttributes(boolean ignoreAdditionalAttributes) {
		this.ignoreAdditionalAttributes = ignoreAdditionalAttributes;
	}
	public CommonFormatAttributeMetaData[] getAttributes() {
		return attributes;
	}
	public void setAttributes(CommonFormatAttributeMetaData[] attributes) {
		this.attributes = attributes;
	}
	@Override
	public String toString() {
		return "WorkRequestTypeMetaData [workRequestType=" + workRequestType + ", WorkRequestTypeId="
				+ WorkRequestTypeId + ", ignoreAdditionalAttributes=" + ignoreAdditionalAttributes + ", attributes="
				+ Arrays.toString(attributes) + "]";
	}
	
	
	
	
	//WorkRequestTypeMetaData getAttributesForWorkRequestType(String WorkRequestType){
	
	
//}
}


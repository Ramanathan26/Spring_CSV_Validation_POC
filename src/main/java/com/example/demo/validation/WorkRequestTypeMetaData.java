package com.example.demo.validation;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class WorkRequestTypeMetaData {

	
	private String workRequestType;
	@Id
	private int WorkRequestTypeId;
	private boolean ignoreAdditionalAttributes;
	@OneToMany(cascade={CascadeType.ALL})
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="Attribute_Name", referencedColumnName="Attribute_Name")
	private List<CommonFormatAttributeMetaData> attributes;
	
	public WorkRequestTypeMetaData(String workRequestType, int workRequestTypeId, boolean ignoreAdditionalAttributes) {
		super();
		this.workRequestType = workRequestType;
		WorkRequestTypeId = workRequestTypeId;
		this.ignoreAdditionalAttributes = ignoreAdditionalAttributes;
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
	
	
	
	
	//WorkRequestTypeMetaData getAttributesForWorkRequestType(String WorkRequestType){
	
	
//}
}


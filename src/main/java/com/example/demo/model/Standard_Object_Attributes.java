package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Standard_Object_Attributes {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "my_seq_gen")
//	@SequenceGenerator(name = "my_seq_gen", sequenceName = "id_seq", allocationSize = 1)
	private int cId;
	private String commonFormatFieldName;
	
	
	
	
	
	
	
	public Standard_Object_Attributes()
	{
		
	}







	public int getcId() {
		return cId;
	}







	public void setcId(int cId) {
		this.cId = cId;
	}







	public String getCommonFormatFieldName() {
		return commonFormatFieldName;
	}







	public void setCommonFormatFieldName(String commonFormatFieldName) {
		this.commonFormatFieldName = commonFormatFieldName;
	}







	public Standard_Object_Attributes(int cId, String commonFormatFieldName) {
		super();
		this.cId = cId;
		this.commonFormatFieldName = commonFormatFieldName;
	}

	
	
}

package com.example.demo.validation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CommonFormatAttributeMetaData {

	@Id
	private String Attribute_Name;
	private boolean Is_required;
	private String DataType;
//	@ManyToOne
//	@JoinColumn(name="WorkRequestTypeId")
//	private WorkRequestTypeMetaData WR_Id;
	public CommonFormatAttributeMetaData(String attribute_Name, boolean is_required, String dataType /*WorkRequestTypeMetaData wR_Id*/) {
		super();
		Attribute_Name = attribute_Name;
		Is_required = is_required;
		DataType = dataType;
		//WR_Id = wR_Id;
	}
	public CommonFormatAttributeMetaData()
	{
		
	}
	public String getAttribute_Name() {
		return Attribute_Name;
	}
	public void setAttribute_Name(String attribute_Name) {
		Attribute_Name = attribute_Name;
	}
	public boolean isIs_required() {
		return Is_required;
	}
	public void setIs_required(boolean is_required) {
		Is_required = is_required;
	}
	public String getDataType() {
		return DataType;
	}
	public void setDataType(String dataType) {
		DataType = dataType;
	}
	/*public WorkRequestTypeMetaData getWR_Id() {
		return WR_Id;
	}
	public void setWR_Id(WorkRequestTypeMetaData wR_Id) {
		WR_Id = wR_Id;
	}
	@Override
	public String toString() {
		return "CommonFormatAttributeMetaData [Attribute_Name=" + Attribute_Name + ", Is_required=" + Is_required
				+ ", DataType=" + DataType + ", WR_Id=" + WR_Id + "]";
	}*/
	
}

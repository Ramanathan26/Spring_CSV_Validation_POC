package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Standard_Object_Mapping_Master {

	@Id
	private int C_Id;
	private String Common_Format_Field_Name;
	
	public Standard_Object_Mapping_Master()
	{
		
	}

	public Standard_Object_Mapping_Master(int c_id, String common_Format_Field_Name) {
		super();
		C_Id = c_id;
		Common_Format_Field_Name = common_Format_Field_Name;
	}

	public int getC_Id() {
		return C_Id;
	}

	public void setC_Id(int c_id) {
		C_Id = c_id;
	}

	public String getCommon_Format_Field_Name() {
		return Common_Format_Field_Name;
	}

	public void setCommon_Format_Field_Name(String common_Format_Field_Name) {
		Common_Format_Field_Name = common_Format_Field_Name;
	}

	@Override
	public String toString() {
		return "Standard_Object_Mapping_Master [Id=" + C_Id + ", Common_Format_Field_Name=" + Common_Format_Field_Name
				+ "]";
	}
	
}

package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Validation_Master {

	@Id
	private int Id;
	@OneToOne
	@JoinColumn(name="Id")
	private Standard_Object_Mapping_Master CF_Field_Id;
	@ManyToOne
	@JoinColumn(name="W_Id")
    private Work_Request_Type_Master Work_Request_Type_Id;
	private String Is_Required;
	
	public Validation_Master()
	{
		
	}

	public Validation_Master(int id, Standard_Object_Mapping_Master cF_Field_Id,
			Work_Request_Type_Master work_Request_Type_Id, String is_Required) {
		super();
		Id = id;
		CF_Field_Id = cF_Field_Id;
		Work_Request_Type_Id = work_Request_Type_Id;
		Is_Required = is_Required;
	}

	public int getW_Id() {
		return Id;
	}

	public void setW_Id(int id) {
		Id = id;
	}

	public Standard_Object_Mapping_Master getCF_Field_Id() {
		return CF_Field_Id;
	}

	public void setCF_Field_Id(Standard_Object_Mapping_Master cF_Field_Id) {
		CF_Field_Id = cF_Field_Id;
	}

	public Work_Request_Type_Master getWork_Request_Type_Id() {
		return Work_Request_Type_Id;
	}

	public void setWork_Request_Type_Id(Work_Request_Type_Master work_Request_Type_Id) {
		Work_Request_Type_Id = work_Request_Type_Id;
	}

	public String getIs_Required() {
		return Is_Required;
	}

	public void setIs_Required(String is_Required) {
		Is_Required = is_Required;
	}

	@Override
	public String toString() {
		return "Validation_Master [Id=" + Id + ", CF_Field_Id=" + CF_Field_Id + ", Work_Request_Type_Id="
				+ Work_Request_Type_Id + ", Is_Required=" + Is_Required + "]";
	}
	
}

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
	@JoinColumn(name="C_Id")
	private Standard_Object_Attributes CF_Field;
	@ManyToOne
	@JoinColumn(name="W_Id")
    private Work_Request_Type_Master Work_Request_Type_Id;
	private boolean Is_Required;
	
	
	
	
	
	
	public Validation_Master()
	{
		
	}

	public Validation_Master(int id, Standard_Object_Attributes cF_Field,
			Work_Request_Type_Master work_Request_Type_Id, boolean is_Required) {
		super();
		Id = id;
		CF_Field = cF_Field;
		Work_Request_Type_Id = work_Request_Type_Id;
		Is_Required = is_Required;
	}

	public int getW_Id() {
		return Id;
	}

	public void setW_Id(int id) {
		Id = id;
	}

	public Standard_Object_Attributes getcF_Field() {
		return CF_Field;
	}

	public void setcF_Field(Standard_Object_Attributes cF_Field) {
		CF_Field = cF_Field;
	}

	public Work_Request_Type_Master getWork_Request_Type_Id() {
		return Work_Request_Type_Id;
	}

	public void setWork_Request_Type_Id(Work_Request_Type_Master work_Request_Type_Id) {
		Work_Request_Type_Id = work_Request_Type_Id;
	}

	public boolean getIs_Required() {
		return Is_Required;
	}

	public void setIs_Required(boolean is_Required) {
		Is_Required = is_Required;
	}

	@Override
	public String toString() {
		return "Validation_Master [Id=" + Id + ", cF_Field=" + CF_Field + ", Work_Request_Type_Id="
				+ Work_Request_Type_Id + ", Is_Required=" + Is_Required + "]";
	}
	
}

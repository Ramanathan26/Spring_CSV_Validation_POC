package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Work_Request_Type_Master {

	@Id
	private int W_Id;
	private String Work_Request_Type;
	
	public Work_Request_Type_Master()
	{
		
	}

	public Work_Request_Type_Master(int w_id, String work_Request_Type) {
		super();
		W_Id = w_id;
		Work_Request_Type = work_Request_Type;
	}

	public int getId() {
		return W_Id;
	}

	public void setId(int id) {
		W_Id = id;
	}

	public String getWork_Request_Type() {
		return Work_Request_Type;
	}

	public void setWork_Request_Type(String work_Request_Type) {
		Work_Request_Type = work_Request_Type;
	}

	@Override
	public String toString() {
		return "Work_Request_Type_Master [Id=" + W_Id + ", Work_Request_Type=" + Work_Request_Type + "]";
	}
	
	
	
}

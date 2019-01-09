package com.example.demo.model;

public class Issue_Intake {

	private int Id;
	private String MappedJson;
	
	public Issue_Intake(int id, String mappedJson) {
		super();
		Id = id;
		MappedJson = mappedJson;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getMappedJson() {
		return MappedJson;
	}
	public void setMappedJson(String mappedJson) {
		MappedJson = mappedJson;
	}
	
	
}


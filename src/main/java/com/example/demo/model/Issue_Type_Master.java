package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Issue_Type_Master {

	@Id
	private int Id;
	private String Issue_Type;
	@ManyToOne
	@JoinColumn(name="F_Id")
	private File_Info File_Id;
	
	public Issue_Type_Master()
	{
		
	}

	public Issue_Type_Master(int id, String issue_Type, File_Info file_Id) {
		super();
		Id = id;
		Issue_Type = issue_Type;
		File_Id = file_Id;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getIssue_Type() {
		return Issue_Type;
	}

	public void setIssue_Type(String issue_Type) {
		Issue_Type = issue_Type;
	}

	public File_Info getFile_Id() {
		return File_Id;
	}

	public void setFile_Id(File_Info file_Id) {
		File_Id = file_Id;
	}

	@Override
	public String toString() {
		return "Issue_Type_Master [Id=" + Id + ", Issue_Type=" + Issue_Type + ", File_Id=" + File_Id + "]";
	}
	

}


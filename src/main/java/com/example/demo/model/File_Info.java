package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class File_Info {

	@Id
	private int F_Id;
	private String File_Name;
	
	
	
	public File_Info()
	{
		
	}
	
	public File_Info(int f_id, String file_Name) {
		super();
		F_Id = f_id;
		File_Name = file_Name;
	}
	public int getF_Id() {
		return F_Id;
	}
	public void setF_Id(int f_id) {
		F_Id = f_id;
	}
	public String getFile_Name() {
		return File_Name;
	}
	public void setFile_Name(String file_Name) {
		File_Name = file_Name;
	}

	@Override
	public String toString() {
		return "File_Info [Id=" + F_Id + ", File_Name=" + File_Name + "]";
	}
	
}

package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Axcis_Report_Column {

	@Id
	private int Id;
	private String columns;
	@ManyToOne
	@JoinColumn(name="F_Id")
	private File_Info File_Id;
	@OneToOne
	@JoinColumn(name="C_Id")
	private Standard_Object_Mapping_Master Mapping_Column;
	
	public Axcis_Report_Column()
	{
		
	}

	public Axcis_Report_Column(int id, String columns, File_Info file_Id, Standard_Object_Mapping_Master mapping_Column) {
		super();
		Id = id;
		this.columns = columns;
		File_Id = file_Id;
		Mapping_Column = mapping_Column;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getColumns() {
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	public File_Info getFile_Id() {
		return File_Id;
	}

	public void setFile_Id(File_Info file_Id) {
		File_Id = file_Id;
	}

	public Standard_Object_Mapping_Master getMapping_Column() {
		return Mapping_Column;
	}

	public void setMapping_Column(Standard_Object_Mapping_Master mapping_Column) {
		Mapping_Column = mapping_Column;
	}

	@Override
	public String toString() {
		return "Axcis_Report_Column [Id=" + Id + ", columns=" + columns + ", File_Id=" + File_Id + ", Mapping_Column="
				+ Mapping_Column + "]";
	}
	
	
	
}

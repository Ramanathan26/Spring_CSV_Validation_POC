package com.example.demo.validation;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CommonFormatAttributeMetaData {

	@Id
	String Attribute_Name;
	boolean Is_required;
	String DataType;
}

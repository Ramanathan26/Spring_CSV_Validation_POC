package com.example.demo.model;

import javax.persistence.*;

@Entity
public class StandardObjectMappingMaster {

//	@Id
//	private int cId;
//	private String commonFormatFieldName;



    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "common_format_field_name")
    private String commonFormatFieldName;


    public StandardObjectMappingMaster() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommonFormatFieldName() {
        return commonFormatFieldName;
    }

    public void setCommonFormatFieldName(String commonFormatFieldName) {
        this.commonFormatFieldName = commonFormatFieldName;
    }

}
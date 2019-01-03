package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.validation.CommonFormatAttributeMetaData;

@RepositoryRestResource(collectionResourceRel="values",path="values")
public interface CommonFormatRepo extends JpaRepository<CommonFormatAttributeMetaData,Integer>{

	
}

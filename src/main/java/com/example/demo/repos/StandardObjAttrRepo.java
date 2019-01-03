package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Standard_Object_Attributes;
@RepositoryRestResource
public interface StandardObjAttrRepo extends JpaRepository<Standard_Object_Attributes, Integer> {

}

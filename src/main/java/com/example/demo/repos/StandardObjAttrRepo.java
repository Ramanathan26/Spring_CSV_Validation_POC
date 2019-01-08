package com.example.demo.repos;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Standard_Object_Attributes;
import com.example.demo.model.Validation_Master;
//@RepositoryRestResource
@RepositoryRestResource(collectionResourceRel = "standardobjattrrepo", path = "standardobjattrrepo")
public interface StandardObjAttrRepo extends JpaRepository<Standard_Object_Attributes, Integer> {
    @Cacheable("standardobjectattributes")
	List<Standard_Object_Attributes> findAll();
}

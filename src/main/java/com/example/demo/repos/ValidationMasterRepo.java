package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Validation_Master;
@RepositoryRestResource
public interface ValidationMasterRepo extends JpaRepository<Validation_Master, Integer> {

	 List<Validation_Master> findAllByWork_Request_Type_Id(int wid);
		

}

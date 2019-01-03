package com.example.demo.repository;

import java.util.List;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;

import com.example.demo.validation.WorkRequestTypeMetaData;


public interface ValidationRepo extends JpaRepository<WorkRequestTypeMetaData,Integer>{

	//@RestResource()
	List<WorkRequestTypeMetaData> findByWorkRequestType(String workrequesttype);
}

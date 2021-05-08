package com.interview.crudtest.demo.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.interview.crudtest.demo.entity.Student;
import com.interview.crudtest.demo.persistance.StudentRepository;

@Service
public class StudentServiceImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    StudentRepository repository;

    
    @Transactional
    public Optional<Student> saveStudent(Student student){
    	LOGGER.debug("inside saveStudent:");
    	Student std = null;
    	try {
    		std = repository.save(student);
    	}catch(IllegalArgumentException ex) {
          LOGGER.error("Failed to save Employee Details as Employee data is NULL");
    	}
    	return Optional.ofNullable(std);
    }
    
    @Transactional
    public Student getStudentById(int id){
    	LOGGER.debug("inside getStudentById:");
    	Optional<Student> optional = null;
    	try {
    		optional = repository.findById(id);
    	}catch(IllegalArgumentException ex) {
          LOGGER.error("Failed to getstudentById");
    	}
    	return optional.orElseGet(Student::new);
    }

    @Transactional
	public List<Student> getAllStudents() {
		LOGGER.debug("inside getAllStudents:");
		List<Student> stdList = null;
		try {
		    stdList = repository.findAll();
		}catch(IllegalArgumentException ex) {
	          LOGGER.error("Failed to getAllStudentsL");
	    }
		return  CollectionUtils.isEmpty(stdList)?Collections.emptyList(): stdList;
	}
	
     @Transactional
     public void deleteStudent(int id) {
    	 LOGGER.debug("inside deleteStudent:");
    	 try {
		  repository.deleteById(id);
    	 }catch(IllegalArgumentException ex) {
    		 LOGGER.error("Failed to deleteStudent Details as Student is Not exist");
    	 } 
	}
     
     @Transactional
	public List<Student> getAllStudentsPerPage(int offset, int limit) {
 		LOGGER.debug("inside getAllStudents:");
 		List<Student> stdList = null;
 		try {
 		    Page<Student> stdPage = repository.findAll(PageRequest.of(offset, limit));
 		   stdList = stdPage.get().collect(Collectors.toList());
 		}catch(IllegalArgumentException ex) {
 	          LOGGER.error("Failed to getAllStudentsL");
 	    }
 		return  CollectionUtils.isEmpty(stdList)?Collections.emptyList(): stdList;
 	}

	public Optional<Student> updateStudent(int id,Student student) {
    	LOGGER.debug("inside updateStudent:");
    	Student resp = null;
    	try {
    		if(null!=student) {
    		Student std = repository.findById(id).get();
    		student.setId(std.getId());
    		repository.save(student);
    		}
    	}catch(IllegalArgumentException ex) {
          LOGGER.error("Failed to save Employee Details as Employee data is NULL");
    	}
    	return Optional.ofNullable(resp);
	}
	
	
}

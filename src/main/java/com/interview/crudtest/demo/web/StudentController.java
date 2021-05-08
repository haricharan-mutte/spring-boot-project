package com.interview.crudtest.demo.web;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interview.crudtest.demo.commonutils.ResponseDto;
import com.interview.crudtest.demo.commonutils.ResponseDtoWrapper;
import com.interview.crudtest.demo.commonutils.ResponseResource;
import com.interview.crudtest.demo.entity.Student;
import com.interview.crudtest.demo.service.StudentServiceImpl;
import com.interview.crudtest.utils.ResponseCodes;

@RestController
@RequestMapping(value = "/student-service")
public class StudentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentServiceImpl service;

	private static final String BASE_URI = "web/v1/student";

	@RequestMapping(value = "web/v1/student", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	ResponseEntity<ResponseDtoWrapper> addStudentDetails(@RequestBody Student student) {
		ResponseDtoWrapper responseDtoWrapper = new ResponseDtoWrapper();
		LOGGER.info("request in  addStudentDetails method");
		int id = service.saveStudent(student).get().getId();
		responseDtoWrapper.setMessages(new ResponseDto(id, ResponseCodes.SUCCESS.toString(), HttpStatus.CREATED));
		responseDtoWrapper.setData(new ResponseResource());
		Link selfRel = WebMvcLinkBuilder.linkTo(StudentController.class).slash(BASE_URI).slash(id)
				.withSelfRel();
		responseDtoWrapper.getMessages().setKeyId(id);
		responseDtoWrapper.getData().add(selfRel);
		return new ResponseEntity<>(responseDtoWrapper, HttpStatus.CREATED);
	}

	@RequestMapping(value = "web/v1/student/{id}")
	ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
		LOGGER.info("request in  getStudent::");
		Student resp = Optional.ofNullable(service.getStudentById(id)).get();
		if (null != resp)
			return new ResponseEntity<>(resp, HttpStatus.OK);
		else
			return new ResponseEntity<>(resp, HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "web/v1/student")
	ResponseEntity<List<Student>> findAllStudents() {
		LOGGER.info("request in  findAllStudents::");
		List<Student> resp = service.getAllStudents();
		if (null != resp && !resp.isEmpty())
			return new ResponseEntity<>(resp, HttpStatus.OK);
		else
			return new ResponseEntity<>(resp, HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "web/v1/student/{id}", method = RequestMethod.PUT)
	ResponseEntity<ResponseDtoWrapper> updateStudent(@PathVariable("id") int studentId, @RequestBody Student student) {
		ResponseDtoWrapper responseDtoWrapper = new ResponseDtoWrapper();
		LOGGER.info("request in  updateStudent method");
		service.updateStudent(studentId, student);
		responseDtoWrapper.setMessages(new ResponseDto(studentId, ResponseCodes.SUCCESS.toString(), HttpStatus.ACCEPTED));
		responseDtoWrapper.setData(new ResponseResource());
		Link selfRel = WebMvcLinkBuilder.linkTo(StudentController.class).slash(BASE_URI).slash(studentId)
				.withSelfRel();
		responseDtoWrapper.getMessages().setKeyId(studentId);
		responseDtoWrapper.getData().add(selfRel);
		return new ResponseEntity<>(responseDtoWrapper, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "web/v1/student/page")
	ResponseEntity<List<Student>> findAllStudentwithRange(@RequestParam("start") int start,
			@RequestParam("limit") int limit) {
		LOGGER.info("request in  findAllStudentwithRange method");
		List<Student> response = service.getAllStudentsPerPage(start, limit);
		if (null != response && !response.isEmpty())
			return new ResponseEntity<>(response, HttpStatus.OK);
		else
			return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "web/v1/student/{id}",method=RequestMethod.DELETE)
	ResponseEntity<Void> deleteById(@PathVariable("id") int id) {
		  LOGGER.info("request in  deleteById method");
		    service.deleteStudent(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

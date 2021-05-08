package com.interview.crudtest.demo.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.crudtest.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}

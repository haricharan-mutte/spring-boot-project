package com.interview.crudtest.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "STUDENT")
@Setter @Getter
public class Student implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3138335847722267019L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="ID")
    private int Id;

    @Column(name ="STUDENT_NAME")
    private String studentName;

    @Column(name ="AGE")
    private int age;
    
    @Column(name ="CLASS")
    private int studentClass;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}

	
}

package com.learnersacademy.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="studentID")
	private int studentId;
	
	@Column(name="studentName")
	private String studentName;
	
	@ManyToOne
	@JoinColumn(name = "class_id", referencedColumnName = "classID")
	private Class1 class1;
	
	
	public Class1 getClass1() {
		return class1;
	}

	public void setClass1(Class1 class1) {
		this.class1 = class1;
	}

	public Student() {
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}

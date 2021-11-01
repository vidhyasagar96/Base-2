package com.learnersacademy.modal;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "Class")
public class Class1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="classId")
	private int classId;
	
	@Column(name="className")
	private String className;
	
	@OneToMany(mappedBy = "class1")
    private List<Student> students;
	
	@OneToMany(mappedBy = "class1")
    private List<Teacher> teachers;
	
	@ManyToMany
	@JoinTable(
	  name = "subject_class",
	  joinColumns = @JoinColumn(name = "class_id", referencedColumnName = "classId"),
	  inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "subjectId")
	)
	private List<Subject> subjects;
	
	public Class1() {
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
}	

	
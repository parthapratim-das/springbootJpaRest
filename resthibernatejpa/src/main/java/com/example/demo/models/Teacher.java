package com.example.demo.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Teachers")
public class Teacher {

	@Id
	@Column(name="Teacher_Id")
	private int id;
	@Column(name="Name")
	private String tname;
	private String qualification;
	@ManyToOne
	@JsonIgnore
	private Department department;
	@ManyToMany(mappedBy = "teachers")
	@JsonIgnore
	private Set<Student> students;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getQualificaiton() {
		return qualification;
	}
	public void setQualificaiton(String qualification) {
		this.qualification = qualification;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}

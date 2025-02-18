package com.springdata_jpa.JPAProject.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jpa_student")
public class Student {
	@Id
	private Integer studentId;
	private String studentName;
	private String studentAbout;

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	private Laptop laptop;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Address> address = new ArrayList<>();

	public Student() {

	}

	public Student(Integer studentId, String studentName, String studentAbout, Laptop laptop, List<Address> address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAbout = studentAbout;
		this.laptop = laptop;
		this.address = address;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAbout() {
		return studentAbout;
	}

	public void setStudentAbout(String studentAbout) {
		this.studentAbout = studentAbout;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAbout=" + studentAbout;
	}

}

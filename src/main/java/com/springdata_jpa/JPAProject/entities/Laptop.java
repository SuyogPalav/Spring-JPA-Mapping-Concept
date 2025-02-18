package com.springdata_jpa.JPAProject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jpa_laptop")
public class Laptop {
	@Id
	private Integer laptopId;
	private String laptopName;
	private String laptopBrand;

	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;

	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Laptop(Integer laptopId, String laptopName, String laptopBrand, Student student) {
		super();
		this.laptopId = laptopId;
		this.laptopName = laptopName;
		this.laptopBrand = laptopBrand;
		this.student = student;
	}

	public Integer getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(Integer laptopId) {
		this.laptopId = laptopId;
	}

	public String getLaptopName() {
		return laptopName;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

	public String getLaptopBrand() {
		return laptopBrand;
	}

	public void setLaptopBrand(String laptopBrand) {
		this.laptopBrand = laptopBrand;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", laptopName=" + laptopName + ", laptopBrand=" + laptopBrand;
	}

}

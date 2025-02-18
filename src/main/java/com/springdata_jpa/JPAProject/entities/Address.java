package com.springdata_jpa.JPAProject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jpa_address")
public class Address {
	@Id
	private Integer addressId;
	private String street;
	private String city;
	private String country;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	public Address() {

	}

	public Address(Integer addressId, String street, String city, String country, Student student) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.country = country;
		this.student = student;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", country=" + country;
	}

}

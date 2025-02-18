package com.springdata_jpa.JPAProject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springdata_jpa.JPAProject.entities.Address;
import com.springdata_jpa.JPAProject.entities.Category;
import com.springdata_jpa.JPAProject.entities.Laptop;
import com.springdata_jpa.JPAProject.entities.Product;
import com.springdata_jpa.JPAProject.entities.Student;
import com.springdata_jpa.JPAProject.repositories.CategoryRepository;
import com.springdata_jpa.JPAProject.repositories.StudentRepository;

@SpringBootApplication
public class JpaProjectApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// ONE TO ONE Mapping

		Student student = new Student();
		student.setStudentId(2);
		student.setStudentName("Kushal");
		student.setStudentAbout("React Dev");

		Laptop laptop = new Laptop();
		laptop.setLaptopId(102);
		laptop.setLaptopName("DELL");
		laptop.setLaptopBrand("Inspiron");

		// Important Step, storing student in Laptop laptop.setStudent(student);
		student.setLaptop(laptop);

		studentRepository.save(student);

		Student studentData = studentRepository.findById(2).get();
		System.out.println(studentData);

		// Checking Bidirectional - Getting Laptop details from Student Table. Laptop
		Laptop laptopData = studentData.getLaptop();
		System.out.println(laptopData);

		// ONE TO MANY Mapping | MANY TO ONE Mapping

		Student student1 = new Student();
		student1.setStudentId(3);
		student1.setStudentName("Haribhajan");
		student1.setStudentAbout("Angu Dev");

		Address address1 = new Address();
		address1.setAddressId(201);
		address1.setStreet("swamin nagar");
		address1.setCity("Mumbai");
		address1.setCountry("IN");
		address1.setStudent(student1);

		Address address2 = new Address();
		address2.setAddressId(202);
		address2.setStreet("Ravi nagar");
		address2.setCity("Thane");
		address2.setCountry("PK");
		address2.setStudent(student1);

		List<Address> address = new ArrayList<>();
		address.add(address1);
		address.add(address2);

		student1.setAddress(address);
		studentRepository.save(student1);

		Student studentData1 = studentRepository.findById(3).get();
		System.out.println(studentData1);

		// Checking Bidirectional - Getting Many Address details from Student Table.
		List<Address> addressData = studentData1.getAddress();

		for (Address a : addressData)
			System.out.println(a);

		// MANY TO MANY Mapping | MANY TO MANY Mapping

		Category category1 = new Category();
		category1.setCid("1001");
		category1.setTitle("Electronics");

		Category category2 = new Category();
		category2.setCid("1002");
		category2.setTitle("Mobile Phones");

		Product product1 = new Product();
		product1.setpId("2001");
		product1.setProductName("Iphone 16");

		Product product2 = new Product();
		product2.setpId("2002");
		product2.setProductName("Samsung s24 ultra");

		Product product3 = new Product();
		product3.setpId("2003");
		product3.setProductName("Onida TV");

		List<Product> category1Product = new ArrayList<>();
		category1Product.add(product1);
		category1Product.add(product2);
		category1Product.add(product3);

		List<Product> category2Product = new ArrayList<>();
		category2Product.add(product1);
		category2Product.add(product2);

		category1.setProduct(category1Product);
		category2.setProduct(category2Product);

		System.out.println("HELOOOOOOOOOOOOO" + category1.getProduct());
		System.out.println("HELOOOOOOOOOOOOO" + category2.getProduct());

		categoryRepository.save(category1);
		categoryRepository.save(category2);

	}
}

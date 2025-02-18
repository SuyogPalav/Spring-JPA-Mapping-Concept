package com.springdata_jpa.JPAProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdata_jpa.JPAProject.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

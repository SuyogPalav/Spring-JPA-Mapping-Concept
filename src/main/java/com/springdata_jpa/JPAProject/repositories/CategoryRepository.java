package com.springdata_jpa.JPAProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdata_jpa.JPAProject.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {

}

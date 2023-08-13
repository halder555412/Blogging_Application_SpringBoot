package com.codewithsajal.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsajal.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}

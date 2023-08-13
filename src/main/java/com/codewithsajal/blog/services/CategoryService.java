package com.codewithsajal.blog.services;

import java.util.List;

import com.codewithsajal.blog.payloads.CategoryDto;

public interface CategoryService {
	//CREATE
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//UPDATE
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	//DELETE
	void deleteCategory(Integer categoryId);
	
	//GET->get all categories
	List<CategoryDto> getAllCategories();
	
	//GET->single categories
	CategoryDto getSingleCategory(Integer categoryId);
}

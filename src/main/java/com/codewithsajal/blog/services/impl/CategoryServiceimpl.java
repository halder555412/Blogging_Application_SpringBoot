package com.codewithsajal.blog.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithsajal.blog.entities.Category;
import com.codewithsajal.blog.exceptions.ResourceNotFoundexception;
import com.codewithsajal.blog.payloads.CategoryDto;
import com.codewithsajal.blog.repository.CategoryRepo;
import com.codewithsajal.blog.services.CategoryService;

@Service
public class CategoryServiceimpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = modelMapper.map(categoryDto, Category.class);
		Category savedcategory = categoryRepo.save(category);
		return modelMapper.map(savedcategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundexception("Category", "Category Id", categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCategory = categoryRepo.save(category);
		return modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundexception("Category", "Category Id", categoryId));
		categoryRepo.delete(category);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> categories = categoryRepo.findAll();
		List<CategoryDto> list_categories = categories.stream().map(cat->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return list_categories;
	}

	@Override
	public CategoryDto getSingleCategory(Integer categoryId) {
		Category category = categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundexception("Category", "Category Id", categoryId));
		return modelMapper.map(category, CategoryDto.class);
	}

}

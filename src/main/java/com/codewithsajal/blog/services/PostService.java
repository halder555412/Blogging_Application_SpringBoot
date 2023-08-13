package com.codewithsajal.blog.services;

import java.util.List;

import com.codewithsajal.blog.entities.Post;
import com.codewithsajal.blog.payloads.PostDto;
import com.codewithsajal.blog.payloads.PostResponse;

public interface PostService {
	//CREATE
	
	PostDto createPost(PostDto postDto,Integer categoryId,Integer userId);
	
	//UPDATE
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//DELETE
	void deletePost(Integer postId);
	
	//GET->single post
	
	PostDto	getPostById(Integer postId);
	
	//GET->all post
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	
	//GET->all post by category
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//GET->all post by user
	List<PostDto> getPostByUser(Integer userId);
	
	//searchPost
	List<PostDto>searchPosts(String keyword);
}

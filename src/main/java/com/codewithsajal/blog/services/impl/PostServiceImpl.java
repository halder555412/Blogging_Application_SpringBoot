package com.codewithsajal.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codewithsajal.blog.entities.Category;
import com.codewithsajal.blog.entities.Post;
import com.codewithsajal.blog.entities.User;
import com.codewithsajal.blog.exceptions.ResourceNotFoundexception;
import com.codewithsajal.blog.payloads.PostDto;
import com.codewithsajal.blog.payloads.PostResponse;
import com.codewithsajal.blog.repository.CategoryRepo;
import com.codewithsajal.blog.repository.PostRepo;
import com.codewithsajal.blog.repository.UserRepo;
import com.codewithsajal.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto,Integer categoryId,Integer userId) {
		
		User user=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundexception("User", "User Id", userId));
		
		Category category = categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundexception("Category", "Category Id", categoryId));
		
		Post post = modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post newPost = postRepo.save(post);
		return modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundexception("Post", "Post Id", postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		Post updatedPost = this.postRepo.save(post);
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundexception("Post", "postId", postId));
		postRepo.delete(post);
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundexception("Post", "postId", postId));
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir) {
		Sort sort=(sortDir.equalsIgnoreCase("asc"))?Sort.by(sortBy).ascending()
												  :Sort.by(sortBy).descending();
		
		Pageable p=PageRequest.of(pageNumber, pageSize, sort);
		
		Page<Post> pagePost = postRepo.findAll(p);
		List<Post> posts = pagePost.getContent();
		List<PostDto> postDtos = posts.stream().map(post->modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		PostResponse postResponse=new PostResponse();
		
		postResponse.setContent(postDtos);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());
		return postResponse;
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundexception("Category", "Category Id", categoryId));
		List<Post> posts = this.postRepo.findByCategory(category);
		return posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundexception("User", "UserId", userId));
		List<Post> posts = this.postRepo.findByUser(user);
		return posts.stream().map(post->modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		List<Post> posts = postRepo.findByTitle("%"+keyword+"%");
		List<PostDto> postDtos = posts.stream().map(post->modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

}

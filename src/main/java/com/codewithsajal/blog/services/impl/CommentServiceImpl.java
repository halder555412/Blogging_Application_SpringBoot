package com.codewithsajal.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithsajal.blog.entities.Comment;
import com.codewithsajal.blog.entities.Post;
import com.codewithsajal.blog.entities.User;
import com.codewithsajal.blog.exceptions.ResourceNotFoundexception;
import com.codewithsajal.blog.payloads.CommentDto;
import com.codewithsajal.blog.repository.CommentRepo;
import com.codewithsajal.blog.repository.PostRepo;
import com.codewithsajal.blog.repository.UserRepo;
import com.codewithsajal.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId,Integer userId) {
		Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundexception("Post", "Post Id", postId));
		
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundexception("User", "User Id", userId));
		Comment comment = modelMapper.map(commentDto, Comment.class);
		
		comment.setUser(user);
		comment.setPost(post);
		
		commentRepo.save(comment);
		return modelMapper.map(comment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundexception("Comment", "Comment Id", commentId));
		commentRepo.delete(comment);
	}

}

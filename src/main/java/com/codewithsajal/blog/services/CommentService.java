package com.codewithsajal.blog.services;

import com.codewithsajal.blog.payloads.CommentDto;

public interface CommentService {
	
	//CREATE
	CommentDto createComment(CommentDto commentDto,Integer postId,Integer userId);
	
	//DELETE
	void deleteComment(Integer commentId);

}

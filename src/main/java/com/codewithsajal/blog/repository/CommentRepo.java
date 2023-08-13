package com.codewithsajal.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsajal.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}

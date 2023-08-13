package com.codewithsajal.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codewithsajal.blog.entities.Category;
import com.codewithsajal.blog.entities.Post;
import com.codewithsajal.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	//List<Post> findByTitleContaining(String title);//It will work though
	
	@Query("select p from Post p where p.title like :key")
	List<Post> findByTitle(@Param("key") String title);
}

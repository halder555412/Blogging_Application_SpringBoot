package com.codewithsajal.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codewithsajal.blog.repository.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepo userRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testRepo() {
		String className = userRepo.getClass().getName();
		Package packageName = userRepo.getClass().getPackage();
		System.out.println(className);
		System.out.println(packageName);
	}

}

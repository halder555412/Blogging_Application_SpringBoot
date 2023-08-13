package com.codewithsajal.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogAppApisApplication /*implements CommandLineRunner*/{

//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMaper() {
		return new ModelMapper();
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(passwordEncoder.encode("456"));
//		System.out.println(passwordEncoder.encode("789"));
//		
//	}

}

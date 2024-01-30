package com.springboot.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringbootBlogRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogRestApiApplication.class, args);
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		
		System.out.println("arman ::" +  bc.encode("arman"));
		System.out.println("admin ::" +  bc.encode("admin"));
	}

}

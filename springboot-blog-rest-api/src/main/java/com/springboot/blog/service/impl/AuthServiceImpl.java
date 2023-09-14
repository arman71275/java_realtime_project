
package com.springboot.blog.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.blog.dto.LoginDto;
import com.springboot.blog.dto.RegisterDto;
import com.springboot.blog.entity.Role;
import com.springboot.blog.entity.User;
import com.springboot.blog.exception.BlogAPIException;
import com.springboot.blog.repository.RoleRepository;
import com.springboot.blog.repository.UserRepository;
import com.springboot.blog.security.JwtTokenProvider;
import com.springboot.blog.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Override
	public String login(LoginDto loginDto) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtTokenProvider.generateToken(authentication);

		return token;
	}

	@Override public String register(RegisterDto registerDto) {
	  
	  // check for email exists in database
		
		if(userRepository.existsByemail(registerDto.getEmail())) { throw new
	  BlogAPIException(HttpStatus.BAD_REQUEST, "Email already registered.");
		}
		
	  //check for usernme exists in database
	  
		if(userRepository.existsByUsername(registerDto.getUsername())) { throw new
	  BlogAPIException(HttpStatus.BAD_REQUEST, "User name already registered."); }
	  
	  
	  User user = new User();
	  user.setName(registerDto.getName());
	  user.setUsername(registerDto.getUsername());
	  user.setEmail(registerDto.getEmail());
	  user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
	  
	  Set<Role> roles = new HashSet<>(); 
	  Role userRole = roleRepository.findByName("ROLE_USER").get();
	  roles.add(userRole);
      user.setRoles(roles); 
      System.out.println("user"+ registerDto.getEmail());
	  userRepository.save(user);
	  
	  return "user registerd successfully!"; }

}

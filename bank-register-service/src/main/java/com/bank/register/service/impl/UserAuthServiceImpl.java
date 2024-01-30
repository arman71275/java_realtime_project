package com.bank.register.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bank.register.dto.LoginDto;
import com.bank.register.dto.RegisterFormDto;
import com.bank.register.entity.Role;
import com.bank.register.entity.UserEntity;
import com.bank.register.repository.RoleRepository;
import com.bank.register.repository.UserRepository;
import com.bank.register.service.UserAuthService;

@Service
public class UserAuthServiceImpl implements UserAuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;

	 @Autowired
	 private AuthenticationManager authentictionManager;
	 
	@Override
	public String register(RegisterFormDto registerFormDto) {
		Optional<UserEntity> findByUsername = userRepository.findByUsername(registerFormDto.getUsername());

		if (findByUsername.isPresent()) {
			return "Email already exists";
		}

		UserEntity user = new UserEntity();
		user.setFirstName(registerFormDto.getFirstName());
		user.setLastName(registerFormDto.getLastName());
		user.setEmail(registerFormDto.getEmail());
		user.setMobileNo(registerFormDto.getMobileNo());
		user.setUsername(registerFormDto.getUsername());
		user.setPassword(bCryptPasswordEncoder.encode(registerFormDto.getPassword()));
		

		Set<Role> roles = new HashSet<>();
		Role findRole = roleRepository.findByRoleName("USER_ROLE");
		roles.add(findRole);
		user.setRoles(roles);
System.out.println("findRole::" + findRole.toString());
		userRepository.save(user);

		return "user registered successfully..";
	}

	@Override
	public String login(LoginDto loginDto) {
		Authentication authentication = authentictionManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
	// Store authentication Object in SecurityContextHolder
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "User Logged in successfully!";
	}

}

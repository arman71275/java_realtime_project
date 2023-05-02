package com.registraion.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registraion.demo.entity.UserDetail;


public interface UserRepository extends JpaRepository<UserDetail, Long> {

	UserDetail findByEmail(String email);

	UserDetail findByEmailAndUserPwd(String email, String password);

	//public List<UserDetail> find(String email);
}

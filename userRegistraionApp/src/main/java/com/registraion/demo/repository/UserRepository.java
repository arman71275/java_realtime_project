package com.registraion.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registraion.demo.entity.UserDetail;

@Repository
public interface UserRepository extends JpaRepository<UserDetail, Long> {

	//public List<UserDetail> find(String email);
}

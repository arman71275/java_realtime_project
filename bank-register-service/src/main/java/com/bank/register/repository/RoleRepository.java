package com.bank.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.register.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	 Role findByRoleName(String roleName);
}

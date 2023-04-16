package com.phonebook.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phonebook.demo.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
//select * from CONTACT_DTLS where active_sw=:status
	public List<Contact> findByActiveSw(String status);

}

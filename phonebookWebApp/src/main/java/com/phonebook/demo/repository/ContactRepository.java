package com.phonebook.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phonebook.demo.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}

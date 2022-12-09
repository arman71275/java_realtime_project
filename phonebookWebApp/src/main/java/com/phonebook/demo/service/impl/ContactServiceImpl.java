package com.phonebook.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.demo.entity.Contact;
import com.phonebook.demo.repository.ContactRepository;
import com.phonebook.demo.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	public ContactRepository contactRepository;

	@Override
	public Contact saveContact(Contact contact) {
		return contactRepository.save(contact);
		 
	}

	@Override
	public List<Contact> getAllContact() {
		return contactRepository.findAll();
		 
	}

	@Override
	public String updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteContact(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

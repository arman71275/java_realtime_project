package com.phonebook.demo.service;

import java.util.List;

import com.phonebook.demo.entity.Contact;

public interface ContactService {
	
	public Contact saveContact(Contact contact);
	public List<Contact> getAllContact();
	public String updateContact(Contact contact);
	public String deleteContact(Long id);
	
}

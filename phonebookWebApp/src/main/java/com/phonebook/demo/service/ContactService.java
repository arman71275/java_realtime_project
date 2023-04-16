package com.phonebook.demo.service;

import java.util.List;

import com.phonebook.demo.entity.Contact;

public interface ContactService {
	
	public String saveContact(Contact contact);// form data input
	public List<Contact> getAllContact();
	public Contact getContact(Long contactId);
	public String updateContact(Contact contact); //form data input
	public String deleteContact(Long contactId);
	
	
}

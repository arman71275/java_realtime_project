package com.phonebook.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.demo.entity.Contact;
import com.phonebook.demo.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	public ContactService contactService;

	@PostMapping("/saveContact")
	public Contact saveContact(@RequestBody Contact contact) {
		return contactService.saveContact(contact);

	}

	@GetMapping("getContact")
	public List<Contact> findAllContact() {
		List<Contact> contactList = contactService.getAllContact();
		return contactList;
	}

}

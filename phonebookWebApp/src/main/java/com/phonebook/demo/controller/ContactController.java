package com.phonebook.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.demo.entity.Contact;
import com.phonebook.demo.exception.ApiError;
import com.phonebook.demo.repository.ContactRepository;
import com.phonebook.demo.service.ContactService;

@RestController
@RequestMapping("/contact/")
public class ContactController {

	@Autowired
	public ContactService contactService;

	@PostMapping("/save")
	public String saveContact(@RequestBody Contact contact) {
		return contactService.saveContact(contact);

	}

	@GetMapping("get")
	public List<Contact> findAllContact() {
		List<Contact> contactList = contactService.getAllContact();
		return contactList;
	}

	@GetMapping("/get/{contactId}")
	public Contact findById(@PathVariable Long contactId) {
		return contactService.getContact(contactId);

	}

	@PutMapping("update")
	public ResponseEntity<String> updateCountry(@RequestBody Contact contact) throws NotFoundException {
		String updatedContact = contactService.updateContact(contact);
		return ResponseEntity.ok().body(updatedContact);
	}

	@DeleteMapping("delete/{contactId}")
	public String deleteContact(@PathVariable Long contactId) {
		return contactService.deleteContact(contactId);
	}
	
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception e) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(), e.getMessage(), new Date());
        return new ResponseEntity<ApiError>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

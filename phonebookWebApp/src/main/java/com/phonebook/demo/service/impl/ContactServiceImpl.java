package com.phonebook.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.demo.entity.Contact;
import com.phonebook.demo.exception.AccountNotFoundexception;
import com.phonebook.demo.repository.ContactRepository;
import com.phonebook.demo.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	public ContactRepository contactRepository;

	@Override
	public String saveContact(Contact contact) {
		contactRepository.save(contact);
		
		if (contact.getContactId() != 0) {
			
			return "Record saved successfully..";
		} else
			return "Contact Failed to Save";

	}

	@Override
	public List<Contact> getAllContact() {
//		return contactRepository.findAll();
return contactRepository.findByActiveSw("Y");
	}

	@Override
	public Contact getContact(Long contactId) {
		Optional<Contact> getcontactById = contactRepository.findById(contactId);
		
		if (getcontactById.isPresent()) {
			return getcontactById.get();
		}else {
		 throw new AccountNotFoundexception("User Account Not found");
		}
	}

	@Override
	public String updateContact(Contact contact) {
		if (contactRepository.existsById(contact.getContactId())) {
			contactRepository.save(contact);
			return "Record Updated";
		}else
		return  "Id "+ contact.getContactId()+ " Record Not found..";
	}

	@Override
	public String deleteContact(Long contactId) {
		/*
		 * if(contactRepository.existsById(contactId)) {
		 * contactRepository.deleteById(contactId); return "Record Deleted.."; }else
		 * return "No Record Found";
		 */
		Optional<Contact> findById = contactRepository.findById(contactId);
	if(findById.isPresent()) {
		Contact contact = findById.get();
		contact.setActiveSw("N");
		contactRepository.save(contact);
		return "Record Deleted..";		
}else {
	return "No Record Foundd!!";
}
	}

}

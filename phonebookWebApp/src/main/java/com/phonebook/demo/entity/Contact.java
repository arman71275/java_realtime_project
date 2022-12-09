package com.phonebook.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
	@Id
	@GeneratedValue
	long contactId;
	String contactName;
	String contactEmail;
	long contactNo;

}

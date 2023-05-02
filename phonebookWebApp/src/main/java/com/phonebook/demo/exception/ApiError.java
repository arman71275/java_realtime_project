package com.phonebook.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ApiError {
	private Integer errorCode;
	private String errorDesc;
	private Date date;

}

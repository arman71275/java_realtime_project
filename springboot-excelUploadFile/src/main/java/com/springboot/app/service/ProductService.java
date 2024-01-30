package com.springboot.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.app.entity.Product;

public interface ProductService {

	void fileUpload(MultipartFile file);

}

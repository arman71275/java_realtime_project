package com.springboot.app.controller;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.app.entity.Product;
import com.springboot.app.helper.ExcelHelper;
import com.springboot.app.repository.ProductRepository;
import com.springboot.app.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/upload")
	public ResponseEntity<?> uploadProductExcelFile(@RequestParam("file") MultipartFile file) {
		
		if(ExcelHelper.checkExcelFormat(file)) {
		this.productService.fileUpload(file);
		
		
		return ResponseEntity.ok("File is uploaded and data is saved to db");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file..");

	}

}

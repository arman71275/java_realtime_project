package com.springboot.app.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.asn1.cmc.GetCert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.app.controller.ProductController;
import com.springboot.app.entity.Product;
import com.springboot.app.helper.ExcelHelper;
import com.springboot.app.repository.ProductRepository;
import com.springboot.app.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void fileUpload(MultipartFile file) {
		log.info("Request inside fileUpload Service classs.." + "with file: " + file.getOriginalFilename());
		
		try {
			List<Product> listOfProduct = ExcelHelper.convertExcelToListOfProduct(file.getInputStream());
			System.out.println("listOfProductServiceImpl::" +listOfProduct );
			productRepository.saveAll(listOfProduct);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	
}

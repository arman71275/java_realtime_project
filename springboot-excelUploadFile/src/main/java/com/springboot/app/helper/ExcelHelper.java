package com.springboot.app.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.app.entity.Product;

public class ExcelHelper {

	public static boolean checkExcelFormat(MultipartFile file) {

		String contentType = file.getContentType();

		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else
			return false;
	}

	public static List<Product> convertExcelToListOfProduct(InputStream is) {

		List<Product> list = new ArrayList<>();

		try {
			XSSFWorkbook workbook = new XSSFWorkbook(is);
 System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
			XSSFSheet sheet = workbook.getSheet("Sheet1");

			int rowNumber = 0;

			Iterator<Row> iterator = sheet.iterator();
			while (iterator.hasNext()) {
				Row row = iterator.next();

				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cells = row.iterator();

				int cid = 0;
				Product p = new Product();
				while (cells.hasNext()) {

					Cell cell = cells.next();
					System.out.println("cell::" + cell);
					
					if(cell.getCellType()==CellType.BLANK) {
						 cell.setCellValue(0);
					}

					switch (cid) {

					case 0:
						p.setSerialNo((long) cell.getNumericCellValue());
						break;

					
					case 1:
						p.setDate(cell.getDateCellValue());
						break;
						
					case 2:
						p.setCustomerName(cell.getStringCellValue());
						break;

					case 3:
						p.setMobileNo((long) cell.getNumericCellValue());
						break;

					case 4:
						p.setChasisNo(cell.getStringCellValue());
						break;

					case 5:
						p.setRegistrationNo(cell.getStringCellValue());
						break;
					case 6:
						p.setRtoOffice(cell.getStringCellValue());
						break;
					default:
						
						break;
					}
					cid++;
				}
				list.add(p);

			}
	       

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		

	}

	/*
	 * private static String getCellValue(XSSFCell cell) {
	 * 
	 * switch (cell.getCellType()) { case NUMERIC: return
	 * String.valueOf(cell.getNumericCellValue()); case STRING: return
	 * cell.getStringCellValue(); default: return cell.getStringCellValue();
	 * 
	 * }
	 * 
	 * }
	 */

}





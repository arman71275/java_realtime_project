package com.jrtp.report.service;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.jrtp.report.binding.SearchRequest;
import com.jrtp.report.entity.CitizenPlan;
import com.jrtp.report.repository.CitizenPlanRepository;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepository citizenPlanRepository;

	@Override
	public List<String> getPlanNames() {
		return citizenPlanRepository.getPlanNames();

	}

	@Override
	public List<String> getPlanStatuses() {
		return citizenPlanRepository.getPlanStatuses();
	}

	@Override
	public List<CitizenPlan> getCitizenPlans(SearchRequest searchRequest) {
		CitizenPlan entity = new CitizenPlan();
		
		if(searchRequest.getPlanName()!=null && !searchRequest.getPlanName().equals("")) {
			entity.setPlanName(searchRequest.getPlanName());
		}
		
		if(searchRequest.getPlanStatus()!=null && !searchRequest.getPlanStatus().equals("")) {
			entity.setPlanStatus(searchRequest.getPlanStatus());
		}
		
		if(searchRequest.getGender()!=null &&!searchRequest.getGender().equals("")) {
			entity.setGender(searchRequest.getGender());
		}
		
		//Prepares Dynamic query for search filter
		Example<CitizenPlan> example = Example.of(entity);
		
		List<CitizenPlan> record = citizenPlanRepository.findAll(example);
		
		return record;
	}

	@Override
	public void exportExcel(HttpServletResponse response)  throws Exception{
		
		//workbook, sheet, row , cell
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("citizens Info");
		XSSFRow headerRow = sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Name");
		headerRow.createCell(2).setCellValue("Email");
		headerRow.createCell(3).setCellValue("Mobile");
		headerRow.createCell(4).setCellValue("Gender");
		headerRow.createCell(5).setCellValue("SSN");
		headerRow.createCell(6).setCellValue("Plan Name");
		headerRow.createCell(7).setCellValue("Plan Status");
		
		List<CitizenPlan> citizenPlans = citizenPlanRepository.findAll();
		
		int dataRowIndex = 1;
		
		for(CitizenPlan record : citizenPlans) {
			XSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(record.getCid());
			dataRow.createCell(1).setCellValue(record.getCname());
			dataRow.createCell(2).setCellValue(record.getEmail());
			dataRow.createCell(3).setCellValue(record.getSsn());
			dataRow.createCell(4).setCellValue(record.getGender());
			dataRow.createCell(5).setCellValue(record.getMobileNo());
			dataRow.createCell(6).setCellValue(record.getPlanName());
			dataRow.createCell(7).setCellValue(record.getPlanStatus());
			dataRowIndex++;
			System.out.println(record);
		}
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}

	@Override
	public void exportPdf(HttpServletResponse response) throws DocumentException, IOException {
				
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(16);
		font.setColor(Color.blue);
		           //Paragraph
		Paragraph p = new Paragraph("Citizens Plan Info", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		
		document.add(p);
		           //pdf table
		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] {1.5f,3.5f,3.0f,2.0f,1.5f,2.0f});
		table.setSpacingBefore(10);
		
		        //set table header data
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(6);
		
		Font headerFont = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);
		
		cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase ("Name",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("SSN",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Gender", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Plan Name", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Plan status", font));
		table.addCell(cell);

		        //set table data
		List<CitizenPlan> allRecords = citizenPlanRepository.findAll();

		for (CitizenPlan record : allRecords) {
			table.addCell(String.valueOf(record.getCid()));
			table.addCell(record.getCname());
			table.addCell(String.valueOf(record.getSsn()));
			table.addCell(record.getGender());
			table.addCell(record.getPlanName());
			table.addCell(record.getPlanStatus());
		}
		document.add(table);
		document.close();
	}

}

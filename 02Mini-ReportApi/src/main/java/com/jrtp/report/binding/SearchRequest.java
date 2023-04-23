package com.jrtp.report.binding;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;
@Data
public class SearchRequest {
	private String planName;
	private String planStatus;
	private String gender;
	private LocalDate startDate;
	private Date endDate;
	
	

}

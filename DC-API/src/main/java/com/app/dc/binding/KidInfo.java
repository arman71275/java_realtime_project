package com.app.dc.binding;

import java.util.List;

import lombok.Data;

@Data
public class KidInfo {
	private List<KidDetailsDto> kids;
	
	private long caseNumber;

}

package com.app.dc.binding;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanSelectionDto{
	private long caseNum;                //To take request
	private long planId;                   //PlanSelctionRequest
	
	private Map<Integer, String> planInfo;  //To return UI response map
	                                        //PlanSelectionResponse

}

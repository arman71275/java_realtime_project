package com.app.dc.binding;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlanSelectionDto {
	private long appId;
	private List<String> planName;
}

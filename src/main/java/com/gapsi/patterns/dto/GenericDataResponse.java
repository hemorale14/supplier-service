package com.gapsi.patterns.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenericDataResponse {
	private String code;
	private Object message;
	private Object detail;
}

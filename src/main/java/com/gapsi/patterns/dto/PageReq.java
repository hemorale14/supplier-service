package com.gapsi.patterns.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageReq {
	@Min(1)
	private Integer pageNumber;
	@Min(1)
	private Integer pageSize;
	
	public Integer getPageNumber() {
		return pageNumber-1;
	}
}

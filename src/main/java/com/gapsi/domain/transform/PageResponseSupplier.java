package com.gapsi.domain.transform;

import org.springframework.data.domain.Page;

import com.gapsi.patterns.dto.Metadata;
import com.gapsi.patterns.dto.PageResponse;
import com.gapsi.patterns.dto.PaginationResponse;
import com.gapsi.patterns.dto.Supplier;
import com.gapsi.patterns.interpreter.Interpreter;

public class PageResponseSupplier implements
Interpreter<Page<Supplier>, PaginationResponse<Supplier>> {

	@Override
	public PaginationResponse<Supplier> interpret(Page<Supplier> input) {
		int currentPage = input.getNumber() + 1;
		int tempSize = input.getSize() * currentPage;
		long from = input.isEmpty() ? 0 : input.isFirst() ? 1 : (tempSize + 1) - input.getSize();
		long to = input.isEmpty() ? 0 : input.isLast() ? input.getTotalElements() : tempSize;
		final Metadata metadata = new Metadata(
				new PageResponse(currentPage, input.getSize(), from, to, input.getTotalPages(), input.isLast()));

		return new PaginationResponse<>(metadata, input.getContent());
	}

}

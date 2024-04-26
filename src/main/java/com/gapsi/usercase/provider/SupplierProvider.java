package com.gapsi.usercase.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.gapsi.domain.exception.ApplicationException;
import com.gapsi.domain.transform.PageResponseSupplier;
import com.gapsi.patterns.dto.GenericDataResponse;
import com.gapsi.patterns.dto.PageReq;
import com.gapsi.patterns.dto.PaginationResponse;
import com.gapsi.patterns.dto.Supplier;
import com.gapsi.patterns.interpreter.Interpreter;
import com.gapsi.repositoy.SupplierPagingAndSortingRepository;
import com.gapsi.repositoy.SupplierRepository;

@Component
public class SupplierProvider {
	
	@Autowired
	private SupplierRepository repository;
	
	@Autowired
	private SupplierPagingAndSortingRepository SpsRepository;
	
	public Supplier create(Supplier supplier) throws ApplicationException {
		if(getSupplierByCompanyName(supplier.getCompanyName()) == null) {
			return repository.save(supplier);
		}
		throw new ApplicationException("Ya existe un proveedor con esta razon social");
	}
	
	public Supplier getSupplierByCompanyName(String companyName) {
		return repository.findByCompanyName(companyName);
	}
	
	
	public Supplier getSupplierById(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public GenericDataResponse deleteSupplierById(Integer id) {
		repository.deleteById(id);
		return GenericDataResponse.builder().code("200").message("Ejecución satisfactoria")
				.detail(String.format("Se realizo la eliminación con Id %s", id)).build();
	}
	
	public List<Supplier> getAllSupplier() {
		return (List<Supplier>) repository.findAll();
	}
	
	public PaginationResponse<Supplier> getAllSupplierWithPagination(PageReq pageReq) {
		Pageable page = PageRequest.of(pageReq.getPageNumber(),
				pageReq.getPageSize());
		Interpreter<Page<Supplier>, PaginationResponse<Supplier>> interpreter =
		        new PageResponseSupplier();
		return  interpreter.interpret(SpsRepository.findAll(page));
	}
	
}

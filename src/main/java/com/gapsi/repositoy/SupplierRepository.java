package com.gapsi.repositoy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gapsi.patterns.dto.Supplier;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Integer> {
	
	Supplier findByCompanyName(String companyName);
}

package com.gapsi.repositoy;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gapsi.patterns.dto.Supplier;

@Repository
public interface SupplierPagingAndSortingRepository extends PagingAndSortingRepository<Supplier, Integer> {

}

package com.gapsi.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gapsi.domain.exception.ApplicationException;
import com.gapsi.patterns.dto.GenericDataResponse;

import jakarta.validation.Valid;

public interface BasicController<D, K> {
	
	@PostMapping
	@ResponseBody D create(@Valid @RequestBody D domain) throws ApplicationException;
	
	@GetMapping(path = "/{id}")
	D getElementById(@PathVariable(value = "id") K id) throws ApplicationException;
	
	@DeleteMapping(path = "/{id}")
	GenericDataResponse deleteElementById(@PathVariable(value = "id") K id) throws ApplicationException;
	
	@GetMapping
	@ResponseBody List<D> getAllElements() throws ApplicationException;
	
	
}

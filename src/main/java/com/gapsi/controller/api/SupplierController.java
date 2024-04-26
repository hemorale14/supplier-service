package com.gapsi.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gapsi.domain.exception.ApplicationException;
import com.gapsi.patterns.dto.ErrorDataResponse;
import com.gapsi.patterns.dto.GenericDataResponse;
import com.gapsi.patterns.dto.PageReq;
import com.gapsi.patterns.dto.PaginationResponse;
import com.gapsi.patterns.dto.Supplier;
import com.gapsi.usercase.provider.SupplierProvider;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Supplier", description = "Supplier Operations")
@RestController
@RequestMapping(value = "/supplier", produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
public class SupplierController implements BasicController<Supplier, Integer>{
	
	@Autowired
	private SupplierProvider provider;
	
	@Operation(
		      responses = {
		          @ApiResponse(responseCode = "200", description = "",
		              content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
		                  schema = @Schema(implementation = Supplier.class))),
		          @ApiResponse(responseCode = "400", description = "Bad Request",
		              content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
		                  schema = @Schema(implementation = ErrorDataResponse.class))),
		          @ApiResponse(responseCode = "500", description = "Internal Server Error",
		              content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
		                  schema = @Schema(implementation = ErrorDataResponse.class)))})
	@Override
	public Supplier create(Supplier supplier) throws ApplicationException {
		log.debug("Creación de un proveedor");
		return provider.create(supplier);
	}
	
	@Operation(
		      responses = {
		          @ApiResponse(responseCode = "200", description = "",
		              content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
		                  schema = @Schema(implementation = Supplier.class))),
		          @ApiResponse(responseCode = "400", description = "Bad Request",
		              content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
		                  schema = @Schema(implementation = ErrorDataResponse.class))),
		          @ApiResponse(responseCode = "500", description = "Internal Server Error",
		              content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
		                  schema = @Schema(implementation = ErrorDataResponse.class)))})
	@Override
	public Supplier getElementById(Integer id) {
		log.debug("Obtener proveedor con id{}", id);
		return provider.getSupplierById(id);
	}
	
	@Operation(
		      responses = {
		          @ApiResponse(responseCode = "200", description = "",
		              content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
		                  schema = @Schema(implementation = GenericDataResponse.class))),
		          @ApiResponse(responseCode = "400", description = "Bad Request",
		              content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
		                  schema = @Schema(implementation = ErrorDataResponse.class))),
		          @ApiResponse(responseCode = "500", description = "Internal Server Error",
		              content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
		                  schema = @Schema(implementation = ErrorDataResponse.class)))})
	@Override
	public GenericDataResponse deleteElementById(Integer id) {
		log.debug("Eliminar proveedor con id{}", id);
		return provider.deleteSupplierById(id);
	}
	
	@Operation(
		      responses = {
		          @ApiResponse(responseCode = "200", description = "",
		              content = @Content( array = @ArraySchema(schema = @Schema(implementation = Supplier.class)), 
		              mediaType = MediaType.APPLICATION_JSON_VALUE)),
		          @ApiResponse(responseCode = "400", description = "Bad Request",
		              content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
		                  schema = @Schema(implementation = ErrorDataResponse.class))),
		          @ApiResponse(responseCode = "500", description = "Internal Server Error",
		              content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
		                  schema = @Schema(implementation = ErrorDataResponse.class)))})
	@Override
	public List<Supplier> getAllElements() {
		log.debug("Obtener todos los proveedor");
		return provider.getAllSupplier();
	}
	
	@PostMapping("supplierspaginable")
	public PaginationResponse<Supplier> getAllElementsPaginable(@Valid @RequestBody PageReq pageReq) {
		log.debug("Obtener todos los proveedor con paginación");
		return provider.getAllSupplierWithPagination(pageReq);
	}

	

}

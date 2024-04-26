package com.gapsi.controller.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gapsi.domain.exception.ApplicationException;
import com.gapsi.patterns.dto.ErrorDataResponse;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

//  @ExceptionHandler({
//	  ApplicationException.class,
//      Exception.class})
//  public final ResponseEntity<ErrorDataResponse> handleApplicationException(
//      final ApplicationException ex) {
//    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//        .body(
//            ErrorDataResponse.builder()
//                .code(HttpStatus.INTERNAL_SERVER_ERROR.toString())
//                .message(ex.getMessage())
//                .detail(ex.getCause().getMessage())
//                .build());
//  }
//
//  @ExceptionHandler({
//	  ApplicationException.class})
//  public final ResponseEntity<ErrorDataResponse> notFoundException(
//      final ApplicationException ex) {
//    return ResponseEntity.status(HttpStatus.NOT_FOUND)
//        .body(
//            ErrorDataResponse.builder()
//                .code(HttpStatus.NOT_FOUND.toString())
//                .message(ex.getMessage())
//                .detail(ex.getCause().getMessage())
//                .build());
//  }
  
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {
    List<String> errors = ex.getBindingResult().getFieldErrors()
        .stream()
        .map(fieldError -> fieldError.getField()
            + " -> " + fieldError.getDefaultMessage())
        .collect(Collectors.toList());
    errors.addAll(ex.getBindingResult().getGlobalErrors()
        .stream()
        .map(fieldError -> fieldError.getObjectName()
            + " -> " + fieldError.getDefaultMessage())
        .toList());
    return handleExceptionInternal(ex,
        ErrorDataResponse.builder()
            .code(HttpStatus.BAD_REQUEST.toString())
            .message(errors)
            .detail(ex.getMessage())
            .build(),
        headers, HttpStatus.BAD_REQUEST, request);
  }
  
//  @Override
//  protected ResponseEntity<Object> handleHttpMessageNotReadable(
//      HttpMessageNotReadableException ex,
//      HttpHeaders headers,
//      HttpStatusCode status,
//      WebRequest request) {
//    return handleExceptionInternal(ex,
//        ErrorDataResponse.builder()
//            .code(HttpStatus.BAD_REQUEST.toString())
//            .message(ex.getMostSpecificCause().getClass().getName())
//            .detail(ex.getMostSpecificCause().getMessage())
//            .build(),
//        headers,
//        HttpStatus.BAD_REQUEST,
//        request);
//  }

}

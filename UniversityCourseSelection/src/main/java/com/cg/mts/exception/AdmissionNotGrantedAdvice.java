package com.cg.mts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdmissionNotGrantedAdvice {
	@ExceptionHandler(AdmissionNotGrantedException.class)
	public ResponseEntity<Object> exceptionHandlerMethod(AdmissionNotGrantedException ex) {
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
}

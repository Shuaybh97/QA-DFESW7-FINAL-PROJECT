package com.qa.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(value = {PlayerNotFoundException.class})
	public ResponseEntity<String> playerNotFoundException(PlayerNotFoundException pnfe){
		
		return new ResponseEntity<String>(pnfe.getMessage(), HttpStatus.NOT_FOUND);
	}

}

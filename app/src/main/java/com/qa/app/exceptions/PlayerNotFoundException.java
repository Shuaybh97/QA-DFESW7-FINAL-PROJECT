package com.qa.app.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Player with id not found")
public class PlayerNotFoundException extends EntityNotFoundException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlayerNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayerNotFoundException(String message) {
		super(message);

	}

	
	
	
}

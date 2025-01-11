package com.ak.exception;

import org.springframework.http.ResponseEntity;

public class IdUpdateNotAllowedException extends Exception {
	
	public IdUpdateNotAllowedException(String message) {
		super(message);
	}
}

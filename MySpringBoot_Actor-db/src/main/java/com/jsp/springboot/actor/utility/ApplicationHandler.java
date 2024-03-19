package com.jsp.springboot.actor.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springboot.actor.exception.ActorNotFoundByException;

@RestControllerAdvice
public class ApplicationHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> actorNotFoundByIdException(ActorNotFoundByException ex){
		
		ErrorStructure<String> errorStructure = new ErrorStructure<>();
		errorStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex.getMessage());
		errorStructure.setErrorData("Actor Object With the given Id doesn't exist!!!");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure , HttpStatus.NOT_FOUND);
		
	}

}
